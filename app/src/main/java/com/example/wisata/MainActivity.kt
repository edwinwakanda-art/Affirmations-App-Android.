package com.example.wisata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                WisataList()
            }
        }
    }
}

data class Wisata(
    val nameRes: Int,
    val imageRes: Int,
    val description: String
)

@Composable
fun WisataList() {
    val wisataList = listOf(
        Wisata(
            R.string.bali,
            R.drawable.bali,
            "Pantai indah dengan pasir putih dan ombak yang cantik."
        ),
        Wisata(
            R.string.bromo,
            R.drawable.bromo,
            "Gunung aktif terkenal dengan pemandangan sunrise."
        ),
        Wisata(
            R.string.raja_ampat,
            R.drawable.rajaampat,
            "Surga bawah laut Indonesia yang sangat indah."
        ),
        Wisata(
            R.string.labuan_bajo,
            R.drawable.labuanbajo,
            "pulai dengan keindahan yang sangat memukau."
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(wisataList) { wisata ->
            WisataCard(wisata)
        }
    }
}

@Composable
fun WisataCard(wisata: Wisata) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = wisata.imageRes),
                contentDescription = stringResource(id = wisata.nameRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = wisata.nameRes),
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = wisata.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}