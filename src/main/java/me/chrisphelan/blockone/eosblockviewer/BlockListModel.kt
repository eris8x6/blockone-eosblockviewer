package me.chrisphelan.blockone.eosblockviewer

var HeadBlockId: String? = null

val BlockList: MutableList<BlockData> = mutableListOf()

data class BlockData(
    val timestamp: String, val producer: String, val previous: String,
    val signature: String, val txn_count: Int, val raw: String) {

    constructor( dto: BlockDto, raw: String )
            : this(dto.timestamp, dto.producer, dto.previous, dto.producer_signature, dto.transactions.size, raw)

}
