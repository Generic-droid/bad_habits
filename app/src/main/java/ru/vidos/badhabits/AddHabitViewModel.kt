package ru.vidos.badhabits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.vidos.badhabits.data.Habit

class AddHabitViewModel(_habit: Habit) : ViewModel() {

    var habit: Habit = _habit

}

class AddHabitViewModelFactory(private val habit: Habit) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddHabitViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddHabitViewModel(habit) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}