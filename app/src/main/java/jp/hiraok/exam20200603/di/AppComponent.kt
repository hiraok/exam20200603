package jp.hiraok.exam20200603.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import jp.hiraok.exam20200603.ExamApp
import jp.hiraok.exam20200603.domain.DomainModule
import jp.hiraok.exam20200603.usecase.UseCaseModule
import jp.hiraok.exam20200603.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApiComponentModule::class,
        AppModule::class,
        DomainModule::class,
        UseCaseModule::class,
        ViewModelModule::class,
        ActivityBuilder::class,
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<ExamApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
