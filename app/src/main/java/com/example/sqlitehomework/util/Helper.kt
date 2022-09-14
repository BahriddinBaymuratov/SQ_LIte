package com.example.sqlitehomework.util

import com.example.sqlitehomework.model.Contact

interface Helper {

    fun addContact(contact: Contact)
    fun getAllContacts(): List<Contact>
    fun deleteContact(contact: Contact)
    fun updateContact(contact: Contact)
    fun getContactById(id: Int): Contact
    fun deleteAllContacts()
}