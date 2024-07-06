package topic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.ArticleScaffold
import composeantipattern.composeapp.generated.resources.LambdaCaptureStateConsoleLog
import composeantipattern.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun LamdaCaptureState(
    onBack: () -> Unit
) {
    ArticleScaffold(
        onBack = onBack,
        header = { Header() },
        footer = { Footer() }
    ) {
        // fixme: check the log cat to see that whole page is recomposed
        SideEffect { println("Warning: Whole page is recomposed") }

        Text("Click the button bellow:", style = MaterialTheme.typography.h5)

        // fixme: even though this state is not on top of the scope, the whole page will still be recomposed
        var index by remember { mutableStateOf(0) }
        SomeWidget(
            index,
            onClick = {
                // fixme: this event require current state of index to predict next index,
                //  therefore this lambda need to be recreated everytime the index is updated to make the current index's state inside the lamba still relevant.
                //  check the log cat to see the recomposition
                index = index + 1
            }
        )
    }
}

@Composable
fun SomeWidget(
    index: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Current Index: $index")
                Button(
                    onClick = onClick
                ) {
                    Text("Next Index")
                }
            }
        }
    }
}

@Composable
private fun Header() {
    Text(
        """
                If a lamda requires a value of a state, then everytime the state is updated, recomposition will be triggered because the lamda need to receive the new state.
                Check the recomposition inspector and see that in this page, whole page will be recomposed everytime a new value is emitted by the index state.
            """.trimIndent()
    )

    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
private fun Footer() {
    Text("See the log cat:", style = MaterialTheme.typography.h5)
    Spacer(modifier = Modifier.height(16.dp))
    Image(
        painter = painterResource(Res.drawable.LambdaCaptureStateConsoleLog),
        contentDescription = null
    )
    Spacer(modifier = Modifier.height(40.dp))
}

