package jp.hiraok.exam20200603.di

import androidx.lifecycle.LifecycleOwner
import dagger.Module
import dagger.Provides
import jp.hiraok.exam20200603.MainActivity

@Module
object ActivityModule {

    @Provides
    @JvmStatic
    fun provideLifecycleOwner(activity: MainActivity) = activity as LifecycleOwner
}