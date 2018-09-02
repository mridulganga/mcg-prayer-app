package app.mcg.prayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChapterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        if (GenericClass.dbc==null) GenericClass.dbc = new DatabaseClass(getApplicationContext());

        Button c[] = new Button[10];
        c[0] = findViewById(R.id.chap1);
        c[1] = findViewById(R.id.chap2);
        c[2] = findViewById(R.id.chap3);
        c[3] = findViewById(R.id.chap4);
        c[4] = findViewById(R.id.chap5);
        c[5] = findViewById(R.id.chap6);
        c[6] = findViewById(R.id.chap7);
        c[7] = findViewById(R.id.chap8);
        c[8] = findViewById(R.id.chap9);
        c[9] = findViewById(R.id.chap10);


        for (int i=0;i<10;i++){
            c[i].setVisibility(View.GONE);
        }

        try {
            for (int i = 0; i < GenericClass.dbc.fetchChapterCount(GenericClass.topic).getInt(0); i++) {
                c[i].setOnClickListener(this);
                c[i].setVisibility(View.VISIBLE);
            }
        }catch(Exception e){}

}


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.chap1: GenericClass.chap=1;break;
            case R.id.chap2: GenericClass.chap=2;break;
            case R.id.chap3: GenericClass.chap=3;break;
            case R.id.chap4: GenericClass.chap=4;break;
            case R.id.chap5: GenericClass.chap=5;break;
            case R.id.chap6: GenericClass.chap=6;break;
            case R.id.chap7: GenericClass.chap=7;break;
            case R.id.chap8: GenericClass.chap=8;break;
            case R.id.chap9: GenericClass.chap=9;break;
            case R.id.chap10: GenericClass.chap=10;break;
        }

        Intent i = new Intent(getApplicationContext(),ContentActivity.class);
        startActivity(i);
    }
}
