package com.example.planeando_suenos.domain.response.smartShopping

import com.example.planeando_suenos.domain.body.smartShopping.Category
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
        iconName = iconName,
    )
}

data class DreamTypeIdResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("iconName") val iconName: String,
    @SerializedName("index") val index: Int,
    @SerializedName("category") val category: CategoryResponse,
) : Response<DreamType> {

    override fun toEntity() = DreamType(
        id = id,
        title = title,
        iconName = iconName,
        index = index,
        category = category.toEntity()
    )
}
data class CategoryResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("interestRatePercentage") val interestRatePercentage: Float,
) : Response<Category> {

    override fun toEntity() = Category(
        id = id,
        title = title,
        interestRatePercentage = interestRatePercentage
    )
}
