package org.d3if4038.themountain.listview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import org.d3if4038.themountain.R
import org.d3if4038.themountain.databinding.FragmentListviewBinding
import org.d3if4038.themountain.databinding.RecyclerviewListItemBinding

/**
 * A simple [Fragment] subclass.
 */
class ListviewFragment : Fragment() {

    private val viewModel: ListviewViewModel by lazy {
        ViewModelProviders.of(this).get(ListviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListviewBinding.inflate(inflater)
        binding.setLifecycleOwner (this)
        binding.viewModel = viewModel

        binding.rvItemList.adapter = ListviewAdapter(ListviewAdapter.OnClickListener{
            viewModel.displayItemDetails(it)
        })
        viewModel.navigateToSelectedItem.observe(this, Observer{
            if (null != it){
                this.findNavController().navigate(
                    ListviewFragmentDirections.actionListviewFragmentToDetailFragment(it))
                viewModel.displayItemDetailsComplete()
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}
