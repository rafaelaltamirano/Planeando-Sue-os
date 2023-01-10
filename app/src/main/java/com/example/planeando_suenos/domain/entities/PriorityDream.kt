package com.example.planeando_suenos.domain.entities

enum class PriorityDream(val priority: String) {
    LowestFirst("lowest"),
    AllAtSameTime("equal"),
    BiggestFirst("biggest")
}