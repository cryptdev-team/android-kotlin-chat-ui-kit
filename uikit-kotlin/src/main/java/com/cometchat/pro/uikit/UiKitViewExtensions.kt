package com.cometchat.pro.uikit

import android.app.Activity
import android.app.KeyguardManager
import android.content.Context
import android.os.Build
import android.view.WindowManager

object UiKitViewExtensions {
    /**
     * Edited By CryptoDev:
     * call this function in activities after calling setContentView(view) to make this activity able to turn screen on
    when launched if the mobile screen is off (in lock status) don't forget to add android:showWhenLocked="true" and
    android:turnScreenOn="true" in manifest file
     */
    fun Activity.turnOnScreenIfLocked() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true)
            setTurnScreenOn(true)
            val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            keyguardManager.requestDismissKeyguard(this, null)
        } else {
            window.addFlags(
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
            )
        }
    }
}