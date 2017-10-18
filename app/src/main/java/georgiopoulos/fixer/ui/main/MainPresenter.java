package georgiopoulos.fixer.ui.main;

import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import georgiopoulos.fixer.data.local.RateRealm;
import georgiopoulos.fixer.data.remote.api.FixerService;
import georgiopoulos.fixer.data.remote.dto.CurrencyList;
import georgiopoulos.fixer.ui.base.BasePresenter;
import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * I'm using try-with-resources, which closes the Realm instance at the end of the statement.
 * While this is normally only supported by Android 4.4 or later,
 * Retrolambda backport this to older versions.
 *
 * Nucleus It can automatically restart requests after a process restart and automatically
 * unsubscribe RxJava subscriptions during onDestroy.
 *
 *  Copyright 2017 georgiopoulos kyriakos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class MainPresenter extends BasePresenter<MainActivity>{

    @Inject FixerService fixerService;
    private RateRealm rateRealm;
    private Realm realmUI;

    @Override
    public void onCreate(Bundle savedState){
        super.onCreate(savedState);
        realmUI = Realm.getDefaultInstance();
    }

    public void loadExchangeRates(){
        Observable<RateRealm> observable =
                fixerService.getCurrencies(date())
                        // Request API data on IO Scheduler
                        .subscribeOn(Schedulers.io())
                        // Write to Realm on Computation scheduler
                        .observeOn(Schedulers.computation()).map(this::writeToRealm)
                        // Read results in Android Main Thread (UI)
                        .observeOn(AndroidSchedulers.mainThread()).map(this::readFromRealm);

        // Read any cached results
        rateRealm = readFromRealm(date());

        // Merge with the observable from API
        if (rateRealm != null) observable = observable.mergeWith(Observable.just(rateRealm));

        // Subscription happens on Main Thread
        observable.subscribe(new Subscriber<RateRealm>(){
            @Override
            public void onCompleted(){
                getView().displayExchange(rateRealm);
            }

            @Override
            public void onError(Throwable e){
                e.printStackTrace();
                getView().toaster(e.getMessage());
            }

            @Override
            public void onNext(RateRealm rateRealm){
                MainPresenter.this.rateRealm=rateRealm;
            }
        });
    }

    private RateRealm findInRealm(Realm realm, String date){
            return realm.where(RateRealm.class).equalTo("date",date).findFirst();
    }

    private RateRealm readFromRealm(String date){
        return findInRealm(realmUI, date);
    }

    private String writeToRealm(CurrencyList currencyList){
        try(Realm realm = Realm.getDefaultInstance()){
            realm.executeTransaction(transactionRealm->{
                RateRealm rateRealm = findInRealm(realm,currencyList.getDate());
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
            return currencyList.getDate();
        }
    }

    private String date(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realmUI.close();
    }
}
