package ru.vidos.badhabits

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.vidos.badhabits.adapters.LOG_TAG
import ru.vidos.badhabits.data.Habit

class MainViewModel : ViewModel() {

    private val habits = arrayListOf<Habit>()
    val habitsList = MutableLiveData<List<Habit>>()

    fun createHabit(habit: Habit) {

        habits.add(habit)
        habitsList.value = habits

        Log.d(LOG_TAG, "MainViewModel: ${habitsList.value.hashCode()}")
    }

}