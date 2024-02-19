package com.flit.flumisk.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

        val tx_max = view.findViewById<EditText>(R.id.max_freq)
        val tx_min = view.findViewById<EditText>(R.id.min_freq)

        val apply = view.findViewById<Button>(R.id.applyG)

       apply.setOnClickListener() {
           val minFreqValue: Int = tx_min.text.toString().toInt() / 1000
           val maxFreqValue: Int = tx_max.text.toString().toInt() / 1000
           if(maxFreqValue >= minFreqValue) {
               cpu.set_max_main_freq(minFreqValue, maxFreqValue)
               Toast.makeText(requireContext(), "Установленны новыя зничения! \uD83D\uDFE2", Toast.LENGTH_LONG).show()
           } else {
               Toast.makeText(requireContext(), "Указано неверное значение! \uD83D\uDD34", Toast.LENGTH_LONG).show()
           }
       }

    }

}