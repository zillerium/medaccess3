package com.example.medaccess3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView tv;
    public static TextView txtDate;
    public static TextView txtType;
    public static TextView txtDosage;
    public static TextView txtTreatment;
    public static TextView txtDescription;
    public static TextView txtPrescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int j=3;
        final Button button = findViewById(R.id.mainButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                int x=8;
                int h=9;
                 tv = (TextView)findViewById(R.id.myTextView);
                //
                // TextView tv1 = (TextView)findViewById(R.id.textView1);

                txtDate = (TextView)findViewById(R.id.txtDate);
                txtType = (TextView)findViewById(R.id.txtType);
                txtDosage = (TextView)findViewById(R.id.txtDosage);
                txtTreatment = (TextView)findViewById(R.id.txtTreatment);
                txtDescription = (TextView)findViewById(R.id.txtDescription);
                txtPrescription = (TextView)findViewById(R.id.txtPrescription);


                tv.setText("Showing Prescription");
                int tokenId = 123;

                PrescriptionData processAPI = new PrescriptionData();
                processAPI.execute(new Integer(tokenId));


            }
        });

        //etTokenId =findViewById(R.id.etTokenId);
       // mainButton=findViewById(R.id.mainButton);

    }
    public void sendMessage(View view) {
        TextView tv = (TextView)findViewById(R.id.myTextView);
       // TextView tv1 = (TextView)findViewById(R.id.textView1);
        tv.setText("My Test");

        int x=8;
        int h=9;

    }
}
