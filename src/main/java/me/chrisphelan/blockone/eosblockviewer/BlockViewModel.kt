package me.chrisphelan.blockone.eosblockviewer

import android.provider.Settings
import android.util.Log
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.fragment_block_list.*
import kotlinx.coroutines.*

class BlockViewModel( val block: BlockData ) {
    val producer: String
        get() = block.producer

    val signature: String
        get() = block.signature

    val timestamp: String
        get() = block.timestamp

    val txn_count: String
        get() = block.txn_count.toString()

    val raw: String
        get() = block.raw
}

