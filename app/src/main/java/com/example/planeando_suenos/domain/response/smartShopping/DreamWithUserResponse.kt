package com.example.planeando_suenos.domain.response.smartShopping

import com.example.planeando_suenos.domain.entities.DreamWithUser
import com.example.planeando_suenos.domain.entities.UserDream
import com.example.planeando_suenos.domain.response.Response
import com.google.gson.annotations.SerializedName


data class DreamWithUserResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("active") val active: Boolean,
    @SerializedName("user") val user: UserDreamResponse,
    @SerializedName("userFinance") val userFinance: UserFinanceResponse,
    @SerializedName("dream") val dream: List<DreamResponse>,
) : Response<DreamWithUser> {
    override fun toEntity() = DreamWithUser(
        id = id,
        title = title,
        user = user.toEntity(),
        active = active,
        userFinance = userFinance.toEntity(),
        dream = dream.map { it.toEntity() },
    )

    data class UserDreamResponse(
        @SerializedName("id") val id: String
    ) : Response<UserDream> {
        override fun toEntity() = UserDream(
            id = id
        )
    }
}