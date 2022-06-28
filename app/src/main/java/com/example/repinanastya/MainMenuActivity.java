package com.example.repinanastya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void salats(View view) {
        Intent intent = new Intent(this, SalatsActivity.class);
        startActivity(intent);
    }

    public void sops(View view) {
        Intent intent = new Intent(this, SopsActivity.class);
        startActivity(intent);
    }

    public void second(View view) {
        Intent intent = new Intent(this, SecondDishActivity.class);
        startActivity(intent);
    }

    public void drinks(View view) {
        Intent intent = new Intent(this, DrinksAcivity.class);
        startActivity(intent);
    }
}