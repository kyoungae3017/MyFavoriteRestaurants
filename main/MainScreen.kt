package com.kyoungae.myfavoriterestaurants.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.kyoungae.myfavoriterestaurants.MainTopAppbar
import com.kyoungae.myfavoriterestaurants.R
import com.kyoungae.myfavoriterestaurants.ui.theme.MyFavoriteRestaurantsTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onSearchRestaurants: () -> Unit,
    onAddRestaurants: () -> Unit,
    viewModel: MainViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            MainTopAppbar {
                onSearchRestaurants()
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onAddRestaurants }) {
                Icon(Icons.Filled.Add, stringResource(id = R.string.add_restaurant) )
            }
        }){it

    }
//    ) {
//
////        Column() {
////            Text(text = "hi")
////        }
//    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MyFavoriteRestaurantsTheme {
        Surface(modifier = Modifier.fillMaxWidth()) {
            MainScreen(onSearchRestaurants = { }, onAddRestaurants = { })
        }
    }
}