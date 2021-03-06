package ru.vidos.badhabits.adapters

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDividerItemDecoration
import ru.vidos.badhabits.R
import ru.vidos.badhabits.data.Habit

const val LOG_TAG = "myLogs"

@BindingAdapter("habitsListData")
fun bindDealsRecyclerView(recyclerView: RecyclerView, data: List<Habit>?) {

    val adapter = recyclerView.adapter as HabitsRecyclerViewAdapter

    // This call notifies the RecyclerView that a new list of data is ready.
    adapter.submitList(null)
    adapter.submitList(data)

    Log.d(LOG_TAG, "BindingAdapter: $data, $adapter")

}

@BindingAdapter("tint")
fun ImageView.setTintDrawable(item: Habit) {

    setColorFilter(
        if(item.type) {
            item.color.toColorInt()
        } else "#FF0000".toColorInt()
            )
}

@BindingAdapter("priority")
fun TextView.setPriority(item: Habit) {
    text = resources.getStringArray(R.array.habitPriority)[item.priority]
}

/**
 * Sets the imageDrawable for the habit type
 */
@BindingAdapter("src")
fun ImageView.setDrawable(item: Habit) {
    setImageResource(
        if (item.type) {
            R.drawable.ic_good_habit_smile
        }   else  R.drawable.ic_bad_habit_smile
    )
}