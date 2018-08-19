package app.mcg.prayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TopicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);



        Button t1,t2;
        t1 = findViewById(R.id.topic_1);
        t2 = findViewById(R.id.topic_2);



        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenericClass.topic = 1;
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenericClass.topic = 2;
            }
        });


        Intent i = new Intent(getApplicationContext(),ChapterActivity.class);
        startActivity(i);

    }
}