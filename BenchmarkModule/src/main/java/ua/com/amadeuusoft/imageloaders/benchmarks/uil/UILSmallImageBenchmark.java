package ua.com.amadeuusoft.imageloaders.benchmarks.uil;

import android.content.Context;
import android.widget.GridView;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.adapters.uil.UILSquareAdapter;
import ua.com.amadeuusoft.imageloaders.benchmarks.ImageLoaderBenchmark;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.containers.SmallImagesUrlContainer;

/**
 * Created by Artem on 30.03.2014.
 */
public class UILSmallImageBenchmark extends ImageLoaderBenchmark {

    public UILSmallImageBenchmark(GridView gridView) {
        super(gridView);
    }

    @Override
    protected BaseBenchmarkAdapter createBenchmarkAdapter(Context context) {
        IUrlListContainer listContainer = new SmallImagesUrlContainer();
        UILSquareAdapter adapter = new UILSquareAdapter(context, listContainer);
        return adapter;
    }

    @Override
    protected String getBenchmarkName() {
        return "UIL";
    }

}
