package sample.app.com

import android.app.Application
import com.facebook.stetho.Stetho
import sample.app.com.di.component.AppComponent
import sample.app.com.di.component.DaggerAppComponent
import sample.app.com.di.module.AppModule
import sample.app.com.di.module.ContextModule
import sample.app.com.di.module.RoomModule

class SampleApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(applicationContext))
                .appModule(AppModule(this))
                .roomModule(RoomModule(this)).build()
    }
}