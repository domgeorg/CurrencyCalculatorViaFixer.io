package georgiopoulos.fixer.ui.view;

import georgiopoulos.fixer.data.local.RateRealm;

/**
 * Created by domg on 15/10/2017.
 */

public interface MainMvpView extends MvpView{
    void displayExchange(RateRealm rateRealm);
    void processError(Throwable e);
}
