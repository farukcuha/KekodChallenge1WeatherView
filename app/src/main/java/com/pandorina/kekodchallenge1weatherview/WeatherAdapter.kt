package com.pandorina.kekodchallenge1weatherview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter(private val list: List<Weather>): RecyclerView.Adapter<WeatherAdapter.Holder>() {
    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val day: TextView = itemView.findViewById(R.id.tv_day)
        private val weatherImage: ImageView = itemView.findViewById(R.id.iv_weather_icon)
        fun bind(weather: Weather){
            day.text = weather.day
            weatherImage.setImageResource(weather.weatherImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return Holder((view))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}