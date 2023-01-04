package com.example.planeando_suenos.domain.response.smartShopping

import com.example.planeando_suenos.domain.body.smartShopping.DreamType
import com.example.planeando_suenos.domain.response.Response
import com.google.gson.annotations.SerializedName

data class DreamTypeResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("iconName") val iconName: String,
) : Response<DreamType> {

    override fun toEntity() = DreamType(
        id = id,
        title = title,
        iconName = iconName
    )
}

data class DreamTypeIdResponse(
    @SerializedName("id") val id: String,
) : Response<DreamType> {

    override fun toEntity() = DreamType(
        id = id,
    )
}
