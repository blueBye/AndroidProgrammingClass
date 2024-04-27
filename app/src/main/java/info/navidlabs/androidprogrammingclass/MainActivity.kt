package info.navidlabs.androidprogrammingclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import info.navidlabs.androidprogrammingclass.ui.theme.AndroidProgrammingClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProgrammingClassTheme {
                DialogBox()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(
        showBackground = true,
        device = "id:pixel_7_pro",
        showSystemUi = true,
        name = "first view"
    )
    @Composable
    private fun DialogBox() {
        AndroidProgrammingClassTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val openDialog1 = remember { mutableStateOf(false) }
                val openDialog2 = remember { mutableStateOf(false) }
                val openDialog3 = remember { mutableStateOf(false) }
                var text by remember { mutableStateOf("") }

                // buttons
                Button(
                    onClick = { openDialog1.value = true },
                    content = { Text(text="Basic") }
                )

                Button(
                    onClick = { openDialog2.value = true },
                    content = { Text(text="Icon") }
                )

                Button(
                    onClick = { openDialog3.value = true },
                    content = { Text(text="Text Field") }
                )

                // alert dialog 1
                if (openDialog1.value) {
                    AlertDialog(
                        onDismissRequest = { openDialog1.value = false },
                        confirmButton = {
                            TextButton(onClick= { openDialog1.value = false } ) {
                                Text(text="confirm")
                            }
                        },
                        title = { Text(text="My Title") },
                        text = { Text(text="my content") },
                        dismissButton = {
                            TextButton(onClick= { openDialog1.value = false } ) {
                                Text(text="dismiss")
                            }
                        },
                    )
                }

                // alert dialog 2
                if (openDialog2.value) {
                    AlertDialog(
                        onDismissRequest = { openDialog2.value = false },
                        confirmButton = {
                            TextButton(onClick= { openDialog2.value = false } ) {
                                Text(text="confirm")
                            }
                        },
                        title = { Text(text="My Title") },
                        text = { Text(text="my content") },
                        icon = {
                            Icon(
                                imageVector= Icons.Default.Info,
                                contentDescription=null
                            )
                        },
                        dismissButton = {
                            TextButton(onClick= { openDialog2.value = false } ) {
                                Text(text="dismiss")
                            }
                        },
                    )
                }

                // alert dialog 3
                if (openDialog3.value) {
                    AlertDialog(
                        onDismissRequest = { openDialog3.value = false },
                        confirmButton = {
                            Row (
                                modifier = Modifier.padding(8.dp),
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                Button(
                                    onClick = { openDialog3.value = false },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text="Confirm")
                                }
                            }
                        },
                        title = { Text(text="My Title") },
                        text = {
                            Column {
                                OutlinedTextField(
                                    value = text,
                                    onValueChange = {text=it},
                                    label = { Text("First Name") }
                                )
                                
                                Text(text="Description")
                            }
                        },
                        icon = {
                            Icon(
                                imageVector=Icons.Default.Info,
                                contentDescription=null
                            )
                        },
                    )
                }
            }
        }
    }
}


