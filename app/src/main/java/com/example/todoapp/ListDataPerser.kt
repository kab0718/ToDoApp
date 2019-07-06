package com.example.todoapp

import org.jetbrains.anko.db.MapRowParser

//DBで検索した結果の一行分をデータクラスに格納するためのクラス
class ListDataPerser : MapRowParser<ListData> {
    override fun parseRow(columns: Map<String, Any?>): ListData {
        return ListData(columns["task_name"] as String, columns["other"] as String)
    }
}