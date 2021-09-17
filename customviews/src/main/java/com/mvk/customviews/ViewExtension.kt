package com.mvk.customviews

import android.view.View
import android.view.ViewGroup

fun View.visible() {
	this.visibility = View.VISIBLE
}

fun View.gone() {
	this.visibility = View.GONE
}

fun View.invisible() {
	this.visibility = View.INVISIBLE
}

fun ViewGroup.visible() {
	this.visibility = View.VISIBLE
}

fun ViewGroup.gone() {
	this.visibility = View.GONE
}

fun ViewGroup.invisible() {
	this.visibility = View.INVISIBLE
}

fun View.setMargin(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
	val params = (layoutParams as? ViewGroup.MarginLayoutParams)
	params?.setMargins(
		left ?: params.leftMargin,
		top ?: params.topMargin,
		right ?: params.rightMargin,
		bottom ?: params.bottomMargin
	)
	layoutParams = params
}

