package info.navidlabs.androidprogrammingclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
                BoxFunction()
                ButtonFunction()
            }
        }
    }
}

@Preview(
    showBackground = true,
    device = "id:pixel_7_pro",
    name = "First View",
    showSystemUi = true,
)
@Composable
private fun BoxFunction() {
    Box(modifier= Modifier
        .fillMaxSize()
        .background(Color.LightGray)
    ) {
        Box(modifier= Modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
        )

        Box(modifier= Modifier
            .size(200.dp, 200.dp)
            .background(Color.Cyan)
            .align(Alignment.Center)
        )

        Box(modifier= Modifier
            .size(300.dp, 300.dp)
            .background(brush= Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.primary,
                    Color.Red,
                )
            ))
            .align(Alignment.BottomEnd)
        )
    }
}

@Preview(
    showBackground = true,
    device = "id:pixel_7_pro",
    showSystemUi = true,
    name = "Second View",
)
@Composable
private fun ButtonFunction() {
    Column(
        modifier=Modifier.fillMaxSize(),
        horizontalAlignment=Alignment.CenterHorizontally,
        verticalArrangement=Arrangement.Center,
    ) {
        Button(onClick={/*onClick*/}) {
            Text(text="Click Me 1")
        }

        Button(
            onClick={/*onClick*/},
            colors=ButtonDefaults.buttonColors(containerColor=Color.Blue),
        ) {
            Text(text="Click Me 2")
        }

        Button(onClick={/*onClick*/}) {
            Text(text="Click", color=Color.Yellow)
            Text(text="Me", color=Color.Red)
        }

        Button(onClick={/*onClick*/}) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = null,
            )
            Text(text="Icon!", color=Color.Red)
        }

        Button(
            onClick={/*onClick*/},
            shape= RoundedCornerShape(12.dp),
        ) {
            Text(text="Custom Corner", color=Color.Yellow)
        }

        Button(
            onClick={/*onClick*/},
            border= BorderStroke(1.dp, color=Color.Blue),
            colors= ButtonDefaults.outlinedButtonColors(contentColor=Color.Blue),
        ) {
            Text(text="Custom Corner")
        }
    }
}