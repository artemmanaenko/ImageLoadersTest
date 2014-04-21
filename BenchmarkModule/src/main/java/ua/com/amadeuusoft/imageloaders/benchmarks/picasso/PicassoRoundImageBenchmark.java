package ua.com.amadeuusoft.imageloaders.benchmarks.picasso;

import android.content.Context;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.adapters.picasso.PicassoRoundImageAdapter;
import ua.com.amadeuusoft.imageloaders.benchmarks.ImageLoaderBenchmark;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.containers.SmallImagesUrlContainer;

/**
 * Created by Artem on 30.03.2014.
 */
public class PicassoRoundImageBenchmark extends ImageLoaderBenchmark {

    public PicassoRoundImageBenchmark(GridView gridView) {
        super(gridView);
    }

    @Override
    protected BaseBenchmarkAdapter createBenchmarkAdapter(Context context) {
        IUrlListContainer listContainer = new SmallImagesUrlContainer();
        PicassoRoundImageAdapter adapter = new PicassoRoundImageAdapter(context, listContainer);
        return adapter;
    }

    @Override
    protected String getBenchmarkName() {
        return "Picasso";
    }

}
