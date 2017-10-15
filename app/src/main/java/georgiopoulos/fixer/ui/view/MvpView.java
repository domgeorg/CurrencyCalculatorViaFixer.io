package georgiopoulos.fixer.ui.view;

import android.content.Context;

import georgiopoulos.fixer.data.remote.api.FixerService;

/**
 * Created by domg on 15/10/2017.
 */

public interface MvpView{
    FixerService getService();
}
