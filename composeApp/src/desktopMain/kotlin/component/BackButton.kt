package component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import composeantipattern.composeapp.generated.resources.Res
import composeantipattern.composeapp.generated.resources.arrow_back_24dp_5F6368_FILL1_wght700_GRAD0_opsz24
import org.jetbrains.compose.resources.painterResource

@Composable
fun BackButton(
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
    ) {
        Icon(
            painter = painterResource(Res.drawable.arrow_back_24dp_5F6368_FILL1_wght700_GRAD0_opsz24),
            contentDescription = "Back"
        )
    }
}