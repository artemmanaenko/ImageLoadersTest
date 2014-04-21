package com.bumptech.glide.loader.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.loader.stream.StreamLoader;
import com.bumptech.glide.resize.ImageManager;
import com.bumptech.glide.resize.LoadedCallback;
import com.bumptech.glide.resize.load.Downsampler;
import com.bumptech.glide.resize.load.Transformation;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * A base class for loaders that user ImageManager. Primarily responsible for keeping track of bitmaps for recycling
 * purposes.
 */
public class ImageManagerLoader implements ImageLoader {
    private final ImageManager imageManager;
    private final Downsampler downsampler;
    private Bitmap acquired;
    private ImageManager.LoadToken loadToken;

    public ImageManagerLoader(Context context) {
        this(context, Downsampler.AT_LEAST);
    }

    public ImageManagerLoader(ImageManager imageManager) {
        this(imageManager, Downsampler.AT_LEAST);
    }

    public ImageManagerLoader(Context context, Downsampler downsampler) {
        this(Glide.get().getImageManager(context), downsampler);
    }

    public ImageManagerLoader(ImageManager imageManager, Downsampler downsampler) {
        this.imageManager = imageManager;
        this.downsampler = downsampler;
    }

    @Override
    public Object fetchImage(String id, StreamLoader streamLoader, Transformation transformation, int width, int height,
                             final ImageReadyCallback cb) {
        if (!isHandled(width, height)) {
            throw new IllegalArgumentException(getClass() + " cannot handle width=" + width + " and/or height =" +
                    height);
        }
        loadToken = imageManager.getImage(id, streamLoader, transformation, downsampler, width, height,
                new LoadedCallback() {
            @Override
            public void onLoadCompleted(Bitmap loaded) {
                onImageReady(loaded, cb.onImageReady(loaded));
            }

            @Override
            public void onLoadFailed(Exception e) {
                cb.onException(e);
            }
        });
        return loadToken;
    }

    protected void onImageReady(Bitmap image, boolean isUsed) {
        if (isUsed) {
            releaseAcquired();
            acquired = image;
        } else {
            imageManager.releaseBitmap(image);
        }
    }

    @Override
    public void clear() {
        releaseAcquired();
        if (loadToken != null) {
            loadToken.cancel();
            loadToken = null;
        }
    }

    private void releaseAcquired() {
        if (acquired != null) {
            imageManager.releaseBitmap(acquired);
            acquired = null;
        }
    }

    protected boolean isHandled(int width, int height) {
        return width >= 0 && height >= 0 ||
                (downsampler == Downsampler.NONE && (width == WRAP_CONTENT || height == WRAP_CONTENT));
    }
}
