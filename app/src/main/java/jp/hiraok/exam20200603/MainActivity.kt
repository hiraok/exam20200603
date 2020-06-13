package jp.hiraok.exam20200603

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.contributor -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.myaccount -> {
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

}