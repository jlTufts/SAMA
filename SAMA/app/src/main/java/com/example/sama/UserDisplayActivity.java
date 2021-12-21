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

public class UserDisplayActivity extends AppCompatActivity {
    EditText editTextUserID, editTextUsername,
            editTextPassword, editTextCnfPassword;
    Button buttonExit, buttonSave;

    TextView textViewDisplay;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        editTextUserID = findViewById(R.id.editTextUserID);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextCnfPassword = findViewById(R.id.editTextCnfPassword);
        buttonSave = findViewById(R.id.buttonSave);
        buttonExit = findViewById(R.id.buttonExit);

        textViewDisplay = findViewById(R.id.textViewLogin);
        textViewDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDisplayActivity.this, MainActivity.class));
            }
        });

        userDao = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUsername.getText().toString().trim();
                String userID = editTextUserID.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();

                if (password.equals(passwordConf)) {
                    User user = new User(userName,password,userID);
                    userDao.insert(user);
                    Intent moveToDisplay = new Intent(UserDisplayActivity.this, MainActivity.class);
                    startActivity(moveToDisplay);

                } else {
                    Toast.makeText(UserDisplayActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
