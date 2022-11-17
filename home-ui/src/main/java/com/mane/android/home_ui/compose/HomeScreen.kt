package com.mane.android.home_ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mane.android.home_domain.domain_data.BreedData
import com.mane.android.home_ui.HomeViewModel
import com.nesyou.staggeredgrid.LazyStaggeredGrid
import com.nesyou.staggeredgrid.StaggeredCells

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val breedsDataListState: List<BreedData> by viewModel.breedDataList.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        PhotoGrid(photos = breedsDataListState)
    }
}

@Composable
fun PhotoGrid(photos: List<BreedData>) {
    LazyStaggeredGrid(cells = StaggeredCells.Adaptive(minSize = 164.dp)) {
        items(photos.size) { photo ->
            Column(modifier = Modifier.wrapContentSize().padding(bottom = 8.dp)) {
                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 8.dp, end = 8.dp, top = 16.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = 10.dp
                ) {
                    AsyncImage(
                        model = photos[photo].imageUrl, contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                }
                photos[photo].name?.let {
                    Card(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = Color.White.copy(alpha = 0.7f),
                        elevation = 10.dp
                    ) {
                        Text(
                            text = it,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .wrapContentWidth()
                                .widthIn(max = 140.dp)
                                .padding(start = 8.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

        }
    }
}

