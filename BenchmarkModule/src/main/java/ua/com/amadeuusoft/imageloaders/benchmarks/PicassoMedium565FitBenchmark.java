package ua.com.amadeuusoft.imageloaders.benchmarks;

import android.content.Context;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.adapters.PicassoSquare565FitAdapter;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.containers.LargeImagesUrlContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class PicassoMedium565FitBenchmark extends ImageLoaderBenchmark{

    public PicassoMedium565FitBenchmark(GridView gridView) {
        super(gridView);
    }

    @Override
    protected BaseBenchmarkAdapter createBenchmarkAdapter(Context context) {
        IUrlListContainer listContainer = new LargeImagesUrlContainer();
        PicassoSquare565FitAdapter adapter = new PicassoSquare565FitAdapter(context, listContainer);
        return adapter;
    }

}
