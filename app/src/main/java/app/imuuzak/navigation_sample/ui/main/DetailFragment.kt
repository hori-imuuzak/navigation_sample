package app.imuuzak.navigation_sample.ui.main

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import app.imuuzak.navigation_sample.R
import app.imuuzak.navigation_sample.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {
    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<DetailFragmentBinding>(
            inflater,
            R.layout.detail_fragment,
            container,
            false
        )

        binding.lifecycleOwner = viewLifecycleOwner

        arguments?.let {
            val linkName = it.getString("name")
            val productName = linkName ?: DetailFragmentArgs.fromBundle(it).productName

            val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            viewModel.setName(productName)

            viewModel.purchased.observe(viewLifecycleOwner, Observer { purchased ->
                if (purchased == true) {
                    findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToThankyouFragment())
                    viewModel.clear()
                }
            })

            binding.viewModel = viewModel
        }

        return binding.root
    }
}