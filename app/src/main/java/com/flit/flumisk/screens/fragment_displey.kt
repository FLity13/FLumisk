package com.flit.flumisk.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.flit.flumisk.R
import com.flit.flumisk.displey

class fragment_displey : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_displey, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val displeyB = view.findViewById<Button>(R.id.setdispleyclocs_btn)
        var displey_clock = 60
        val displey = displey()

        displeyB.text = displey_clock.toString() + " Гц"
        displeyB.setOnClickListener() {
            when(displey_clock) {
                60 -> displey_clock= 75
                75 -> displey_clock= 90
                90 -> displey_clock= 120
                120 ->displey_clock = 60
            }
            displeyB.text = displey_clock.toString() + " Гц"
            displey.set_displey_clock(displey_clock)
        }
    }

}