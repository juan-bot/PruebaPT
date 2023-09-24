package com.example.pruebapt.domain.repository

import android.content.Context
import android.util.Log
import com.example.pruebapt.data.local.AppDataBase
import com.example.pruebapt.data.local.BankEntity
import com.example.pruebapt.data.local.DataBase
import com.example.pruebapt.data.model.BankResponse
import com.example.pruebapt.data.network.RetrofitBank
import com.example.pruebapt.presentation.BankModel

class GetInfoBanksRepository (){

    private suspend fun getBanksApi(): List<BankResponse>{
        return RetrofitBank.api().getBankInfo()
    }
    private suspend fun CreateDB(context: Context): AppDataBase {
        return DataBase(context).getDB()
    }
    suspend fun getInfoBanks(context: Context): MutableList<BankModel>{
        var db = CreateDB(context)
        val localData = db.bankDao().getAll()
        val bankList : MutableList<BankModel> = arrayListOf()
        if(localData.isEmpty()){
            val response = getBanksApi()
            for (i in response.indices) {
                Log.i("RESPONSE:","${response[i].bankName} ,${response[i].description} ,${response[i].age} ,${response[i].url}")
                val obj = BankEntity(
                    uid = i+1,
                    name =  response[i].bankName,
                    url =  response[i].url,
                    age =  response[i].age,
                    description =  response[i].description
                )
                val responseRoom = db.bankDao().insert(obj)
                val model = BankModel(
                    age = response[i].age,
                    bankName=  response[i].bankName,
                    description = response[i].description,
                    url= response[i].url
                )
                bankList.add(model)
            }

        }else{
            for (i in localData.indices) {
                Log.i("LOCAL:","${localData[i].name} ,${localData[i].description} ,${localData[i].age} ,${localData[i].url}")

                var obj = BankModel(
                     age = localData[i].age,
                     bankName=  localData[i].name,
                     description = localData[i].description,
                     url= localData[i].url
                )
                bankList.add(obj)
            }
        }
        return bankList
    }

}