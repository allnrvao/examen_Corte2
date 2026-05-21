package ni.edu.uam.flighttrack.data.model.remote

import ni.edu.uam.flighttrack.data.model.model.Vuelos
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface VuelosApi {
    @GET("/api/vuelos")
    suspend fun getVuelos(): List<Vuelos>
    @GET("/api/vuelos/{id}")
    suspend fun getVueloById(@Path("id") id: Long): Vuelos
    @POST("/api/vuelos")
    suspend fun createVuelo(@Body vuelo: Vuelos): Vuelos
    @PUT("/api/vuelos/{id}")
    suspend fun updateVuelo(@Path("id") id: Long, @Body vuelo: Vuelos): Vuelos
    @DELETE("/api/vuelos/{id}")
    suspend fun deleteVuelo(@Path("id") id: Long)
}