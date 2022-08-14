package com.example.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SaveActivity extends AppCompatActivity {
    TextView sname,sdob,sgender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_activity);

        sname=findViewById(R.id.sname);
        sdob=findViewById(R.id.sdob);
        sgender=findViewById(R.id.sgender);

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("NAME");
        String dateOfBirth = bundle.getString("DOB");
        String gender = bundle.getString("GENDER");


//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText(venName);




        sname.setText("Name: "+ name);
        sdob.setText("Selected Date: "+ dateOfBirth);
        sgender.setText("Gender Is: "+ gender);


//        sname=findViewById(R.id.name);
//
//
//
//        String itemText = (String) spin.getSelectedItem();
//
//        String name=sname.toString();
//        String dobirth=eText.toString();
//
//
//        Intent i = new Intent(getApplicationContext(),SaveActivity.class);
//        i.putExtra("NAME",name);
//        i.putExtra("DOB",dobirth);
//        i.putExtra("GENDER",itemText);
//        startActivity(i);



    }}


