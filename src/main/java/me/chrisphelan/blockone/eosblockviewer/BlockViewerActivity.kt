package me.chrisphelan.blockone.eosblockviewer

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

val LOG_TAG = "eosblockviewer"

class BlockViewerActivity : AppCompatActivity() {

    lateinit var listFrag: Fragment
    lateinit var detailFrag: BlockDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_block_viewer)

        // TODO Adjust this for screen rotation
        // TODO Adjust this for change of views

        supportFragmentManager.let{
            if (it.findFragmentById(R.id.fragment_container) == null) {
                listFrag = BlockListFragment(::navToDetail)
                it.beginTransaction().add(R.id.fragment_container, listFrag ).commit()
            }
        }

        detailFrag = BlockDetailFragment()
    }

    fun navToDetail( block: BlockData ) {
        supportFragmentManager.beginTransaction().remove(listFrag).add(R.id.fragment_container, detailFrag).commit()
        detailFrag.block = block
    }


}
