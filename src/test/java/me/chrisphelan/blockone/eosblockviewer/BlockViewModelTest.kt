package me.chrisphelan.blockone.eosblockviewer

import assertk.*
import assertk.assertions.isEqualTo
import io.mockk.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BlockViewModelTest {

    lateinit var subject: BlockViewModel

    val testBlockData = BlockData(
        timestamp = "Test timestamp",
        producer = "Test producer",
        previous = "Test previous",
        signature = "Test signature",
        txn_count = 5,
        raw = "Test raw data block" )

    @Test
    fun `passes timestamp from BlockData`() {
        subject = BlockViewModel( testBlockData )

        assert(subject.timestamp).isEqualTo(testBlockData.timestamp)
    }

    @Test
    fun `passes producer from BlockData`() {
        subject = BlockViewModel( testBlockData )

        assert(subject.producer).isEqualTo(testBlockData.producer)
    }

    @Test
    fun `passes signature from BlockData`() {
        subject = BlockViewModel( testBlockData )

        assert(subject.signature).isEqualTo(testBlockData.signature)
    }

    @Test
    fun `passes txn_count from BlockData`() {
        subject = BlockViewModel( testBlockData )

        assert(subject.txn_count).isEqualTo( "5" )
    }

    @Test
    fun `passes raw from BlockData`() {
        subject = BlockViewModel( testBlockData )

        assert(subject.raw).isEqualTo(testBlockData.raw)
    }

}