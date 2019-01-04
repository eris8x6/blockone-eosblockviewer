package me.chrisphelan.blockone.eosblockviewer

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://api.eosnewyork.io/v1/"

val eosGetBlock: EosGetBlock by lazy { eosClient.create(EosGetBlock::class.java) }

private val eosClient by lazy { buildClient() }

private fun buildClient(): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(buildHttpClient())
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

private fun buildHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(15, TimeUnit.SECONDS)
    .readTimeout(15, TimeUnit.SECONDS)
    .build()

interface EosGetBlock {

    @POST( "chain/get_block")
    fun getBlock(@Body blockIdDto: BlockIdDto): Call<BlockDto>

}
