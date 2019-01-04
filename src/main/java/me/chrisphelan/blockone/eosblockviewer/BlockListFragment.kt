package me.chrisphelan.blockone.eosblockviewer

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val fragment = inflater.inflate( R.layout.fragment_block_list, container, false)

        setUpBlockListView(fragment.findViewById(R.id.blockListView))

        GlobalScope.launch {
            Log.d( LOG_TAG, "In network coroutine (test version)")
            val fetchedBlock: BlockDto? = eosGetBlock.getBlock( BlockIdDto("35520468"))
                .execute().body()
            val fauxBlockList: List<BlockData> = listOf( fetchedBlock?.let{ BlockData( it ) }
                ?: BlockData( "Never", "No One", "Nothing", emptyList()))

            withContext(MainScope().coroutineContext) {
                (blockListView.adapter as BlockListAdapter).setBlocks(fauxBlockList)
            }

        }

        return fragment
    }

    private fun setUpBlockListView(view: RecyclerView) = with(view) {
        adapter = BlockListAdapter(dummyData())
        layoutManager = LinearLayoutManager( this@BlockListFragment.context)
        setHasFixedSize(true)
    }

    private fun dummyData(): List<BlockData> = listOf(
        BlockData("today", "Me", "2", listOf( TransactionData( "foo" )) ),
        BlockData("yesterday", "Someone Else", "1", listOf( TransactionData( "bar" )) ),
        BlockData("beginning of time", "God", "root", listOf( TransactionData( "bletch" )) )
    )


}