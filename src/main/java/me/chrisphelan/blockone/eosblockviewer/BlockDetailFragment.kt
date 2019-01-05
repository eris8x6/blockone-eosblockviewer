package me.chrisphelan.blockone.eosblockviewer

import android.databinding.DataBindingUtil
import android.support.v4.app.Fragment
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_block_detail.*
import me.chrisphelan.blockone.eosblockviewer.databinding.FragmentBlockDetailBinding

class BlockDetailFragment() : Fragment() {

    lateinit var block: BlockData

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        {
            val binding: FragmentBlockDetailBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_block_detail, container, false)

            require(::block.isInitialized)
            binding.apply{
                blockViewModel = BlockViewModel(block)
                executePendingBindings()
            }

            return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        raw_toggle_switch.setOnCheckedChangeListener { buttonView, isChecked: Boolean ->
            raw_data_view.visibility = if (isChecked) View.VISIBLE else View.INVISIBLE
        }

        raw_data_view.movementMethod = ScrollingMovementMethod()

    }

}