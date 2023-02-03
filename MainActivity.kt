package com.kyoungae.myfavoriterestaurants

import android.os.Bundle
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kyoungae.myfavoriterestaurants.ui.theme.MyFavoriteRestaurantsTheme
import com.kyoungae.myownrestaurants.MORNavGraph
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.daum.mf.map.api.MapView

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFavoriteRestaurantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MORNavGraph()
//                    TestMainScreen()
                }
            }
        }
    }
}

@Composable
fun LandingScreen(
    isLoading: Boolean
) {

    Log.d("TAG", "TestLandingScreen: 호출")
    if (isLoading){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        }
        Log.d("TAG", "TestLandingScreen: 로딩 중")
    }else{
        Log.d("TAG", "TestLandingScreen: 로딩 끝")
    }
    
}

@Composable
fun TestMainScreen() {

    var isLoading by remember {
        mutableStateOf(true)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.error)) {
        Text(text = "main화면")
    }

//    TestLandingScreen(isLoading = isLoading)

    LaunchedEffect(true) {
        delay(3000)
        isLoading = false
    }

    // 해당 변수가 변했을 때 변화가 일어나는게 아니고 isLoading 변수가 false로 변할 때 호출?
    val showButton by remember() {
        derivedStateOf { isLoading = false }
    }


}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFavoriteRestaurantsTheme {
//        TestLandingScreen(true)
    }
}