package com.example.atosrm.presentation.fr.list_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.atosrm.data.person_srm.PersonSRMDao

@Suppress("UNCHECKED_CAST")
class ListViewModelFactory(
    private val dao: PersonSRMDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListFragmentViewModel(dao = dao) as T
    }

}