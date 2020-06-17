package jp.hiraok.exam20200603.ui

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.PageKeyedDataSource
import jp.hiraok.exam20200603.model.Contributor
import jp.hiraok.exam20200603.usecase.GetContributorsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContributorsDataSource(
    private val lifeCycleOwner: LifecycleOwner,
    private val useCase: GetContributorsUseCase
) : PageKeyedDataSource<Int, Contributor>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Contributor>
    ) {

        val currentPage = 1
        lifeCycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            useCase.execute(currentPage).observe(lifeCycleOwner, Observer {
                callback.onResult(it, null, 1)
            })
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Contributor>
    ) {
        val key = params.key + 1
        lifeCycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            useCase.execute(key).observe(lifeCycleOwner, Observer {
                callback.onResult(it, null)
            })
        }

    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Contributor>
    ) {
    }

}