package sample.app.com.view.fragment.welcome

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sample.app.com.R
import sample.app.com.view.activity.main.MainActivity
import sample.app.com.view.fragment.BaseFragment

class WelcomeFragment : BaseFragment() {

    private lateinit var activity: MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_welcome, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        if (bundle != null) {

        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as MainActivity
    }
}