package com.example.lmisjetpack.ui.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lmisjetpack.R
import com.example.lmisjetpack.ui.theme.LmisJetpackTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Splash(onTimeout: () -> Unit) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val offsetLeft = remember { Animatable(-300f) }
    val offsetRight = remember { Animatable(300f) }

    LaunchedEffect(Unit) {
        launch {
            offsetLeft.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
            )
        }
        launch {
            offsetRight.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
            )
        }

        delay(1500)
        onTimeout()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.splashbg),
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .padding(
                    top = screenHeight * 0.10f,
                    start = screenWidth * 0.05f,
                    end = screenWidth * 0.05f
                )
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(screenHeight * 0.10f))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.phc),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(x = offsetLeft.value.dp)
                        .size(80.dp)
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "Ministry of Health\nand Family Welfare",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(screenHeight * 0.10f))
            Image(
                painter = painterResource(R.drawable.splash),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .offset(x = offsetRight.value.dp)
                    .padding(horizontal = screenWidth * 0.10f)
            )

            Spacer(modifier = Modifier.height(screenHeight * 0.10f))

            Text(
                text = "National Institute of \nHealth & Family Welfare",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    LmisJetpackTheme {
        Splash(onTimeout = {})
    }
}