package com.ibsu.draganddrop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibsu.draganddrop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvAdapter: UsefulDocsAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        setupTextView()
    }

    private fun setupTextView() {
        binding.textView.setOnDragListener { view, dragEvent ->
            val dragEventAction = dragEvent.action
            val draggedView = dragEvent.localState as View

            val originalTextValue = binding.textView.text
            if(dragEvent!=null) {
                when (dragEventAction) {
                    DragEvent.ACTION_DRAG_ENTERED -> {
                        Log.d("DragEvent", "ACTION_DRAG_ENTERED")
                        Log.d("ssss", dragEvent?.clipData?.getItemAt(0)?.text.toString())
                        binding?.textView?.text = dragEvent?.clipData?.getItemAt(0)?.text
                        return@setOnDragListener true

                    }

                    DragEvent.ACTION_DRAG_EXITED ->{
                        Log.d("DragEvent", "ACTION_DRAG_EXITED")
                        binding.textView.text = originalTextValue
                        return@setOnDragListener false
                }
                    DragEvent.ACTION_DROP -> {
                        Log.d("DragEvent", "ACTION_DROP")
                        binding.textView.text = dragEvent.clipData.getItemAt(0).text
                        return@setOnDragListener true

                    }
                }
            }
            return@setOnDragListener true
        }
    }

    private fun setupRecycler() {
        rvAdapter = UsefulDocsAdapter(this)
        val recycler = binding.rv
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = rvAdapter
        recycler.layoutManager = layoutManager
        rvAdapter.submitList(documentList)
    }

}