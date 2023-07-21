package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }


    @Composable
    fun MyApp(
        modifier: Modifier = Modifier,
        names: List<String> = listOf("World", "Compose")
    ) {
        Column(modifier = modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 8.dp),
            color = MaterialTheme.colorScheme.primary
        ) {
           Row(modifier = Modifier.padding(24.dp)) {
               Column(modifier = Modifier.weight(1f)) {
                   Text("Hello, ")
                   Text("$name!")
               }
               Button(onClick = { /*TODO*/ }) {
                   Text("Show more")
               }

           }
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun DefaultPreview() {
        BasicsCodelabTheme {
            MyApp()
        }
    }
}