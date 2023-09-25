package com.example.appfinal.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.appfinal.R
import com.example.appfinal.navigation.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

@Composable
fun NoCosmere(navController: NavController){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
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
        MenuNoCosmere(navController)
    }
}

@Composable
private fun MenuNoCosmere(navController: NavController) {
    val colorboton = Color(0xFF3b3f3e)
//https://wallpaperaccess.com/full/39617.jpg
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .paint(
                painterResource(id = R.drawable.fondolargo4),
                contentScale = ContentScale.FillHeight
            )
            .padding(start = 5.dp)
            .padding(end = 5.dp)
            .padding(top = 50.dp),
    ) {
        Text(buildAnnotatedString{
            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color(0xFFe12121), fontSize = 20.sp)) {
                append("NO ")
            }

            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color(0xFFffffff), fontSize = 20.sp)) {
                append("COSMERE")
            }
        })
        Spacer(modifier = Modifier.size(100.dp))
        obtenerImagen(idLibro = "Citónica")
        obtenerImagen(idLibro = "Escuadrón")
        obtenerImagen(idLibro = "Estelar")
        obtenerImagen(idLibro = "El Despertar")
        obtenerImagen(idLibro = "Redención")
    }
}