package com.flit.flumisk

import com.stericson.RootShell.*
import com.stericson.RootShell.execution.Command
import com.stericson.RootShell.execution.Shell
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import com.stericson.RootTools.*

class gpu {

    fun set_gpu_freq(Frequency : String) {

        if (RootShell.isAccessGiven()) {

            val gpu_settings_freqMax_pach = "/sys/kernel/gpu/gpu_max_clock"
            val gpu_settings_freqMin_pach = "/sys/kernel/gpu/gpu_min_clock"
            val gpu_freq_table = "/sys/kernel/gpu/gpu_freq_table"

            val set_freqMax_gpu = Command(3,"su -c echo $Frequency > $gpu_settings_freqMax_pach")
            RootShell.getShell(true).add(set_freqMax_gpu)
            val set_freqMin_gpu = Command(4,"su -c echo $Frequency > $gpu_settings_freqMin_pach")
            RootShell.getShell(true).add(set_freqMin_gpu)

        } else {
            // Обработка случая, когда Root-доступ отсутствует
        }

    }

    fun get_freqMax_cpu(): String {
        var maxFreq = ""
        try {
            val cmd = "cat /sys/kernel/gpu/gpu_max_clock"
            val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", cmd))
            val reader = process.inputStream.bufferedReader()
            maxFreq = reader.readLine()
            reader.close()
            process.destroy()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return maxFreq
    }

    fun set_max_main_freq(minFrequency: Int, maxFrequency: Int) {
        if (RootShell.isAccessGiven()) {
            val commandMax = Command(
                0,
                "su -c echo $maxFrequency > /sys/kernel/gpu/gpu_max_clock"
            )
            val commandMin = Command(
                1,
                "su -c echo $minFrequency > /sys/kernel/gpu/gpu_min_clock"
            )
            RootShell.getShell(true).add(commandMax)
            RootShell.getShell(true).add(commandMin)
        }
    }

    fun getLastThreeCharacters(inputText: String): String {
        return if (inputText.length >= 3) {
            inputText.takeLast(3)
        } else {
            inputText
        }
    }

    fun readLastThreeCharactersOfFile(): Int? {
        var maxFreq = ""
        try {
            val cmd = "cat /sys/kernel/gpu/gpu_freq_table"
            val process = Runtime.getRuntime().exec(arrayOf("sh", "-c", cmd))
            val reader = process.inputStream.bufferedReader()
            maxFreq = reader.readLine()
            reader.close()
            process.destroy()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return getLastThreeCharacters(maxFreq).toInt()
    }

}