package com.example.planeando_suenos.domain.entities

enum class PriorityDream(val priority: String) {
    TuSuenioMasPequenioPrimero("lowest"),
    TodosTusSueniosAlMismoTiempo("equal"),
    TuSuenioMasGrandePrimero("biggest")
}