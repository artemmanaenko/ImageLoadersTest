package ua.com.amadeuusoft.imageloaders;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import ua.com.amadeuusoft.imageloaders.db.BenchmarkDAO;
import ua.com.amadeuusoft.imageloaders.db.DatabaseHelper;

/**
 * Created by Artem on 09.04.2014.
 */
public class BenchmarkApplication extends Application {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    private BenchmarkDAO benchmarkDAO;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getWritableDatabase();
        benchmarkDAO = new BenchmarkDAO(db);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        db.close();
    }

    public BenchmarkDAO getBenchmarkDAO() {
        return benchmarkDAO;
    }

}
