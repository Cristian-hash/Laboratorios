package com.idnp2024a.loginsample;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.idnp2024a.loginsample.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        EditText edtUsername = binding.edtUsername;
        EditText edtPassword = binding.edtPassword;
        Button btnLogin = binding.btnLogin;
        Button btnAddAccount = binding.btnAddAccount;


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Dentro del OnClickListener del botón de login
                if(edtUsername.getText().toString().equals("admin") && edtPassword.getText().toString().equals("admin")) {
                    // Si la autenticación es exitosa, crear un Intent para ir a HomeActivity
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

                    // Agregar el valor del campo de usuario como extra en el Intent
                    intent.putExtra("username", edtUsername.getText().toString());

                    // Iniciar HomeActivity
                    startActivity(intent);
                    finish(); // Terminar LoginActivity para que el usuario no pueda volver atrás
                } else {
                    // Si la autenticación falla, mostrar mensaje de error
                    Toast.makeText(getApplicationContext(), "Error en la Autenticacion", Toast.LENGTH_SHORT).show();
                    Log.d(TAG,"Error en la Autenticacion");
                }
            }
        });

        btnAddAccount.setOnClickListener(V->{
            Intent intent = new Intent(getApplicationContext(),AccountActivity.class);
            startActivity(intent);
        });
    }
}