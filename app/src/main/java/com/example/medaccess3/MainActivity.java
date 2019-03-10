package com.example.medaccess3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView tv;

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
                // TextView tv1 = (TextView)findViewById(R.id.textView1);

                tv.setText("My Test");
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
