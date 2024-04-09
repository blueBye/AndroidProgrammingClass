package info.navidlabs.androidprogrammingclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.BackoffPolicy
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import info.navidlabs.androidprogrammingclass.ui.theme.AndroidProgrammingClassTheme
import java.time.Duration
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProgrammingClassTheme {
                LaunchedEffect(key1 = Unit) {
                    val workRequest = PeriodicWorkRequestBuilder<CustomWorker>(
                        repeatInterval = 1,
                        repeatIntervalTimeUnit = TimeUnit.HOURS,
                    ).setBackoffCriteria(
                        backoffPolicy = BackoffPolicy.LINEAR,
                        duration = Duration.ofSeconds(15)
                    ).build()

                    val workManager = WorkManager.getInstance(applicationContext)
                    workManager.enqueueUniquePeriodicWork(
                        "myWorkerName",
                        ExistingPeriodicWorkPolicy.KEEP,
                        workRequest
                    )
                }
            }
        }
    }
}
