package cl.emilym.standardbutton.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.emilym.compose.standardbutton.ButtonType
import cl.emilym.compose.standardbutton.StandardButton
import cl.emilym.standardbutton.test.theme.StandardButtonTheme

@Composable
fun App() {
    StandardButtonTheme {
        Scaffold { innerPadding ->
            Column(Modifier.padding(innerPadding).padding(16.dp)) {
                var counter by remember { mutableStateOf(0) }
                StandardButton(
                    type = ButtonType.PRIMARY,
                    onClick = { counter++ }
                ) {
                    Text("This is a test of the button (counter = ${counter})")
                }
            }
        }
    }
}