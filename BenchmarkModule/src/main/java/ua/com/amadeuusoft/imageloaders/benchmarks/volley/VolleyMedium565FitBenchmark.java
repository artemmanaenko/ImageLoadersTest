package ua.com.amadeuusoft.imageloaders.benchmarks.volley;

import android.content.Context;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.adapters.volley.VolleySquare565FitAdapter;
import ua.com.amadeuusoft.imageloaders.benchmarks.ImageLoaderBenchmark;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.containers.LargeImagesUrlContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class VolleyMedium565FitBenchmark extends ImageLoaderBenchmark {

    public VolleyMedium565FitBenchmark(GridView gridView) {
        super(gridView);
    }

    @Override
    protected BaseBenchmarkAdapter createBenchmarkAdapter(Context context) {
        IUrlListContainer listContainer = new LargeImagesUrlContainer();
        VolleySquare565FitAdapter adapter = new VolleySquare565FitAdapter(context, listContainer);
        return adapter;
    }

    @Override
    protected String getBenchmarkName() {
        return "Volley";
    }

}
