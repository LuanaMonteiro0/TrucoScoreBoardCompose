package br.edu.ifsp.scl.sc3029972.trucoscoreboardcompose

import android.content.Context
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
import androidx.compose.material3.AlertDialog
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

    BuildToastElevenHand(
        ctx = context,
        pontuacao = pontuacaoEquipeA,
        equipe = "A"
    )

    BuildToastElevenHand(
        ctx = context,
        pontuacao = pontuacaoEquipeB,
        equipe = "B"
    )

    if(pontuacaoEquipeA > 11){
        BuildWinnerAlertDialog(
            equipe = "A",
            OnGameRestart = {
                pontuacaoEquipeA = 0
                pontuacaoEquipeB = 0
            }
        )
    }

    if(pontuacaoEquipeB > 11){
        BuildWinnerAlertDialog(
            equipe = "B",
            OnGameRestart = {
                pontuacaoEquipeA = 0
                pontuacaoEquipeB = 0
            }
        )
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

                BuildMainContentArea(
                    equipe = "Equipe A",
                    pontuacao = pontuacaoEquipeA,
                    onClickPlusOne = {
                        pontuacaoEquipeA++
                    },
                    onClickPlusThree = {
                        pontuacaoEquipeA+=3
                    }
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
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {

                BuildMainContentArea(
                    equipe = "Equipe B",
                    pontuacao = pontuacaoEquipeB,
                    onClickPlusOne = {
                        pontuacaoEquipeB++
                    },
                    onClickPlusThree = {
                        pontuacaoEquipeB+=3
                    }
                )

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

@Composable
fun BuildToastElevenHand(ctx: Context, pontuacao: Int, equipe: String){

    LaunchedEffect(pontuacao) {
        if(pontuacao == 11){
            Toast.makeText(
                ctx,
                "Equipe ${equipe} está na mão de 11",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}


@Composable
fun BuildWinnerAlertDialog(equipe: String, OnGameRestart: () -> Unit){

        AlertDialog(
            onDismissRequest = {
                OnGameRestart()
            },
            title = { Text("Parabéns!") },
            text = { Text("A Equipe ${equipe} ganhou!") },
            confirmButton = {
                Button(onClick = {
                    OnGameRestart()
                }) {
                    Text("Reiniciar")
                }
            }
        )

}


@Composable
fun BuildMainContentArea(equipe: String, pontuacao: Int, onClickPlusOne: () -> Unit, onClickPlusThree: () -> Unit){

    Text(
        text = equipe,
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Right,
        textDecoration = TextDecoration.Underline,
        fontSize = 20.sp
    )

    Text(
        text = pontuacao.toString(),
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
        onClick = {
            onClickPlusOne()
        }
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
        onClick = {
            onClickPlusThree()
                  },
        enabled = pontuacao < 11
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


@Preview(showBackground = true)
@Composable
fun TrucoScoreBoardScreenPreview() {
    TrucoScoreBoardComposeTheme {
        TrucoScoreBoardScreen(modifierParametro = Modifier.fillMaxSize())
    }
}

