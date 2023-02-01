package android.maxim.fragmentsendandreceivedata

import android.maxim.fragmentsendandreceivedata.databinding.FragmentSenderBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SenderFragment: Fragment() {

    private lateinit var binding: FragmentSenderBinding
    private lateinit var stringData: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSenderBinding.inflate(layoutInflater)
        binding.btnTransitionWithData.setOnClickListener{ goWithData() }
        binding.btnTransitionWithoutData.setOnClickListener{ goWithoutData() }
        return binding.root
    }

    private fun goWithData() {
        stringData = binding.stringInput.text.toString()
        navigator().goWithData(stringData)
    }

    private fun goWithoutData() {
        navigator().goWithoutData()
    }
}