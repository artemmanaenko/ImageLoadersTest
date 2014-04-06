package ua.com.amadeuusoft.imageloaders.adapters;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.transformations.Config565Transformation;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class PicassoSquare565FitAdapter extends BaseBenchmarkAdapter {

    private Config565Transformation transformation = new Config565Transformation();

    public PicassoSquare565FitAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected void loadImage(ImageView imageView, String url) {
        Picasso.with(context).load(url).transform(transformation).fit().into(imageView);
    }
}
