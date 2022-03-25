package id.my.fanslab.gamesuitch4.action

import id.my.fanslab.gamesuitch4.ActionSuit
import id.my.fanslab.gamesuitch4.data.DataModel
import id.my.fanslab.gamesuitch4.data.DataSources

class KertasAction: ActionSuit(DataSources.kertasData) {
    override fun win(): DataModel {
        val win = DataSources.kertasData.win
        return DataSources.convertStringToData(win)
    }

    override fun lose(): DataModel {
        val lose = DataSources.kertasData.lose
        return DataSources.convertStringToData(lose)
    }
}