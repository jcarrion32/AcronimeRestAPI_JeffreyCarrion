package com.example.acronimerestapi_jeffreycarrion.data.api

import com.example.acronimerestapi_jeffreycarrion.data.model.AbbreviationResponse
import com.example.acronimerestapi_jeffreycarrion.utils.DICTIONARY_ENDPOINT
import com.example.acronimerestapi_jeffreycarrion.utils.SF
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET(DICTIONARY_ENDPOINT)
    suspend fun getAbbreviation(
        @Query(SF) sf: String
    ): Response<List<AbbreviationResponse>>
}