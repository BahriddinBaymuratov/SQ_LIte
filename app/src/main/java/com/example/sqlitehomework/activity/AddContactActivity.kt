package com.example.sqlitehomework.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlitehomework.MyDataBase
import com.example.sqlitehomework.R
import com.example.sqlitehomework.databinding.ActivityAddContactBinding
import com.example.sqlitehomework.model.Contact

class AddContactActivity : AppCompatActivity() {
    private lateinit var myDataBase: MyDataBase
    private val binding by lazy { ActivityAddContactBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title =  this.resources.getString(R.string.a)

        myDataBase = MyDataBase(this)

        binding.btnAdd.setOnClickListener {
            val name = binding.addTextName.text.toString().trim()
            val number = binding.addTextNumber.text.toString().trim()
            if(name.isBlank() && number.isBlank()){
                Toast.makeText(this, "Enter data!!", Toast.LENGTH_SHORT).show()
            }else{
                myDataBase.addContact(Contact(name,number))
                Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show()
            }
        }
    }
}