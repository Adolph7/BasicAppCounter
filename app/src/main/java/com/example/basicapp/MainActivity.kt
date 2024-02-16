
package com.example.basicapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            basic()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun basic() {
    var count by remember{ mutableStateOf( 0) }

    var max by remember{ mutableStateOf(10) }

    var color= if (count>max) MaterialTheme.colorScheme.error else Color.Green

    Column {
        Text(text = "$count",
            color = color,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
                .background(Color.LightGray)
                .padding(16.dp))

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier
            .align(Alignment.CenterHorizontally)) {
            Button(onClick = {count++}) {
                Text(text = "Add")

            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { if (count > 0) count--}) {
                Text(text = "Remove")

            }

        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Maximum value...")
        TextField(value = "$max", onValueChange = {max = it.toIntOrNull() ?: 10})
    }

}



