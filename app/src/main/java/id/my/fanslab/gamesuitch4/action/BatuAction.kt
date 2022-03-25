package id.my.fanslab.gamesuitch4.action

import id.my.fanslab.gamesuitch4.ActionSuit
import id.my.fanslab.gamesuitch4.data.DataModel
import id.my.fanslab.gamesuitch4.data.DataSources

class BatuAction: ActionSuit(DataSources.batuData) {
    override fun win(): DataModel {
        val win = DataSources.batuData.win
        return DataSources.convertStringToData(win)
    }

    override fun lose(): DataModel {
        val lose = DataSources.batuData.lose
        return DataSources.convertStringToData(lose)
    }
}