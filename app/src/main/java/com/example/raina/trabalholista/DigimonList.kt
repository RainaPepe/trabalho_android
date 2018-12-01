package com.example.raina.trabalholista

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_digimon_list.*

class DigimonList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digimon_list)

        val digimon_list = ArrayList<Digimon>()
        val c1 = Digimon(1L, "Agumon", "agumon", "rookie", "Koromon","Greymon")
        val c2 = Digimon(2L, "Greymon", "greymon", "champhion", "Agumon","MetalGreymon")
        val c3 = Digimon(3L, "Gabumon", "gabumon", "rookie", "Tsunimon","Garurumon")
        val c4 = Digimon(4L, "Garurumon", "garurumon", "champhion", "Gabumon","WereGarurumon")
        val c5 = Digimon(5L, "Renamon", "renamon", "rookie", "...","Kyuubimon")
        val c6 = Digimon(6L, "Kyuubimon", "kyuubimon","champhion", "Renamon","Taomon")
        val c7 = Digimon(7L, "Tentomon", "tentomon","rookie", "...","Kabuterimon")
        val c8 = Digimon(8L, "Veemon", "veemon","rookie", "...","ExVeemon")
        val c9 = Digimon(9L, "Omegamon", "omegamon","mega", "WarGreymon+MetalGarurumon","nenhuma")


        digimon_list.add(c1)
        digimon_list.add(c2)
        digimon_list.add(c3)
        digimon_list.add(c4)
        digimon_list.add(c5)
        digimon_list.add(c6)
        digimon_list.add(c7)
        digimon_list.add(c8)
        digimon_list.add(c9)

        val adapter = PokemonAdapter(applicationContext, digimon_list, assets)

        val lista = findViewById<ListView>(R.id.lista)
        lista.setAdapter(adapter)
        lista.setOnItemClickListener {parent, view, position, id ->
            val digimon = digimon_list.get(position)
            val intent = Intent(this, DigimonDetalhe::class.java)
            intent.putExtra("digimon", digimon)
            startActivity(intent)
        }

    }

}
