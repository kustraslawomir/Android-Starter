package sample.app.com.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import sample.app.com.di.module.AppModule
import sample.app.com.di.module.BuilderModule
import sample.app.com.di.module.ContextModule
import sample.app.com.di.module.RoomModule
import sample.app.com.di.scopes.AppScope
import sample.app.com.view.activity.main.MainViewModel
import sample.app.com.view.activity.splash.SplashViewModel

@AppScope
@Component(modules = [(AndroidInjectionModule::class), (BuilderModule::class), (AppModule::class), (ContextModule::class), (RoomModule::class)])
interface AppComponent {

    fun inject(mainViewModel: MainViewModel)

    fun inject(splashViewModel: SplashViewModel)

}