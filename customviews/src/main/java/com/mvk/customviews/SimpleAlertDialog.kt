package com.mvk.customviews

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction

class SimpleAlertDialog : DialogFragment() {

	private lateinit var onDismiss: () -> Unit

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
		return LayoutInflater.from(context).inflate(R.layout.layout_simple_alert_dialog, null)
	}

	override fun onDismiss(dialog: DialogInterface) {
		onDismiss()
		super.onDismiss(dialog)
	}

	override fun onStart() {
		super.onStart()
		dialog?.window?.setLayout(
			WindowManager.LayoutParams.MATCH_PARENT,
			WindowManager.LayoutParams.WRAP_CONTENT
		)
	}

	fun configureDialog(
		title: String,
		message: String,
		titleColor: Int = ColorProvider.getThemeColor(
			requireContext(),
			ColorProvider.primaryMainColor
		),
		messageColor: Int = ColorProvider.getThemeColor(
			requireContext(),
			ColorProvider.greyscaleHeaderColor
		),
		backgroundColor: Int = ColorProvider.getThemeColor(
			requireContext(),
			ColorProvider.whiteColor
		),
		positiveText: String = "Ok",
		negativeText: String = "",
		positiveTextColor: Int = ColorProvider.getThemeColor(
			requireContext(),
			ColorProvider.primaryMainColor
		),
		negativeTextColor: Int = ColorProvider.getThemeColor(
			requireContext(),
			ColorProvider.statesErrorColor
		),
		onPositiveClickListener: () -> Unit = {},
		onNegativeClickListener: () -> Unit = {},
		onDismiss: () -> Unit = {}
	) {
		dialog?.findViewById<ConstraintLayout>(R.id.root)?.background =
			dialog?.findViewById<ConstraintLayout>(R.id.root)?.background?.let {
				(it.mutate() as InsetDrawable).run {
					drawable = (drawable?.mutate() as GradientDrawable).let {
						it.setColor(backgroundColor)
						it
					}
					this
				}
			}
		dialog?.findViewById<TextView>(R.id.dialogTitleTv)?.apply {
			text = title
			setTextColor(titleColor)
			if (title.isEmpty()) {
				gone()
			}
		}
		dialog?.findViewById<TextView>(R.id.dialogDescriptionTv)?.apply {
			text = message
			setTextColor(messageColor)
			setMargin(
				context.convertDpToPx(16),
				context.convertDpToPx(16),
				context.convertDpToPx(16)
			)
		}
		dialog?.findViewById<TextView>(R.id.dialogPositiveButton)?.apply {
			text = positiveText
			setTextColor(positiveTextColor)
			setOnClickListener {
				dismiss()
				onPositiveClickListener()
			}
		}
		dialog?.findViewById<TextView>(R.id.dialogNegativeButton)?.apply {
			text = negativeText
			setTextColor(negativeTextColor)
			if (negativeText.isEmpty()) {
				gone()
			} else {
				visible()
			}
			setOnClickListener {
				dismiss()
				onNegativeClickListener()
			}
		}
		this.onDismiss = onDismiss
	}

	companion object {
		fun showDialog(
			fragmentTransaction: FragmentTransaction,
			context: Context,
			title: String,
			message: String,
			titleColor: Int = ColorProvider.getThemeColor(
				context,
				ColorProvider.primaryMainColor
			),
			messageColor: Int = ColorProvider.getThemeColor(
				context,
				ColorProvider.greyscaleHeaderColor
			),
			backgroundColor: Int = ColorProvider.getThemeColor(
				context,
				ColorProvider.whiteColor
			),
			positiveText: String = "Ok",
			negativeText: String = "",
			positiveTextColor: Int = ColorProvider.getThemeColor(
				context,
				ColorProvider.primaryMainColor
			),
			negativeTextColor: Int = ColorProvider.getThemeColor(
				context,
				ColorProvider.statesErrorColor
			),
			onPositiveClickListener: () -> Unit = {},
			onNegativeClickListener: () -> Unit = {},
			onDismiss: () -> Unit = {}
		): SimpleAlertDialog {
			val dialogFragment = SimpleAlertDialog()
			dialogFragment.show(fragmentTransaction, "dialog")
			withDelayOnMain(50) {
				dialogFragment.configureDialog(
					title,
					message,
					titleColor,
					messageColor,
					backgroundColor,
					positiveText,
					negativeText,
					positiveTextColor,
					negativeTextColor,
					onPositiveClickListener,
					onNegativeClickListener,
					onDismiss
				)
			}
			return dialogFragment
		}
	}
}