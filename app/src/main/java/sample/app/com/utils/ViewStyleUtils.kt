package sample.app.com.utils

import android.content.Context
import android.content.res.Resources
import android.view.View

class ViewStyleUtils {

    companion object {

        fun setPadding(context: Context, view: View) {
            if (hasNavBar(context.resources)) {
                view.setPadding(0, 0, 0, getNavViewHeight(context))
            }
        }

        private fun hasNavBar(resources: Resources): Boolean {
            val id = resources.getIdentifier("config_showNavigationBar", "bool", "android")
            return id > 0 && resources.getBoolean(id)
        }

        private fun getNavViewHeight(context: Context): Int {
            val resourceId = context.resources.getIdentifier("navigation_bar_height", "dimen", "android")
            return if (resourceId > 0) {
                context.resources.getDimensionPixelSize(resourceId)
            } else 0
        }
    }
}