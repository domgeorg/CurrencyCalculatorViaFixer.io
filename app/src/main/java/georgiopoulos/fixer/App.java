package georgiopoulos.fixer;

import android.app.Application;

import georgiopoulos.fixer.injection.AppComponent;
import georgiopoulos.fixer.injection.AppModule;
import georgiopoulos.fixer.injection.DaggerAppComponent;
import georgiopoulos.fixer.injection.NetworkModule;
import georgiopoulos.fixer.utils.Reflection;
import georgiopoulos.fixer.utils.Injector;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
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

public class App extends Application implements Injector{

    private Reflection<AppComponent> injector;

    @Override
    public void onCreate(){
        super.onCreate();

        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);

        AppComponent component = DaggerAppComponent.builder()
                .networkModule(new NetworkModule())
                .appModule(new AppModule(this))
                .build();
        injector = new Reflection<>(AppComponent.class,component);
    }

    @Override
    public void inject(Object target){
        injector.inject(target);
    }
}
