package com.example.planeando_suenos.domain.entities


import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.body.smartShopping.UserFinance

class DreamWithUser(
    val id: String? = null ,
    val title: String? = null ,
    val active: Boolean? = null ,
    val user: UserDream? = null ,
    val endDate: String? = null,
    val userFinance: UserFinance? = null ,
    val dream: List<Dream>? = null ,
)

data class UserDream(
      val id: String
)