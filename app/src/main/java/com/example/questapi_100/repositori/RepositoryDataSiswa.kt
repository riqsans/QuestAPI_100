package com.example.questapi_100.repositori

import com.example.questapi_100.apiservice.ServiceApiSiswa
import com.example.questapi_100.modeldata.DataSiswa

interface RepositoryDataSiswa{
    suspend fun getDataSiswa():List<DataSiswa>
    suspend fun postDatSiswa(dataSiswa: DataSiswa):retrofit2.Response<Void>
    suspend fun getSatuSiswa(id:Int) : DataSiswa
    suspend fun editSatuSiswa(id:Int,dataSiswa: DataSiswa):retrofit2.Response<Void>
}


class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
):RepositoryDataSiswa{
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDatSiswa(dataSiswa: DataSiswa): retrofit2.Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
    override suspend fun getSatuSiswa(id: Int): DataSiswa = serviceApiSiswa.getSatuSiswa(id)
    override suspend fun editSatuSiswa(id: Int,dataSiswa: DataSiswa):retrofit2.Response<Void> = serviceApiSiswa.editSatuSiswa(id, dataSiswa)
}
