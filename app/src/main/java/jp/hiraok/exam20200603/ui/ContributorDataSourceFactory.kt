package jp.hiraok.exam20200603.ui

import androidx.lifecycle.LifecycleOwner
import androidx.paging.DataSource
import jp.hiraok.exam20200603.usecase.GetContributorsUseCase
import jp.hiraok.exam20200603.model.Contributor
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class ContributorDataSourceFactory @Inject constructor(
    lifecycleOwner: LifecycleOwner,
    useCase: GetContributorsUseCase
) : DataSource.Factory<Int, Contributor>() {

    private val source = ContributorsDataSource(lifecycleOwner, useCase)

    override fun create(): DataSource<Int, Contributor> {
        return source
    }
}
