package com.example.lab4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lab4.ui.theme.Lab4Theme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    AppNavHost(modifier = Modifier.fillMaxSize(), navController = rememberNavController())
                }
            }
        }
    }
}

@Composable
fun LoginScreen(navHostController: NavHostController) {
    val context = LocalContext.current
    var username by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Logo")
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = username, onValueChange = {username = it}, label = {Text(text = "Username")})
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = password, onValueChange = {password = it}, label = {Text(text = "Password")})
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            Toast.makeText(context, "Login Successfully!", Toast.LENGTH_LONG).show()
            val intent = Intent(context, Bai2Activity::class.java)
            val nhanVienModel = NhanVienModel(username, password)

            intent.putExtra(KEY_USERNAME, username)
            intent.putExtra(KEY_NHANVIEN_MODEL, nhanVienModel)
            navHostController.navigate("${NavigationItem.Home.route}/$username/$password")
//            context.startActivity(intent)
        }) {
            Text(text = "Login")
        }
    }
}