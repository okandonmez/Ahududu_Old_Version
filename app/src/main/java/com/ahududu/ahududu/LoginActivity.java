package com.ahududu.ahududu;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnGoReg;
    EditText edtPass, edtUser;
    ImageView imgGoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setStatusBarColor(R.color.statusBarColor);
        connectToUI();

        btnGoReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        imgGoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int usernameLength = edtUser.getText().length();
                int passwordLength = edtPass.getText().length();

                if (usernameLength == 0 || passwordLength == 0) {
                    if (usernameLength == 0)
                        edtUser.setError("Kullanıcı adı boş bırakılamaz.");
                    if (passwordLength == 0)
                        edtPass.setError("Şifre boş bırakılamaz.");
                }
                else{
                    loginRequest();
                }

            }
        });

    }

    public void connectToUI(){
        edtPass = findViewById(R.id.edtPasswordLogin);
        edtUser = findViewById(R.id.edtUsernameLogin);

        edtUser.setText("demo");
        edtPass.setText("demo");

        imgGoLogin = findViewById(R.id.imgLogin);
        btnGoReg = findViewById(R.id.btnGoReg);
    }

    public void loginRequest(){
        String username = edtUser.getText().toString();
        String password = edtPass.getText().toString();
        if (username.contains("demo") && password.contains("demo") ){
            Intent intent = new Intent(getApplicationContext(),MainPage.class);
            startActivity(intent);
            LoginActivity.this.finish();
        }
        else{
            showAlertDialog("Kullanıcı adı veya Şifre Hatalı", "Hata");
        }
    }

    public void setStatusBarColor(int statusBarColor){
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),statusBarColor));
    }

    public void showAlertDialog(String message, String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);

        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
