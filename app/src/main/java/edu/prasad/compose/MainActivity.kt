package edu.prasad.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import edu.prasad.compose.ui.theme.ComposeTheme
import kotlin.math.min

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }

            }
        }
    }
}

@Composable
fun Greeting() {

    Column {
        Text(text = "Hello ${onLoadChnage()}---!")
        Canvas(modifier = Modifier.fillMaxSize()) {
            val radius = min(size.width,size.height) / 2.0f
            val padding = 20
            drawCircle(color = Color.Black, radius = radius - padding, style = Stroke(width = 5.0f))
            val path = Path().apply {
                moveTo(padding.toFloat(),center.y)
                lineTo(x=size.width - padding,y=center.y)
            }
            drawPath(
                path = path,
                color = Color.Red,
                style = Stroke(width = 5.0f)
            )
        }

    }
}

@Composable
fun onLoadChnage():String{
    return "true"
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        Greeting()
    }
}

@Composable
fun NameInput() {
    val textValue = remember{ mutableStateOf("")}
    textValue.value = "Hello"
}

@Composable
fun BeautifulImage() {
    Image(
        painter =
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "My app icon",
        contentScale = ContentScale.Fit
    )
}

