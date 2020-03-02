package com.example.letsgetcheckedassignment

import android.content.Context
import android.graphics.Color
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdpter(private var dataList: List<DataModel>, private val context: Context, val clickListener: (DataModel, Int) -> Unit) : RecyclerView.Adapter<DataAdpter.ViewHolder>() {

    var onItemClick: ((DataModel) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {

        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel=dataList.get(position)


        holder.country_name.text=dataModel.name;
        holder.capital_name.text=dataModel.capital;
        holder.region_name.text=dataModel.region;

        holder?.itemView?.setOnClickListener { clickListener(dataModel, position) }



    }


   inner class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        lateinit var country_name:TextView
        lateinit var capital_name: TextView
        lateinit var region_name: TextView


        init {
            country_name=itemLayoutView.findViewById(R.id.country_name)
            capital_name=itemLayoutView.findViewById(R.id.capital_name)
            region_name=itemLayoutView.findViewById(R.id.region_name)


            itemLayoutView.setOnClickListener {
                onItemClick?.invoke(dataList[adapterPosition])
            }

        }

    }

}
