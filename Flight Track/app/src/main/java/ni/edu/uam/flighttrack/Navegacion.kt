package ni.edu.uam.flighttrack

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ni.edu.uam.flighttrack.vistas.*
import ni.edu.uam.administracion.modelo.Vuelo

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    val vuelos = remember { mutableStateListOf<Vuelo>() }

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("crearVuelo") {
            CrearVueloScreen(vuelos = vuelos, onDone = { navController.popBackStack() })
        }
        composable("crearPasajero") {
            CrearPasajeroScreen(
                vuelos = vuelos,
                onDone = { navController.popBackStack() },
                onAdministrarPasajeros = { vueloIndex ->
                    navController.navigate("administrarPasajeros/$vueloIndex")
                }
            )
        }
        composable("administrarVuelos") {
            AdministrarVuelosScreen(
                vuelos = vuelos,
                onVerPasajeros = { vueloIndex ->
                    navController.navigate("administrarPasajeros/$vueloIndex")
                },
                onDone = { navController.popBackStack() }
            )
        }
        composable("administrarPasajeros/{vueloIndex}") { backStackEntry ->
            val vueloIndex = backStackEntry.arguments?.getString("vueloIndex")?.toIntOrNull() ?: -1
            AdministrarPasajerosScreen(
                vuelos = vuelos,
                vueloIndex = vueloIndex,
                onDone = { navController.popBackStack() }
            )
        }
    }
}
