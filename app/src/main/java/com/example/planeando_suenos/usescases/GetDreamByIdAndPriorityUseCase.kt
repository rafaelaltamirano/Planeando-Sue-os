package com.example.planeando_suenos.usescases

import com.example.planeando_suenos.data.dao.SmartShoppingDao
import com.example.planeando_suenos.domain.entities.DreamWithUser
import javax.inject.Inject

class GetDreamByIdAndPriorityUseCase @Inject constructor(private val smartShoppingDao: SmartShoppingDao) {

    suspend operator fun invoke(dreamId: String, priority: String): DreamWithUser {
        return smartShoppingDao.getDreamById(dreamId, priority)
    }
}