package com.flit.flumisk

import android.widget.TextView
import java.io.BufferedReader
import com.stericson.RootShell.*
import com.stericson.RootShell.execution.Command
import com.stericson.RootTools.*
import android.os.Handler
import java.io.File
import java.io.FileReader

class get_info {

    fun processString(inputString: String): String {
        return when {
            inputString.length > 3 -> inputString.substring(0, inputString.length - 3)
            inputString.length == 3 -> inputString
            else -> "??? °C"
        }
    }

//    private val handler = Handler()
//    private var value: Int = 0
//    private var textView: TextView? = null
//
//    fun startUpdatingValue(textViewToUpdate: TextView) {
//        textView = textViewToUpdate
//        handler.postDelayed(object : Runnable {
//            override fun run() {
//                // Чтение значения из файла (здесь нужно использовать RootShell)
//
//                val file = File("путь_к_файлу_с_значением") // Замените на путь к вашему файлу
//                if (file.exists()) {
//                    val content: String = file.readText().trim()
//                    value = content.toInt()
//                }
//
//                // Обновление значения в TextView
//                textView?.text = "Значение: $value"
//
//                // Повторно запускаем через 2 секунды
//                handler.postDelayed(this, 2000)
//            }
//        }, 0)
//    }
//
//    fun stopUpdatingValue() {
//        handler.removeCallbacksAndMessages(null)
//    }

}