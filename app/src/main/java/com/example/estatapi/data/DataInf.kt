package com.example.estatapi.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class DataInf(

    @JsonProperty(value = "VALUE")
    val dataValueList: List<DataValue>
)
{
    fun getDataValueListByCat(cat01: String, cat02: String): List<DataValue>{
        return dataValueList.filter { d -> d.cat01 == cat01 && d.cat02 == cat02 }.sortedBy { d -> d.time }
    }
}