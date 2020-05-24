package app.imuuzak.navigation_sample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.imuuzak.navigation_sample.R
import app.imuuzak.navigation_sample.databinding.ThankyouFragmentBinding

class ThankyouFragment: Fragment() {
    companion object {
        fun newInstance() = ThankyouFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ThankyouFragmentBinding>(
            inflater,
            R.layout.thankyou_fragment,
            container,
            false
        )

        return binding.root
    }
}