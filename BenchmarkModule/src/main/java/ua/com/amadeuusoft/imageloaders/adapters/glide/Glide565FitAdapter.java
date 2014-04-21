package ua.com.amadeuusoft.imageloaders.adapters.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.transformations.GlideConfig565Transformation;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class Glide565FitAdapter extends BaseBenchmarkAdapter {

    private GlideConfig565Transformation transformation = new GlideConfig565Transformation();

    public Glide565FitAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected void loadImage(ImageView imageView, String url) {
        Glide.load(url)
                .approximate()
                .centerCrop()
                .transform(transformation)
                .into(imageView);
    }
}
