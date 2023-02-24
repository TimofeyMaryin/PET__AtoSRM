package com.example.atosrm.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.atosrm.data.person_srm.PersonSRMDao
import com.example.atosrm.data.person_srm.PersonSRMImpl
import com.example.atosrm.presentation.fr.add_person_srm.AddPersonViewModel

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory(
    private val navController: NavController,
    private val application: Application,
    private val dao: PersonSRMDao,
    private val addPersonViewModel: AddPersonViewModel
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(
            navController = navController,
            application = application,
            dao = dao,
            addPersonViewModel = addPersonViewModel
        ) as T
    }

}