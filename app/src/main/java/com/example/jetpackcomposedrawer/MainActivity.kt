package com.example.jetpackcomposedrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposedrawer.ui.theme.JetpackComposeDrawerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDrawerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){

                }
            }
        }
    }
}

@Composable
fun NavigationDrawer(
    modifier : Modifier = Modifier
){
    Scaffold (
        topBar = {
            MyTopBar(
                onMenuClick = {

                }
            )
        }
    ){ paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            contentAlignment = Alignment.Center
        ){
            Text(stringResource(R.string.hello_world))
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    onMenuClick: ()->Unit
){
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                onMenuClick()
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.menu)
                )
            }
        },
        title = {
            Text(stringResource(R.string.app_name))
        }
    )
}

@Preview(showBackground = true)
@Composable
fun NavigationDrawerPreview(){
    JetpackComposeDrawerTheme {
        NavigationDrawer()
    }
}