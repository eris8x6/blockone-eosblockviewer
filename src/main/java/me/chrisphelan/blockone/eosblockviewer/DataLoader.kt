package me.chrisphelan.blockone.eosblockviewer

import android.util.Log
import kotlinx.coroutines.*

object DataLoader {

    fun loadChainInfo() {
        GlobalScope.launch {
            val chainInfo = eosGetBlock.getChainInfo().execute().body()

            HeadBlockId = chainInfo?.head_block_id
        }
    }

    fun loadBlock(blockId: String) {
        GlobalScope.launch {
            val blockDto = eosGetBlock.getBlock( BlockIdDto(blockId) ).execute().body()
            blockDto?.let{ BlockList.add( BlockData(it) )}

        }
    }
/*
    GlobalScope.launch {
        Log.d( LOG_TAG, "In network coroutine (test version)")


        val rawBlock: String = eosGetBlock.getRawBlock( BlockIdDto("35520468"))
            .execute().body()?.string() ?: "Invalid response"
        Log.d( LOG_TAG, "Test of raw block fetch: $rawBlock" )

        val fetchedBlock: BlockDto? = eosGetBlock.getBlock( BlockIdDto("35520468"))
            .execute().body()
        val fauxBlockList: List<BlockData> = listOf( fetchedBlock?.let{ BlockData( it ) }
            ?: BlockData( "Never", "No One", "Nothing", emptyList()))

        // This moves to ViewModel, probably
//        withContext(MainScope().coroutineContext) {
//            (blockListView.adapter as BlockListAdapter).setBlocks(fauxBlockList)
//        }

    }
*/

}