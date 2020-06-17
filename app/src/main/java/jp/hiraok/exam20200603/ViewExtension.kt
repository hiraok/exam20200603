package jp.hiraok.exam20200603

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object ViewExtension {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(url: String?) {
        Picasso.get().load(url).transform(CircleTransform()).into(this)
    }
}