package ua.com.amadeuusoft.imageloaders;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.benchmarks.UILMedium565FitSizeLimitBenchmark;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBenchmark = (Button) findViewById(R.id.go_button);
        startBenchmark.setOnClickListener(goClickListener);
    }

    private View.OnClickListener goClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            GridView gridView = (GridView) findViewById(R.id.grid);
            //new PicassoSmallImageBenchmark(gridView).run();
            //new PicassoMediumImageBenchmark(gridView).run();
            //new PicassoMediumImageFitBenchmark(gridView).run();
            //new PicassoRoundImageBenchmark(gridView).run();

            //new UILSmallImageBenchmark(gridView).run();
            //new UILMediumImageBenchmark(gridView).run();
            //new UILMediumFitImageBenchmark(gridView).run();
            //new UILRoundImageBenchmark(gridView).run();

            //new UILMedium565FitBenchmark(gridView).run();
            //new PicassoMedium565FitBenchmark(gridView).run();
            // new UILMedium565FitNonCacheBenchmark(gridView).run();
            new UILMedium565FitSizeLimitBenchmark(gridView).run();
        }
    };

}
