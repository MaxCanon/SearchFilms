package com.example.searchfilms.presentation.cast

import com.example.searchfilms.core.ui.RVItem
import com.example.searchfilms.domain.models.MovieCastPerson

sealed interface MoviesCastRVItem : RVItem {

    data class HeaderItem(
        val headerText: String,
    ) : MoviesCastRVItem

    data class PersonItem(
        val data: MovieCastPerson,
    ) : MoviesCastRVItem

}