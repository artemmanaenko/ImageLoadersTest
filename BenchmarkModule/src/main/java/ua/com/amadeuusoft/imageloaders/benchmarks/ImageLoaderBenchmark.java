package ua.com.amadeuusoft.imageloaders.benchmarks;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ua.com.amadeuusoft.imageloaders.BenchmarkApplication;
import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public abstract class ImageLoaderBenchmark {

    enum Direction {
        STOP, DOWN, UP
    }

    protected static String TAG = "ImageLoaderBenchmark";

    private static final int NEXT_SCROLL_DELAY = 1000;
    private static final int DEFAULT_SELECTION_STEP = 4;

    private GridView gridView;

    private Direction direction = Direction.STOP;

    private int selectionStepSize = DEFAULT_SELECTION_STEP;

    private int selectItemIndex;
    private Timer scrollTimer = new Timer();
    private Debug.MemoryInfo memoryInfo;

    private List<Float> usedMemoryCollector = new ArrayList<Float>();

    public ImageLoaderBenchmark(GridView gridView) {
        if (gridView == null)
            throw new IllegalStateException("grid view cannot be null");
        this.gridView = gridView;
        gridView.setAdapter(createBenchmarkAdapter(gridView.getContext()));
        memoryInfo = new Debug.MemoryInfo();
    }

    public void run() {
        resetBenchmark();
        direction = Direction.DOWN;
        scrollTimer.schedule(new ScrollTimerTask(), NEXT_SCROLL_DELAY, NEXT_SCROLL_DELAY);
    }
    ;

    protected void resetBenchmark() {
        scrollTimer.cancel();
        scrollTimer = new Timer();
        selectItemIndex = 0;
        gridView.setSelection(selectItemIndex);
        usedMemoryCollector.clear();
    }

    private class ScrollTimerTask extends TimerTask {
        @Override
        public void run() {
            if (selectItemIndex == gridView.getCount() - 1) {
                direction = Direction.UP;
            } else if (selectItemIndex == 0) {
                if (direction == Direction.UP) {
                    direction = Direction.STOP;
                    postFinishResult();
                    return;
                }
            }
            if (direction == Direction.DOWN) {
                selectItemIndex += selectionStepSize;
                selectItemIndex = Math.min(selectItemIndex, gridView.getCount() - 1);
            } else {
                selectItemIndex -= selectionStepSize;
                selectItemIndex = Math.max(0, selectItemIndex);
            }
            gridView.post(runPostSelection);
        }
    };

    private Runnable runPostSelection = new Runnable() {
        @Override
        public void run() {
            gridView.setSelection(selectItemIndex);
            collectUsedMemory();
        }
    };

    protected void collectUsedMemory() {
        Debug.getMemoryInfo(memoryInfo);
        usedMemoryCollector.add(getTotalUsedMemory());
    }

    protected float getTotalUsedMemory() {
        double usedMemory = memoryInfo.getTotalPss();
        float memoryInMb = (float) (usedMemory / 1024);
        memoryInMb = (float) (Math.round(memoryInMb * Math.pow(10, 2)) / Math.pow(10, 2));//round value
        return memoryInMb;
    }

    protected void postFinishResult() {
        scrollTimer.cancel();
        StringBuilder builder = new StringBuilder();
        builder.append("used memory by steps: ");
        for (Float memorySize : usedMemoryCollector) {
            builder.append(memorySize).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        Log.d(TAG, builder.toString().replace('.', ','));
        BenchmarkResult result = new BenchmarkResult(getBenchmarkName(), usedMemoryCollector);
        BenchmarkApplication application = (BenchmarkApplication) gridView.getContext().getApplicationContext();
        application.getBenchmarkDAO().storeBenchmarkResult(result);
    }

    protected abstract BaseBenchmarkAdapter createBenchmarkAdapter(Context context);
    protected abstract String getBenchmarkName();

}
