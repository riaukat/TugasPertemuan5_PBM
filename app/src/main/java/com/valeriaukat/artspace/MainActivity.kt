package com.valeriaukat.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valeriaukat.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ImageGallery()
                }
            }
        }
    }
}

@Composable
fun ImageGallery() {
    val images = listOf(
        Pair(R.drawable.bangunan, "Sailing Under the Bridge"),
        // Tambahkan lebih banyak gambar di sini
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = images[currentIndex].first),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        BasicText(
            text = images[currentIndex].second,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (currentIndex > 0) currentIndex--
                }
            ) {
                Text("Previous")
            }
            Button(
                onClick = {
                    if (currentIndex < images.size - 1) currentIndex++
                }
            ) {
                Text("Next")
            }
        }
    }
}