package com.kyoungae.myfavoriterestaurants.data

import com.kyoungae.myfavoriterestaurants.data.local.TDLocalDataSource
import kotlinx.coroutines.flow.Flow
import net.daum.mf.map.api.MapView

class DefaultTDRepository(
    private val tdLocalDataSource: TDDataSource,
    private val tdRemoteDataSource: TDDataSource
): TDRepository {

    override fun set(): String {
        TODO("Not yet implemented")
    }

}