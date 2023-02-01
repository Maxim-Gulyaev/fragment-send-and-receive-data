package android.maxim.fragmentsendandreceivedata

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun goWithData(stringData: String)

    fun goWithoutData()

    fun goBack()
}