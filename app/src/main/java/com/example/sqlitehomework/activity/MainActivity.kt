package com.example.sqlitehomework.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlitehomework.R
import com.example.sqlitehomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title = this.resources.getString(R.string.c)

        binding.btnAddContact.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        }
        binding.btnList.setOnClickListener {
            startActivity(
                Intent(this@MainActivity, AllContactsActivity::class.java)
            )
        }
    }
}