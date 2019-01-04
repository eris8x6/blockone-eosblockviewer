package me.chrisphelan.blockone.eosblockviewer

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity

val LOG_TAG = "eosblockviewer"

class BlockViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_block_viewer)

        // TODO Adjust this for screen rotation
        // TODO Adjust this for change of views

        supportFragmentManager.let{
            if (it.findFragmentById(R.id.fragment_container) == null) {
                it.beginTransaction().add(R.id.fragment_container, BlockListFragment()).commit()
            }
        }


    }
}
