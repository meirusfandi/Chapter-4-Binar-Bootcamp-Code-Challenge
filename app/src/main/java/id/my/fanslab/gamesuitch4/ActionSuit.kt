package id.my.fanslab.gamesuitch4

import id.my.fanslab.gamesuitch4.data.DataModel
import id.my.fanslab.gamesuitch4.data.DataSources

abstract class ActionSuit(val dataModel: DataModel): Suit {

    abstract fun win(): DataModel
    abstract fun lose(): DataModel

    override fun action(suitName: String): String {
        val suitCom = DataSources.convertStringToData(suitName)

        val isWin = win() == suitCom
        val isLose = lose() == suitCom
        val isDraw = dataModel == suitCom

        return when {
            isWin -> "Player 1 win!"
            isLose -> "Computer Win!"
            isDraw -> "DRAW"
            else -> "Invalid!"
        }
    }
}