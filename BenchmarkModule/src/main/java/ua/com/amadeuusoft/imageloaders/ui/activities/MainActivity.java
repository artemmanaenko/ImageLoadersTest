package ua.com.amadeuusoft.imageloaders.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.io.File;

import ua.com.amadeuusoft.imageloaders.BenchmarkApplication;
import ua.com.amadeuusoft.imageloaders.R;
import ua.com.amadeuusoft.imageloaders.benchmarks.query.QuerySmallImageBenchmark;

public class MainActivity extends Activity {

    private BenchmarkApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        application = (BenchmarkApplication) this.getApplication();

        clearCacheFolder(getCacheDir());

        Button startBenchmark = (Button) findViewById(R.id.go);
        startBenchmark.setOnClickListener(buttonClickListener);

        Button closeButton = (Button) findViewById(R.id.close);
        closeButton.setOnClickListener(buttonClickListener);

        Button showResultsButton = (Button) findViewById(R.id.show_results);
        showResultsButton.setOnClickListener(buttonClickListener);

        Button clearDatabase = (Button) findViewById(R.id.clear_database);
        clearDatabase.setOnClickListener(buttonClickListener);
    }

    private void clearCacheFolder(final File dir) {
        if (dir != null && dir.isDirectory()) {
            try {
                for (File child : dir.listFiles()) {
                    if (child.isDirectory())
                        clearCacheFolder(child);
                    child.delete();
                }
            } catch (Exception e) {
                Log.e("Benchmark", String.format("Failed to clean the cache, error %s", e.getMessage()));
            }
        }
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.go:
                    startBenchmark();
                    break;
                case R.id.close:
                    finish();
                    break;
                case R.id.show_results:
                    showGraphResults();
                    break;
                case R.id.clear_database:
                    clearDatabaseResults();
                    break;
            }
        }
    };

    private void clearDatabaseResults(){
        application.getBenchmarkDAO().clearResults();
    }

    private void showGraphResults(){
        Intent intent = new Intent(this, GraphActivity.class);
        startActivity(intent);
    }

    private void startBenchmark() {
        GridView gridView = (GridView) findViewById(R.id.grid);

        //new PicassoSmallImageBenchmark(gridView).run();
        //new UILSmallImageBenchmark(gridView).run();
        //new VolleySmallImageBenchmark(gridView).run();
        //new GlideSmallImageBenchmark(gridView).run();
        new QuerySmallImageBenchmark(gridView).run();

        //new PicassoMediumImageBenchmark(gridView).run();
        //new UILMediumImageBenchmark(gridView).run();
        //new VolleyMediumImageBenchmark(gridView).run();
        //new GlideMediumImageBenchmark(gridView).run();
        //new QueryMediumImageBenchmark(gridView).run();

       // new PicassoRoundImageBenchmark(gridView).run();
        //new UILRoundImageBenchmark(gridView).run();
       //new VolleyRoundImageBenchmark(gridView).run();
        //new GlideRoundImageBenchmark(gridView).run();
        //new QueryRoundImageBenchmark(gridView).run();

        //new PicassoMedium565FitBenchmark(gridView).run();
        //new UILMedium565FitBenchmark(gridView).run();
        //new VolleyMedium565FitBenchmark(gridView).run();
        //new GlideMedium565FitBenchmark(gridView).run();
        //new QueryMedium565FitBenchmark(gridView).run();


        //new PicassoMediumImageFitBenchmark(gridView).run();
        //new UILMediumFitImageBenchmark(gridView).run();
        // new UILMedium565FitNonCacheBenchmark(gridView).run();
        // new UILMedium565FitSizeLimitBenchmark(gridView).run();
        //new VolleyMediumImageFitBenchmark(gridView).run();


    }

}
