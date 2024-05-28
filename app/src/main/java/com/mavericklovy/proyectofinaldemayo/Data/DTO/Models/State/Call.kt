package com.mavericklovy.proyectofinaldemayo.Data.DTO.Models.State



data class categoryResponse(
    @SerializedName("message")
    val message: List<String>?,
    @SerializedName("status")
    val status: String,
    @SerializedName("error")
    val error: categoryApiError? = null
)

data class categoryApiError(
    val code: Int,
    val message: String
)