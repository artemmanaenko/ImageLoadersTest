package ua.com.amadeuusoft.imageloaders.adapters.query;

import android.content.Context;
import android.widget.ImageView;

import com.androidquery.AQuery;
import com.androidquery.callback.ImageOptions;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.ui.widgets.QueryFit565ImageView;

/**
 * Created by Artem on 15.04.2014.
 */
public class QuerySquareFit565Adapter extends BaseQueryAdapter {

    public QuerySquareFit565Adapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected void loadImage(AQuery aq, ImageView imageView, String url) {
        ImageOptions options = new ImageOptions();
        options.ratio = 1;
        aq.id(imageView).image(url, options);
    }

    @Override
    protected ImageView createImageView(){
        return new QueryFit565ImageView(context);
    }

}
