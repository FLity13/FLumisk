package com.flit.flumisk

import com.stericson.RootShell.RootShell
import com.stericson.RootShell.execution.Command
import android.content.Context
import android.hardware.display.DisplayManager
import android.os.Build

class displey {

    fun set_displey_clock(refreshRate: Int) {
        if (RootShell.isAccessGiven()) {
            val refreshRateStr = refreshRate.toString() // Преобразование Int в String

            val command = Command(1, "su -c settings put system peak_refresh_rate $refreshRateStr") // Настройка максимальной частоты обновления экрана
            val command2 = Command(2, "su -c settings put system minimum_refresh_rate $refreshRateStr") // Настройка минимальной частоты обновления экрана

            val shell = RootShell.getShell(true)
            shell.add(command)
            shell.add(command2)

            // Дожидаемся выполнения команд
        } else {
            // Root доступ не предоставлен
        }
    }


}