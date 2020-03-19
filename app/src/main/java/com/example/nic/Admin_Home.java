package com.example.nic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin_Home extends AppCompatActivity {
    private EditText caseNo,caseDetails,hearingDate,status;
    private Button submit;
    public static Context adminHome;
    public static Context adminClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__home);

        caseNo = findViewById(R.id.CaseNo);
        caseDetails = findViewById(R.id.CaseDetails);
        hearingDate = findViewById(R.id.HearingDate);
        status = findViewById(R.id.Status);

        submit = findViewById(R.id.submit);

        adminHome = getApplicationContext();
        adminClose = Admin_Home.this;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 RequestHandler request = new RequestHandler();
                 request.execute(caseNo.getText().toString(),caseDetails.getText().toString(),hearingDate.getText().toString(),status.getText().toString());
            }
        });

    }
}
