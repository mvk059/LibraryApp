package com.mvk.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LibraryActivity : AppCompatActivity() {

	companion object {
//		private lateinit var logoutCallback: (Boolean) -> Unit
//
//		fun initLogoutCallback(logoutCallback : (Boolean) -> Unit) {
//			this.logoutCallback = logoutCallback
//		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_library)
//		binding = DataBindingUtil.setContentView(this, R.layout.activity_library)
//		setListeners()
	}

//	private fun setListeners() {
//		binding.libLogoutBtn.setOnClickListener {
//			logoutCallback(true)
//			finish()
//		}
//		binding.libLogoutFailBtn.setOnClickListener {
//			logoutCallback(false)
//			finish()
//		}
//	}

}