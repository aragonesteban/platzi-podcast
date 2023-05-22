package com.example.platzipodcasts.presentation.welcome.widgets

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.platzipodcasts.R

private const val LAST_POSITION_CAROUSEL = 2

@Composable
fun WelcomeButtons(
    positionCarousel: Int,
    navigateToHome: () -> Unit,
    onChangePage: () -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
    ) {
        TextButton(
            onClick = { navigateToHome() },
            modifier = Modifier
                .animateContentSize(animationSpec = snap())
                .getModifierForSkipButton(position = positionCarousel)
        ) {
            Text(text = stringResource(id = R.string.btn_skip_welcome_screen))
        }
        Button(
            onClick = {
                if (positionCarousel != LAST_POSITION_CAROUSEL) {
                    onChangePage()
                } else {
                    navigateToHome()
                }
            },
            modifier = Modifier
                .animateContentSize(animationSpec = spring())
                .getModifierForNextButton(position = positionCarousel)
        ) {
            Text(
                text = stringResource(id = getTextForNextButton(positionCarousel))
            )
        }
    }
}

fun getTextForNextButton(position: Int): Int =
    if (position != LAST_POSITION_CAROUSEL) {
        R.string.btn_next_welcome_screen
    } else {
        R.string.btn_continue_welcome_screen
    }

fun Modifier.getModifierForSkipButton(position: Int): Modifier =
    if (position != LAST_POSITION_CAROUSEL)
        this.wrapContentWidth()
    else
        this.size(0.dp)


fun Modifier.getModifierForNextButton(position: Int): Modifier =
    if (position != LAST_POSITION_CAROUSEL)
        this.wrapContentWidth()
    else
        this.fillMaxWidth()
