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
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        textViewRegister = findViewById(R.id.textViewRegister);

        dataBase = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();


        textViewRegister.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RegistrationActivity.class)));

        buttonLogin.setOnClickListener(this::onClick);

    }

    private void onClick(View v) {
        String name = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        User user = db.getUser(name, password);
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
