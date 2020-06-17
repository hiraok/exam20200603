package jp.hiraok.exam20200603.di

import android.app.Application
import dagger.Module
import dagger.Provides
import jp.hiraok.exam20200603.api.ApiComponent
import jp.hiraok.exam20200603.api.GitHubApi
import javax.inject.Singleton

@Module
internal object ApiComponentModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideGitHubApi(application: Application): GitHubApi =
        ApiComponent.builder().context(application).build().gitHubApi()

}