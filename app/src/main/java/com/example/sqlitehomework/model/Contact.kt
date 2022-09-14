package com.example.sqlitehomework.model

class Contact {
    var id: Int? = null
    var name: String? = null
    var number: String? = null



    constructor(id: Int?, name: String?, number: String?) {
        this.id = id
        this.name = name
        this.number = number
    }

    constructor(name: String?, number: String?) {
        this.name = name
        this.number = number
    }
    override fun equals(other: Any?): Boolean {
        if (other !is Contact) return false
        return (other.name == this.name && other.number == this.number)
    }

}