package jp.hiraok.exam20200603.domain

import dagger.Binds
import dagger.Module
import jp.hiraok.exam20200603.domain.impl.GitHubRepositoryImpl

@Module
abstract class DomainModule {

    @Binds
    abstract fun provideContributorRepository(contributorRepository: GitHubRepositoryImpl): GitHubRepository
}