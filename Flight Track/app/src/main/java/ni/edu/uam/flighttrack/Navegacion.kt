package ni.edu.uam.flighttrack

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ni.edu.uam.flighttrack.vistas.*
import ni.edu.uam.flighttrack.viewmodel.VuelosViewModel
import ni.edu.uam.flighttrack.viewmodel.ClientesViewModel

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    val vuelosViewModel: VuelosViewModel = viewModel()
    val clientesViewModel: ClientesViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("crearVuelo") {
            CrearVueloScreen(
                vuelosViewModel = vuelosViewModel,
                clientesViewModel = clientesViewModel,
                onDone = { navController.popBackStack() }
            )
        }
        composable("crearCliente") {
            CrearClienteScreen(
                clientesViewModel = clientesViewModel,
                onDone = { navController.popBackStack() }
            )
        }
        composable("administrarVuelos") {
            AdministrarVuelosScreen(
                vuelosViewModel = vuelosViewModel,
                onDone = { navController.popBackStack() }
            )
        }
        composable("administrarClientes") {
            AdministrarClientesScreen(
                clientesViewModel = clientesViewModel,
                onDone = { navController.popBackStack() }
            )
        }
    }
}
