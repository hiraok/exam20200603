package jp.hiraok.exam20200603.usecase.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import jp.hiraok.exam20200603.domain.GitHubRepository
import jp.hiraok.exam20200603.usecase.GetContributorsUseCase
import jp.hiraok.exam20200603.model.Contributor
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class GetContributorsUseCaseImpl @Inject constructor(
    private val gitHubRepository: GitHubRepository
) : GetContributorsUseCase {
    override suspend fun execute(page: Int): LiveData<List<Contributor>> = liveData {
        gitHubRepository.findContributorAll(page).collect {
            emit(it)
        }
    }
}