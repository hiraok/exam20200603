package jp.hiraok.exam20200603.domain.impl

import jp.hiraok.exam20200603.api.GitHubApi
import jp.hiraok.exam20200603.api.response.ContributorResponse
import jp.hiraok.exam20200603.domain.GitHubRepository
import jp.hiraok.exam20200603.model.Contributor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val api: GitHubApi
) : GitHubRepository {
    override suspend fun findContributorAll(page: Int): Flow<List<Contributor>> = flow {
        emit(
            api.contributors(page).map {
                it.toDomain()
            }
        )
    }

    private fun ContributorResponse.toDomain(): Contributor {
        return Contributor(
            id = login,
            avatarUrl = avatarUrl,
            htmlUrl = htmlUrl
        )
    }
}