package com.example.sqlitehomework.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlitehomework.MyDataBase
import com.example.sqlitehomework.R
import com.example.sqlitehomework.adapter.ContactAdapter
import com.example.sqlitehomework.databinding.ActivityAllContactsBinding
import com.example.sqlitehomework.model.Contact
import com.example.sqlitehomework.util.snack

class AllContactsActivity : AppCompatActivity() {

    private lateinit var myDataBase: MyDataBase
    private lateinit var adapter: ContactAdapter
    private val binding by lazy { ActivityAllContactsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title =  this.resources.getString(R.string.b)

        val myDataBase = MyDataBase(this)
        val contactAdapter = ContactAdapter()
        contactAdapter.contactList = myDataBase.getAllContacts() as MutableList<Contact>

        binding.recyclerView.adapter = contactAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this@AllContactsActivity)

        contactAdapter.onDeleteClick = {contact, pos ->
            AlertDialog.Builder(this).apply {
                setTitle("Delete")
                setMessage("Do you want to delete this contact?")
                setNegativeButton("No", null)
                setPositiveButton("Yes") {_, _ ->
                    snack(binding.root, "Successfully deleted!")
                    contactAdapter.notifyItemRemoved(pos)
                    contactAdapter.contactList.removeAt(pos)
                    myDataBase.deleteContact(contact)
                }
            }.create().show()
        }

    }


}
