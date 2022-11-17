package com.mane.android.home_ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mane.android.home_domain.domain_data.BreedData
import com.mane.android.common_ui.R
import com.mane.android.home_ui.DetailsViewModel


@Composable
fun DetailsScreen(viewModel: DetailsViewModel, navigateBack: () -> Boolean) {
    val breedDataState: BreedData? by viewModel.breedData.collectAsState()

    breedDataState?.let { data ->
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    contentDescription = "Back arrow",
                    alignment = Alignment.CenterStart,
                    modifier = Modifier
                        .size(38.dp)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .clickable { navigateBack() }
                )
                data.name?.let {
                    Text(
                        text = it,
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 24.sp
                    )
                }
            }
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 16.dp, bottom = 16.dp)
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = 10.dp
            ) {
                AsyncImage(
                    model = data.imageUrl, contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
            Text(
                text =
                data.temperament
                        + "\n\n" + data.weight + " Kgs"
                        + "\n\n" + data.height + " Cm At The Withers" + "\n\n"
                        + data.lifeSpan + " years average life span",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 32.dp)
            )
        }
    } ?: Box(modifier = Modifier.fillMaxSize())
    {
        LinearProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .semantics {
                    this.contentDescription = "Progress Bar"
                },
            color = Color.Black
        )
    }
}