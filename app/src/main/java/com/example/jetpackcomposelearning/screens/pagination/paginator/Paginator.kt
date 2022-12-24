package com.example.jetpackcomposelearning.screens.pagination.paginator

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}