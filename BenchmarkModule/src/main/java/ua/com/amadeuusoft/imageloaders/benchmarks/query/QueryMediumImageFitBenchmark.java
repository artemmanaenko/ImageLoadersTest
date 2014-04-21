package ua.com.amadeuusoft.imageloaders.benchmarks.query;

import android.content.Context;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.adapters.query.QuerySquareFitAdapter;
import ua.com.amadeuusoft.imageloaders.benchmarks.ImageLoaderBenchmark;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.containers.LargeImagesUrlContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class QueryMediumImageFitBenchmark extends ImageLoaderBenchmark {

    public QueryMediumImageFitBenchmark(GridView gridView) {
        super(gridView);
    }

    @Override
    protected BaseBenchmarkAdapter createBenchmarkAdapter(Context context) {
        IUrlListContainer listContainer = new LargeImagesUrlContainer();
        QuerySquareFitAdapter adapter = new QuerySquareFitAdapter(context, listContainer);
        return adapter;
    }

    @Override
    protected String getBenchmarkName() {
        return "Query";
    }

}
