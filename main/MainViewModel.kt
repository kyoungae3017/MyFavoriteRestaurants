package com.kyoungae.myfavoriterestaurants.main

import androidx.lifecycle.ViewModel
import com.kyoungae.myfavoriterestaurants.data.TDRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tdRepository: TDRepository
) : ViewModel(){
    val dd = tdRepository
}