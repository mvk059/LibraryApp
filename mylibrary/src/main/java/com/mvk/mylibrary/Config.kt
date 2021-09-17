package com.mvk.mylibrary

object Config {

	private lateinit var logoutInterface: LogoutInterface

	fun performLogout(isLogout: Boolean) {
		logoutInterface.logout(isLogout)
	}

	fun initConfig(logoutInterface: LogoutInterface) {
		this.logoutInterface = logoutInterface
	}

//	fun getSharedPref(): SharedPrefContract {
//		return this.logoutInterface.getSharedPref()
//	}
}