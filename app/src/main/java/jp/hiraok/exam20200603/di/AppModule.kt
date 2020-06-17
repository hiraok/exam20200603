package jp.hiraok.exam20200603.di

import dagger.Module
import dagger.Provides
import jp.hiraok.exam20200603.ExamApp

@Module
object AppModule {

    @Provides
    @JvmStatic
    fun provideApplication(application: ExamApp) = application

}