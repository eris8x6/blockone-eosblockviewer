package me.chrisphelan.blockone.eosblockviewer

import android.opengl.Visibility
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_block_list.*
import kotlinx.coroutines.*

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

    private fun dummyData(): List<BlockData> = listOf(
        BlockData("today", "Me", "2", listOf( TransactionData( "foo" )) ),
        BlockData("yesterday", "Someone Else", "1", listOf( TransactionData( "bar" )) ),
        BlockData("beginning of time", "God", "root", listOf( TransactionData( "bletch" )) )
    )


}