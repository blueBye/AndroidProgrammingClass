package info.navidlabs.androidprogrammingclass

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class CustomBCR: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "TEST_ACTION") {
            Log.i("Broadcast Custom Action", "custom broadcast receiver")
        }
    }
}