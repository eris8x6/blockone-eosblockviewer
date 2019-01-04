package me.chrisphelan.blockone.eosblockviewer

data class BlockData(
    val timestamp: String, val producer: String, val previous: String, val transactions: List<TransactionData>) {
    constructor( dto: BlockDto ) : this( dto.timestamp, dto.producer, dto.previous,
        dto.transactions.map{ TransactionData( it.trx.let { if (it is String) it else "Complex" } ) } )

}

data class TransactionData(val trxId: String)