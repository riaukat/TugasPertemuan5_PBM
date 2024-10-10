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
        // Mengatur konten untuk aktivitas dengan tema yang telah ditentukan
        setContent {
            ArtSpaceTheme {
                // Membuat Surface sebagai kontainer utama
                Surface(modifier = Modifier.fillMaxSize()) {
                    // Menampilkan galeri gambar
                    ImageGallery()
                }
            }
        }
    }
}

@Composable
fun ImageGallery() {
    // Daftar gambar dan deskripsi yang akan ditampilkan
    val images = listOf(
        Pair(R.drawable.bangunan, "Sailing Under the Bridge"),
        // Tambahkan lebih banyak gambar di sini
    )

    // Menggunakan state untuk menyimpan indeks gambar saat ini
    var currentIndex by remember { mutableStateOf(0) }

    // Mengatur layout kolom untuk menampilkan gambar dan teks
    Column(
        modifier = Modifier
            .fillMaxSize() // Mengisi ukuran maksimum
            .padding(16.dp), // Menambahkan padding di sekitar kolom
        verticalArrangement = Arrangement.Center, / Menyusun konten secara vertikal di tengah
        horizontalAlignment = Alignment.CenterHorizontally // Menyusun konten secara horizontal di tengah
    ) {
        // Menampilkan gambar berdasarkan indeks saat ini
        Image(
            painter = painterResource(id = images[currentIndex].first), // Mengambil gambar dari drawable
            contentDescription = null, // Menambahkan deskripsi konten untuk aksesibilitas
            modifier = Modifier.fillMaxWidth() // Mengisi lebar maksimum
        )
        Spacer(modifier = Modifier.height(16.dp)) // Menambahkan ruang vertikal antara gambar dan teks
        // Menampilkan teks deskripsi gambar
        BasicText(
            text = images[currentIndex].second, // Mengambil deskripsi gambar
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold) // Mengatur gaya teks
        )
        Spacer(modifier = Modifier.height(8.dp)) // Menambahkan ruang vertikal antara teks dan tombol
        // Mengatur baris untuk tombol navigasi
        Row(
            modifier = Modifier.fillMaxWidth(), // Mengisi lebar maksimum
            horizontalArrangement = Arrangement.SpaceBetween // Menyusun tombol dengan ruang di antara mereka
        ) {
            // Tombol untuk kembali ke gambar sebelumnya
            Button(
                onClick = {
                    // Mengurangi indeks jika bukan gambar pertama
                    if (currentIndex > 0) currentIndex--
                }
            ) {
                Text("Previous") // Teks tombol
            }
            // Tombol untuk melanjutkan ke gambar berikutnya
            Button(
                onClick = {
                    // Meningkatkan indeks jika bukan gambar terakhir
                    if (currentIndex < images.size - 1) currentIndex++
                }
            ) {
                Text("Next") // Teks tombol
            }
        }
    }
}
