package georgiopoulos.fixer.ui.presenter;

import java.text.SimpleDateFormat;
import java.util.Date;

import georgiopoulos.fixer.data.local.RateRealm;
import georgiopoulos.fixer.data.remote.dto.CurrencyList;
import georgiopoulos.fixer.ui.view.MainMvpView;
import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by domg on 15/10/2017.
 */

public class MainPresenter implements BasePresenter<MainMvpView>{

    public static String TAG = "MainPresenter";
    private MainMvpView  mainMvpView;
    private Subscription subscription;
    private RateRealm    rateRealm;

    @Override
    public void attachView(MainMvpView view) {
        this.mainMvpView = view;
    }

    @Override
    public void detachView() {
        this.mainMvpView = null;
        if (subscription != null) subscription.unsubscribe();
    }

    public void loadExchangeRates(){
        Observable<RateRealm> observable =

                // Request API data on IO Scheduler
                mainMvpView.getService().getCurrencies(date()).subscribeOn(Schedulers.io())

                        // Write to Realm on Computation scheduler
                        .observeOn(Schedulers.computation()).map(this::writeToRealm)

                        // Read results in Android Main Thread (UI)
                        .observeOn(AndroidSchedulers.mainThread()).map(this::readFromRealm);

        // Read any cached results
        rateRealm = readFromRealm(date());

        if (rateRealm != null)
            // Merge with the observable from API
            observable = observable.mergeWith(Observable.just(rateRealm));

        // Subscription happens on Other thread
        subscription = observable.subscribe(new Subscriber<RateRealm>(){
            @Override
            public void onCompleted(){
                mainMvpView.displayExchange(rateRealm);
            }

            @Override
            public void onError(Throwable e){
                mainMvpView.processError(e);
            }

            @Override
            public void onNext(RateRealm rateRealm){
                MainPresenter.this.rateRealm=rateRealm;
            }
        });
    }

    private RateRealm readFromRealm(String date){
        return findInRealm(Realm.getDefaultInstance(), date);
    }

    private RateRealm findInRealm(Realm realm,String date){
        return realm.where(RateRealm.class).equalTo("date",date).findFirst();
    }

    private String date(){
        Date date = new Date();
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
        return modifiedDate;
    }

    private String writeToRealm(CurrencyList currencyList){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(transactionRealm->{
            RateRealm rateRealm = findInRealm(transactionRealm,currencyList.getDate());
            if (rateRealm == null) rateRealm = transactionRealm.createObject(RateRealm.class,currencyList.getDate());
            rateRealm.setEUR(1);
            rateRealm.setAUD(currencyList.getRates().getAUD());
            rateRealm.setBGN(currencyList.getRates().getBGN());
            rateRealm.setBRL(currencyList.getRates().getBRL());
            rateRealm.setCAD(currencyList.getRates().getCAD());
            rateRealm.setCHF(currencyList.getRates().getCHF());
            rateRealm.setCNY(currencyList.getRates().getCNY());
            rateRealm.setCZK(currencyList.getRates().getCZK());
            rateRealm.setDKK(currencyList.getRates().getDKK());
            rateRealm.setGBP(currencyList.getRates().getGBP());
            rateRealm.setHKD(currencyList.getRates().getHKD());
            rateRealm.setHRK(currencyList.getRates().getHRK());
            rateRealm.setHUF(currencyList.getRates().getHUF());
            rateRealm.setIDR(currencyList.getRates().getIDR());
            rateRealm.setILS(currencyList.getRates().getILS());
            rateRealm.setINR(currencyList.getRates().getINR());
            rateRealm.setJPY(currencyList.getRates().getJPY());
            rateRealm.setKRW(currencyList.getRates().getKRW());
            rateRealm.setMXN(currencyList.getRates().getMXN());
            rateRealm.setMYR(currencyList.getRates().getMYR());
            rateRealm.setNOK(currencyList.getRates().getNOK());
            rateRealm.setNZD(currencyList.getRates().getNZD());
            rateRealm.setPHP(currencyList.getRates().getPHP());
            rateRealm.setPLN(currencyList.getRates().getPLN());
            rateRealm.setRON(currencyList.getRates().getRON());
            rateRealm.setRUB(currencyList.getRates().getRUB());
            rateRealm.setSEK(currencyList.getRates().getSEK());
            rateRealm.setSGD(currencyList.getRates().getSGD());
            rateRealm.setTHB(currencyList.getRates().getTHB());
            rateRealm.setTRY(currencyList.getRates().getTRY());
            rateRealm.setUSD(currencyList.getRates().getUSD());
            rateRealm.setZAR(currencyList.getRates().getZAR());
        });
        realm.close();
        return currencyList.getDate();
    }
}
