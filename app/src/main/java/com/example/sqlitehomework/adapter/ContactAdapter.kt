package com.example.sqlitehomework.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlitehomework.databinding.ContactLayoutBinding
import com.example.sqlitehomework.model.Contact

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    lateinit var onDeleteClick: (Contact, pos: Int) -> Unit
    var contactList: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ContactLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    override fun getItemCount(): Int = contactList.size

    inner class ContactViewHolder(private val binding: ContactLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.textName.text = contact.name
            binding.textNumber.text = contact.number
            binding.btnDelete.setOnClickListener {
                onDeleteClick(contact, adapterPosition)
            }
        }
    }
}