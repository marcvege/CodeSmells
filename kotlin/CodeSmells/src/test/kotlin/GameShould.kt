import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class GameShould : FreeSpec({
    lateinit var game: Game

    beforeEach {
        game = Game()
    }

    "not allow player O to play first" {
        val exception = shouldThrow<Exception> {
            game.play('O', 0, 0)
        }
        exception.message shouldBe "Invalid first player"
    }

    "not allow player X to play twice in a row" {
        val exception = shouldThrow<Exception> {
            game.play('X', 0, 0)
            game.play('X', 0, 1)
        }
        exception.message shouldBe "Invalid next player"
    }

    "not allow player to play in last played position" {
        val exception = shouldThrow<Exception> {
            game.play('X', 0, 0)
            game.play('O', 0, 0)
        }
        exception.message shouldBe "Invalid position"
    }

    "not allow player to play in any played position" {
        val exception = shouldThrow<Exception> {
            game.play('X', 0, 0)
            game.play('O', 1, 0)
            game.play('X', 0, 0)
        }
        exception.message shouldBe "Invalid position"
    }

    "declare player X as winner if three in top row"{
        game.play('X', 0, 0)
        game.play('O', 1, 0)
        game.play('X', 0, 1)
        game.play('O', 1, 1)
        game.play('X', 0, 2)

        val winner: Char = game.winner()

        winner shouldBe 'X'
    }

    "declare player O as winner if three in top row"{
        game.play('X', 2, 2)
        game.play('O', 0, 0)
        game.play('X', 1, 0)
        game.play('O', 0, 1)
        game.play('X', 1, 1)
        game.play('O', 0, 2)

        val winner: Char = game.winner()

        winner shouldBe 'O'
    }

    "declare player X as winner if three in middle row"{
        game.play('X', 1, 0)
        game.play('O', 0, 0)
        game.play('X', 1, 1)
        game.play('O', 0, 1)
        game.play('X', 1, 2)

        val winner: Char = game.winner()

        winner shouldBe 'X'
    }

    "declare player o as winner ig three in middle row"{
        game.play('X', 0, 0)
        game.play('O', 1, 0)
        game.play('X', 2, 0)
        game.play('O', 1, 1)
        game.play('X', 2, 1)
        game.play('O', 1, 2)

        val winner: Char = game.winner()

        winner shouldBe 'O'
    }

    "declare player X as winner ig three in bottom row"{
        game.play('X', 2, 0)
        game.play('O', 0, 0)
        game.play('X', 2, 1)
        game.play('O', 0, 1)
        game.play('X', 2, 2)

        val winner: Char = game.winner()

        winner shouldBe 'X'
    }

    "declare player o as winnter it three in bottom row"{
        game.play('X', 0, 0)
        game.play('O', 2, 0)
        game.play('X', 1, 0)
        game.play('O', 2, 1)
        game.play('X', 1, 1)
        game.play('O', 2, 2)

        val winner: Char = game.winner()

        winner shouldBe 'O'
    }
})