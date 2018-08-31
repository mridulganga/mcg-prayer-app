package app.mcg.prayerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseClass extends SQLiteOpenHelper {

    public static String initSQL_page  = "create table page (page_id int primary key, page_no int, verse text, meaning text, audio_content text, topic_id int, chapter_id int);";
    public static String initSQL_topic  = "create table topic(topic_id int primary key, topic_name text);";
    public static String initSQL_chapter  ="create table chapter(chapter_id int primary key, chapter_no int, topic_id int)";


    DatabaseClass(Context context){
        super(context, "main.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(initSQL_topic);
        db.execSQL(initSQL_chapter);
        db.execSQL(initSQL_page);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}


/*


*/
