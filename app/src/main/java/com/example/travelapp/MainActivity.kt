package com.example.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.ui.features.DetailScreen
import com.example.travelapp.ui.features.HomeScreen
import com.example.travelapp.ui.features.SplashScreen
import com.example.travelapp.ui.theme.TravelAppTheme
import com.google.accompanist.insets.ProvideWindowInsets

import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // This makes it possible to draw behind the status bar.
        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            TravelAppTheme {
                    val navController = rememberNavController()

                    ProvideWindowInsets {

                        val systemUiController = rememberSystemUiController()
                        SideEffect {
                            systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
                        }

                        val navController = rememberNavController()

                        val scaffoldState = rememberScaffoldState()

                        Scaffold(
                            scaffoldState = scaffoldState,
                            drawerContent = {
                                Text(text = "SCAFOLDR")
                            }
                        ){
                            Surface(
                                        modifier = Modifier.fillMaxSize(),
                                        color = MaterialTheme.colors.background
                                    ) {

                                        NavHost(
                                            navController = navController,
                                            startDestination = "splash"
                                        ) {


                                            composable("splash") {

                                                SplashScreen(navController)

                                            }

                                            composable("home") {

                                                HomeScreen(navController)

                                            }

                                            composable("detail") {
                                                DetailScreen(navController)
                                            }

                                        }
                                    }
                        }

                    }
                }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TravelAppTheme {
        Greeting("Android")
    }
}