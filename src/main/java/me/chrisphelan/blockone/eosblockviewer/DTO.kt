package me.chrisphelan.blockone.eosblockviewer

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BlockDto {
    lateinit var timestamp: String
    lateinit var producer: String
    lateinit var previous: String
    lateinit var transactions: List<TransactionDto>
}

@JsonClass(generateAdapter = true)
class TransactionDto {
    lateinit var trx: Any
}

@JsonClass(generateAdapter = true)
class BlockIdDto(val block_num_or_id: String)

@JsonClass(generateAdapter = true)
class ChainInfoDto {
    lateinit var head_block_id: String
}
