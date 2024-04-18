package cl.emilym.compose.standardbutton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

enum class ButtonType {
    PRIMARY, SECONDARY, TERTIARY
}

@Composable
fun StandardButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.PRIMARY,
    enabled: Boolean = true,
    shape: Shape? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    padding: PaddingValues? = null,
    stroke: BorderStroke? = null,
    elevation: ButtonElevation? = null,
    content: @Composable RowScope.() -> Unit,
) {
    when (type) {
        ButtonType.PRIMARY, ButtonType.SECONDARY -> ComponentButton(
            onClick, modifier,
            if (type == ButtonType.PRIMARY) getStyle().primary else getStyle().secondary,
            enabled, shape, backgroundColor, contentColor, padding, stroke, elevation, content
        )
        ButtonType.TERTIARY -> ComponentTextButton(
            onClick, modifier,
            getStyle().tertiary,
            enabled, shape, backgroundColor, contentColor, padding, stroke, elevation, content
        )
    }
}

@Composable
fun ComponentTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: ButtonStyle? = null,
    enabled: Boolean = true,
    shape: Shape? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    padding: PaddingValues? = null,
    stroke: BorderStroke? = null,
    elevation: ButtonElevation? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val actualStyle = style ?: getStyle().fallback
    val actualPadding = padding ?: actualStyle.padding

    TextButton(
        onClick = onClick,
        shape = shape ?: actualStyle.shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor ?: actualStyle.backgroundColor,
            contentColor = contentColor ?: actualStyle.contentColor
        ),
        enabled = enabled,
        contentPadding = padding ?: actualStyle.padding,
        border = stroke ?: actualStyle.stroke,
        elevation = elevation ?: actualStyle.elevation,
        modifier = Modifier
            .defaultMinSize(minHeight = actualStyle.minimumHeight + (actualPadding.calculateTopPadding() + actualPadding.calculateBottomPadding()))
            .then(modifier)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Row(horizontalArrangement = Arrangement.spacedBy(actualStyle.contentSpacing), verticalAlignment = Alignment.CenterVertically) {
                content()
            }
        }
    }
}

@Composable
fun ComponentButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: ButtonStyle? = null,
    enabled: Boolean = true,
    shape: Shape? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    padding: PaddingValues? = null,
    stroke: BorderStroke? = null,
    elevation: ButtonElevation? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val actualStyle = style ?: getStyle().fallback
    val actualPadding = padding ?: actualStyle.padding

    Button(
        onClick = onClick,
        shape = shape ?: actualStyle.shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor ?: actualStyle.backgroundColor,
            contentColor = contentColor ?: actualStyle.contentColor
        ),
        enabled = enabled,
        contentPadding = padding ?: actualStyle.padding,
        border = stroke ?: actualStyle.stroke,
        elevation = elevation ?: actualStyle.elevation,
        modifier = Modifier
            .defaultMinSize(minHeight = actualStyle.minimumHeight + (actualPadding.calculateTopPadding() + actualPadding.calculateBottomPadding()))
            .then(modifier)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Row(horizontalArrangement = Arrangement.spacedBy(actualStyle.contentSpacing), verticalAlignment = Alignment.CenterVertically) {
                content()
            }
        }
    }
}