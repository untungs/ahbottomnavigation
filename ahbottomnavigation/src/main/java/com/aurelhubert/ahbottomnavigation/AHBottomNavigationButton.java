package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;

public class AHBottomNavigationButton extends AHBottomNavigationBaseItem {

    private Drawable background;

    @DrawableRes
    private int backgroundRes;

    public AHBottomNavigationButton(Drawable background, Drawable drawable) {
        super(drawable);
        this.background = background;
    }

    public AHBottomNavigationButton(@DrawableRes int backgroundRes, @DrawableRes int drawableRes) {
        super(drawableRes);
        this.backgroundRes = backgroundRes;
    }

    public Drawable getBackground(Context context) {
        if (backgroundRes != 0) {
            try {
                return AppCompatResources.getDrawable(context, backgroundRes);
            } catch (Resources.NotFoundException e) {
                return ContextCompat.getDrawable(context, backgroundRes);
            }
        }
        return background;
    }

    public void setBackground(Drawable background) {
        this.background = background;
        this.backgroundRes = 0;
    }

    public void setBackground(@DrawableRes int backgroundRes) {
        this.backgroundRes = backgroundRes;
        this.background = null;
    }
}
