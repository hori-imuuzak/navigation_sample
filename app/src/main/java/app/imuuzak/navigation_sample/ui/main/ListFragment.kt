package app.imuuzak.navigation_sample.ui.main

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import app.imuuzak.navigation_sample.R
import app.imuuzak.navigation_sample.databinding.ListFragmentBinding

class ListFragment : Fragment() {
    companion object {
        fun newInstance() = ListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ListFragmentBinding>(
            inflater,
            R.layout.list_fragment,
            container,
            false
        )

        binding.list.setOnItemClickListener { _, _, position, _ ->
            val items = resources.getStringArray(R.array.products)
            view?.findNavController()?.navigate(
                ListFragmentDirections.actionListFragmentToDetailFragment(items[position])
            )
        }

        return binding.root
    }
}