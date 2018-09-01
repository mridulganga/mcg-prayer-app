package app.mcg.prayerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseClass extends SQLiteOpenHelper {

    public static String initSQL_page  = "create table page (page_id int, verse text, meaning text, audio_content text, topic_id int, chapter_id int)";
    public static String initSQL_topic  = "create table topic(topic_id int primary key, topic_name text, chapter_count int)";
    public static String initSQL_chapter  ="create table chapter(chapter_id int, topic_id int, page_count int)";


    SQLiteDatabase database;

    DatabaseClass(Context context){
        super(context, "main.db", null, 1);
        database = this.getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
//        database = db;
        db.execSQL(initSQL_topic);
        db.execSQL(initSQL_chapter);
        db.execSQL(initSQL_page);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void initDB(){
        // add all the data
        // sql dump
        insertTopic(1,"topic 1",2);
        insertTopic(2,"topic 2",3);
        insertTopic(3,"topic 3",4);

        insertChapter(1,1,3);
        insertChapter(2,1,5);

        insertChapter(1,2,2);
        insertChapter(2,2,3);
        insertChapter(3,2,4);

        insertChapter(1,3,2);
        insertChapter(2,3,3);
        insertChapter(3,3,5);
        insertChapter(4,3,2);

        insertPage(1,1,1,"v1","m1","none");
        insertPage(2,1,1,"v2","m2","none");
        insertPage(3,1,1,"v3","m3","none");

        insertPage(1,1,2,"v1","m1","none");
        insertPage(2,1,2,"v2","m2","none");
        insertPage(3,1,2,"v3","m3","none");
        insertPage(4,1,2,"v4","m4","none");
        insertPage(5,1,2,"v5","m5","none");
    }

    public void insertTopic(int topicID, String topicName, int chapterCount){
        ContentValues values = new ContentValues();
        values.put("topic_id",topicID);
        values.put("topic_name",topicName);
        values.put("chapter_count",chapterCount);
        database.insert("topic",null,values);
    }

    public void insertChapter(int chapterID, int topicID,int pageCount){
        ContentValues values = new ContentValues();
        values.put("topic_id",topicID);

        values.put("chapter_id",chapterID);
        values.put("page_count",pageCount);
        database.insert("chapter",null,values);
    }

    public void insertPage(int pageID, int topicID, int chapterID, String verse, String meaning,String audioContent){
        ContentValues values = new ContentValues();
        values.put("page_id",pageID);
        values.put("verse",verse);
        values.put("meaning",meaning);
        values.put("audio_content",audioContent);
        values.put("chapter_id",chapterID);
        values.put("topic_id",topicID);
        database.insert("page",null,values);
    }

    public Cursor fetchTopics() {
        String[] columns = new String[] { "topic_id","topic_name" };
        Cursor cursor = database.query("topic", columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchChapterCount(int topicID) {
        String[] columns = new String[] { "chapter_count" };
        Cursor cursor = database.query("topic", columns, "topic_id = ?", new String[]{topicID + ""}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchPageCount(int topicID, int chapterID) {
        String[] columns = new String[] { "page_count" };
        Cursor cursor = database.query("chapter", columns, "topic_id = ? and chapter_id = ?", new String[]{topicID + "", chapterID + ""}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }


    public Cursor fetchPage(int topicID, int chapterID, int pageNo) {
        String[] columns = new String[] { "verse","meaning","audio_content" };
        Cursor cursor = database.query("page", columns, "topic_id = ? and chapter_id = ? and page_id = ?", new String[]{topicID + "",chapterID + "", pageNo + ""}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    }