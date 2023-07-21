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
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, onContinueClicked: () -> Unit) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelabTheme {
        OnboardingScreen (onContinueClicked = {})
    }
}
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
    fun MyApp(modifier: Modifier = Modifier) {

        var shouldShowOnboarding by remember { mutableStateOf(true) }

        Surface(modifier) {
            if (shouldShowOnboarding) {
                OnboardingScreen( onContinueClicked = {shouldShowOnboarding=false})
            } else {
                Greetings()
            }
        }
    }
    @Preview
    @Composable
    fun MyAppPreview() {
        BasicsCodelabTheme {
            MyApp(Modifier.fillMaxSize())
        }
    }

    @Composable
    private fun Greetings(
        modifier: Modifier = Modifier,
        names: List<String> = listOf("World", "Compose")
    ) {
        Column(modifier = modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }

    @Preview(showBackground = true, widthDp = 320)
    @Composable
    private fun GreetingsPreview() {
        BasicsCodelabTheme {
            Greetings()
        }
    }

    @Composable
    fun Greeting(name: String) {
        var expanded by remember { mutableStateOf(false) }
        val extraPadding = if (expanded) 48.dp else 0.dp

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 8.dp),
            color = MaterialTheme.colorScheme.primary
        ) {
           Row(modifier = Modifier.padding(24.dp)) {
               Column(modifier = Modifier.weight(1f).padding(bottom = extraPadding)) {
                   Text("Hello, ")
                   Text("$name!")
               }
               ElevatedButton(
                   onClick = { expanded = !expanded }
               ) {
                   Text(if (expanded ) "Show less" else "Show more")
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