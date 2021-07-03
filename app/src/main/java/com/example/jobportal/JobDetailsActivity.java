package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JobDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private TextView mTitle;
    private TextView mDate;
    private TextView mDescription;
    private TextView mSkills;
    private TextView mSalary;
    private TextView mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

        toolbar = findViewById(R.id.toolbar_job_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Job Details");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitle = findViewById(R.id.job_details_title);
        mDate = findViewById(R.id.job_details_date);
        mDescription = findViewById(R.id.job_details_description);
        mSkills = findViewById(R.id.job_details_skills);
        mSalary = findViewById(R.id.job_details_salary);
        mLocation=findViewById(R.id.job_details_location);

        //Receive Data from all job activity using intent..
        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String date = intent.getStringExtra("date");
        String description = intent.getStringExtra("description");
        String skills = intent.getStringExtra("skills");
        String salary = intent.getStringExtra("salary");
        String location = intent.getStringExtra("location");

        mTitle.setText(title);
        mDate.setText(date);
        mDescription.setText(description);
        mSkills.setText(skills);
        mSalary.setText(salary);
        mLocation.setText(location);

    }
}