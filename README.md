# Currency Calculator via fixer.io

![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/money.png)

## Libraries:
1. [Retrofit](http://square.github.io/retrofit/)
2. [Okhttp3](https://github.com/square/okhttp/tree/master/okhttp/src/main/java/okhttp3)
3. [Gson](https://github.com/google/gson)
3. [Rxjava](https://github.com/ReactiveX/RxJava)
4. [Rxandroid](https://github.com/ReactiveX/RxAndroid)
5. [Realm](https://blog.realm.io/realm-for-android/)
6. [Butter Knife](http://jakewharton.github.io/butterknife/)
7. [Dagger2](https://google.github.io/dagger/)
8. [SuperToasts](https://github.com/JohnPersano/SuperToasts)
9. [Project Lombok](https://projectlombok.org/)
10. [Nucleus](https://github.com/konmik/nucleus)
11. [Icepick](https://github.com/frankiesardo/icepick)

## Free APIs
1. [Fixer.io](http://fixer.io/)

## Model View Presenter(MVP) for the presentation layer
View is a layer that displays data and reacts to user actions. On Android, this could be an Activity, a Fragment, an android.view.View or a Dialog.

* **Model ** is a data access layer such as database API or remote server API.

* **Presenter** is a layer that provides View with data from Model. Presenter also handles background tasks.

On Android MVP is a way to separate background tasks from activities/views/fragments to make them independent of most lifecycle-related events. This way an application becomes simpler, overall application reliability increases up to 10 times, application code becomes shorter, code maintainability becomes better and developer’s life becomes happier.

### Fixer is a simple calculator with currency exchange feature via fixer.io wich is a free JSON API for current and historical foreign exchange rates published by the European Central Bank:

![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/Screenshot_20171018-181129.png)![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/Screenshot_20171018-181220.png)
![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/Screenshot_20171018-181657.png)![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/Screenshot_20171018-181506.png)

> I always like apps that still work offline, even if a I have an epic network coverage with [COSMOTE](https://www.cosmote.gr/hub/) and I never run out of data, I want to bring my future users the pleasure of slacking off in situations where the network coverage is awful. So I use Rxjava + Rxandroid to combine the results from the API call with the cached results from the Realm database in case they exists. Retrofit and Gson handles the REST communication. 

### Currency conversion Formula:
![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/CodeCogsEqn%20(1).png)

### Start without Realm:
``` Java 
public interface FixerService{
    @GET("/{date}")Observable<CurrencyList> getCurrencies(@Path("date") String date);
}
```

This is a simple API call using Retrofit + Rxjava. getCurrencies returns a CurrencyList observable object, a POJO generated from the JSON response. I can implement the call by subscribing to the Observable<WeatherResponse> on the IO thread and observing the responses from the Android main thread.

``` Java 
// Request API data on IO Scheduler
service.getCurrencies(date()).subscribeOn(Schedulers.io())
    // Read results in Android Main Thread (UI)
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(this::display, this::processError);
```

The schedulers will play an important role in my solution with Realm.
This is how my current solution looks like. The data goes from the cloud to our display straight from the REST call.

![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/1.png)

### Adding Realm
Now I'm going to add Realm in the middle. The response will be stored into the database before it is displayed. Because how Realm works I want the response object to be a “managed object” from Realm, I need to create a new RateRealm object within our Realm instance.

![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/2.png)

The second time I query the data, I want to first obtain anything that is stored in the database and then obtain it fresh from the API.

![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/3.png)

Going back to the schedulers, I don’t want to write to the database in the main thread (blocking the UI) and I don’t want to use either the IO thread since it may be blocked already with another slow network call. I' m going to use the Computation scheduler for that task.

![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/4.png)

***

## Coding the solution

``` Java
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

```
| Butter Knife | Dagger         |
| ------------- |-------------|
|![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/icons8-Chef%20Knife%20Filled-100.png)|![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/icons8-Syringe%20Filled-100.png)|
I'm using Butter Knife the popular View "injection" library for Android. This library writes common boilerplate view code for me based on annotations to save you time and significantly reduce the lines of boilerplate code written. Butterknife uses compile-time annotations which means there is no additional cost at run-time. Instead of slow reflection, code is generated ahead of time. Calling bind delegates to this generated code that can see and debug. This means that Butterknife does not slow down app at all!|I centralize me singleton with Dagger 2 witch simplifies access to shared instances. Just as the ButterKnife library makes it easier to define references to Views, event handlers, and resources, Dagger 2 provides a simple way to obtain references to shared instances. Once I declare in Dagger my singleton instances FixerService I can declare fields with a simple @Inject annotation.|

| Nucleus | Icepick        |
| ------------- |-------------|
|![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/icons8-Atom%20Editor%20Filled-100.png)|![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/icons8-Ice%20Cream%20Scoop%20Filled-100.png)|
I follow the [KISS principle](https://www.wikiwand.com/en/KISS_principle) implementing Model View Presenter (MVP) for the presentation layer in order to clear separation of responsibilities between components. I'm using Nucleus, an Android library which utilizes the Model-View-Presenter pattern to properly connect background tasks with visual parts of an application.|I slink orientation changes with Icepick, an Android library that eliminates the boilerplate of saving and restoring instance state. It uses annotation processing to generate code that does bundle manipulation and key generation.|

![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/Screenshot_20171018-181556.png)![](https://github.com/domgeorg/CurrencyCalculatorViaFixer.io/blob/master/currency%20exchange/Screenshot_20171018-181608.png)

> icons from [Icons8](https://icons8.com/) - logo from [Fixer.io](http://fixer.io)

## LICENSE
```
Copyright 2017 georgiopoulos kyriakos

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
