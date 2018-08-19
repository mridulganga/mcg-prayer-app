package app.mcg.prayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        int topic = GenericClass.topic;
//            gerate sql query using topic id
//            get results
//            display in recycler view
        Button chap1 = findViewById(R.id.chap1);
        Button chap2 = findViewById(R.id.chap2);
        Button chap3 = findViewById(R.id.chap3);
        Button chap4 = findViewById(R.id.chap4);

        chap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenericClass.chap=1;
                Intent i = new Intent(getApplicationContext(),ContentActivity.class);
                startActivity(i);

            }
        });

        chap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenericClass.chap=2;
                Intent i = new Intent(getApplicationContext(),ContentActivity.class);
                startActivity(i);

            }
        });

        chap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenericClass.chap=3;
                Intent i = new Intent(getApplicationContext(),ContentActivity.class);
                startActivity(i);

            }
        });
        chap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenericClass.chap=4;
                Intent i = new Intent(getApplicationContext(),ContentActivity.class);
                startActivity(i);

            }
        });





}


}
