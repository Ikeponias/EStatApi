package com.example.estatapi.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SurveyData(

    @JsonProperty(value = "@code")
    val code: String,

    @JsonProperty(value = "@name")
    val name: String,

    @JsonProperty(value = "@level")
    val level: String,

    @JsonProperty(value = "@unit")
    val unit: String?
)
{
    override fun toString(): String {
        return name
    }
}