package com.mane.android.home_ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mane.android.home_domain.domain_data.BreedData
import com.mxalbert.sharedelements.LocalSharedElementsRootScope
import com.mxalbert.sharedelements.SharedElementsRootScope
import com.mxalbert.sharedelements.SharedMaterialContainer
import com.nesyou.staggeredgrid.LazyStaggeredGrid
import com.nesyou.staggeredgrid.StaggeredCells

@Composable
fun DogsScreen(listState: LazyListState, breedsDataListState: List<BreedData>) {

    LaunchedEffect(listState) {
        val previousIndex = (previousSelectedDog / 2).coerceAtLeast(0)
        if (!listState.layoutInfo.visibleItemsInfo.any { it.index == previousIndex }) {
            listState.scrollToItem(previousIndex)
        }
    }

    val scope = LocalSharedElementsRootScope.current

    Column(modifier = Modifier.fillMaxSize()) {
        DogGrid(dogs = breedsDataListState, listState = listState, scope)
    }
}

@Composable
fun DogGrid(dogs: List<BreedData>, listState: LazyListState, scope: SharedElementsRootScope?) {
    LazyStaggeredGrid(cells = StaggeredCells.Adaptive(minSize = 164.dp)) {
        items(dogs.size) { itemIndex ->
            Column(modifier = Modifier.wrapContentSize().padding(bottom = 8.dp)) {
                dogs[itemIndex].name?.let {
                    SharedMaterialContainer(
                        key = it,
                        screenKey = "dog list",
                        transitionSpec = MaterialFadeInTransitionSpec
                    ) {
                        Card(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(start = 8.dp, end = 8.dp, top = 16.dp),
                            shape = RoundedCornerShape(20.dp),
                            elevation = 10.dp
                        ) {
                            if (scope != null) {
                                AsyncImage(
                                    model = dogs[itemIndex].imageUrl, contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .clickable(enabled = !scope.isRunningTransition) {
                                            scope.changeSelectedDog(itemIndex, dogs)
                                        }
                                )
                            }
                        }
                    }
                }
                dogs[itemIndex].name?.let {
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