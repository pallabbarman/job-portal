package com.example.jobportal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailReg;
    private EditText passReg;

    private Button btnReg;
    private Button btnLogin;


    //Firebase Auth
    private FirebaseAuth mAuth;

    //progress dialog
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        mDialog = new ProgressDialog(this);

        Registration();
    }

    private void Registration() {

        emailReg = findViewById(R.id.email_registration);
        passReg = findViewById(R.id.registration_password);

        btnReg = findViewById(R.id.btn_registration);
        btnLogin = findViewById(R.id.btn_login);


        btnReg.setOnClickListener(v -> {

            String email = emailReg.getText().toString().trim();
            String pass = passReg.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                emailReg.setError("Required Field..");
                return;
            }

            if (TextUtils.isEmpty(pass)) {
                passReg.setError("Required Field..");
                return;
            }

            mDialog.setMessage("Processing..");
            mDialog.show();

            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {

                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));

                    mDialog.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), "Registration Failed..", Toast.LENGTH_SHORT).show();
                }
            });

        });

        btnLogin.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));

    }
}