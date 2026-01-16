# wordle_midterm
```kotlin
package com.example.midterm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class wordle (private val wordBank: Array<String>) {
    // The word the user is trying to guess
    val wordLive: LiveData<String>   // using LiveData 
        get() = word
    private val word = MutableLiveData("")

    // the past guess
    val guessesLive: LiveData<MutableList<WordleGuess>>
        get() = guesses
    private val guesses = MutableLiveData(mutableListOf<WordleGuess>());

     // filter out the placeholder to keep track ok guess count
    private val nonBlankGuess
        get() = guesses.value?.filter { itt -> itt.chars.any {it.character != null} };

    // current status
    val gameStateLive : LiveData<WordleGameState>
        get() = gameStatus
    private val gameStatus = MutableLiveData<WordleGameState>()

    // error message
    val errorMessageLive : LiveData<String>
        get() = errorMessage
    private val errorMessage = MutableLiveData("")

    fun startNewGame() {
        word.value = wordBank[Random.nextInt(wordBank.size)].uppercase();
        Log.d("Word Guess", word.value.toString());

        guesses.value = arrayListOf(
            WordleGuess.generateBlank(),
            WordleGuess.generateBlank(),
            WordleGuess.generateBlank(),
            WordleGuess.generateBlank(),
            WordleGuess.generateBlank()
        )
        gameStatus.value = WordleGameState.PLAYING;
    }

    fun submitGuesses(guess: String) {
        if (!wordBank.contains(guess.uppercase())) {
            errorMessage.value = "Invalid word, Please try again"
            return
        }

        guesses.value?.forEach{
            val guessWord = it.chars.joinToString(separator = "") {
                itt -> itt.character.toString()
            }
            if(guessWord == guess.uppercase()) {
                errorMessage.value = "You 've already guessed that word"
                return
            }
        }

        val wordleGuess = WordleGuess(arrayListOf())
        guess.uppercase().forEachIndexed {
            index, char ->
            val characterGuess = WordleCharacterGuess (
                character = char,
                isInWord = word.value?.contains(char) ?: false,
                isInCorrectPlace = word.value?.indexOf(char) == index
            )
            wordleGuess.chars.add(characterGuess)
        }

        val oldValues = nonBlankGuess ?: mutableListOf()
        val newGuess = mutableListOf(wordleGuess, *oldValues.toTypedArray())
        repeat(6 - newGuess.size) {
            newGuess.add(WordleGuess.generateBlank())
        }
        guesses.value = newGuess
        checkGameState()
    }

    private fun checkGameState() {
        if (guesses.value?.any{ it.chars.all { itt -> itt.isInCorrectPlace } } == true) {
            gameStatus.value = WordleGameState.WIN
        } else {
            if ((nonBlankGuess?.size ?: 0) > 5) {
                gameStatus.value = WordleGameState.LOSE
            }
        }
    }

    fun clearErrorMessage() {
        errorMessage.value = ""
    }

    enum class WordleGameState {
        PLAYING,
        WIN,
        LOSE
    }
}


data class WordleCharacterGuess (
    val character: Char? = null,
    val isInWord: Boolean = false,
    val isInCorrectPlace: Boolean = false,
)

data class WordleGuess (val chars: ArrayList<WordleCharacterGuess>) {
    companion object{
        fun generateBlank(): WordleGuess {
            return WordleGuess(arrayListOf()).apply {
                repeat(5) {
                    chars.add(WordleCharacterGuess())
                }
            }
        }
    }
}

``