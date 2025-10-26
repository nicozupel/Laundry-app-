package com.gestor.turnos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupMachineCards()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewBookings)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BookingAdapter(getMockBookings())
    }

    private fun setupMachineCards() {
        val nextBookingCard = findViewById<MaterialCardView>(R.id.cardNextBooking)
        val nextBookingText = findViewById<MaterialTextView>(R.id.textNextBooking)

        nextBookingText.text = "Próximo turno: Lavarropas 1\nHoy 14:30 - 16:30"

        nextBookingCard.setOnClickListener {
            nextBookingText.text = "Turno actualizado"
        }
    }

    private fun getMockBookings(): List<Booking> {
        return listOf(
            Booking("1", "Lavarropas 1", "Hoy 14:30", "Reservado"),
            Booking("2", "Secarropas 2", "Mañana 10:00", "Reservado"),
            Booking("3", "Lavarropas 2", "Ayer 16:00", "Completado")
        )
    }
}

data class Booking(
    val id: String,
    val machine: String,
    val time: String,
    val status: String
)