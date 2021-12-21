package com.example.sama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import com.example.sama.Data.UserDao;
import com.example.sama.Data.UserDatabase;
import com.example.sama.Model.User;


public class MainActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;
    UserDao db;
    UserDatabase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //instantiate login view
        setContentView(R.layout.activity_login);
        //setup variables
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        //set text view to register
        textViewRegister = findViewById(R.id.textViewRegister);
        //setup database
        dataBase = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();


        textViewRegister.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RegistrationActivity.class)));

        buttonLogin.setOnClickListener(this::onClick);


    }
    public void onRegister(View reg){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    private void onClick(View v) {
        String name = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        User user = db.getUser(name);
        if (user != null) {
            Intent i = new Intent(MainActivity.this, UserDisplayActivity.class);
            i.putExtra("User", user);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(MainActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}
