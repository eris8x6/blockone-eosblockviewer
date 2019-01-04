package me.chrisphelan.blockone.eosblockviewer

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_block_list.*

class BlockListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate( R.layout.fragment_block_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBlockListView(blockListView)

        loadButton.setOnClickListener { ViewModel.onLoadButtonClick() }

    }

    private fun setUpBlockListView(view: RecyclerView) = with(view) {
        val blockListAdapter = BlockListAdapter(emptyList())
        adapter = blockListAdapter
        ViewModel.updateBlockListView = blockListAdapter::setBlocks
        layoutManager = LinearLayoutManager( this@BlockListFragment.context)
        setHasFixedSize(true)
    }

}