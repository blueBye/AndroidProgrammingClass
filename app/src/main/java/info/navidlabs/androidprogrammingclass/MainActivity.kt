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
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import info.navidlabs.androidprogrammingclass.ui.theme.AndroidProgrammingClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProgrammingClassTheme {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text="Vertical List",
                        modifier=Modifier.padding(bottom=8.dp),
                    )
                    VerticalList()

                    Text(
                        text="Vertical Grid List",
                        modifier=Modifier.padding(bottom=8.dp),
                    )
                    VerticalGridList()

                    Text(
                        text="Horizontal List",
                        modifier=Modifier.padding(bottom=8.dp),
                    )
                    HorizontalList()

                    Text(
                        text="Horizontal Grid List",
                        modifier=Modifier.padding(bottom=8.dp),
                    )
                    HorizontalGridList()
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
    private fun VerticalList() {
        LazyColumn(
            Modifier.height(120.dp)
        ) {
            items(prepareOptionsList()) {
                ItemLayoutVertical(optionList=it)
            }
        }
    }

    @Preview(
        showBackground = true,
        device = "id:pixel_7_pro",
        name = "Second View",
        showSystemUi = true,
    )
    @Composable
    private fun VerticalGridList() {
        LazyVerticalGrid(
            modifier=Modifier.height(120.dp),
            columns= GridCells.Adaptive(128.dp)
        ) {
            items(prepareOptionsList()) {
                ItemLayout(optionsList=it)
            }
        }
    }

    @Preview(
        showBackground = true,
        device = "id:pixel_7_pro",
        showSystemUi = true,
        name = "Third View",
    )
    @Composable
    private fun HorizontalList() {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(prepareOptionsList()) {
                ItemLayoutVertical(optionList=it)
            }
        }
    }

    @Preview(
        showBackground = true,
        device = "id:pixel_7_pro",
        showSystemUi = true,
        name = "Forth View",
    )
    @Composable
    private fun HorizontalGridList() {
        LazyHorizontalGrid(rows=GridCells.Fixed(count=4)) {
            items(prepareOptionsList()){
                ItemLayout(optionsList = it)
            }
        }
    }

    @Composable
    fun ItemLayoutVertical(optionList: ImageList) {
        Card(
            shape=RoundedCornerShape(size=4.dp),
            modifier=Modifier.padding(bottom=10.dp),
        ) {
            Row(
                verticalAlignment=Alignment.CenterVertically,
                modifier=Modifier.width(192.dp),
            ) {
                Image(
                    painter=painterResource(optionList.icon),
                    contentDescription=null,
                    contentScale=ContentScale.FillHeight,
                    modifier=Modifier.size(56.dp),
                )
                Text(
                    text=(optionList.text),
                    style=MaterialTheme.typography.titleSmall,
                    modifier= Modifier.padding(horizontal=16.dp),
                )
            }
        }
    }


    @Composable
    private fun ItemLayout(
        optionsList: ImageList,
    ) {
        Card(
            shape=RoundedCornerShape(size=8.dp),
            modifier=Modifier.padding(4.dp),
        ) {
            Box(
                modifier= Modifier
                    .fillMaxWidth()
                    .clickable {}
                    .padding(all = 8.dp),
                contentAlignment=Alignment.Center,
            ) {
                Image(
                    painter=painterResource(id=optionsList.icon),
                    modifier=Modifier.size(size=100.dp),
                    contentDescription=null,
                )
            }
        }
    }

    private fun prepareOptionsList(): MutableList<ImageList> {
        val imageML = mutableListOf<ImageList>()
        imageML.add(ImageList(icon=R.drawable.image_0, text="0"))
        imageML.add(ImageList(icon=R.drawable.image_1, text="1"))
        imageML.add(ImageList(icon=R.drawable.image_2, text="2"))
        imageML.add(ImageList(icon=R.drawable.image_3, text="3"))
        imageML.add(ImageList(icon=R.drawable.image_4, text="4"))
        imageML.add(ImageList(icon=R.drawable.image_5, text="5"))
        imageML.add(ImageList(icon=R.drawable.image_6, text="6"))
        imageML.add(ImageList(icon=R.drawable.image_7, text="7"))
        imageML.add(ImageList(icon=R.drawable.image_8, text="8"))
        imageML.add(ImageList(icon=R.drawable.image_9, text="9"))
        return imageML
    }

    data class ImageList(val icon: Int, val text: String)
}

