package info.navidlabs.androidprogrammingclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import info.navidlabs.androidprogrammingclass.ui.theme.AndroidProgrammingClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProgrammingClassTheme {
                CardImageFunction()
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
private fun CardImageFunction() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // card 1
        Card(
            shape=RoundedCornerShape(size=5.dp),
            modifier=Modifier.padding(8.dp),
        ) {
            Row(
                modifier=Modifier.padding(all=12.dp),
                verticalAlignment=Alignment.CenterVertically,
                horizontalArrangement=Arrangement.Center,
            ) {
                Icon(imageVector = Icons.Default.Face, contentDescription = null)

                Spacer(modifier=Modifier.width(8.dp))
                Text(
                    text="alice",
                    fontSize=16.sp,
                    fontWeight=FontWeight.Medium,
                )
            }
        }

        //card 2
        Card (
            shape=RoundedCornerShape(4.dp),
            modifier=Modifier.padding(8.dp),
        ) {
            Row(
                verticalAlignment=Alignment.CenterVertically,
                modifier=Modifier.width(200.dp),
            ) {
                Icon(imageVector = Icons.Default.Face, contentDescription = null)
                Text(
                    text="bob",
                    style=MaterialTheme.typography.headlineSmall,
                    modifier=Modifier.padding(horizontal=12.dp),
                )
            }
        }

        // card 3
        Card(
            shape=RoundedCornerShape(4.dp),
            modifier=Modifier.padding(8.dp),
        ) {
            Column(
                modifier= Modifier
                    .padding(8.dp)
                    .width(100.dp),
                horizontalAlignment=Alignment.CenterHorizontally,
            ) {
                Image(
                    painter=painterResource(id=R.drawable.filotecnia_s_store___society6),
                    contentDescription=null,
                    modifier=Modifier.clip(shape=CircleShape).size(60.dp),
                    contentScale= ContentScale.Crop,
                )
                Text(
                    text="Hello Cards!",
                    modifier=Modifier
                        .paddingFromBaseline(
                            top=40.dp,
                        ),
                    fontWeight= FontWeight.Medium,
                )
            }
        }
    }
}