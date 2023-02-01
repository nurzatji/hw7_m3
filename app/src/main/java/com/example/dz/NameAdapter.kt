package com.example.dz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz.databinding.ItemNameBinding
import kotlin.reflect.KFunction1

class  NameAdapter(private val nameList:ArrayList<Names>, val onClick: KFunction1<Int, Unit>
):RecyclerView.Adapter<NameAdapter.NameViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        return NameViewHolder(
            ItemNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    inner class NameViewHolder(private val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = nameList[adapterPosition]
            itemView.setOnClickListener{
                onClick(adapterPosition)
            }
            binding.apply {
                tvName.text = item.name
                binding.tvFam.text = item.fam
                Glide.with(imgPhoto).load(item.photo).into(imgPhoto)
            }

        }
    }
}

