package ua.com.amadeuusoft.imageloaders.adapters.uil;

import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class UILSquareAdapter extends BaseUILAdapter {

    public UILSquareAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected DisplayImageOptions getDisplayImageOptions() {
        return new DisplayImageOptions.Builder()
                .imageScaleType(ImageScaleType.NONE)
                .resetViewBeforeLoading(true)
                .displayer(new FadeInBitmapDisplayer(500, true, true, false))
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .build();
    }
}
