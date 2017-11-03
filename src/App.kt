/**
 * Created by nicholasturner on 10/26/17.
 */
fun main(args: Array<String>) {
    GameModel.resetGame()
    GamePresenter.onDeckTap()
    GameModel.debugPrint()
}