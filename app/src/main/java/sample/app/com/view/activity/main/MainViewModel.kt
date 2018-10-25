package sample.app.com.view.activity.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import sample.app.com.SampleApplication
import sample.app.com.repository.local.AppDataBase
import timber.log.Timber
import javax.inject.Inject

class MainViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var database: AppDataBase

    init {
        SampleApplication.appComponent.inject(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Timber.e("Lifecycle -> ON_DESTROY")
    }
}