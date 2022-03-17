package ru.vidos.badhabits

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.vidos.badhabits.data.Habit
import ru.vidos.badhabits.databinding.ActivityAddHabitBinding

class AddHabitActivity : AppCompatActivity() {

    private val viewModel by viewModels<AddHabitViewModel> {
        AddHabitViewModelFactory(
            intent.getSerializableExtra(EXTRA_HABIT) as Habit
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityAddHabitBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_habit)

        binding.viewModel = viewModel

        binding.saveButton.setOnClickListener {
            when {
                viewModel.habit.title.isBlank() -> {
                    binding.titleInputLayout.error = "Empty field"
                }
                viewModel.habit.description.isBlank() -> {
                    binding.descriptionInputLayout.error = "Empty field"
                }
                viewModel.habit.quantity.isBlank() -> {
                    binding.quantityInputLayout.error = "Empty field"
                }
                viewModel.habit.periodicity.isBlank() -> {
                    binding.periodicityInputLayout.error = "Empty field"
                }
                else -> {
                    val resultIntent = Intent().apply {
                        putExtra(EXTRA_HABIT, viewModel.habit)
                    }
                    setResult(RESULT_OK, resultIntent)
                    finish()
                }
            }
        }
    }
}