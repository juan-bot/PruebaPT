package com.example.pruebapt.presentation

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebapt.data.model.BankResponse
import com.example.pruebapt.domain.repository.GetInfoBanksRepository
import com.example.pruebapt.presentation.view.AdpBank
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BankListViewModel: ViewModel() {
    private val repo = GetInfoBanksRepository()
    private lateinit var adapter: AdpBank
    var adpBank: MutableLiveData<AdpBank> = MutableLiveData()
    fun apiCall(context: Context){

        viewModelScope.launch {
            //repo.getBanks()
            val response = repo.getInfoBanks(context)
            var bankList = mutableListOf<BankModel>()
            for (i in response) {
                bankList.add(i)
            }

            adapter = AdpBank(bankList)
            adpBank.postValue(adapter)
        }
    }

}