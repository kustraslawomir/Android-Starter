package sample.app.com.utils

import com.google.android.material.snackbar.Snackbar
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText

class UiExtensions {

    fun EditText.onChange(cb: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                cb(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })


        fun View.snack(message: String, length: Int = com.google.android.material.snackbar.Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
            val snack = com.google.android.material.snackbar.Snackbar.make(this, message, length)
            snack.f()
            snack.show()
        }
    }


    fun View.hide() {
        visibility = View.GONE
    }

    fun View.show() {
        visibility = View.VISIBLE
    }
}