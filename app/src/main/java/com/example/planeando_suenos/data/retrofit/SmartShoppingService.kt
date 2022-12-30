package com.example.planeando_suenos.data.retrofit

import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.domain.response.ErrorResponse
import com.example.planeando_suenos.domain.response.smartShopping.GetAllDreamsPlanResponse
import com.example.planeando_suenos.domain.response.smartShopping.GetDreamByIdResponse
import com.example.planeando_suenos.domain.response.smartShopping.GetDreamsTypeResponse
import com.example.planeando_suenos.domain.response.smartShopping.SuccessDreamResponse
import com.example.planeando_suenos.framework.retrofit.smartShopping.SmartShoppingApi
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SmartShoppingService @Inject constructor(private val smartShoppingApi: SmartShoppingApi) {

    suspend fun getDreamsType(): GetDreamsTypeResponse {
        return withContext(Dispatchers.IO) {
            val response = smartShoppingApi.getDreamsType()
            response.body() ?: run {
                val errorResponse =
                    Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                GetDreamsTypeResponse(
                    uuid = errorResponse.uuid,
                    success = false,
                    data = null,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }

    suspend fun createDreamPlan(dream: Dream): SuccessDreamResponse {
        return withContext(Dispatchers.IO) {
            require(dream.id == null)
            val response = smartShoppingApi.createDreamPlan(dream)
            response.body() ?: run {
                val errorResponse =
                    Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                SuccessDreamResponse(
                    uuid = errorResponse.uuid,
                    success = false,
                    data = null,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }

    suspend fun updateDreamPlan(dream: Dream): SuccessDreamResponse {
        return withContext(Dispatchers.IO) {
            requireNotNull(dream.id)
            val response = smartShoppingApi.updateDreamPlan(dream)
            response.body() ?: run {
                val errorResponse =
                    Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                SuccessDreamResponse(
                    uuid = errorResponse.uuid,
                    success = false,
                    data = null,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }

    suspend fun getAllDreamsPlan(): GetAllDreamsPlanResponse {
        return withContext(Dispatchers.IO) {
            val response = smartShoppingApi.getAllDreamsPlan()
            response.body() ?: run {
                val errorResponse =
                    Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                GetAllDreamsPlanResponse(
                    data = null,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }

    suspend fun getDreamById(dreamId: String): GetDreamByIdResponse {
        return withContext(Dispatchers.IO) {
            val response = smartShoppingApi.getDreamById(dreamId)
            response.body() ?: run {
                val errorResponse =
                    Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                GetDreamByIdResponse(
                    data = null,
                    code = errorResponse.code,
                    message = errorResponse.message,
                    details = errorResponse.details
                )
            }
        }
    }
}