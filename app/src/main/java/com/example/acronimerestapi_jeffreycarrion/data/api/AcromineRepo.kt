package com.example.acronimerestapi_jeffreycarrion.data.api

import com.example.acronimerestapi_jeffreycarrion.utils.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AcromineRepo {
    fun fetchAbbreviation(sf: String): Flow<ApiState>
}
class AcromineRepoImpl @Inject constructor(private val service: Service) :
    AcromineRepo {
    override fun fetchAbbreviation(sf: String): Flow<ApiState> =
        flow {
            emit(ApiState.Loading)
            try {
                val response = service.getAbbreviation(sf)

                if (response.isSuccessful && !response.body().isNullOrEmpty()) {
                    emit(response.body()?.let {
                        ApiState.Success(it[0])
                    } ?: throw Exception ("Null Response"))
                } else {
                    throw Exception("Could not find any matches")
                }
            } catch (e:Exception) {
                emit(ApiState.Error(e))
            }
        }
}