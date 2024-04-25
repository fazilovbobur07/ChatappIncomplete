package com.example.chatapp.models

import java.io.Serializable

class User:Serializable {
    var displayname: String? = null
    var Email: String? = null
    var UID: String? = null
    var photoUrl: String? = null

    constructor()
    constructor(displayname: String?, Email: String?, UID: String?, photoUrl: String?) {
        this.displayname = displayname
        this.Email = Email
        this.UID = UID
        this.photoUrl = photoUrl
    }

    override fun toString(): String {
        return "User(displayname=$displayname, Email=$Email, UID=$UID, photoUrl=$photoUrl)"
    }
}

