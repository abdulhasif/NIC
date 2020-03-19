package com.example.nic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class User_Home extends AppCompatActivity {
    public static TextView caseNumber,caseDetails,status,hearingData;
    private EditText caseNo;
    private Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home);

        caseNumber = findViewById(R.id.caseNumber);
        caseDetails = findViewById(R.id.caseDetails);
        status = findViewById(R.id.status);
        hearingData = findViewById(R.id.hearingData);

        caseNo = findViewById(R.id.CaseNo);

        search = findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestHandler handler = new RequestHandler();
                handler.execute(caseNo.getText().toString());
            }
        });
    }
}
