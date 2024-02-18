package com.flit.flumisk.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import com.flit.flumisk.R
import com.flit.flumisk.cpu
import com.stericson.RootShell.RootShell
import kotlinx.coroutines.selects.select

class fragment_cpu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cpu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cpu = cpu()

        val min_fr_cpu = 300000
        var max_fr_cpu = cpu.get_freqMax_cpu().toInt()
        val max_fr_const = cpu.get_freqMax_cpu().toInt()

        val tx_max = view.findViewById<EditText>(R.id.max_freq)
        val tx_min = view.findViewById<EditText>(R.id.min_freq)
        
        val select_freq = view.findViewById<Button>(R.id.select_freq)
        val apply = view.findViewById<Button>(R.id.apply)

        select_freq.text = (max_fr_cpu/1000).toString() + " МГц"
        select_freq.setOnClickListener() {
            when(max_fr_cpu) {
                max_fr_const -> max_fr_cpu = min_fr_cpu
                min_fr_cpu -> max_fr_cpu = max_fr_const/4
                max_fr_const/4 -> max_fr_cpu = max_fr_const/3
                max_fr_const/3 -> max_fr_cpu = max_fr_const/2
                max_fr_const/2 -> max_fr_cpu = max_fr_const
            }

            select_freq.text = (max_fr_cpu/1000).toString() + " МГц"
            cpu.setCPU(max_fr_cpu)
        }

        apply.setOnClickListener() {
            cpu.set_max_main_freq(tx_min.text.toString().toInt(), tx_max.text.toString().toInt())
        }

    }
}
