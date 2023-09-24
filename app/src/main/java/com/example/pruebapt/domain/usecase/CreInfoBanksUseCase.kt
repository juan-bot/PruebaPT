package com.example.pruebapt.domain.usecase

import android.content.Context
import com.example.pruebapt.domain.repository.GetInfoBanksRepository

class CreInfoBanksUseCase {
    fun getInfobanksUsecase(context: Context){
        suspend fun getInfo(){
            val repo = GetInfoBanksRepository()
            repo.getInfoBanks(context)
        }
    }
}