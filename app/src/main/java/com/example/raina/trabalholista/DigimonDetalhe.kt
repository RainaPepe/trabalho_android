package com.example.raina.trabalholista

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_digimon_detalhe.*
import java.io.IOException
import java.io.InputStream
import kotlin.coroutines.experimental.EmptyCoroutineContext

class DigimonDetalhe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digimon_detalhe)

        val intent = intent
        if (intent != null) {
            val digimon = intent.getSerializableExtra("digimon") as Digimon
            val fotodigimon = findViewById<ImageView>(R.id.fotodigimon)
            val nomedigimon = findViewById<TextView>(R.id.nomedigimon)
            val fase = findViewById<TextView>(R.id.fase)
            val preEvolucao = findViewById<TextView>(R.id.preEvolucao)
            val posEvolucao = findViewById<TextView>(R.id.posEvolucao)
            val bitmap = getBitmapFromAsset(digimon.imagem)
            nomedigimon.text = digimon.nome
            fase.text = "Fase: " + digimon.fase
            preEvolucao.text = "Pré Evolução: " + digimon.preEvolucao
            posEvolucao.text = "Proximas Evoluções: " + digimon.posEvolucao
            fotodigimon.setImageBitmap(bitmap)
        }
    }

    private fun getBitmapFromAsset(imagem: String): Bitmap {
        val assetManager = this.assets
        var istr: InputStream? = null
        try {
            istr = assetManager.open("$imagem.png")
        } catch (e: IOException) {
            istr = assetManager.open("renamon.png")
        }
        return BitmapFactory.decodeStream(istr)
    }

}
