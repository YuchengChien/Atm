package com.jason.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText ed_userId;
    private EditText ed_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_userId = findViewById(R.id.userId);
        ed_password = findViewById(R.id.passwd);
    }

    public void login(View view) {
        String userId = ed_userId.getText().toString();
        String password = ed_password.getText().toString();
        if("jack".equals(userId) && "1234".equals(password)) {
            setResult(RESULT_OK);
            finish();
        }
    }

    public void quit(View view) {

    }
}
