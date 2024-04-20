package info.navidlabs.androidprogrammingclass

import android.net.http.HttpException
import android.os.Build
import android.os.Bundle
import android.os.ext.SdkExtensions
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.navidlabs.androidprogrammingclass.models.PoemItem
import info.navidlabs.androidprogrammingclass.ui.theme.AndroidProgrammingClassTheme
import info.navidlabs.androidprogrammingclass.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProgrammingClassTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var poem by remember { mutableStateOf(PoemItem()) }
                    val scope = rememberCoroutineScope()

                    LaunchedEffect(key1 = true) {
                        scope.launch(Dispatchers.IO) {
                            val response = try {
                                RetrofitInstance.api.getRandomPoem()
                            } catch (e: Exception) {
                                Log.e("Retrofit", "Error::${e.message}")
                                return@launch
                            }

                            if(response.isSuccessful && response.body() != null) {
                                withContext(Dispatchers.Main) {
                                    poem = response.body()!!.first()
                                    Log.i("Retrofit", response.code().toString())
                                    Log.i("Retrofit", response.body().toString())
                                }
                            }
                            else {
                                Log.e("Retrofit", response.code().toString())
                            }
                        }
                    }

                    Button(onClick = {
                        GlobalScope.launch(Dispatchers.IO) {
                            val response = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(
                                    Build.VERSION_CODES.TIRAMISU) >= 7) {
                                try {
                                    RetrofitInstance.api.getRandomPoem()
                                } catch (e: HttpException) {
                                    Log.e("Retrofit", "HTTP Error::${e.message}")
                                    return@launch
                                } catch (e: IOException) {
                                    Log.e("Retrofit", "IO Error::${e.message}")
                                    return@launch
                                }
                            } else {
                                try {
                                    RetrofitInstance.api.getRandomPoem()
                                } catch (e: Exception) {
                                    Log.e("Retrofit", "Error::${e.message}")
                                    return@launch
                                }
                            }

                            if(response.isSuccessful && response.body() != null) {
                                withContext(Dispatchers.Main) {
                                    poem = response.body()!!.first()
                                    Log.i("Retrofit", response.code().toString())
                                    Log.i("Retrofit", response.body().toString())
                                }
                            }
                            else {
                                Log.e("Retrofit", response.code().toString())
                            }
                        }
                    }) {
                        Text(text="New Poem")
                    }

                    PoemCard(poem)
                }
            }
        }
    }
}


@Composable
fun PoemCard(poem: PoemItem) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text= poem.title, fontSize = 20.sp)
        Text(text="By ${poem.author}", fontSize = 12.sp)
        Text(text=poem.lines.joinToString(separator = "\n"), fontSize = 16.sp)
    }
}