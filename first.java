package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class first extends AppCompatActivity {
    public static final String PARAM_PORTFOLIO = "param_portfolio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void submitData(View view) {
        EditText etName = findViewById(R.id.name);
        EditText etPos = findViewById(R.id.pos);
        EditText etUni = findViewById(R.id.editTextTextPersonName);
        EditText etDegree = findViewById(R.id.editTextTextPersonName2);
        EditText etYear = findViewById(R.id.editTextTextPersonName3);
        EditText etOrgName = findViewById(R.id.editTextTextPersonName4);
        EditText etCourseName = findViewById(R.id.editTextTextPersonName5);
        EditText etEnterYear = findViewById(R.id.editTextNumber);
        EditText etEmail = findViewById(R.id.editTextTextEmailAddress);
        if (etName.getText().toString().isEmpty() || etName.getText().toString() == null) {
            etName.setError("Valid Name Mandatory");
            etName.requestFocus();
        }
        if (etPos.getText().toString().isEmpty() || etPos.getText().toString() == null) {
            etPos.setError("Valid Position Mandatory");
            etPos.requestFocus();
        }
        if (etUni.getText().toString().isEmpty() || etUni.getText().toString() == null) {
            etUni.setError("Valid University Name Mandatory");
            etUni.requestFocus();
        }
        if (etDegree.getText().toString().isEmpty() || etDegree.getText().toString() == null) {
            etDegree.setError("Enter Valid Degree ");
            etDegree.requestFocus();
        }
        if (etYear.getText().toString().isEmpty() || etYear.getText().toString() == null) {
            etYear.setError("InValid Year");
            etYear.requestFocus();
        }
        if (etOrgName.getText().toString().isEmpty() || etOrgName.getText().toString() == null) {
            etOrgName.setError("InValid Organization Name ");
            etOrgName.requestFocus();
        }
        if (etCourseName.getText().toString().isEmpty() || etCourseName.getText().toString() == null) {
            etCourseName.setError("Course Name Mandatory");
            etCourseName.requestFocus();
        }
        if (etEnterYear.getText().toString().isEmpty() || etEnterYear.getText().toString() == null) {
            etEnterYear.setError("Enter Valid Year ");
            etEnterYear.requestFocus();
        }
        if (etEmail.getText().toString().isEmpty() || etEmail.getText().toString() == null) {
            etEmail.setError("Enter Valid MAIL ID ");
            etEmail.requestFocus();
        }
        Education education = new Education(etUni.getText().toString(), etDegree.getText().toString(), etYear.getText().toString());
        Course course = new Course(etOrgName.getText().toString(), etCourseName.getText().toString(), etEnterYear.getText().toString());
        PortFolio portfolio = new PortFolio(etName.getText().toString(), etPos.getText().toString(), education, course, etEmail.getText().toString());
        Intent intent = new Intent();
        intent.putExtra(PARAM_PORTFOLIO, portfolio);
        setResult(RESULT_OK, intent);
        finish();
    }
}