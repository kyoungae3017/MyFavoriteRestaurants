package com.kyoungae.myownrestaurants

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kyoungae.myfavoriterestaurants.main.MainScreen
import kotlinx.coroutines.CoroutineScope

@Preview
@Composable
fun MORNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = MORDestinations.MAIN_ROUTE,
    navActions: MORNavigationActions = remember(navController) {
        MORNavigationActions(navController)
    }
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        //main screen
        composable(MORDestinations.MAIN_ROUTE){
            MainScreen(onSearchRestaurants = {}, onAddRestaurants = {})
        }
    }
}