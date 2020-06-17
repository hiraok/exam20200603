package jp.hiraok.exam20200603.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import jp.hiraok.exam20200603.MainActivity
import jp.hiraok.exam20200603.ui.MainViewModel
import jp.hiraok.exam20200603.viewmodel.ViewModelKey

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(
        mainViewModel: MainViewModel
    ): ViewModel

}
