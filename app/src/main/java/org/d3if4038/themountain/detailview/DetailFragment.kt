package org.d3if4038.themountain.detailview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import org.d3if4038.themountain.R
import org.d3if4038.themountain.databinding.FragmentDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        val theMountainProperty = DetailFragmentArgs.fromBundle(arguments!!).SELECTEDDETAILPROPERTY
        val viewModelFactory = DetailViewModelFactory(theMountainProperty,application)

        binding.viewModel = ViewModelProviders.of(
            this,viewModelFactory).get(DetailViewModel::class.java)
        return binding.root
    }

}
