package ru.vidos.badhabits.data

import java.io.Serializable

data class Habit (
    var color: String = "#ADFF2F",
    var title: String = "",
    var description: String = "",
    var priority: Int = 0,
    var type: Boolean = true,
    var quantity: String = "",
    var periodicity: String = ""
) : Serializable