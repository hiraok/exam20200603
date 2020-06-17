package jp.hiraok.exam20200603.ui

import android.app.Dialog
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import jp.hiraok.exam20200603.R
import jp.hiraok.exam20200603.databinding.FragmentDetailBinding
import kotlinx.android.parcel.Parcelize

class ContributorDetailFragment : BottomSheetDialogFragment() {

    companion object {

        const val KEY = "dto"
        val TAG = ContributorDetailFragment::class.java.canonicalName

        fun show(
            fragmentManager: FragmentManager,
            dto: DetailDto
        ) {
            return ContributorDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY, dto)
                }
            }.show(fragmentManager, TAG)
        }
    }

    private val dto by lazy { arguments?.getParcelable<DetailDto>(KEY) }

    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            null,
            false
        ).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            binding.lifecycleOwner = viewLifecycleOwner
            binding.contributor = dto
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.BottomSheetDialog)
        return super.onCreateDialog(savedInstanceState)
    }

    @Parcelize
    data class DetailDto(
        val name: String,
        val avatarUrl: String,
        val htmlUrl: String
    ) : Parcelable

}
