package com.example.nursingsymposium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConferenceSchedulerActivity extends AppCompatActivity {

    Button speaker_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conference_scheduler);
        speaker_click=findViewById(R.id.speaker_click);

        speaker_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ConferenceSchedulerActivity.this,SpeakerActivity.class);
                startActivity(intent);
            }
        });
    }
}