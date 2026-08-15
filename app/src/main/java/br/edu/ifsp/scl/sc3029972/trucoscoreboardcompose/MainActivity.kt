package br.edu.ifsp.scl.sc3029972.trucoscoreboardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3029972.trucoscoreboardcompose.ui.theme.TrucoScoreBoardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrucoScoreBoardComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TrucoScoreBoardScreen(
                        modifierParametro = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TrucoScoreBoardScreen( modifierParametro: Modifier = Modifier) {
    Row(
        modifier = modifierParametro.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            Text(
                text = "Equipe A",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Right,
                textDecoration = TextDecoration.Underline,
                fontSize = 20.sp
            )

            Text(
                text = "0" ,
                modifier = Modifier
                        .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 90.sp
            )

            Text(
                text = "Pontos",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Left
            )

        }

        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 4.dp),
            color = Color.Gray,
            thickness = 1.dp
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            Text(
                text = "Equipe B",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Right,
                textDecoration = TextDecoration.Underline
            )

            Text(
                text = "0" ,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 90.sp
            )

            Text(
                text = "Pontos",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Left
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrucoScoreBoardScreenPreview() {
    TrucoScoreBoardComposeTheme {
        TrucoScoreBoardScreen(modifierParametro = Modifier.fillMaxSize())
    }
}

