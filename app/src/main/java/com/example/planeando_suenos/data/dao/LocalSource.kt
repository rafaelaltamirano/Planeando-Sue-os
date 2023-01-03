package com.example.planeando_suenos.data.dao

interface LocalSource<T> {

    suspend fun save(t:  T)

    suspend fun load(): T?

    suspend fun clear()

}