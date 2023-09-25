package com.example.appfinal.Screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.appfinal.R
import com.example.appfinal.navigation.*
import kotlinx.coroutines.launch

@Composable
fun MenuInicial(navController: NavController){
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
        // Screen content
        Menu(navController)
    }
}

val colorboton = Color(0xff231f20)
val colortexto = Color(0xFFff9400)

@Composable
private fun Menu(navController: NavController) {
    //var image = painterResource(id = R.drawable.owl)

    val Fondo = Color(0xFFdc928d)
    // Color de fondo fffcf1
    // Color de texto 27533a
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .paint(
                painterResource(id = R.drawable.fondonuevo),
                contentScale = ContentScale.FillHeight
            )
            .fillMaxHeight()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Image(
            modifier = Modifier
                .size(200.dp, 200.dp),
            painter = painterResource(id = R.drawable.icono),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(50.dp))
        noticias(url = "https://cosmere.es/wp-content/uploads/2022/12/20221206-Avance-El-Archivo-de-las-Tormentas-05-Flashback-Szeth-1_v02_WEB.jpg", des = "El nuevo libro del Archivo de las tormentas tendra como protagonista a Szeth y descubriremos su pasado.")
        noticias(url = "https://cosmere.es/wp-content/uploads/2022/11/20221209-Guia-Mistborn_WEB.jpg", des = "Nueva edición de Nacidos de la bruma, ya puedes encontrarla en la libreria de tu preferencia")
        noticias(url = "https://cosmere.es/wp-content/uploads/2022/11/20221116-01-DS-CON-2022-Discurso-de-Brandon_WEB_02.jpg", des = "Sanderson habla sobre DragonSteel y de cuando saldra el libro que contara el inicio del cosmere.")

    }
}

@Composable
fun noticias(des: String, url: String){
    Card(
        modifier = Modifier
            .background(color = colorboton)
            .width(360.dp)
            .height(300.dp)
    ) {
        Column() {


            AsyncImage(
                model = url,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Novedad",
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xff000000),
                modifier = Modifier
                    .background(colortexto)
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.size(7.dp))
            Text(text = des,
            modifier = Modifier.padding(5.dp))
        }
    }
    Spacer(modifier = Modifier.size(20.dp))
}