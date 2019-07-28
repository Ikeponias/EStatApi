package com.example.estatapi.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class DataValue(

    @JsonProperty(value = "@cat01")
    val cat01 : String, // 150

    @JsonProperty(value = "@cat02")
    val cat02 : String, // 230

    @JsonProperty(value = "@time")
    val time : String, // 2006000000

    @JsonProperty(value = "@unit")
    val unit : String, // 人

    @JsonProperty(value = "$")
    val value: String
)