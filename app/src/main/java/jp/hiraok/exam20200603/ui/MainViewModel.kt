package jp.hiraok.exam20200603.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import jp.hiraok.exam20200603.model.Contributor
import javax.inject.Inject

class MainViewModel @Inject constructor(
    factory: ContributorDataSourceFactory
) : ViewModel() {

    val contributors: LiveData<PagedList<Contributor>>

    init {
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()
        contributors = LivePagedListBuilder(factory, config).build()
    }

}