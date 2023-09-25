package com.example.appfinal.Screens

import android.graphics.Movie
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.appfinal.R
import com.example.appfinal.navigation.AppScreens
import com.example.appfinal.navigation.DrawerBody
import com.example.appfinal.navigation.DrawerHeader
import com.example.appfinal.navigation.MenuItem
import com.google.firebase.firestore.FirebaseFirestore
import io.grpc.Context
import kotlinx.coroutines.launch

@Composable
fun Guia(navController: NavController){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            com.example.appfinal.navigation.AppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                navController = navController,
                items = listOf(
                    MenuItem(
                        id = "menu",
                        title = "Noticias",
                        contentDescription = "El menu inicial",
                        icon = Icons.Default.Notifications,
                        ruta = AppScreens.ScreenMenu.route
                    ),
                    MenuItem(
                        id = "buscar",
                        title = "Buscar",
                        contentDescription = "Buscar un libro",
                        icon = Icons.Default.Search,
                        ruta = AppScreens.SecondScreen.route
                    ),
                    MenuItem(
                        id = "guia",
                        title = "Guia",
                        contentDescription = "Libros por orden cronológico",
                        icon = Icons.Default.Star,
                        ruta = AppScreens.TherdScreen.route
                    ),
                    MenuItem(
                        id = "cosmere",
                        title = "Cosmere",
                        contentDescription = "Informacions sobre el cosmere",
                        icon = Icons.Default.Info,
                        ruta = AppScreens.FourthScreen.route
                    ),
                    MenuItem(
                        id = "personajes",
                        title = "Personajes",
                        contentDescription = "Ver algunos personajes del cosmere",
                        icon = Icons.Default.Person,
                        ruta = AppScreens.FithScreen.route
                    ),
                    MenuItem(
                        id = "no cosmere",
                        title = "Libros no cosmere",
                        contentDescription = "Libros fuera del cosmere",
                        icon = Icons.Default.AddCircle,
                        ruta = AppScreens.SixScreen.route
                    ),
                    MenuItem(
                        id = "autor",
                        title = "Brandon Sanderson",
                        contentDescription = "Informacion sobre el autor",
                        icon = Icons.Default.Face,
                        ruta = AppScreens.SevenScreen.route
                    ),
                )
            ) {
                println("Clicked on ${it.title}")
            }

        }
    ) {
        MenuGuia(navController)
    }
}

@Composable
private fun MenuGuia(navController: NavController) {
    val db = FirebaseFirestore.getInstance()
    val colorboton = Color(0xFF3b3f3e)
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xff0e0d0e))
            .padding(end = 5.dp)
            .padding(top = 50.dp),
    ) {
        var datos by remember { mutableStateOf("") }
        var titulo by remember { mutableStateOf("") }
        var imagen by remember { mutableStateOf("") }
        var nombre_coleccion = "Libros"
        val field_busqueda = "nombre"
        Spacer(modifier = Modifier.size(20.dp))
        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text(text = "Título del libro", color = Color(0xFFFFFFFF)) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                textColor = Color.White,
                cursorColor = Color.White,
                unfocusedBorderColor = Color.White
            ),
            modifier = Modifier

                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            singleLine = true,
        )
        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = {

                datos = ""
                imagen = ""

                db.collection("Libros")
                    .get()

                db.collection(nombre_coleccion)
                    .whereEqualTo(field_busqueda, titulo.uppercase())
                    .get()

                    .addOnSuccessListener { resultado ->
                        for (encontrado in resultado) {
                            datos += encontrado["descripcion"].toString()
                            imagen += encontrado["imagen"].toString()
                        }

                        if (datos.isEmpty()) {
                            Toast.makeText(context, "No existe ese libro", Toast.LENGTH_LONG).show()
                        }
                    }
                    .addOnFailureListener { resultado ->
                        datos = "La conexión a FireStore no se ha podido completar"
                    }
                    .addOnFailureListener { resultado ->
                        datos = "La conexión a FireStore no se ha podido completar"
                    }
            },

            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorboton,
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Color.White)

        )
        {

            Text(text = "Encontrar Libro")

        }

        Spacer(modifier = Modifier.size(15.dp))

        AsyncImage(model = imagen, contentDescription = null, modifier = Modifier.width(250.dp).height(500.dp))
        Box(
            modifier = Modifier
                .padding(20.dp)
                .background(Color(0xff3b363b), shape = RoundedCornerShape(5))
                .border(BorderStroke(5.dp, Color(0xff4c474c)), shape = RoundedCornerShape(5)),
        ) {
            if (datos != "") {
                Text(text = datos, color = Color.White, modifier = Modifier.padding(17.dp))
            }

        }
    }
}
