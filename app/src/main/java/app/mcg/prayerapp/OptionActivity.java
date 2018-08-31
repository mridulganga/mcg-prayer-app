package app.mcg.prayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        Button option_select = findViewById(R.id.option_select);
        option_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton learn_radio = findViewById(R.id.option_learn);
//                RadioButton recite_radio = findViewById(R.id.option_recite);

               GenericClass.option = learn_radio.isChecked();

               Intent i = new Intent(getApplicationContext(),TopicActivity.class);
               startActivity(i);

            }
        });

    }
}
