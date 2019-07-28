package com.example.estatapi.datafactory

import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.estatapi.ApiTask
import com.example.estatapi.BuildConfig
import com.example.estatapi.R
import com.example.estatapi.RequiredConstants
import com.example.estatapi.data.EStatsData
import com.example.estatapi.data.StatsData
import com.example.estatapi.data.SurveyData
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class StatsDataFactory {
    private val apiTask: ApiTask = ApiTask()
    lateinit var statsData: StatsData
    lateinit var iCallbackTaskFromActivity: ICallbackTaskFromActivity

    init {
        apiTask.execute("https://api.e-stat.go.jp/rest/2.1/app/json/getStatsData?appId="+ BuildConfig.APP_KEY +"&statsDataId=0003191360")
    }

    fun setOnCallback() {
        apiTask.setOnCallback(object : ApiTask.ICallbackTask {
            override fun callback(result: String) {
                val statsData: StatsData = jacksonObjectMapper().readValue<EStatsData>(result).statsData

                this@StatsDataFactory.statsData = statsData
                iCallbackTaskFromActivity.callback()
            }})
    }


    fun setOnCallbackFromActivity(iCallbackTaskFromActivity: ICallbackTaskFromActivity) {
        this.iCallbackTaskFromActivity = iCallbackTaskFromActivity
    }

    interface ICallbackTaskFromActivity {
        fun callback()
    }
}