package com.example.estatapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.estatapi.data.DataValue
import com.example.estatapi.data.SurveyData
import com.example.estatapi.data.SurveyDataObj

class SurveyResultViewAdapter(private val context: Context, private val surveyDataObj: SurveyDataObj, private val dataValueList: List<DataValue>) :
    RecyclerView.Adapter<SurveyResultViewAdapter.DataViewHolder>() {
    class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val yearTextView: TextView = view.findViewById(R.id.year)
        val valueTextView: TextView = view.findViewById(R.id.value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(context).inflate(R.layout.result_row, parent, false))

    override fun getItemCount(): Int = dataValueList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.yearTextView.text = surveyDataObj.getSurveyDataByCode(dataValueList[position].time)?.name
        holder.valueTextView.text = dataValueList[position].value + dataValueList[position].unit
    }
}