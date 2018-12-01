package com.example.raina.trabalholista

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.io.IOException
import java.io.InputStream


class PokemonAdapter(context: Context, lista: ArrayList<Digimon>, assetManager: AssetManager) : BaseAdapter() {

    private var digimonList: ArrayList<Digimon>
    private var inflator: LayoutInflater
    private var assetManager: AssetManager

    init {
        this.digimonList = lista
        this.inflator = LayoutInflater.from(context)
        this.assetManager = assetManager
    }

    override fun getCount(): Int {

        return this.digimonList.size

    }

    override fun getItem(position: Int): Any? {

        return this.digimonList.get(position)

    }

    override fun getItemId(position: Int): Long {

        return this.digimonList.get(position).id;

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val digimon = this.digimonList.get(position)
        val view = this.inflator.inflate(R.layout.digimon_line, parent, false)
        val bitmapImage = this.getBitmapFromAsset(digimon.imagem)

        (view.findViewById<TextView>(R.id.nome)).text = digimon.nome
        var imageView = view.findViewById<ImageView>(R.id.foto)
        imageView.setImageBitmap(bitmapImage)
        return view
    }


    private fun getBitmapFromAsset(imagem: String): Bitmap {
        val assetManager = this.assetManager
        var istr: InputStream? = null
        try {
            istr = assetManager.open("$imagem.png")
        } catch (e: IOException) {
            istr = assetManager.open("renamon.png")
        }
        return BitmapFactory.decodeStream(istr)
    }

}