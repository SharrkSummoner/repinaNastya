package com.example.repinanastya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText name;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
    }

    public void signUp(View view) {
        if (email.getText().toString().isEmpty() ||
                password.getText().toString().isEmpty() ||
                name.getText().toString().isEmpty() ||
                phone.getText().toString().isEmpty()) {
            createDialog(this, "Не все поля заполнены");
        } else if (!checkEmail(email.getText().toString())) {
            createDialog(this, "Некорректно введенна почта");
        } else trySignUp();
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void createDialog(Activity activity, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder
                .setTitle("Ошибка")
                .setMessage(msg)
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        builder.create().show();
    }

    private boolean checkEmail(String mail) {
        return mail.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,3})$");
    }

    public void trySignUp() {
        String mail = email.getText().toString();
        String pass = email.getText().toString();

        String url = "https://food.madskill.ru/auth/register";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST, url,
                response -> {
                    Intent intent = new Intent(this, MainMenuActivity.class);
                    SignUpActivity.this.startActivity(intent);
                    SignUpActivity.this.finish();
                },
                error -> createDialog(this, "Регистрация не удалась")
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("email", mail);
                params.put("password", pass);
                params.put("login", mail);
                return params;
            }
        };

        requestQueue.add(request);
    }
}