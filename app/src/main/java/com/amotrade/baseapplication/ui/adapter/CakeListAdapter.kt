package com.amotrade.baseapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amotrade.baseapplication.R
import com.amotrade.baseapplication.data.CakeData
import com.amotrade.baseapplication.ui.CakeItemClickListener
import com.amotrade.baseapplication.ui.viewholder.CakeEvenViewHolder
import com.amotrade.baseapplication.ui.viewholder.CakeOddViewHolder
import com.amotrade.baseapplication.utils.CAKE_ITEM_EVEN
import com.amotrade.baseapplication.utils.CAKE_ITEM_ODD
import com.amotrade.baseapplication.utils.isIdEven

class CakeListAdapter(val cakeDataList: List<CakeData>, val cakeItemClickListener: CakeItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var layoutInflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        layoutInflater = LayoutInflater.from(parent.context)
        when (viewType) {
            CAKE_ITEM_EVEN -> {
                return CakeEvenViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_cake,
                        parent,
                        false
                    )
                )
            }
            CAKE_ITEM_ODD -> {
                return CakeOddViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_cake,
                        parent,
                        false
                    )
                )
            }
            else -> {
                return CakeOddViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_cake,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = cakeDataList[position]
        if (isIdEven(item.id.toInt())) {
            (holder as CakeEvenViewHolder).setData(item, cakeItemClickListener)
        } else {
            (holder as CakeOddViewHolder).setData(item, cakeItemClickListener)
        }
    }

    override fun getItemCount(): Int {
        return cakeDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        val itemId = cakeDataList[position].id.toInt()
        return if (isIdEven(itemId)) {
            CAKE_ITEM_EVEN
        } else {
            CAKE_ITEM_ODD
        }
    }

}