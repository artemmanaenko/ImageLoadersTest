package ua.com.amadeuusoft.imageloaders.ui.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewStyle;
import com.jjoe64.graphview.LineGraphView;

import java.util.List;

import ua.com.amadeuusoft.imageloaders.BenchmarkApplication;
import ua.com.amadeuusoft.imageloaders.R;
import ua.com.amadeuusoft.imageloaders.benchmarks.BenchmarkResult;

/**
 * Created by Artem on 08.04.2014.
 */
public class GraphActivity extends Activity {

    private BenchmarkApplication application;
    private FrameLayout graphRoot;

    private int[] lineColors = new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN, Color.YELLOW};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        application = (BenchmarkApplication) getApplication();
        graphRoot = (FrameLayout) findViewById(R.id.graph_root);
        List<BenchmarkResult> savedResults = application.getBenchmarkDAO().getSavedResults();
        drawGraphs(savedResults);
    }

    private void drawGraphs(List<BenchmarkResult> benchmarkResults) {
        GraphView graphView = new LineGraphView(this, "");
        float maxValue = 0;
        float minValue = 100;
        for(BenchmarkResult benchmark : benchmarkResults){
            GraphView.GraphViewData[] data = new GraphView.GraphViewData[benchmark.getResultList().size()];
            for(int i = 0; i < benchmark.getResultList().size(); i++){
                float value = benchmark.getResultList().get(i);
                data[i] = new GraphView.GraphViewData(i, value);
                if(value > maxValue)
                    maxValue = value;
                if(value < minValue)
                    minValue = value;
            }
            GraphViewSeries.GraphViewSeriesStyle style = new GraphViewSeries.GraphViewSeriesStyle();
            style.color = lineColors[benchmarkResults.indexOf(benchmark)];
            graphView.addSeries(new GraphViewSeries(benchmark.getTitle(), style, data));
        }
        graphView.setManualYAxisBounds(maxValue, minValue);
        graphView.setGraphViewStyle(new GraphViewStyle(Color.WHITE, Color.BLACK, Color.LTGRAY));
        graphView.setHorizontalLabels(new String[]{});
        graphView.setShowLegend(true);
        graphView.setLegendWidth(200);
        graphView.setLegendAlign(GraphView.LegendAlign.BOTTOM);
        graphView.setBackgroundColor(Color.WHITE);
        graphRoot.addView(graphView);
    }

}
