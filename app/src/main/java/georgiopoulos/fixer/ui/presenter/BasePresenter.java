package georgiopoulos.fixer.ui.presenter;

/**
 * Created by domg on 15/10/2017.
 */

public interface BasePresenter<V>{

    void attachView(V view);
    void detachView();

}
