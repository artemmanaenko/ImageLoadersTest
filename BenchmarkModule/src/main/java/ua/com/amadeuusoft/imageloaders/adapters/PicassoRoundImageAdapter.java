package ua.com.amadeuusoft.imageloaders.adapters;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;
import ua.com.amadeuusoft.imageloaders.transformations.RoundTransformation;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class PicassoRoundImageAdapter extends BaseBenchmarkAdapter {

    private RoundTransformation roundTransformation = new RoundTransformation();

    public PicassoRoundImageAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected void loadImage(ImageView imageView, String url) {
        Picasso.with(context).load(url).transform(roundTransformation).noFade().into(imageView);
    }
}
