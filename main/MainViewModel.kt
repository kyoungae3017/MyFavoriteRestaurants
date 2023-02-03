package com.kyoungae.myfavoriterestaurants.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyoungae.myfavoriterestaurants.data.TDRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import net.daum.mf.map.api.MapView
import javax.inject.Inject

data class MainUiState(
    val isLoading : Boolean = false,
    val setMap: MapView? = null
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tdRepository: TDRepository,
    val savedStateHandle: SavedStateHandle
) : ViewModel(){


    private val _isLoading = MutableStateFlow(false)
//    private val

//    val uiState: StateFlow<MainUiState> = combine(
//        _isLoading,
//    ){
//
//    }


}