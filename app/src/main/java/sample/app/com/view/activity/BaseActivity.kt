package sample.app.com.view.activity

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    fun setPadding(view: View) {
        if (hasNavBar(resources)) {
            view.setPadding(0, 0, 0, getNavViewHeight())
        }
    }

    private fun hasNavBar(resources: Resources): Boolean {
        val id = resources.getIdentifier("config_showNavigationBar", "bool", "android")
        return id > 0 && resources.getBoolean(id)
    }

    private fun getNavViewHeight(): Int {
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            resources.getDimensionPixelSize(resourceId)
        } else 0
    }

    internal fun replaceFragment(fragment: Fragment, container: Int) {
        val mFragmentManager = supportFragmentManager
        val fragmentTransaction = mFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(container, fragment, fragment::class.java.simpleName)
        fragmentTransaction?.addToBackStack(fragment::class.java.simpleName)
        fragmentTransaction?.commit()
    }
}