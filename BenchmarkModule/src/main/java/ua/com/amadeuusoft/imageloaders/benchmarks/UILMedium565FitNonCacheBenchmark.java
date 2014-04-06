package ua.com.amadeuusoft.imageloaders.benchmarks;

import android.content.Context;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.adapters.UILSquare565FitNonCacheAdapter;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.containers.LargeImagesUrlContainer;

/**
 * Created by Artem on 30.03.2014.
 */
public class UILMedium565FitNonCacheBenchmark extends ImageLoaderBenchmark{

    public UILMedium565FitNonCacheBenchmark(GridView gridView) {
        super(gridView);
    }

    @Override
    protected BaseBenchmarkAdapter createBenchmarkAdapter(Context context) {
        IUrlListContainer listContainer = new LargeImagesUrlContainer();
        UILSquare565FitNonCacheAdapter adapter = new UILSquare565FitNonCacheAdapter(context, listContainer);
        return adapter;
    }

}
