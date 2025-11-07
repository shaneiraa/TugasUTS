package com.example.tugasuts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val editUsername = findViewById<EditText>(R.id.editUsername)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editFirstName = findViewById<EditText>(R.id.editFirstName)
        val editLastName = findViewById<EditText>(R.id.editLastName)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        btnSubmit.setOnClickListener {
            // Validasi semua field tidak boleh kosong
            if (isAllFieldsFilled(editUsername, editEmail, editFirstName, editLastName, editPassword)) {
                // Semua field terisi
                val username = editUsername.text.toString()
                val email = editEmail.text.toString()
                val firstName = editFirstName.text.toString()
                val lastName = editLastName.text.toString()

                // Tampilkan pesan sukses
                val successMessage = "User $firstName $lastName (Username: $username) berhasil didaftarkan"
                Toast.makeText(this, successMessage, Toast.LENGTH_LONG).show()
            } else i
        }

        }
    }


    private fun isAllFieldsFilled(
        editUsername: EditText,
        editEmail: EditText,
        editFirstName: EditText,
        editLastName: EditText,
        editPassword: EditText
    ): Boolean {
        return editUsername.text.toString().isNotEmpty() &&
                editEmail.text.toString().isNotEmpty() &&
                editFirstName.text.toString().isNotEmpty() &&
                editLastName.text.toString().isNotEmpty() &&
                editPassword.text.toString().isNotEmpty()
    }
