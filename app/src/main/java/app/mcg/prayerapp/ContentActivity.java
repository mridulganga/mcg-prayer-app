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

        int topic = getIntent().getIntExtra("topic",0);
        int chapter = getIntent().getIntExtra("chapter",0);
        int page = getIntent().getIntExtra("page",0);

        TextView verse=findViewById(R.id.verse);
        verse.setText(topic + " " + chapter + " " + page);

        Button prev_btn=findViewById(R.id.prev_btn);
        Button next_btn=findViewById(R.id.next_btn);

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_page(1);
            }
        });
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_page(2);
            }
        });



    }

    void update_page(int action)
    {
        if(action==1)
        {
            GenericClass.page-=1;
        }
        else
        {
            GenericClass.page+=1;
        }
    }
}
