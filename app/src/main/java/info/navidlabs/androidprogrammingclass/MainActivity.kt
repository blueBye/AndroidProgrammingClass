package info.navidlabs.androidprogrammingclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import info.navidlabs.androidprogrammingclass.ui.theme.AndroidProgrammingClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProgrammingClassTheme {
                // A surface container using the 'background' color from the theme
                mainLayout()
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
private fun mainLayout() {
    Column{
        Text("Row Layout")
        RowLayout()

        Text("Column Layout")
        ColumnLayout()
    }
}

@Composable
private fun RowLayout() {
    Row(
        modifier=Modifier.fillMaxWidth(),
        verticalAlignment= Alignment.Top,
        horizontalArrangement= Arrangement.SpaceEvenly,
    ) {
        Text(text="Row 1", fontSize=30.sp)
        Text(text="Row 2", fontSize=30.sp)
        Text(text="Row 3", fontSize=30.sp)
    }
}

@Composable
private fun ColumnLayout() {
    Column(
        modifier=Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment=Alignment.CenterHorizontally,
    ) {
        Text(text="Col 1", fontSize=30.sp)
        Text(text="Col 2", fontSize=30.sp)
        Text(text="Col 3", fontSize=30.sp)
    }
}
