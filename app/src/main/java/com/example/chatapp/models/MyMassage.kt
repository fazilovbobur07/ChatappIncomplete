package com.example.chatapp.models

import java.text.SimpleDateFormat
import java.util.Date

class MyMassage {
    var id:String? = null
    var fromUID:String? = null
    var toUID:String? = null
    var text:String? = null
    var data:String? = null

    constructor()
    constructor(id: String?, fromUID: String?, toUID: String?, text: String?) {
        this.id = id
        this.fromUID = fromUID
        this.toUID = toUID
        this.text = text
        this.data = SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(Date())
    }

    override fun toString(): String {
        return "MyMassage(id=$id, fromUID=$fromUID, toUID=$toUID, text=$text, data=$data)"
    }
}