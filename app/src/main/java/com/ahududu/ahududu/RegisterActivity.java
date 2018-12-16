package com.ahududu.ahududu;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        connectToUI();
        setStatusBarColor(R.color.statusBarColor);

    }

    public void connectToUI () {
        btnBack = findViewById(R.id.btnRegBack);
        btnBack.setOnClickListener(this);
    }

    public void setStatusBarColor(int statusBarColor){
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(),statusBarColor));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRegBack){
            onBackPressed();
        }
    }
}
