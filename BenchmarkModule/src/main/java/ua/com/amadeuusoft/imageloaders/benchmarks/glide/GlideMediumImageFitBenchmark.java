package ua.com.amadeuusoft.imageloaders.benchmarks.glide;

import android.content.Context;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.adapters.glide.GlideFitAdapter;
import ua.com.amadeuusoft.imageloaders.benchmarks.ImageLoaderBenchmark;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.containers.LargeImagesUrlContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class GlideMediumImageFitBenchmark extends ImageLoaderBenchmark {

    public GlideMediumImageFitBenchmark(GridView gridView) {
        super(gridView);
    }

    @Override
    protected BaseBenchmarkAdapter createBenchmarkAdapter(Context context) {
        IUrlListContainer listContainer = new LargeImagesUrlContainer();
        GlideFitAdapter adapter = new GlideFitAdapter(context, listContainer);
        return adapter;
    }

    @Override
    protected String getBenchmarkName() {
        return "Glide";
    }

}
