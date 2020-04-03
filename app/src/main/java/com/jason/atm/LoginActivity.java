package com.jason.atm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
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
        final String password = ed_password.getText().toString();
        FirebaseDatabase.getInstance().getReference("users")
                .child(userId).child("password")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String pw = (String)dataSnapshot.getValue();
                        if(pw.equals(password)) {
                            setResult(RESULT_OK);
                            finish();
                        } else {
                            new AlertDialog.Builder(LoginActivity.this)
                                    .setTitle("登入結果")
                                    .setMessage("登入失敗")
                                    .setPositiveButton("OK", null)
                                    .show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        throw databaseError.toException(); // Don't ignore errors
                    }
                });
        /*if("jack".equals(userId) && "1234".equals(password)) {
            setResult(RESULT_OK);
            finish();
        }*/
    }

    public void quit(View view) {

    }
}
