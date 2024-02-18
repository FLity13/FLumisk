package com.flit.flumisk

import com.stericson.RootShell.*
import com.stericson.RootShell.execution.Command
import com.stericson.RootTools.*
import java.io.IOException

class cpu {

    fun setCPU(Frequency: Int) {
        if (RootShell.isAccessGiven()) {
            val numberOfCores = Runtime.getRuntime().availableProcessors()

            for (i in 0 until numberOfCores) {
                val commandMax = Command(
                    0,
                    "su -c echo $Frequency > /sys/devices/system/cpu/cpu$i/cpufreq/scaling_max_freq"
                )
                val commandMin = Command(
                    1,
                    "su -c echo $Frequency > /sys/devices/system/cpu/cpu$i/cpufreq/scaling_min_freq"
                )
                RootShell.getShell(true).add(commandMax)
                RootShell.getShell(true).add(commandMin)
            }
        } else {
            // Обработка случая, когда Root-доступ отсутствует
        }
    }

    fun get_freqMax_cpu(): String {
        var maxFreq = ""
        try {
            val cmd = "cat /sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
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
            val numberOfCores = Runtime.getRuntime().availableProcessors()

            for (i in 0 until numberOfCores) {
                val commandMax = Command(
                    0,
                    "su -c echo $maxFrequency > /sys/devices/system/cpu/cpu$i/cpufreq/scaling_max_freq"
                )
                val commandMin = Command(
                    1,
                    "su -c echo $minFrequency > /sys/devices/system/cpu/cpu$i/cpufreq/scaling_min_freq"
                )
                RootShell.getShell(true).add(commandMax)
                RootShell.getShell(true).add(commandMin)
            }
        } else {
            // Обработка случая, когда Root-доступ отсутствует
        }

    }
}