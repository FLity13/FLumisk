package com.flit.flumisk

import java.io.IOException
import com.stericson.RootShell.RootShell
import com.stericson.RootShell.execution.Command

class CPU {

    fun getMaxCpuFrequency(): String {
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

//    fun setMinCpuFrequency(newMinFrequency: Int) {
//        val numberOfCores = Runtime.getRuntime().availableProcessors()
//
//        for (i in 0 until numberOfCores) {
//            val minFrequencyFile = File("/sys/devices/system/cpu/cpu$i/cpufreq/scaling_min_freq")
//
//            // Устанавливаем новую минимальную частоту процессора
//            minFrequencyFile.writeText(newMinFrequency.toString())
//        }
//    }
//
//    fun setMaxCpuFrequency(newMaxFrequency: Int) {
//        val numberOfCores = Runtime.getRuntime().availableProcessors()
//
//        for (i in 0 until numberOfCores) {
//            val maxFrequencyFile = File("/sys/devices/system/cpu/cpu$i/cpufreq/scaling_max_freq")
//
//            // Устанавливаем новую максимальную частоту процессора
//            maxFrequencyFile.writeText(newMaxFrequency.toString())
//        }
//    }

    fun CoresI() : String {
        if (RootShell.isAccessGiven()) {
            return Runtime.getRuntime().availableProcessors().toString()
        } else {
            return "0"
        }
    }

    fun setCPU(Frequency: Int) {
        if (RootShell.isAccessGiven()) {
            val numberOfCores = Runtime.getRuntime().availableProcessors()

            for (i in 0 until numberOfCores) {
                val commandMax = Command(0, "su -c echo $Frequency > /sys/devices/system/cpu/cpu$i/cpufreq/scaling_max_freq")
                val commandMin = Command(1, "su -c echo $Frequency > /sys/devices/system/cpu/cpu$i/cpufreq/scaling_min_freq")
                RootShell.getShell(true).add(commandMax)
                RootShell.getShell(true).add(commandMin)
            }
        } else {
            // Обработка случая, когда Root-доступ отсутствует
        }
    }

}