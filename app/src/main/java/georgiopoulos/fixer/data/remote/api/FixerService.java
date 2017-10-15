package georgiopoulos.fixer.data.remote.api;

import georgiopoulos.fixer.data.remote.dto.CurrencyList;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by domg on 14/10/2017.
 */

public interface FixerService{
    @GET("/{date}")Observable<CurrencyList> getCurrencies(@Path("date") String date);
}
