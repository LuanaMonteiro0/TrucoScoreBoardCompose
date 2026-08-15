package br.edu.ifsp.scl.sc3029972.trucoscoreboardcompose

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current

    var pontuacaoEquipeA by remember { mutableIntStateOf(0) }
    var pontuacaoEquipeB by remember { mutableIntStateOf(0) }


    LaunchedEffect(pontuacaoEquipeA) {
        if(pontuacaoEquipeA == 11){
            Toast.makeText(context,"Equipe A está na mão de 11", Toast.LENGTH_LONG).show()
        }
    }

    LaunchedEffect(pontuacaoEquipeB) {
        if(pontuacaoEquipeB == 11){
            Toast.makeText(context,"Equipe B está na mão de 11", Toast.LENGTH_LONG).show()
        }
    }


    Column(modifier = modifierParametro.fillMaxSize()) {
        Row(
            modifier = Modifier.weight(4f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
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
                    text = pontuacaoEquipeA.toString(),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 100.sp
                )

                Text(
                    text = "Pontos",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Left
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    onClick = {pontuacaoEquipeA++}
                ) {
                    Text(
                        text = "+ 1",
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    onClick = {pontuacaoEquipeA+=3},
                    enabled = pontuacaoEquipeA < 11
                ) {
                    Text(
                        text = "+ 3",
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                }
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
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Equipe B",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Right,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 20.sp
                )

                Text(
                    text = pontuacaoEquipeB.toString(),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 100.sp
                )

                Text(
                    text = "Pontos",
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Left
                )


                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    onClick = {pontuacaoEquipeB++}
                ) {
                    Text(
                        text = "+ 1",
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    onClick = {pontuacaoEquipeB+=3},
                    enabled = pontuacaoEquipeB < 11
                ) {
                    Text(
                        text = "+ 3",
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                }

            }
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            color = Color.Gray,
            thickness = 1.dp
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(15.dp),
            onClick = {
                pontuacaoEquipeB = 0
                pontuacaoEquipeA = 0
            }
        ) {
            Text(
                text = "Limpar",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp
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

