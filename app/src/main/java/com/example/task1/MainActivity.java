package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinnerGender;
    String[] gender = { "Select","Male", "Female" ,"Others"};

    DatePickerDialog picker;
    EditText dateOfBirth,sname;
    Button sendBtn;
    boolean isAllFieldsChecked = false;
Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        spinnerGender = (Spinner) findViewById(R.id.spinner);
        spinnerGender.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(aa);


        dateOfBirth=(EditText) findViewById(R.id.dob);
        dateOfBirth.setInputType(InputType.TYPE_NULL);
        dateOfBirth.setOnClickListener(this);

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateOfBirth.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        sendBtn=findViewById(R.id.save);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname=findViewById(R.id.name);

                String itemText = (String) spinnerGender.getSelectedItem();

       String name=sname.getText().toString();
       String dobirth=dateOfBirth.getText().toString();

                isAllFieldsChecked = CheckAllFields();


                if (isAllFieldsChecked) {
                    Intent i = new Intent(context,SaveActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("NAME",name);
                    bundle.putString("DOB",dobirth);
                    bundle.putString("GENDER",itemText);
                    i.putExtras(bundle);
                    startActivity(i);
                }

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

    }
    private boolean CheckAllFields() {
        if (sname.length() == 0) {
            sname.setError("This field is required");
            return false;
        }

        if (dateOfBirth.length() == 0) {
            dateOfBirth.setError("This field is required");
            return false;
        }


        return true;
    }
}