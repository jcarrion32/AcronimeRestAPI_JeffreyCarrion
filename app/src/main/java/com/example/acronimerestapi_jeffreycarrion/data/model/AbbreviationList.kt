package com.example.acronimerestapi_jeffreycarrion.data.model

data class AbbreviationResponse(
    val sf: String? = null,
    val lfs: List<AbbreviationItem>
)

data class AbbreviationItem(
    val lf: String? = null,
    val freq: Int? = null,
    val since: Int? = null,
    val vars: List<AbbreviationItem?>? = null
)
