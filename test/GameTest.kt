import org.junit.Test

/**
 * Created by nicholasturner on 11/1/17.
 */
class GameTest {
    @Test
    fun kingInFirstFoundationPile() {
        //Arrange
        var numGames = 0
        val maxGames = 10000

        //Act
        for (i in 1..maxGames) {
            numGames++
            GameModel.resetGame()
            for (j in 1..100) {
                GamePresenter.onDeckTap()
                GamePresenter.onWasteTap()
                GameModel.tableauPiles.forEachIndexed { index, tableauPile ->
                    GamePresenter.onTableauTap(index, tableauPile.cards.lastIndex)
                }
            }
            if (GameModel.foundationPiles[0].cards.size == 13) {
                break
            }
        }

        //Assert
        GameModel.debugPrint()
        println("# of Games: $numGames")
        assert(numGames < maxGames)
    }
}