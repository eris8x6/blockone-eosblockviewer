package me.chrisphelan.blockone.eosblockviewer

object DataLoader {

    fun loadChainInfo() {
        val chainInfo = eosGetBlock.getChainInfo().execute().body()
        HeadBlockId = chainInfo?.head_block_id
    }

    fun loadBlock(blockId: String) {
        BlockIdDto(blockId).let {
            val blockDto = eosGetBlock.getBlock( it ).execute().body()
            val blockRaw = eosGetBlock.getRawBlock( it ).execute().body()
            if (blockDto != null && blockRaw != null) {
                BlockList.add( BlockData( blockDto, blockRaw.string() ))
            }
        }
    }

}