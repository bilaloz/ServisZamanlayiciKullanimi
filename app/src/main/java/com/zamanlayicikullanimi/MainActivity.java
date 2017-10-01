package com.zamanlayicikullanimi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText edt ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = (EditText) findViewById(R.id.edt);
        findViewById(R.id.baslat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("deger");

                myRef.setValue(edt.getText().toString());
                int a = Integer.parseInt(edt.getText().toString());
                startService( new Intent(MainActivity.this,ServicesActivity.class));
            }
        });
        findViewById(R.id.bitir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopService( new Intent(MainActivity.this,ServicesActivity.class));
            }
        });
    }
}
