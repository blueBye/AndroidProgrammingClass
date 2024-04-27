package info.navidlabs.androidprogrammingclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.navidlabs.androidprogrammingclass.ui.theme.AndroidProgrammingClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProgrammingClassTheme {
                FormScreen()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(
        showBackground = true,
        device = "id:pixel_7_pro",
        name = "Second View",
        showSystemUi = true,
    )
    @Composable
    private fun FormScreen() {
        var name by remember{ mutableStateOf("") }
        var email by remember{ mutableStateOf("") }

        Column(
            modifier=Modifier.padding(16.dp).fillMaxWidth(),
            horizontalAlignment=Alignment.CenterHorizontally,
        ) {
            Text(
                text="Information Form",
                color= Color.Blue,
                modifier=Modifier.padding(bottom=10.dp),
                fontSize=20.sp,
            )
            // name field
            OutlinedTextField(
                value=name,
                onValueChange={ name=it },
                label={Text(text="Enter Your Name")},
                leadingIcon={Icon(Icons.Default.Person, null)},
                modifier=Modifier.padding(vertical=8.dp).fillMaxWidth(),
            )
            // email field
            OutlinedTextField(
                value=email,
                onValueChange={ email=it },
                label={Text(text="Enter Your Email")},
                leadingIcon={Icon(Icons.Default.Email, null)},
                modifier=Modifier.padding(vertical=8.dp).fillMaxWidth(),
            )
            // submit button
            Button(
                onClick={/*TODO*/},
                modifier=Modifier
                    .padding(vertical=16.dp)
                    .fillMaxWidth()
            ){
                Icon(Icons.Default.Send, "Submit", tint=Color.White)
                Text(
                    text="Submit",
                    color=Color.White,
                    modifier=Modifier.padding(start=8.dp)
                )
            }
        }
    }
}

