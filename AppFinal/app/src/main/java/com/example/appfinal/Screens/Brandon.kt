package com.example.appfinal.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun Brandon(navController: NavController){
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
        MenuBrandon(navController)
    }
}

@Composable
private fun MenuBrandon(navController: NavController) {
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
    ) {
        Spacer(modifier = Modifier.size(30.dp))
        Text(buildAnnotatedString{
            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color(0xFFffffff), fontSize = 20.sp)) {
                append("BRANDON ")
            }

            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color(0xFFff9500), fontSize = 20.sp)) {
                append("SANDERSON")
            }

        })
        Spacer(modifier = Modifier.size(30.dp))
        AsyncImage(model = "https://i0.wp.com/www.lacasadeel.net/wp-content/uploads/2017/07/Brandon-Sanderson-1.jpg?resize=700%2C450&ssl=1", contentDescription = null)
        Spacer(modifier = Modifier.size(30.dp))
        Card(backgroundColor = Color(0xff0e0d0e)) {
            Text(
                text= "Brandon Sanderson nació el 19 de diciembre de 1975, en Lincoln, Nebraska. De niño le encantaba leer, pero perdió interés en el tipo de obras que solían sugerirle, y para cuando llegó a secundaria nunca abría un libro si podía evitarlo. Todo esto cambió cuando tenía 13 o 14 años y una astuta profesora, la Sra. Reader, le ofreció la oportunidad de leer Vencer al Dragón, de Bárbara Hambly. Brandon disfrutó este libro de principio a fin, y buscó otros similares. Descubrió autores como Robert Jordan, Melanie Rawn, David Eddings, Anne McCaffrey, y Orson Scott Card. Brandon siguió siendo un ávido lector hasta acabar el instituto. Le gustaba tanto la fantasía épica que incluso intentó escribir alguna cosa por sí mismo. Sus primeros intentos, dice, eran terribles.\n" +
                        "\n" +
                        "En 1994 Brandon se matriculó en un grado bioquímica de la Brigham Young University (BYU). Entre 1995 y 1997 se tomó un tiempo sabático y ejerció de misionero con la Iglesia de Jesucristo de los Santos de los Últimos Días. Brandon suele decir que fue durante el tiempo que pasó en Seúl, Korea, cuando se dio cuenta que no echaba para nada de menos la química, pero que echaba de menos escribir. Cuando volvió a la BYU, se convirtió en estudiante de Inglés, para el desconsuelo de su madre, quien siempre pensó que se sería médico. \n"+
                        "\n"+
                        "Brandon se tomó en serio la escritura, trabajando de noche como conserje de un hotel porque le permitían escribir en el trabajo. Durante esta época asistía a la universidad a tiempo completo durante el día, trabajaba de noche para pagarse sus estudios, y escribía todo lo que podía. Confiesa que apenas tenía vida social, pero terminó siete novelas durante este tiempo. Brandon envió varios escritos para que fueran publicados… Y acumuló una buena cantidad de cartas rechazándolos. A pesar de todo siguió siendo un escritor dedicado.\n" +
                        "\n" +
                        "Ser voluntario en The Leading Edge, la revista de fantasía y ciencia ficción de la BYU, fue una experiencia maravillosa para él. Leyó muchos escritos que se les remitían, forjó amistades para toda la vida, y ejerció como editor jefe durante su último año." +
                        "\n"
                        ,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFffffff),
                modifier = Modifier
                    .padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.size(30.dp))
        Text(buildAnnotatedString{
            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color(0xFFffffff), fontSize = 20.sp)) {
                append("GALARDONES OBTENIDOS")
            }
        })
        Spacer(modifier = Modifier.size(30.dp))
        Column(
            modifier = Modifier.background(Color(0xff0e0d0e)).padding(20.dp)
        ) {
            galardones("2005","Elantris (Elantris) – En 2006 Brandon hizo su primera visita a España con motivo de la entrega de los Premios UPC de Ciencia Ficción")
            galardones("2007","Defending Elysium (En defensa del Eliseo) –  Premio Internacional UPC de Ciencia  Ficción, Universidad Politécnica de Cataluña")
            galardones("2008","The Hero of Ages (El Héroe de las Eras) – Reviewers’ Choice Best Book Award, Best Epic Fantasy Novel Award, Romantic Times\n" +
                    "\n" +
                    "The Hero of Ages (El Héroe de las Eras) – Whitney Awards, Best Speculative Fiction Awards, LDStorymakers")
            galardones("2010","The Way of Kings (El Camino de los Reyes) – Whitney Awards, Best Speculative Fiction Award, LDStorymakers\n" +
                    "\n" +
                    "The Way of Kings (El Camino de los Reyes) – Whitney Awards, Best Novel of the Year Award, LDStorymakers\n" +
                    "\n" +
                    "Towers of Midnight (Torres de Medianoche) – Goodreads Choice Awards 2010, Best Fantasy of 2010, Goodreads")
            galardones("2011","The Way of Kings (El Camino de los Reyes) – David Gemmell Legend Award, DGLA\n" +
                    "\n" +
                    "The Alloy of Law (Aleación de Ley) – Whitney Awards, Best Novel of the Year Award, LDStorymakers")
            galardones("2013","The Emperor’s Soul (El Alma del Emperador) – Hugo Award, Best Novella, World Science Fiction Society\n" +
                    "\n" +
                    "Steelheart (Steelheart) – Whitney Awards, Best Young Adult—Speculative, LDStorymakers")
            galardones("2014","Words of Radiance (Palabras Radiantes) – 2014 Whitney Finalists, Best Fantasy of 2014, Whitney Awards")
            galardones("2015","Words of Radiance (Palabras Radiantes) – David Gemmell Legend Award, DGLA")
        }
    }
}

@Composable
fun galardones(anio: String, premio: String){
    Card(
        backgroundColor = Color(0xff0e0d0e)
    ) {
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFff9500),
                    fontSize = 20.sp
                )
            ) {
                append(anio+"\n \n")
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFffffff),
                    fontSize = 20.sp
                )
            ) {
                append(premio+"\n \n")
            }
        })
    }
}