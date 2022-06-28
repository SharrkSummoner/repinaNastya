package com.example.repinanastya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signIn(View view) {
        Intent intent = new Intent(this, SignInActivity.class);
        MainActivity.this.startActivity(intent);
        MainActivity.this.finish();
    }

    public void signUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        MainActivity.this.startActivity(intent);
        MainActivity.this.finish();
    }
}