package soulever.project.utils

import android.app.Activity
import android.app.AlertDialog
import soulever.project.R

class LoadingDialog(activity: Activity) {
    val myActivity = activity
    private lateinit var loadingDialog: AlertDialog

    fun startLoading() {
        val builder = AlertDialog.Builder(myActivity)
        val inflater = myActivity.layoutInflater
        builder.setView(inflater.inflate(R.layout.custom_loading, null))
        builder.setCancelable(false)

        loadingDialog = builder.create()
        loadingDialog.show()
    }

    fun dismiss() {
        loadingDialog.dismiss()
    }


}