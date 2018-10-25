package sample.app.com.view.activity.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import sample.app.com.R
import sample.app.com.view.activity.BaseActivity
import sample.app.com.view.activity.main.MainActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashh)
        val viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        lifecycle.addObserver(viewModel)

        viewModel.navigateToMainActivity.observe(this, Observer<Boolean> { shouldNavigateToMainScreen ->
            if (shouldNavigateToMainScreen)
                navigateToMainScreen()
        })
    }

    private fun navigateToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}