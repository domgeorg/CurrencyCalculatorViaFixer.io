package georgiopoulos.fixer;

import android.app.Application;

import georgiopoulos.fixer.injection.component.DaggerFixerComponent;
import georgiopoulos.fixer.injection.component.FixerComponent;
import georgiopoulos.fixer.injection.module.FixerModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by domg on 14/10/2017.
 */

public class App extends Application{

    public FixerComponent component;

    @Override
    public void onCreate(){
        super.onCreate();

        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);

        component = DaggerFixerComponent.builder().fixerModule(new FixerModule(getString(R.string.base_url))).build();
    }
}
