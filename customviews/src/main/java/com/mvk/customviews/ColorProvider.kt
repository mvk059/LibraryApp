package com.mvk.customviews

import android.content.Context
import android.view.ContextThemeWrapper

object ColorProvider {
	var primaryMainColor = R.color.primaryMain
	var greyscaleHeaderColor = R.color.greyscaleHeader
	var statesErrorColor = R.color.statesError
	var whiteColor = R.color.pure_white

	fun getThemeColor(context: Context, colorAttrId: Int): Int =
		ContextThemeWrapper(context, R.style.AppTheme).getColor(colorAttrId)


}