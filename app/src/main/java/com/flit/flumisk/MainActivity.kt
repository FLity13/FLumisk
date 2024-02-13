package com.flit.flumisk

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.stericson.RootTools.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //##########################################################################################
        // Подключение и назначение
        val displey = Displey()
        val cpu = CPU()

        var displeyS = 60
        var cpuS = cpu.getMaxCpuFrequency().toInt()
        var CPU_CONST = cpu.getMaxCpuFrequency().toInt()

        val pashalka1 = "Будте причиной улыбок"
        val pashalka2 = "Тили-тили трали-вали"
        val pashalka3 = "Звезды сияют ярче в тёмные часы"

        val displeySelect = findViewById<Button>(R.id.ButtonD)
        val cpuSelect = findViewById<Button>(R.id.ButtonC)
        val apply = findViewById<Button>(R.id.apply)

        val pashalochka = findViewById<TextView>(R.id.Pashalka)

//        var Clocks = findViewById<TextView>(R.id.clocks)

//        val applyClocks = findViewById<Button>(R.id.apply)

//        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        var RootEoD = false
        val RootStatus = findViewById<TextView>(R.id.RootStatus)
//        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)
        //##########################################################################################

        //##########################################################################################
        // Получения данных ползунка (CPU_Clock)
//        class SeekBarHandler(private val seekBar: SeekBar) {
//            private var value: Int = 0
//            private val minValue = 300000
//            private var maxValue = 0
//
//            init {
//                val maxValue = setCpu.getMaxCpuFrequency().toInt()
//                this.maxValue = maxValue
//
//                seekBar.max = 100
//
//                seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
//                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                        value = minValue + progress * ((maxValue - minValue) / 100)
//                        Clocks.text = value.toString() + " кГц"
//                    }
//
//                    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
//
//                    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
//                })
//            }
//
//            fun getValue(): Int {
//                return value
//            }
//        }
        //##########################################################################################

        //##########################################################################################
        // Проверка Root
        fun checkRootAccess() {
            if (RootTools.isRootAvailable()) {
                // "root" доступ доступен
                Toast.makeText(this, "Root доступ обнаружен!", Toast.LENGTH_SHORT).show()
                RootStatus.text = "Доступен"
                RootStatus.setTextColor(ContextCompat.getColor(this, R.color.cMainGreen))
                RootEoD = true
            } else {
                // "root" доступ отсутствует
                Toast.makeText(this, "Root доступ не обнаружен!", Toast.LENGTH_SHORT).show()
                RootStatus.text = "Не доступен"
                RootStatus.setTextColor(ContextCompat.getColor(this, R.color.cMainPink))
//                toggleButton.text = "Нет ROOT доспупа!"
                RootEoD = false
            }
        }
        checkRootAccess()
        //##########################################################################################

        //##########################################################################################
        // Частота экрана
//        toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked) {
//                if(RootEoD) {
//                    // Выполнить действие для состояния "Function B"
//                    setDispley.setDispley(120)
//                } else {
//                    Toast.makeText(this, "Root доступ не обнаружен!", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                // Выполнить действие для состояния "Function A"
//                setDispley.setDispley(60)
//            }
//        }
        displeySelect.text = displeyS.toString() + " Гц"
        displeySelect.setOnClickListener() {
            when(displeyS) {
                60 -> displeyS = 90
                90 -> displeyS = 120
                120 -> displeyS = 60
            }
            displeySelect.text = displeyS.toString() + " Гц"
        }
        //##########################################################################################

        //##########################################################################################
        // Управление частотой процессора
//        applyClocks.setOnClickListener {
//            val seekBarHandler = SeekBarHandler(seekBar)
//            val clocksCPU = seekBarHandler.getValue().toInt()
//            setCpu.setCPU(clocksCPU)
//        }
        cpuSelect.text = (cpuS/1000).toString() + " MГц"
        cpuSelect.setOnClickListener() {
            when(cpuS) {
                CPU_CONST -> cpuS = 300000
                300000 -> cpuS = CPU_CONST/2
                CPU_CONST/2 -> cpuS = CPU_CONST
            }
            cpuSelect.text = (cpuS/1000).toString() + " MГц"
        }
        //##########################################################################################

        //##########################################################################################
        // Подтверждние выбора
        apply.setOnClickListener() {
            cpu.setCPU(cpuS)
            displey.setDispley(displeyS)
        }
        //##########################################################################################

        // Всякое
        fun generateRandomNumber(): Int {
            return Random.nextInt(1, 4) // Генерируем случайное число от 1 до 3
        }
        val pashlk = generateRandomNumber()
        if (pashlk == 1) {
            pashalochka.text = pashalka1
        } else if(pashlk == 2) {
            pashalochka.text = pashalka2
        } else if(pashlk == 3) {
            pashalochka.text = pashalka3
        }
    }

}

