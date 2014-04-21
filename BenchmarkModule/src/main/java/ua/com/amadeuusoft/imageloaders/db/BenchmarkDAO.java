package ua.com.amadeuusoft.imageloaders.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ua.com.amadeuusoft.imageloaders.benchmarks.BenchmarkResult;

/**
 * Created by Artem on 08.04.2014.
 */
public class BenchmarkDAO {

    final static String TABLE_NAME;
    final static String CREATE_STATEMENT;

    private final static String KEY_BENCHMARK_NAME = "sender_id";
    private final static String KEY_VALUE = "value";

    static {
        TABLE_NAME = "benchmark_results";
        CREATE_STATEMENT = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + " ( "
                + KEY_BENCHMARK_NAME + " TEXT,"
                + KEY_VALUE + " FLOAT"
                + " )";
    }

    private final SQLiteDatabase db;

    public BenchmarkDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public void storeBenchmarkResult(BenchmarkResult result) {
        ContentValues values = new ContentValues();
        String benchmarkName = result.getTitle();
        db.beginTransaction();
        for(Float value : result.getResultList()){
            values.put(KEY_BENCHMARK_NAME, benchmarkName);
            values.put(KEY_VALUE, value);
            db.insert(TABLE_NAME, null, values);
            values.clear();
        }
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public List<BenchmarkResult> getSavedResults(){
        List<String> benchmarkLists = getBenchmarkLists();
        List<BenchmarkResult> result = new ArrayList<BenchmarkResult>(benchmarkLists.size());
        for(String benchmarkName : benchmarkLists){
            List<Float> valuesList = getBenchmarkValuesByName(benchmarkName);
            result.add(new BenchmarkResult(benchmarkName, valuesList));
        }
        return result;
    }

    private List<String> getBenchmarkLists(){
        List<String> list = new ArrayList<String>();
        String sql = "SELECT DISTINCT " + KEY_BENCHMARK_NAME + " FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                list.add(c.getString(0));
            } while (c.moveToNext());
        }
        c.close();
        return list;
    }

    private List<Float> getBenchmarkValuesByName(String benchmarkName){
        List<Float> list = new ArrayList<Float>();
        String sql = "SELECT " + KEY_VALUE + " FROM " + TABLE_NAME + " WHERE " + KEY_BENCHMARK_NAME + "=?";
        String[] args = new String[]{benchmarkName};
        Cursor c = db.rawQuery(sql, args);
        if (c.moveToFirst()) {
            do {
                list.add(c.getFloat(0));
            } while (c.moveToNext());
        }
        c.close();
        return list;
    }

    public void clearResults(){
        db.delete(TABLE_NAME, null, null);
    }

}
