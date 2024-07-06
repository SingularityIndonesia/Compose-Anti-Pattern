import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import topic.LamdaCaptureState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose Antipattern",
    ) {
        var screen by remember { mutableStateOf("main") }

        Navigator(
            screen,
            toMain = { screen = "main" },
            toLambdaCaptureState = { screen = "lamda-capture-state" }
        )
    }
}

@Composable
fun Navigator(
    screen: String,
    toMain: () -> Unit,
    toLambdaCaptureState: () -> Unit
) {
    when (screen) {
        "main" -> MainScreen(
            toLambdaCaptureState = toLambdaCaptureState
        )

        "lamda-capture-state" -> LamdaCaptureState(
            onBack = toMain
        )
    }
}

@Composable
fun MainScreen(
    toLambdaCaptureState: () -> Unit
) {
    LazyColumn {
        item {
            Topic(
                "Lambda Capture State",
                "Observing states inside a lamda triggering recomposition when states updated.",
                toLambdaCaptureState
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Topic(
    topic: String,
    abstract: String,
    toDetail: () -> Unit
) {
    Box(
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Card(
            onClick = toDetail
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    topic,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.size(24.dp))
                Text(
                    abstract,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}