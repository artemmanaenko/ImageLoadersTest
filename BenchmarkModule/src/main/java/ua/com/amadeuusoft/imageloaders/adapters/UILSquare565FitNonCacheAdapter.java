package ua.com.amadeuusoft.imageloaders.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class UILSquare565FitNonCacheAdapter extends BaseBenchmarkAdapter {

    private DisplayImageOptions options;

    public UILSquare565FitNonCacheAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(context);
        ImageLoader.getInstance().init(config);
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(false)
                .imageScaleType(ImageScaleType.EXACTLY)
                .resetViewBeforeLoading(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .build();
    }

    @Override
    protected void loadImage(ImageView imageView, String url) {
        ImageLoader.getInstance().displayImage(url, imageView, options);
    }
}
