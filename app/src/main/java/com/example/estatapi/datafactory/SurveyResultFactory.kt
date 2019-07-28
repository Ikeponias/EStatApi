package com.example.estatapi.datafactory

import com.example.estatapi.RequiredConstants
import com.example.estatapi.data.*

class SurveyResultFactory {
    fun create(cat01: Pair<String, String>, cat02: Pair<String, String>, statsData: StatsData): SurveyResult {
        val surveyDataInf: SurveyDataInf = statsData.statisticalData.surveyDataInf
        val dataInf: DataInf = statsData.statisticalData.dataInf
        val dataValueList: List<DataValue> = dataInf.getDataValueListByCat(cat01.first, cat02.first)

        return SurveyResult(cat01, cat02, surveyDataInf.getSurveyDataObjById("time"), dataValueList)
    }

}