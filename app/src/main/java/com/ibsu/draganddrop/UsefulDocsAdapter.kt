package com.ibsu.draganddrop

import android.content.ClipData
import android.content.Context
import android.os.Build
import android.os.CombinedVibration
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ibsu.draganddrop.databinding.ItemBinding


class UsefulDocsAdapter(private val context: Context) :
    ListAdapter<UsefulDocsItem, UsefulDocsAdapter.ItemViewHolder>(ItemDiffCallback()) {
    private var clipData: ClipData? = null


    inner class ItemViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(position: Int) {


            val source = getItem(absoluteAdapterPosition)
            binding.textView.text = source.nameEn

            binding.cardView.setOnLongClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    val vibrator = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager

                    // Create a VibrationEffect for newer Android versions
                    val effect = VibrationEffect.createOneShot(100, VibrationEffect.EFFECT_DOUBLE_CLICK)

                    // Create a CombinedVibration with the single VibrationEffect
                    val combinedVibration = CombinedVibration.createParallel(effect)

                    vibrator.cancel()
                    vibrator.vibrate(combinedVibration)
                } else {
                    // Initialize the Vibrator
                    // Create a VibrationEffect for older versions (deprecated, but still works)
                    @Suppress("DEPRECATION")
                    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    vibrator.cancel()
                    @Suppress("DEPRECATION")
                    vibrator.vibrate(100)

                }

                 clipData =
                    ClipData.newPlainText("textContent", binding.textView.text.toString())
                val myShadowBuilder = View.DragShadowBuilder(it);
                it.startDragAndDrop(clipData, myShadowBuilder, it, 0)
                return@setOnLongClickListener true

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(position)
    }

    private class ItemDiffCallback : DiffUtil.ItemCallback<UsefulDocsItem>() {
        override fun areItemsTheSame(oldItem: UsefulDocsItem, newItem: UsefulDocsItem): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: UsefulDocsItem, newItem: UsefulDocsItem): Boolean =
            oldItem == newItem

    }

}