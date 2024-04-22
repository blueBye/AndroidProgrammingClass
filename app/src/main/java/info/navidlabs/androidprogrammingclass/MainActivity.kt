package info.navidlabs.androidprogrammingclass

import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import info.navidlabs.androidprogrammingclass.ui.theme.AndroidProgrammingClassTheme
import java.math.BigInteger
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProgrammingClassTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val p = "Hello Android"

                    val md5 = MessageDigest.getInstance("MD5")
                    val sha256 = MessageDigest.getInstance("SHA-256")

                    val hMD5 = md5.digest(p.toByteArray())
                    val hSHA256 = sha256.digest(p.toByteArray())

                    Log.i("Hash", "md5: ${BigInteger(1, hMD5).toString(16).padStart(32, '0')}")
                    Log.i("Hash", "sha256: ${BigInteger(1, hSHA256).toString(16).padStart(32, '0')}")
                }
            }
        }
    }
}
