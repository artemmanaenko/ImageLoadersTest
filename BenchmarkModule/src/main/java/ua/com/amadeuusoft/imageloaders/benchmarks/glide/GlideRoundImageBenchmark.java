package ua.com.amadeuusoft.imageloaders.benchmarks.glide;

import android.content.Context;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.adapters.glide.GlideRoundImageAdapter;
import ua.com.amadeuusoft.imageloaders.benchmarks.ImageLoaderBenchmark;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.containers.SmallImagesUrlContainer;

/**
 * Created by Artem on 30.03.2014.
 */
public class GlideRoundImageBenchmark extends ImageLoaderBenchmark {

    public GlideRoundImageBenchmark(GridView gridView) {
        super(gridView);
    }

    @Override
    protected BaseBenchmarkAdapter createBenchmarkAdapter(Context context) {
        IUrlListContainer listContainer = new SmallImagesUrlContainer();
        GlideRoundImageAdapter adapter = new GlideRoundImageAdapter(context, listContainer);
        return adapter;
    }

    @Override
    protected String getBenchmarkName() {
        return "Glide";
    }

}
