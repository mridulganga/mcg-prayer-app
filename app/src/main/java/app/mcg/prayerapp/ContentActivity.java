package app.mcg.prayerapp;

import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        if (GenericClass.dbc==null) GenericClass.dbc = new DatabaseClass(getApplicationContext());

        Button prev_btn=findViewById(R.id.prev_btn);
        Button next_btn=findViewById(R.id.next_btn);

        // Set intial page to 1 and view that page
        GenericClass.page = 1;
        viewUpdate();

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GenericClass.page > 1)
                    GenericClass.page --;
                viewUpdate();
            }
        });
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GenericClass.page<10)
                    GenericClass.page++;
                viewUpdate();
            }
        });

    }

    void viewUpdate(){
        int topic = GenericClass.topic;
        int chapter = GenericClass.chap;
        int page = GenericClass.page;
        String option = GenericClass.option?"Learn":"Recite";

        try {
            Cursor c = GenericClass.dbc.fetchPage(GenericClass.topic, GenericClass.chap, GenericClass.page);
            String verse = c.getString(0);
            String meaning = c.getString(1);
            String audio = c.getString(2);

            TextView data, versetv, meaningtv;
            data = findViewById(R.id.data);
            versetv = findViewById(R.id.verse);
            meaningtv = findViewById(R.id.meaning);

            data.setText(option + " \nTopic : " + topic + " \nChapter : " + chapter + " \nPage : " + page);
            versetv.setText(verse);
            meaningtv.setText(meaning);
        }catch(Exception e){}

    }

}
