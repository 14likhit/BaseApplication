package com.amotrade.baseapplication.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amotrade.baseapplication.data.CakeData
import com.amotrade.baseapplication.databinding.ItemCakeBinding
import com.amotrade.baseapplication.ui.CakeItemClickListener

class CakeOddViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val itemCakeBinding = ItemCakeBinding.bind(itemView)

    fun setData(cakeData: CakeData, cakeItemClickListener: CakeItemClickListener?) {
        itemCakeBinding.cakeIV.visibility = View.INVISIBLE
        itemCakeBinding.cakeFlavorTV.text = cakeData.type
        itemCakeBinding.cakeRootCL.setOnClickListener {
            cakeItemClickListener?.onCakeClick(cakeData)
        }
    }
}