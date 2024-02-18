package com.flit.flumisk.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.flit.flumisk.R
import com.flit.flumisk.gpu

class fragment_gpu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gpu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cpu = gpu()

        val min_fr_cpu = 180000
        var max_fr_cpu = 800000
        val max_fr_const = 800000

        val tx_max = view.findViewById<EditText>(R.id.max_freq)
        val tx_min = view.findViewById<EditText>(R.id.min_freq)

        val select_freq = view.findViewById<Button>(R.id.select_freq)
        val apply = view.findViewById<Button>(R.id.apply)

       select_freq.text = (max_fr_cpu/1000).toString() + " МГц"
       select_freq.setOnClickListener() {
           when(max_fr_cpu) {
               min_fr_cpu * 5 -> max_fr_cpu = min_fr_cpu * 4
               min_fr_cpu * 4 -> max_fr_cpu = min_fr_cpu * 3
               min_fr_cpu * 3 -> max_fr_cpu = min_fr_cpu * 2
               min_fr_cpu * 2 -> max_fr_cpu = min_fr_cpu * 1
               min_fr_cpu * 1 -> max_fr_cpu = min_fr_cpu * 5
           }

           select_freq.text = (max_fr_cpu/1000).toString() + " МГц"
           cpu.set_gpu_freq(max_fr_cpu.toString())
       }

       apply.setOnClickListener() {
           cpu.set_max_main_freq(tx_min.text.toString().toInt(), tx_max.text.toString().toInt())
       }

    }

}