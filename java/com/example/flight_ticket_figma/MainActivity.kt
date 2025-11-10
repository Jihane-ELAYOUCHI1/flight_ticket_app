package com.example.flight_ticket_figma


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var flightsRecyclerView: RecyclerView
    private lateinit var flightAdapter: FlightAdapter
    private val flightList: MutableList<Flight> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flight_list)

        // Initialiser le RecyclerView
        flightsRecyclerView = findViewById(R.id.flightsRecyclerView)
        flightsRecyclerView.layoutManager = LinearLayoutManager(this)

        // Créer la liste des vols
        flightList.addAll(createFlightList())

        // Configurer l'adapter
        flightAdapter = FlightAdapter(flightList)
        flightsRecyclerView.adapter = flightAdapter
    }

    private fun createFlightList(): List<Flight> {
        return listOf(
            Flight(
                "Indigo",
                "DEL",
                "06:30",
                "BLR",
                "10:45",
                "04h 15m",
                "7,319",
                "Use Code : flyspecwyf5 and get 88% instant cashback",
                "Free Meal"
            ),
            Flight(
                "Vistara",
                "DEL",
                "07:15",
                "BLR",
                "09:40",
                "02h 25m",
                "7,319",
                "Use Code : flyswexy10 and get 99% instant cashback",
                null
            ),
            Flight(
                "SpiceJet",
                "DEL",
                "07:55",
                "BLR",
                "10:05",
                "02h 10m",
                "7,319",
                "Use CODE2024 and get Rs.250 instant discount",
                null
            )
            // Tu peux ajouter plus de vols ici...
        )
    }


    fun addFlight(flight: Flight) {
        flightList.add(flight)
        flightAdapter.notifyItemInserted(flightList.size - 1)
    }

    fun removeFlight(position: Int) {
        if (position in flightList.indices) {
            flightList.removeAt(position)
            flightAdapter.notifyItemRemoved(position)
        }
    }

    fun updateFlightList(newFlightList: List<Flight>) {
        flightList.clear()
        flightList.addAll(newFlightList)
        flightAdapter.notifyDataSetChanged()
    }
}

