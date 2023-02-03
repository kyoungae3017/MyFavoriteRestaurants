package com.kyoungae.myfavoriterestaurants.data

import kotlinx.coroutines.flow.Flow
import net.daum.mf.map.api.MapView

interface TDRepository {
    fun set(): String
}