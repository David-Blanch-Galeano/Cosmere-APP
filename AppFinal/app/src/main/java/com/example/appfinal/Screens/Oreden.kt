package com.example.appfinal.Screens

import android.graphics.Movie
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.appfinal.R
import com.example.appfinal.navigation.AppScreens
import com.example.appfinal.navigation.DrawerBody
import com.example.appfinal.navigation.DrawerHeader
import com.example.appfinal.navigation.MenuItem
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

@Composable
fun Orden(navController: NavController){
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
        MenuOrden(navController)
    }
}

@Composable
private fun MenuOrden(navController: NavController) {
    val colorboton = Color(0xFF3b3f3e)
//https://wallpaperaccess.com/full/39617.jpg
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .paint(painterResource(id = R.drawable.fondolargo5), contentScale = ContentScale.FillHeight)
            .padding(start = 5.dp)
            .padding(end = 5.dp)
            .padding(top = 50.dp),
    ) {
        Text(buildAnnotatedString{
            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color(0xFFffffff), fontSize = 20.sp)) {
                append("ORDEN DE ")
            }

            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color(0xFFff9500), fontSize = 20.sp)) {
                append("LECTURA")
            }
        })
        Spacer(modifier = Modifier.size(60.dp))

        obtenerImagen(idLibro = "Elantris")
        obtenerImagen(idLibro = "El Imperio Final")
        obtenerImagen(idLibro = "El Pozo de la Ascensión")
        obtenerImagen(idLibro = "El Héroe de las Eras")
        obtenerImagen(idLibro = "El aliento de los Dioses")
        obtenerImagen(idLibro = "Arcanum Ilimitado")
        obtenerImagen(idLibro = "El Camino de los Reyes")
        obtenerImagen(idLibro = "Palabras Radiantes")
        obtenerImagen(idLibro = "Juramentada")
        obtenerImagen(idLibro = "Esquirla del Amanecer")
        obtenerImagen(idLibro = "El Ritmo de la Guerra")
        obtenerImagen(idLibro = "Aleación de ley")
        obtenerImagen(idLibro = "Sombras de identidad")
        obtenerImagen(idLibro = "Brazales de Duelo")
        obtenerImagen(idLibro = "El metal perdido")
    }
}

@Composable
fun obtenerImagen(idLibro: String){
    val db = FirebaseFirestore.getInstance()
    var imagen by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    db.collection("Libros")
        .get()
        .addOnSuccessListener { resultado ->
            for (encontrado in resultado) {
                if (encontrado.id == idLibro) {
                    imagen = "${encontrado.data.get("imagen")}"
                    nombre = "${encontrado.data.get("nombre")}"
                    break
                }
            }
        }

    Row(Modifier.fillMaxWidth()) {
        Column(Modifier.weight(1F)) {
            Text(text = nombre,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFFFFFFF),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 100.dp)
                    .padding(horizontal = 40.dp)
            )
        }
        Column(Modifier.weight(1F)) {
            Card() {
                Box(){
                    AsyncImage(model = imagen, contentDescription = null, modifier = Modifier.width(167.dp).height(260.dp))                }
            }
        }
    }
    Spacer(modifier = Modifier.size(40.dp))
}