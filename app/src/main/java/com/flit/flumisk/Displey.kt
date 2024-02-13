package com.flit.flumisk

import com.stericson.RootShell.RootShell
import com.stericson.RootShell.execution.Command
import android.content.Context
import android.hardware.display.DisplayManager
import android.os.Build

class Displey {

//    fun getMaxRefreshRate(context: Context): Float {
//        val displayManager = context.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
//        var maxRefreshRate = 0f
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            for (display in displayManager.displays) {
//                for (mode in display.supportedModes) {
//                    val refreshRate = mode.refreshRate
//                    if (refreshRate > maxRefreshRate) {
//                        maxRefreshRate = refreshRate
//                    }
//                }
//            }
//        }
//
//        return maxRefreshRate
//    }

    fun setDispley(refreshRate: Int) {
        if (RootShell.isAccessGiven()) {
            val refreshRateStr = refreshRate.toString() // Преобразование Int в String

            val command = Command(1, "settings put system peak_refresh_rate $refreshRateStr") // Настройка максимальной частоты обновления экрана
            val command2 = Command(2, "settings put system minimum_refresh_rate $refreshRateStr") // Настройка минимальной частоты обновления экрана

            val shell = RootShell.getShell(true)
            shell.add(command)
            shell.add(command2)

            // Дожидаемся выполнения команд
        } else {
            // Root доступ не предоставлен
        }
    }
}