package ni.edu.uam.flighttrack.data.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCliente {
    private const val BASE_URL = "http://192.168.56.1:8080/"

    val api: ClienteApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ClienteApi::class.java)
    }

    val apiVuelos: VuelosApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VuelosApi::class.java)
    }
}