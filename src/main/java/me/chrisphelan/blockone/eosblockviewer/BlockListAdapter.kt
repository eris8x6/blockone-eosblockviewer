package me.chrisphelan.blockone.eosblockviewer

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_block_listing.*

class BlockListAdapter(private var items: List<BlockData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_block_listing, parent, false)
        return BlockListingHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        require(holder is BlockListingHolder)
        holder.bind(items[position])
    }

    fun setBlocks(newBlockList: List<BlockData>) {
        this.items = newBlockList
        notifyDataSetChanged()
    }

    inner class BlockListingHolder(private val blockListingView: View) :
            RecyclerView.ViewHolder(blockListingView) {

        // This could be cleaned up using Android data binding framework
        val timestampView: TextView = blockListingView.findViewById( R.id.timestampView )
        val producerView: TextView = blockListingView.findViewById( R.id.producerView )

        fun bind(block: BlockData) {
            timestampView.text = block.timestamp
            producerView.text = block.producer
        }
    }
}