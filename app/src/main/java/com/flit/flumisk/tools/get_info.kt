package com.flit.flumisk

import java.io.BufferedReader
import com.stericson.RootShell.*
import com.stericson.RootShell.execution.Command
import com.stericson.RootTools.*
import java.io.FileReader

class get_info {

    fun processString(inputString: String): String {
        return when {
            inputString.length > 3 -> inputString.substring(0, inputString.length - 3)
            inputString.length == 3 -> inputString
            else -> "??? °C"
        }
    }

//    fun get_max_freq(filePath: String): String {
//        var firstWord = ""
//        RootShell.getShell(true).use { shell ->
//            val command = "cat $filePath | awk '{print \$1}'" // Команда для чтения первого слова из файла
//            val result = shell.run(command) // Выполнение команды через RootShell
//            if (result.isSuccessful) {
//                firstWord = result.out.joinToString().trim() // Получение вывода команды
//            } else {
//                // Обработка ошибки или вывод информации об ошибке
//            }
//        }
//        return firstWord
//    }
//
//    fun get_min_freq(filePath: String): String {
//        var lastThreeChars = ""
//        RootShell.getShell(true).use { shell ->
//            val command = "cat $filePath | rev | cut -c 1-3 | rev" // Команда для чтения последних трех символов из файла
//            val result = shell.run(command)
//            if (result.isSuccessful) {
//                lastThreeChars = result.out.joinToString().trim()
//            } else {
//                // Обработка ошибки или вывод информации об ошибке
//            }
//        }
//        return lastThreeChars
//    }
//
//    fun get_min_freq(filePath: String): String {
//        var lastThreeChars = ""
//        BufferedReader(FileReader(filePath)).use { reader ->
//            val line: String? = reader.readLine()
//            line?.let {
//                val length = it.length
//                lastThreeChars = if (length >= 3) {
//                    it.substring(length - 3)
//                } else {
//                    it
//                }
//            }
//        }
//        return lastThreeChars
//    }


}