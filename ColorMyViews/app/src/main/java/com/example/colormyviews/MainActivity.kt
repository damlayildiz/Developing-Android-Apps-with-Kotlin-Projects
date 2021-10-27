package com.example.colormyviews

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setListeners()
	}
	private fun setListeners() {
		val boxes: List<Int> = listOf(R.id.box_one_text, R.id.box_two_text, R.id.box_three_text,
			R.id.box_four_text, R.id.box_five_text, R.id.red_button, R.id.yellow_button, R.id.green_button)

		for (box in boxes) {
			findViewById<TextView>(box).setOnClickListener {
				makeColored(it)
			}
		}
	}

	@SuppressLint("ResourceType")
	private fun makeColored(view: View) {
		when (view.id) {

			// Boxes using Color class colors for background
			R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
			R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

			// Boxes using Android color resources for background
			R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
			R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
			R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

			// Boxes using custom colors for background
			R.id.red_button -> findViewById<TextView>(R.id.box_three_text).setBackgroundResource(Color.RED)
			R.id.yellow_button -> findViewById<TextView>(R.id.box_four_text).setBackgroundResource(Color.YELLOW)
			R.id.green_button -> findViewById<TextView>(R.id.box_five_text).setBackgroundResource(Color.GREEN)
			else -> view.setBackgroundColor(Color.LTGRAY)
		}
	}
}