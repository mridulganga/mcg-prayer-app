package app.mcg.prayerapp;

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

        // fetch page data from db and view it.
        TextView verse=findViewById(R.id.verse);
        verse.setText(option + " \nTopic : " + topic + " \nChapter : " + chapter + " \nPage : " + page);
    }

}
