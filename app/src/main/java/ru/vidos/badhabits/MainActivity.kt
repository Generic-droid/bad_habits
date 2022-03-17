package ru.vidos.badhabits

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.vidos.badhabits.adapters.HabitsRecyclerViewAdapter
import ru.vidos.badhabits.data.Habit
import ru.vidos.badhabits.databinding.ActivityMainBinding

const val EXTRA_HABIT = "habit"

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {

            val data: Intent? = result.data
            val habit = data?.getSerializableExtra(EXTRA_HABIT) as? Habit
            if (habit is Habit) {
                viewModel.createHabit(habit)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Activity
        binding.lifecycleOwner = this

        // Giving the binding access to the MainViewModel
        binding.viewModel = viewModel

        val adapter = HabitsRecyclerViewAdapter {
            openAddHabitActivityForResult(it)
        }

        // Sets the adapter of the habitsRecyclerView RecyclerView
        binding.habitsRecyclerView.adapter = adapter

        binding.habitsFab.setOnClickListener {

            openAddHabitActivityForResult(Habit())
        }
    }

    private fun openAddHabitActivityForResult(habit: Habit) {
        val intent = Intent(this, AddHabitActivity::class.java).apply {
            putExtra(EXTRA_HABIT, habit)
        }
        resultLauncher.launch(intent)
    }
}