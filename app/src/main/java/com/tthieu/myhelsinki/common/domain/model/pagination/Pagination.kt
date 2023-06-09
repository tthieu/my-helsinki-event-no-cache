package com.tthieu.myhelsinki.common.domain.model.pagination

data class Pagination(
    val lastItemIdx: Int, // from 0
    val totalItems: Int
) {
    companion object {
        // For the cases when we store the current page locally, but haven't yet requested a new page
        // from the remote source. Total pages should change with time, so we'll handle the value as
        // unknown before updating.
        const val UNKNOWN_TOTAL = -1
        const val DEFAULT_PAGE_SIZE = 20
    }

    val canLoadMore: Boolean
        get() = totalItems == UNKNOWN_TOTAL || lastItemIdx < totalItems - 1
}
