package com.mvk.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mvk.mylibrary.databinding.ActivityLibraryBinding

class LibraryActivity : AppCompatActivity() {

	private lateinit var binding: ActivityLibraryBinding

	companion object {
		private lateinit var logoutCallback: (Boolean) -> Unit

		fun initLogoutCallback(logoutCallback : (Boolean) -> Unit) {
			this.logoutCallback = logoutCallback
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_library)
		setListeners()
	}

	private fun setListeners() {
		binding.libLogoutBtn.setOnClickListener {
			logoutCallback(true)
			finish()
		}
		binding.libLogoutFailBtn.setOnClickListener {
			logoutCallback(false)
			finish()
		}
	}

}