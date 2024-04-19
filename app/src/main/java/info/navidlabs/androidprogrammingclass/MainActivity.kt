package info.navidlabs.androidprogrammingclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import info.navidlabs.androidprogrammingclass.ui.theme.AndroidProgrammingClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProgrammingClassTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextFunction()
                }
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
private fun TextFunction() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)
    ) {
        Text(
            text=buildAnnotatedString {
                withStyle(style=SpanStyle(
                    fontSize=30.sp,
                    color=Color.Green,
                )) {
                    append("Hello")
                }

                append(" ... ")

                withStyle(style= SpanStyle(
                    fontSize=30.sp,
                    color=Color.Blue,
                )
                ) {
                    append("World")
                }
            },
            modifier=Modifier.fillMaxSize(),
            style= TextStyle(
                color=Color.Red,
                fontSize = 30.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                letterSpacing = 12.sp,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.LineThrough,
            ),
            maxLines = 2,
        )
    }
}
