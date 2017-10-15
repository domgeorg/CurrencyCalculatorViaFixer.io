package georgiopoulos.fixer.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import georgiopoulos.fixer.injection.module.FixerModule;
import georgiopoulos.fixer.ui.view.MainActivity;

/**
 * Created by domg on 14/10/2017.
 */

@Singleton
@Component(modules = {FixerModule.class})
public interface FixerComponent{
    void inject(MainActivity activity);
}
