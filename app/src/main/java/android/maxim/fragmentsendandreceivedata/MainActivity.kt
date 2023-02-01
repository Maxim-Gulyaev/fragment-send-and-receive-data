package android.maxim.fragmentsendandreceivedata

import android.maxim.fragmentsendandreceivedata.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, SenderFragment())
                .commit()
        }
    }

    override fun goWithData(stringData: String) {
        launchFragment(ReceiverFragment.newInstance(stringData))
    }

    override fun goWithoutData() {
        launchFragment(ReceiverFragment())
    }

    override fun goBack() {
        onBackPressedDispatcher.onBackPressed()
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}