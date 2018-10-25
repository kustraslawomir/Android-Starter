package sample.app.com.view.activity.splash

import androidx.lifecycle.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SplashViewModel : ViewModel(), LifecycleObserver {

    private var disposable: Disposable
    internal var navigateToMainActivity: MutableLiveData<Boolean> = MutableLiveData()

    init {
        disposable = Observable.just(true)
                .delay(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ navigateToMainActivity.value = true }, { Timber.e(it.message) })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        disposable.dispose()
        Timber.e("Lifecycle -> ON_DESTROY")
    }
}