package com.example.acronimerestapi_jeffreycarrion.utils

import com.example.acronimerestapi_jeffreycarrion.data.model.AbbreviationResponse

sealed class ApiState {
    object Loading: ApiState()
    class Error(val exception: Exception): ApiState()
    class Success(val response: AbbreviationResponse): ApiState()
}