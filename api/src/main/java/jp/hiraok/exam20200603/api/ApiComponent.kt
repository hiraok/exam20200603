package jp.hiraok.exam20200603.api

import android.content.Context
import dagger.BindsInstance
import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun gitHubApi(): GitHubApi

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ApiComponent
    }


    companion object {
        fun builder(): Builder =
            DaggerApiComponent.builder()
    }
}
