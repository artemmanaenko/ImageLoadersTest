package ua.com.amadeuusoft.imageloaders.adapters.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ua.com.amadeuusoft.imageloaders.adapters.BaseBenchmarkAdapter;
import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.transformations.GlideRoundTransformation;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class GlideRoundImageAdapter extends BaseBenchmarkAdapter {

    private GlideRoundTransformation roundTransformation = new GlideRoundTransformation();

    public GlideRoundImageAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected void loadImage(ImageView imageView, String url) {
        Glide.load(url)
                .centerCrop()
                .transform(roundTransformation)
                .into(imageView);
    }
}
