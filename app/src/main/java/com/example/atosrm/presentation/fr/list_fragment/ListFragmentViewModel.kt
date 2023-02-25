package com.example.atosrm.presentation.fr.list_fragment

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.atosrm.data.ApplicationDataBase
import com.example.atosrm.data.person_srm.PersonSRM
import com.example.atosrm.data.person_srm.PersonSRMDao
import com.example.atosrm.data.person_srm.PersonSRMImpl
import com.example.atosrm.data.person_srm.PersonSRMRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



class ListFragmentViewModel(
    private val dao: PersonSRMDao
): ViewModel() {




}