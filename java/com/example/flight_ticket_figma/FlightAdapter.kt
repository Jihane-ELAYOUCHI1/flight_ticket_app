package com.example.flight_ticket_figma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlightAdapter(private val flightList: List<Flight>) :
    RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flight_item, parent, false)
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flight = flightList[position]

        holder.airlineName.text = flight.airlineName
        holder.departureCode.text = flight.departureCode
        holder.departureTime.text = flight.departureTime
        holder.arrivalCode.text = flight.arrivalCode
        holder.arrivalTime.text = flight.arrivalTime
        holder.duration.text = flight.duration
        holder.price.text = flight.price
        holder.promoCode.text = flight.promoCode

        if (!flight.extraInfo.isNullOrEmpty()) {
            holder.extraInfo.visibility = View.VISIBLE
            holder.extraInfo.text = flight.extraInfo
        } else {
            holder.extraInfo.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = flightList.size

    class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val airlineName: TextView = itemView.findViewById(R.id.airlineName)
        val departureCode: TextView = itemView.findViewById(R.id.departureCode)
        val departureTime: TextView = itemView.findViewById(R.id.departureTime)
        val arrivalCode: TextView = itemView.findViewById(R.id.arrivalCode)
        val arrivalTime: TextView = itemView.findViewById(R.id.arrivalTime)
        val duration: TextView = itemView.findViewById(R.id.duration)
        val price: TextView = itemView.findViewById(R.id.price)
        val promoCode: TextView = itemView.findViewById(R.id.promoCode)
        val extraInfo: TextView = itemView.findViewById(R.id.extraInfo)
    }
}
