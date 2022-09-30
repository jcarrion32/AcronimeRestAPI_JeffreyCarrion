package com.example.acronimerestapi_jeffreycarrion.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.acronimerestapi_jeffreycarrion.R
import com.example.acronimerestapi_jeffreycarrion.data.model.AbbreviationItem
import com.example.acronimerestapi_jeffreycarrion.databinding.AbbreListItemBinding

class Adapter (private val list: MutableList<AbbreviationItem> = mutableListOf()): RecyclerView.Adapter<Adapter.AcromineViewHolder>(){

    lateinit var varsList: (List<AbbreviationItem>) -> Unit

    constructor(vars: (List<AbbreviationItem>) -> Unit): this(){
        varsList = vars
    }

    inner class AcromineViewHolder(private val binding: AbbreListItemBinding): RecyclerView.ViewHolder(binding.root) {
        private val res = binding.root.context.resources

        fun onBind(item: AbbreviationItem){
            binding.apply {
                tvAbbreName.text = res.getString(R.string.item_name,item.lf)
                tvAbbreFreq.text = res.getString(R.string.item_freq, item.freq.toString())
                tvAbbreSince.text = res.getString(R.string.item_since, item.since.toString())

                if (!item.vars.isNullOrEmpty()) {
                    btnVars.apply {
                        visibility = View.VISIBLE
                        setOnClickListener { varsList(item.vars as List<AbbreviationItem>) }
                    }
                }
            }
        }
    }

    fun setNewList(newList: List<AbbreviationItem>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcromineViewHolder =
        AcromineViewHolder(
            AbbreListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: AcromineViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}