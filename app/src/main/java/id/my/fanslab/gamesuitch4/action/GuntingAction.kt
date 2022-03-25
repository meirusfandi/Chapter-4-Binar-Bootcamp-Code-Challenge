package id.my.fanslab.gamesuitch4.action

import id.my.fanslab.gamesuitch4.ActionSuit
import id.my.fanslab.gamesuitch4.data.DataModel
import id.my.fanslab.gamesuitch4.data.DataSources

class GuntingAction: ActionSuit(DataSources.guntingData) {
    override fun win(): DataModel {
        val win = DataSources.guntingData.win
        return DataSources.convertStringToData(win)
    }

    override fun lose(): DataModel {
        val lose = DataSources.guntingData.lose
        return DataSources.convertStringToData(lose)
    }
}