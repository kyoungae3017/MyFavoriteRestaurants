package com.kyoungae.myownrestaurants

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.kyoungae.myownrestaurants.MORScreens.ADD_MOR_SCREEN
import com.kyoungae.myownrestaurants.MORScreens.MAIN_SCREEN

//MORNavigation class에서 사용
private object MORScreens{
    const val MAIN_SCREEN = "main"
    const val ADD_MOR_SCREEN = "addMOR"
}

object MORDestinationsArgs{

}

object MORDestinations{
    const val MAIN_ROUTE = MAIN_SCREEN
    const val ADD_MOR_ROUTE = ADD_MOR_SCREEN
}

class MORNavigationActions(val navController: NavController) {

    fun navigateToMain(){
        navController.navigate(MAIN_SCREEN){

            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }

            launchSingleTop = true
        }
    }

}