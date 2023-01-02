package com.example.planeando_suenos.domain.response.smartShopping

import com.example.planeando_suenos.domain.entities.DreamType
import com.example.planeando_suenos.domain.response.Response
import com.google.gson.annotations.SerializedName

data class DreamTypeResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
) : Response<DreamType> {

    override fun toEntity() = DreamType(
        id = id,
        title = title,
        description = description
    )
}
