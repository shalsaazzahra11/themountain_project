package org.d3if4038.themountain.listview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if4038.themountain.databinding.RecyclerviewListItemBinding
import org.d3if4038.themountain.network.TheMountainProperty

class ListviewAdapter(private val onClickListener: OnClickListener): ListAdapter<TheMountainProperty,
        ListviewAdapter.TheMountainPropertyViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListviewAdapter.TheMountainPropertyViewHolder {
        return TheMountainPropertyViewHolder(RecyclerviewListItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }
    override fun onBindViewHolder(holder: ListViewAdapter.TheMountainPropertyViewHolder,position: Int){
        val theMountainProperty = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onCLick(theMountainProperty)
        }
        holder.bind(theMountainProperty)
    }
    companion object DiffCallback: DiffUtil.ItemCallback<AsmaulHusnaProperty>(){
        override fun areItemsTheSame(
            oldItem: TheMountainProperty,
            newItem: TheMountainProperty
        ): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(
            oldItem: TheMountainProperty,
            newItem: TheMountainProperty
        ): Boolean {
            return oldItem.id == newItem.id
        }

        class TheMountainPropertyViewHolder(
            private var binding: RecyclerviewListItemBinding)
            : RecyclerView.ViewHolder(binding.root){
            fun bind(theMountainProperty: TheMountainProperty){
            binding.property = theMountainProperty
                binding.executePendingBindings()
            }
        }
        class OnClickListener(val clickListener: (theMountainProperty:TheMountainProperty)-> Unit){
            fun onClick(theMountainProperty: TheMountainProperty) = clickListener(theMountainProperty)
        }
    }

}