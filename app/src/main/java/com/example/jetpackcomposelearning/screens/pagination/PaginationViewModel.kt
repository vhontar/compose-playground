package com.example.jetpackcomposelearning.screens.pagination

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposelearning.screens.pagination.paginator.DefaultPaginator
import com.example.jetpackcomposelearning.screens.pagination.repository.ListItem
import com.example.jetpackcomposelearning.screens.pagination.repository.Repository
import kotlinx.coroutines.launch

class PaginationViewModel: ViewModel() {
    var state by mutableStateOf(ScreenState())

    private val repository = Repository()
    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            repository.getItems(nextPage, 20)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(errorMessage = it?.localizedMessage)
        },
        onSuccess = { items, nextKey ->
            state = state.copy(
                items = state.items + items,
                page = nextKey,
                endReached = items.isEmpty()
            )
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() = viewModelScope.launch {
        paginator.loadNextItems()
    }
}

data class ScreenState(
    val isLoading: Boolean = false,
    val items: List<ListItem> = emptyList(),
    val errorMessage: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)