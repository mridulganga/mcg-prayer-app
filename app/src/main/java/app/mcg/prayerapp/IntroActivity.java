package app.mcg.prayerapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button intro_next = findViewById(R.id.intro_next);
        intro_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GenericClass.dbc = new DatabaseClass(getApplicationContext());
                GenericClass.dbc.initDB();

                Intent i = new Intent(getApplicationContext(),OptionActivity.class);
                startActivity(i);
            }
        });

    }
}
