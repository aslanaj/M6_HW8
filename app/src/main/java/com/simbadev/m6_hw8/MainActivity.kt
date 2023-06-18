package com.simbadev.m6_hw8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simbadev.m6_hw8.ui.theme.M6_HW8Theme

val list = listOf(
    YoutubePlayListsModel(
        image = R.drawable.sixth,
        title =  "Text 1",
        count = "Count 1"),
    YoutubePlayListsModel(
        image = R.drawable.second,
        title =  "Text 2",
        count = "Count 3"),
    YoutubePlayListsModel(
        image = R.drawable.sixth,
        title =  "Text 3",
        count = "Count 3"),
    YoutubePlayListsModel(
        image = R.drawable.fivth,
        title =  "Text 4",
        count = "Count 4"),
    YoutubePlayListsModel(
        image = R.drawable.sixth,
        title =  "Text 4",
        count = "Count 4"),
    YoutubePlayListsModel(
        image = R.drawable.third,
        title =  "Text 5",
        count = "Count 5"),
    YoutubePlayListsModel(
        image = R.drawable.first,
        title =  "Text 6",
        count = "Count 6"),
    YoutubePlayListsModel(
        image = R.drawable.sixth,
        title =  "Text 7",
        count = "Count 7"),
    YoutubePlayListsModel(
        image = R.drawable.third,
        title =  "Text 8",
        count = "Count 8"),
    YoutubePlayListsModel(
        image = R.drawable.first,
        title =  "Text 9",
        count = "Count 9"),
    YoutubePlayListsModel(
        image = R.drawable.sixth,
        title =  "Text 10",
        count = "Count 10"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M6_HW8Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    YoutubePlayListsScreen(list)
                }
            }
        }
    }
}

@Composable
fun YoutubePlayListsScreen(youtubePlayListsModel: List<YoutubePlayListsModel>) {

    LazyColumn(content = {
        itemsIndexed(youtubePlayListsModel) { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)

            ) {
                Card(
                    shape = RoundedCornerShape(10)
                ) {
                    Box(
                        modifier = Modifier
                            .width(120.dp)
                            .height(90.dp)
                    ) {
                        Image(
                            modifier = Modifier.fillMaxWidth(),
                            painter = painterResource(id = item.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .background(Color.Black.copy(alpha = 0.7f))
                                .height(24.dp)
                                .fillMaxWidth()
                                .align(alignment = Alignment.BottomCenter)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 24.dp),
                                text = stringResource(R.string.playlist),
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = item.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = item.count,
                        fontSize = 12.sp
                    )
                }
            }

        }
    })

}

@Preview(showBackground = true)
@Composable
fun Youtube_Preview() {
    M6_HW8Theme {
        YoutubePlayListsScreen(
            youtubePlayListsModel = list
        )
    }
}
