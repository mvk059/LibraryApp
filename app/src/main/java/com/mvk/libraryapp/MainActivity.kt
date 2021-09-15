package com.mvk.libraryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mvk.libraryapp.databinding.ActivityMainBinding
import com.mvk.mylibrary.LibraryActivity

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
		navigateToNextPage()
	}

	private fun navigateToNextPage() {
		binding.mainBtn.setOnClickListener {
			val intent = Intent(this, LibraryActivity::class.java)
			startActivity(intent)
			LibraryActivity.initLogoutCallback {
				logoutUser(it)
			}
		}
	}

	private fun logoutUser(isLogout: Boolean) {
		if (isLogout)
			Toast.makeText(this, "Logout successful", Toast.LENGTH_LONG).show()
		else
			Toast.makeText(this, "Logout failed", Toast.LENGTH_LONG).show()
	}
}