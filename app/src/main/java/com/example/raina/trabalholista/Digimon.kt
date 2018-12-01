package com.example.raina.trabalholista


import java.io.Serializable

data class Digimon(var id: Long,
                   var nome: String,
                   var imagem: String,
                   var fase: String,
                   var preEvolucao: String,
                   var posEvolucao: String) : Serializable