package com.kyoungae.myfavoriterestaurants.main

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.lifecycleScope
import com.kyoungae.myfavoriterestaurants.MainTopAppbar
import com.kyoungae.myfavoriterestaurants.R
import com.kyoungae.myfavoriterestaurants.ui.theme.MyFavoriteRestaurantsTheme
import kotlinx.coroutines.launch
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

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
                Icon(Icons.Filled.Add, stringResource(id = R.string.add_restaurant))
            }
        }) { paddingValue ->

        initKaKaoMap(modifier = modifier, paddingValues = paddingValue)

    }
}

@Composable
fun initKaKaoMap(
    modifier: Modifier,
    paddingValues: PaddingValues
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val coroutineScope = rememberCoroutineScope()

    val mapView = remember {
        com.google.android.gms.maps.MapView(context).apply {
            getMapAsync {
                MapView(context).apply {
                    setZoomLevel(10, true)
                    setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633),true)
                }
            }
        }
    }

//    val mapView = remember {
//        MapView(context).apply {
//            setShowCurrentLocationMarker(true)
//            setCurrentLocationEventListener(object : MapView.CurrentLocationEventListener {
//                override fun onCurrentLocationUpdate(p0: MapView?, p1: MapPoint?, p2: Float) {
////                    currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOff
//                    Log.d("TAG", "onCurrentLocationUpdate: lldd")
//                }
//
//                override fun onCurrentLocationDeviceHeadingUpdate(p0: MapView?, p1: Float) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onCurrentLocationUpdateFailed(p0: MapView?) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onCurrentLocationUpdateCancelled(p0: MapView?) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//        }
//    }


    val lifecycleObserver = remember {
        LifecycleEventObserver { source, event ->
                when (event) {
                    Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
                    Lifecycle.Event.ON_START -> mapView.onStart()
                    Lifecycle.Event.ON_RESUME -> mapView.onResume()
                    Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                    Lifecycle.Event.ON_STOP -> mapView.onStop()
                    Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                    else -> throw IllegalStateException()
                }
        }
    }



    DisposableEffect(true){
        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleObserver)
        }
    }

    Box(modifier = modifier.padding(paddingValues)) {

        AndroidView(factory = {
            LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL

                addView(mapView)
            }
        })

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_my_location_24),
                contentDescription = stringResource(
                    id = R.string.my_location
                )
            )
        }
    }


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