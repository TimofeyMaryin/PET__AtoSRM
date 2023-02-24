package com.example.atosrm.presentation.fr.search

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.atosrm.domain.use_cases.person_srm.SearchUseCase

class SearchViewModel: ViewModel() {
    var searchValue by mutableStateOf("")
        private set

    fun changeSearchValue(value: String) {
        searchValue = value
    }

    suspend fun searchPerson(application: Application, searchValue: String) = SearchUseCase.execute(application, searchValue)

}