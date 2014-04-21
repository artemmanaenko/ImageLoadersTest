package ua.com.amadeuusoft.imageloaders.adapters.uil;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class UILSquare565FitSizeLimitAdapter extends BaseUILAdapter {

    public UILSquare565FitSizeLimitAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int imageMaxSize = metrics.widthPixels/2;
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(imageMaxSize, imageMaxSize)
                .build();
        ImageLoader.getInstance().init(config);
    }

    @Override
    protected DisplayImageOptions getDisplayImageOptions() {
        return new DisplayImageOptions.Builder()
                .imageScaleType(ImageScaleType.EXACTLY)
                .resetViewBeforeLoading(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .build();
    }

}
