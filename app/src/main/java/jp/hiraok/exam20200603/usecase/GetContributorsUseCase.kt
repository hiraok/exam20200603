package jp.hiraok.exam20200603.usecase

import androidx.lifecycle.LiveData
import jp.hiraok.exam20200603.model.Contributor

interface GetContributorsUseCase {
    suspend fun execute(page: Int): LiveData<List<Contributor>>
}