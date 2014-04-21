package ua.com.amadeuusoft.imageloaders.benchmarks.query;

import android.content.Context;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.adapters.query.QueryRoundImageAdapter;
import ua.com.amadeuusoft.imageloaders.benchmarks.ImageLoaderBenchmark;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.containers.SmallImagesUrlContainer;

/**
 * Created by Artem on 30.03.2014.
 */
public class QueryRoundImageBenchmark extends ImageLoaderBenchmark {

    public QueryRoundImageBenchmark(GridView gridView) {
        super(gridView);
    }

    @Override
    protected BaseBenchmarkAdapter createBenchmarkAdapter(Context context) {
        IUrlListContainer listContainer = new SmallImagesUrlContainer();
        QueryRoundImageAdapter adapter = new QueryRoundImageAdapter(context, listContainer);
        return adapter;
    }

    @Override
    protected String getBenchmarkName() {
        return "Query";
    }

}
