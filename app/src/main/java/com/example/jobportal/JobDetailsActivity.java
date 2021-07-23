package com.example.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JobDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private TextView mTitle;
    private TextView mDate;
    private TextView mDescription;
    private TextView mSkills;
    private TextView mSalary;
    private TextView mLocation;

    private Button apply_btn;

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
        mLocation = findViewById(R.id.job_details_location);

        apply_btn = findViewById(R.id.btn_apply);

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

        apply_btn.setOnClickListener(v -> {
            String message = "Thank you for applying for this position.";
            NotificationCompat.Builder builder = new NotificationCompat.Builder(JobDetailsActivity.this)
                    .setSmallIcon(R.drawable.ic_message)
                    .setContentTitle("Successfully applied")
                    .setContentText(message)
                    .setAutoCancel(true);

            Intent intent1 = new Intent(JobDetailsActivity.this, NotificationActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent1.putExtra("message", message);

            PendingIntent pendingIntent = PendingIntent.getActivity(JobDetailsActivity.this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, builder.build());
        });

    }
}