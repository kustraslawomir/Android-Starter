package sample.app.com.view.activity.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import sample.app.com.R
import sample.app.com.view.activity.BaseActivity
import sample.app.com.view.fragment.welcome.WelcomeFragment

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        lifecycle.addObserver(viewModel)

        replaceFragment(WelcomeFragment(), R.id.fragmentsContainer)
    }
}
