package com.mane.android.home_ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mane.android.home_domain.domain_data.BreedData
import com.mane.android.common_ui.R
import com.mxalbert.sharedelements.LocalSharedElementsRootScope
import com.mxalbert.sharedelements.SharedMaterialContainer


@Composable
fun DetailScreen(breedData: BreedData, breedsDataListState: List<BreedData>) {
    val (fraction, setFraction) = remember { mutableStateOf(1f) }
    Surface(color = Color.Black.copy(alpha = 0.32f * (1 - fraction)))
    {

        breedData.name?.let {
            SharedMaterialContainer(
                key = it,
                screenKey = "Details screen",
                isFullscreen = true,
                transitionSpec = MaterialFadeOutTransitionSpec,
                onFractionChanged = setFraction
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(top = 8.dp)
                    ) {
                        val scope = LocalSharedElementsRootScope.current
                        if (scope != null) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                                contentDescription = "Back arrow",
                                alignment = Alignment.CenterStart,
                                modifier = Modifier.clickable(enabled = !scope.isRunningTransition) {
                                    scope.changeSelectedDog(-1, breedsDataListState)
                                }.size(38.dp).padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                        breedData.name?.let {
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
                            model = breedData.imageUrl, contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                        )
                    }
                    Text(
                        text =
                        breedData.temperament
                                + "\n\n" + breedData.weight + " Kgs"
                                + "\n\n" + breedData.height + " Cm At The Withers" + "\n\n"
                                + breedData.lifeSpan + " years average life span",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 32.dp)
                    )
                }
            }
        }
    }
}