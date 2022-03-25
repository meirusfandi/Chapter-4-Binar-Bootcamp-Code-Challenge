package id.my.fanslab.gamesuitch4.action

import id.my.fanslab.gamesuitch4.ActionSuit
import id.my.fanslab.gamesuitch4.data.DataModel
import id.my.fanslab.gamesuitch4.data.DataSources

class InvalidAction: ActionSuit(DataSources.invalidData) {
    override fun win(): DataModel {
        return DataSources.invalidData
    }

    override fun lose(): DataModel {
        return DataSources.invalidData
    }
}