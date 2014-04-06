package ua.com.amadeuusoft.imageloaders.benchmarks;

import android.content.Context;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.adapters.PicassoSquareFitAdapter;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.containers.LargeImagesUrlContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class PicassoMediumImageFitBenchmark extends ImageLoaderBenchmark{

    public PicassoMediumImageFitBenchmark(GridView gridView) {
        super(gridView);
    }

    @Override
    protected BaseBenchmarkAdapter createBenchmarkAdapter(Context context) {
        IUrlListContainer listContainer = new LargeImagesUrlContainer();
        PicassoSquareFitAdapter adapter = new PicassoSquareFitAdapter(context, listContainer);
        return adapter;
    }

}
