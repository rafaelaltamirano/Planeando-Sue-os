package com.example.planeando_suenos.domain.entities

import com.google.gson.annotations.SerializedName


class DreamWithUser(
    val title: String,
    val userFinance: UserFinance,
    val dream: List<Dream>,
    val id: String,
    val active: Boolean,
    val user: UserDream
)

data class UserDream(
      val id: String
)