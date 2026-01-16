# midterm
```kotlin
package com.example.midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midterm.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val wordle1 = wordle(wordBank = resources.getStringArray(R.array.words))
        wordle1.startNewGame()

        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val gameState by wordle1.gameStateLive
                        .observeAsState(wordle.WordleGameState.PLAYING)

                    if (gameState == wordle.WordleGameState.PLAYING) {
                        wordleGame(wordle1 = wordle1)
                    } else {
                        GameOverScreen(
                            gameState = gameState,
                            word = wordle1.wordLive.value,
                            startNewGame = wordle1::startNewGame
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GameOverScreen (
    gameState: wordle.WordleGameState,
    word: String?,
    startNewGame: () -> Unit
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        if (gameState == wordle.WordleGameState.WIN) {
            Text(text = "You Won! The word was $word")
        } else {
            Text(text = "You Lose! The word was $word")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = startNewGame) {
            Text(text = "New Game")
        }
    }
}

@Composable
fun wordleGame(wordle1: wordle) {
    var userGuess by rememberSaveable { mutableStateOf("") }
    val pastGuess by wordle1.guessesLive.observeAsState(mutableListOf())
    val errorMessage by wordle1.errorMessageLive.observeAsState("")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = userGuess,
            singleLine = true,
            onValueChange = {
                wordle1.clearErrorMessage()
                if (it.length < 6) {
                    userGuess = it
                }
            },
            label = {Text("Guess")},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                wordle1.submitGuesses(userGuess)
                userGuess = ""
            }),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            )
        )

        Text(
            text = errorMessage,
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption
        )
        LazyColumn(
            modifier = Modifier.padding(
                PaddingValues(
                    top = 16.dp
                )
            )
        ) {
            items(pastGuess) {
                guess -> wordleGuessRow(guess = guess)
            }
        }
    }
}

@Composable
fun wordleGuessRow(guess: WordleGuess) {
    LazyRow {
        items(guess.chars.size) {
            index ->
            val character = guess.chars[index].character
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .aspectRatio(1f),
                backgroundColor = when(true) {
                    (character == null) -> Color.White
                    guess.chars[index].isInCorrectPlace -> Color(34, 139, 34)
                    guess.chars[index].isInWord -> Color(255, 215, 0)
                    else -> Color.Gray
                }
            ) {
                Text (
                    text = character?.toString() ?: "",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .width(24.dp)
                )
            }
        }
    }
}
```