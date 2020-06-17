package jp.hiraok.exam20200603.usecase

import dagger.Binds
import dagger.Module
import jp.hiraok.exam20200603.usecase.impl.GetContributorsUseCaseImpl

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun getContributorsUseCase(getContributorsUseCase: GetContributorsUseCaseImpl): GetContributorsUseCase

}