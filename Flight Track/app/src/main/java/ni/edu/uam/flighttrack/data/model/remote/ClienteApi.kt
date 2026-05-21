package ni.edu.uam.flighttrack.data.model.remote

import ni.edu.uam.flighttrack.data.model.model.Cliente
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ClienteApi {
    @GET("/api/clientes")
    suspend fun getClientes(): List<Cliente>
    @GET("/api/clientes/{id}")
    suspend fun getClienteById(@Path("id") id: Long): Cliente
    @POST("/api/clientes")
    suspend fun createCliente(@Body cliente: Cliente): Cliente
    @PUT("/api/clientes/{id}")
    suspend fun updateCliente(@Path("id") id: Long, @Body cliente: Cliente): Cliente
    @DELETE("/api/clientes/{id}")
    suspend fun deleteCliente(@Path("id") id: Long)

}