package com.example.appfinal.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import com.example.appfinal.R
import com.example.appfinal.navigation.*
import kotlinx.coroutines.launch

@Composable
fun Cosmere(navController: NavController){
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
        MenuCosmere(navController)
    }
}

@Composable
private fun MenuCosmere(navController: NavController) {
    val colorboton = Color(0xFF3b3f3e)
//https://wallpaperaccess.com/full/39617.jpg
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .paint(
                painterResource(id = R.drawable.fondolargo5),
                contentScale = ContentScale.FillHeight
            )
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.uo),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(30.dp))
        Text(buildAnnotatedString{
            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color(0xFFffffff), fontSize = 20.sp)) {
                append("¿QUÉ ES EL ")
            }

            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color(0xFFff9500), fontSize = 20.sp)) {
                append("COSMERE")
            }

            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color(0xFFffffff), fontSize = 20.sp)) {
                append("?")
            }
        })
        Spacer(modifier = Modifier.size(30.dp))
        Card(backgroundColor = Color(0xff0e0d0e)) {
            Text(
                text = "Cosmere es la palabra que define el universo en el cual muchos de los libros de Brandon Sanderson tienen lugar. Es decir, a pesar de que las historias se desarrollan en diferentes mundos, cada uno de estos se encuentra en la misma galaxia, o cúmulo estelar.\n" +
                        "\n" +
                        "La estructura del universo literario del Cosmere es la misma que la nuestra. Fuerzas como la gravedad o el magnetismo, son idénticas a las que conocemos. Así mismo, el tiempo fluye al mismo ritmo que el nuestro.\n" +
                        "\n" +
                        "Por lo tanto, todas las novelas del Cosmere comparten una única cosmología, siguen las mismas reglas en cuanto a magia se refiere, y están conectadas por una historia general (aunque no todas las culturas que pueblan las páginas lo conocen). A pesar de esto, Brandon ha dicho en reiteradas ocasiones que no se necesita tener ningún conocimiento del Cosmere para disfrutar las historias narradas en los diferentes mundos, cada una de ellas puede ser leída por separado, y sin necesidad de seguir un orden establecido. Pero, eventualmente será necesario tener una cierta comprensión de este universo literario para entender su trama. Toda la información que da lugar al Cosmere se está añadiendo lentamente a los libros en forma de pistas y comentarios, una especie de historia detrás de la historia que saltará a primer plano en futuras novelas.\n" +
                        "\n" +
                        "Un ejemplo que todos entenderemos es el Universo Marvel, que tiene un sistema similar. A pesar de tener sus historias propias, todos sus personajes están conectados y a veces se cruzan, ya que viven en el mismo universo. El Cosmere es lo mismo. Hay personajes que llamamos saltamundos que visitan otras tramas. Uno de los mini juegos en las historias de Brandon es encontrar a estos personajes.\n" +
                        "\n" +
                        "Si lo que te preocupaba era tener que leer los libros en cierto orden al enterarte de que están conectados en un mismo universo, esta información es todo lo que necesitas, pues ya sabes que no es necesario. De todos modos si quieres una guía de lectura, tenemos una creada.\n" +
                        "\n" +
                        "Para aquellos interesados en el lore, vamos a hacer una breve recapitulación de todo lo que sabemos hasta ahora de la historia del Cosmere. Esto no es spoiler como tal, al ser la historia del origen del universo. Podemos considerarlo una precuela, y esperamos poder aprender de ella en profundidad en libros futuros de Brandon como Dragonsteel y la trilogía final de Nacidos de la Bruma.",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFffffff),
                modifier = Modifier
                    .padding(20.dp)
            )
        }
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.constelaciones_mundos_cosmere),
            contentDescription = null,
        )
        Card(backgroundColor = Color(0xff0e0d0e)) {
            Text(
                text = "La historia del Cosmere comienza con Adonalsium. No está claro quién o qué fue Adonalsium, si era una fuerza, una persona, un dios, o algo similar. Tampoco está claro si tenía consciencia propia.\n" +
                        "\n" +
                        "A pesar de no conocer grandes detalles, Adonalsium es comúnmente descrito como el poder de la creación y hacedor de todo el Cosmere, así como de la vida que lo habita. Posiblemente era algo con cantidades increíbles de Investidura (que es el nombre que recibe la magia en el Cosmere). Toda la Investidura que aparece en los libros deriva del poder de Adonalsium.\n" +
                        "\n" +
                        "En esta época, muchas de las razas eran conscientes de su existencia. Algunos lo veneraban como a un dios. Otros, en cambio y por diversos motivos, se oponían a él.\n" +
                        "\n" +
                        "En este segundo grupo estaban los que codiciaban el poder de la creación o temían que supusiera una amenaza. Finalmente esta facción acabó creando un arma misteriosa con el objetivo de usarla contra Adonalsium.\n" +
                        "\n" +
                        "Brandon ha explicado que uno de los intentos de destruir Adonalsium terminó en fracaso, pero no conocemos detalles al respecto, es posible que el arma fallara o que el arma fuese creada tras ese primer intento fallido. Tendremos que esperar a libros futuros o a que Brandon decida compartir más información con nosotros.\n" +
                        "\n" +
                        "Aunque sabemos que los seres humanos ya habitaban planetas, no sabemos cuántos eran, ni la cantidad de mundos que ocupaban. También es un hecho conocido que los primeros seres humanos estaban en el planeta Yolen, como es el caso de Hoid, (una persona de gran importancia en el Cosmere) quien es originario de ese mundo.",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFffffff),
                modifier = Modifier
                    .padding(20.dp)
            )
        }
    }
}