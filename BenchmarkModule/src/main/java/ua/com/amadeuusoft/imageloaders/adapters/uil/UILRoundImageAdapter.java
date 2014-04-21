package ua.com.amadeuusoft.imageloaders.adapters.uil;

import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import ua.com.amadeuusoft.imageloaders.containers.IUrlListContainer;

/**
 * Created by Artem Manayenko on 30.03.2014.
 */
public class UILRoundImageAdapter extends BaseUILAdapter {


    public UILRoundImageAdapter(Context context, IUrlListContainer urlListContainer) {
        super(context, urlListContainer);
    }

    @Override
    protected DisplayImageOptions getDisplayImageOptions() {
        return new DisplayImageOptions.Builder()
                .imageScaleType(ImageScaleType.NONE)
                .resetViewBeforeLoading(true)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .displayer(new RoundedBitmapDisplayer(Integer.MAX_VALUE))//max_int is the way to make circle image
                .build();
    }


}
