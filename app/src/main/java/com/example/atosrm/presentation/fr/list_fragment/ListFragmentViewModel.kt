package com.example.atosrm.presentation.fr.list_fragment

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.atosrm.data.ApplicationDataBase
import com.example.atosrm.data.person_srm.PersonSRMImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ListFragmentViewModel @Inject constructor(
    private val application: Application
): ViewModel() {
    private val repo = PersonSRMImpl(application = application)

    suspend fun getAllList() = repo.getAllUser()
    suspend fun checkIsTherePerson() = getAllList().isEmpty()
}