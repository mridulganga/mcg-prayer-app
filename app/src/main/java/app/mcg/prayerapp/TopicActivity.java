package app.mcg.prayerapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TopicActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);


//        if (GenericClass.dbc==null) GenericClass.dbc = new DatabaseClass(getApplicationContext());


        Button t1,t2,t3,t4,t5;
        t1 = findViewById(R.id.topic_1);
        t2 = findViewById(R.id.topic_2);
        t3 = findViewById(R.id.topic_3);
        t4 = findViewById(R.id.topic_4);
        t5 = findViewById(R.id.topic_5);

        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.topic_1:
                GenericClass.topic = 1;
                break;
            case R.id.topic_2:
                GenericClass.topic = 2;
                break;
            case R.id.topic_3:
                GenericClass.topic = 3;
                break;
            case R.id.topic_4:
                GenericClass.topic = 4;
                break;
            case R.id.topic_5:
                GenericClass.topic = 5;
                break;
        }
        Intent i = new Intent(getApplicationContext(),ChapterActivity.class);
        startActivity(i);
    }
}
