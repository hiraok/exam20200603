package jp.hiraok.exam20200603

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import jp.hiraok.exam20200603.databinding.ActivityMainBinding
import jp.hiraok.exam20200603.ui.ContributorDetailFragment
import jp.hiraok.exam20200603.ui.MainRecyclerViewAdapter
import jp.hiraok.exam20200603.ui.MainViewModel
import jp.hiraok.exam20200603.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainRecyclerViewAdapter.OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private var adapter: MainRecyclerViewAdapter? = null

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        createRecyclerView()
    }


    private fun createRecyclerView() {
        adapter = MainRecyclerViewAdapter(this)
        binding.apply {
            lifecycleOwner = this@MainActivity
            val layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
            val divider = DividerItemDecoration(
                this@MainActivity,
                layoutManager.orientation
            )
            recyclerView.addItemDecoration(divider)
        }

        viewModel.contributors.observe(this, Observer {
            adapter?.submitList(it)
        })
    }

    override fun onClick(dto: ContributorDetailFragment.DetailDto) {
        ContributorDetailFragment.show(supportFragmentManager, dto)
    }

}