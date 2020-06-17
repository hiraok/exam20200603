package jp.hiraok.exam20200603.domain

import jp.hiraok.exam20200603.model.Contributor
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {

    suspend fun findContributorAll(page: Int): Flow<List<Contributor>>
}