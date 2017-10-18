package georgiopoulos.fixer.ui.base;

import android.os.Bundle;

import icepick.Icepick;
import nucleus.presenter.RxPresenter;

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

public class BasePresenter<ViewType> extends RxPresenter<ViewType> {

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        Icepick.restoreInstanceState(this, savedState);
    }

    @Override
    protected void onSave(Bundle state) {
        super.onSave(state);
        Icepick.saveInstanceState(this, state);
    }
}
