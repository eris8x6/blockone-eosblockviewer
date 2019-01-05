package me.chrisphelan.blockone.eosblockviewer

import assertk.*
import assertk.assertions.isEqualTo
import io.mockk.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BlockDataTest {

    var subject: BlockData? = null

    val testBlockDto = BlockDto().apply{
        producer = "Test producer"
        producer_signature = "Test signature"
        previous = "Test previous"
        timestamp = "Test timestamp"
        transactions = List( 5, { i -> "Test string transaction" } )
    }

    val testBlockRaw = "Test raw data block"

    @Test
    fun `initializes producer from a blockDto`() {
        subject = BlockData( testBlockDto, testBlockRaw )

        assert(subject?.producer).isEqualTo("Test producer")
    }

    @Test
    fun `initializes signature from a blockDto`() {
        subject = BlockData( testBlockDto, testBlockRaw )

        assert(subject?.signature).isEqualTo("Test signature")
    }

    @Test
    fun `initializes previous from a blockDto`() {
        subject = BlockData( testBlockDto, testBlockRaw )

        assert(subject?.previous).isEqualTo("Test previous")
    }

    @Test
    fun `initializes timestamp from a blockDto`() {
        subject = BlockData( testBlockDto, testBlockRaw )

        assert(subject?.timestamp).isEqualTo("Test timestamp")
    }

    @Test
    fun `initializes transaction count from a blockDto with all string transactions`() {
        subject = BlockData( testBlockDto, testBlockRaw )

        assert(subject?.txn_count).isEqualTo(5)
    }

    @Test
    fun `initializes transaction count from a blockDto with mixed string and non-string transactions`() {
        val testNonStringTxnDto = BlockDto().apply{
            producer = ""
            producer_signature = ""
            previous = ""
            timestamp = ""
            transactions = listOf( 6 to "foo", 7 to "bar", "bletch" )
        }

        subject = BlockData( testNonStringTxnDto, testBlockRaw )

        assert(subject?.txn_count).isEqualTo(3)
    }

    @Test
    fun `initializes raw data block from a string`() {
        subject = BlockData(testBlockDto, testBlockRaw)

        assert(subject?.raw).isEqualTo("Test raw data block")
    }
}
