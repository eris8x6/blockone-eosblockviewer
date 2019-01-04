package me.chrisphelan.blockone.eosblockviewer

import android.provider.Settings
import android.util.Log
import kotlinx.android.synthetic.main.fragment_block_list.*
import kotlinx.coroutines.*

object ViewModel {

    // This would be better with Observable
    lateinit var updateBlockListView: (List<BlockData>) -> Unit

    private val blockList: List<BlockData>
        get() = BlockList.toList()

    private val hasChainInfo: Boolean
        get() = HeadBlockId != null

    private val  blockCount: Int
        get() = BlockList.size

    private val  prevBlockId: String?
        get() = if (blockCount > 0) BlockList.last().previous else HeadBlockId

    var isLoading = false
        set(value: Boolean) {
            field = value

        }

    fun onLoadButtonClick() {

        if (!isLoading) launchBlockLoader()

    }

    private fun launchBlockLoader() {
        isLoading = true

        GlobalScope.launch{
            if (!hasChainInfo) DataLoader.loadChainInfo()

            while (blockCount < 20) {
                prevBlockId?.let{ DataLoader.loadBlock(it) }
            }

            withContext( MainScope().coroutineContext ) {
                updateBlockListView(blockList)
            }

            delay(30000)
            isLoading = false
        }
    }


}