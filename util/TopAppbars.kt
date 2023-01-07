package com.kyoungae.myfavoriterestaurants

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kyoungae.myfavoriterestaurants.ui.theme.MyFavoriteRestaurantsTheme

@Composable
fun MainTopAppbar(
    onSearch: () -> Unit,
    ) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        actions = {
            IconButton(onClick = onSearch) {
                Icon(Icons.Filled.Search, stringResource(id = R.string.search_restaurant))
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun PreviewMainTopAppbar() {
    MyFavoriteRestaurantsTheme {
        Surface {
            MainTopAppbar({})
        }
    }
}