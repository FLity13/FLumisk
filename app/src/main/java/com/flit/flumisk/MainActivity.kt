package com.flit.flumisk

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.flit.flumisk.screens.fragment_battaty
import com.flit.flumisk.screens.fragment_begin
import com.flit.flumisk.screens.fragment_cpu
import com.flit.flumisk.screens.fragment_displey
import com.flit.flumisk.screens.fragment_gpu

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun setNewFragment(fragment: Fragment) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.frame_layout, fragment)
            ft.commit()
        }

        val fr_text : TextView = findViewById(R.id.fragment_info)

        val fr_cpu: Fragment = fragment_cpu()
        val fr_battary: Fragment = fragment_battaty()
        val fr_displey: Fragment = fragment_displey()
        val fr_gpu: Fragment = fragment_gpu()

        val tx_cpu = findViewById<Button>(R.id.cpu)
        val tx_battaty = findViewById<Button>(R.id.battary)
        val tx_displey = findViewById<Button>(R.id.displey)
        val tx_gpu = findViewById<Button>(R.id.gpu)

        setNewFragment(fragment_begin())

        tx_cpu.setOnClickListener() {
            fr_text.text = "Настройки процессора"
            setNewFragment(fr_cpu)
        }

        tx_battaty.setOnClickListener() {
            fr_text.text = "Об батареи"
            setNewFragment(fr_battary)
        }

        tx_displey.setOnClickListener() {
            fr_text.text = "Настройки экрана"
            setNewFragment(fr_displey)
        }

        tx_gpu.setOnClickListener() {
            fr_text.text = "Настройки графического процессора"
            setNewFragment(fr_gpu)
        }

    }
}