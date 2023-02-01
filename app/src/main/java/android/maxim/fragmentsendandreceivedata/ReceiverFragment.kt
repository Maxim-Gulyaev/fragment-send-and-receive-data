package android.maxim.fragmentsendandreceivedata

import android.maxim.fragmentsendandreceivedata.databinding.FragmentReceiverBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ReceiverFragment: Fragment() {

    private lateinit var binding: FragmentReceiverBinding
    private lateinit var data: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = if (arguments?.getString(STRING_DATA) != null) {
            arguments?.getString(STRING_DATA).toString()
        } else { "no data" }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReceiverBinding.inflate(layoutInflater)
        binding.btnBack.setOnClickListener{ goBack() }
        binding.stringOutput.text = data
        return binding.root
    }

    private fun goBack() {
        navigator().goBack()
    }

    companion object {
        @JvmStatic private val STRING_DATA = "STRING_DATA"

        @JvmStatic
        fun newInstance(stringData: String): ReceiverFragment {
            val args = Bundle()
            args.putString(STRING_DATA, stringData)
            val fragment = ReceiverFragment()
            fragment.arguments = args
            return fragment
        }
    }
}