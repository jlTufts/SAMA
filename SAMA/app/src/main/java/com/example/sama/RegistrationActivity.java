package com.example.sama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sama.Data.UserDao;
import com.example.sama.Data.UserDatabase;
import com.example.sama.Model.User;

public class RegistrationActivity extends AppCompatActivity {
    EditText editTextUserID, editTextUsername, editTextPassword, editTextCnfPassword;
    Button buttonRegister;

    TextView textViewLogin;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUserID = findViewById(R.id.editTextUserID);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextCnfPassword = findViewById(R.id.editTextCnfPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });

        userDao = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUsername.getText().toString().trim();
                String userID = editTextUserID.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();

                if (password.equals(passwordConf)) {
                    User user = new User(userName,password,userID);
                    userDao.insert(user);
                    Intent moveToLogin = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(moveToLogin);

                } else {
                    Toast.makeText(RegistrationActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}