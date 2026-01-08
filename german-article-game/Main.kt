/*
* DER, DIE or DAS?
* Learn German definite articles.
*/

import kotlin.random.Random

fun main() {
    game(10)
}

fun game(maxNumOfRounds: Int = 7) {
    val nouns = mutableListOf(
        Noun("Zeitung", Article.F),
        Noun("Lehrerin", Article.F), Noun("Tischlein", Article.N),
        Noun("Tourismus", Article.M), Noun("Reinigung", Article.F),
        Noun("Kollegin", Article.F), Noun("Freiheit", Article.F)
    )
    var score = 0
    var round = 0
    loop@ while (round < maxNumOfRounds) {
        println("Der, die or das? Enter the correct article:")
        val index = Random.nextInt(0, nouns.size)
        println("___ ${nouns[index].word}")
        var input = readln().trim()
        while (input.lowercase() != nouns[index].article.value.lowercase()) {
            round++
            if (round == maxNumOfRounds) {
                println()
                break@loop
            }
            println("Try again!")
            input = readln().trim()
        }
        if (input.lowercase() == nouns[index].article.value.lowercase()) {
            println("${nouns[index].article.value} ${nouns[index].word}. Correct!\n")
            score++
            round++
            nouns.removeAt(index)
            if (nouns.isEmpty()) break
        }
    }
    println("Game over. Your score is $score/$round.")
}

enum class Article(val value: String) {
    M("Der"), // Masculine
    F("Die"), // Feminine
    N("Das") // Neuter
}

class Noun(val word: String, val article: Article)