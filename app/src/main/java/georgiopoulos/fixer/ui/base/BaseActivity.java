package georgiopoulos.fixer.ui.base;


import android.os.Bundle;

import georgiopoulos.fixer.utils.Injector;
import icepick.Icepick;
import nucleus.factory.PresenterFactory;
import nucleus.presenter.Presenter;
import nucleus.view.NucleusAppCompatActivity;

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

public class BaseActivity <P extends Presenter> extends NucleusAppCompatActivity<P>{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        final PresenterFactory<P> superFactory = super.getPresenterFactory();
        setPresenterFactory(superFactory == null ? null : (PresenterFactory<P>) () -> {
            P presenter = superFactory.createPresenter();
            ((Injector)getApplication()).inject(presenter);
            return presenter;
        });
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this,savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        Icepick.saveInstanceState(this, bundle);
    }
}
