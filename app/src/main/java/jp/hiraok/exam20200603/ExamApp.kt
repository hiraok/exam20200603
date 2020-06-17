package jp.hiraok.exam20200603

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import jp.hiraok.exam20200603.di.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

class ExamApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        DaggerAppComponent.builder().application(this).build().inject(this)
        return dispatchingAndroidInjector
    }


}