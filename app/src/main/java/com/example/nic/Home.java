package com.example.nic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    private Button admin,user;
    public static String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        admin = findViewById(R.id.admin);
        user = findViewById(R.id.user);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    key = "insert";
                    startActivity(new Intent(Home.this,Admin_Home.class));
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    key = "fetch";
                    startActivity(new Intent(Home.this,User_Home.class));
            }
        });

    }
}
