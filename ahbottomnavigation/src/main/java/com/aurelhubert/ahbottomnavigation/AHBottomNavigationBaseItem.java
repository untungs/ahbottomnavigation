package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;

public class AHBottomNavigationBaseItem {
    protected Drawable drawable;

    @DrawableRes
    protected int drawableRes = 0;

    protected AHBottomNavigationBaseItem(Drawable drawable) {
        this.drawable = drawable;
    }

    protected AHBottomNavigationBaseItem(@DrawableRes int drawableRes) {
        this.drawableRes = drawableRes;
    }

    public Drawable getDrawable(Context context) {
        if (drawableRes != 0) {
            try {
                return AppCompatResources.getDrawable(context, drawableRes);
            } catch (Resources.NotFoundException e) {
                return ContextCompat.getDrawable(context, drawableRes);
            }
        }
        return drawable;
    }

    public void setDrawable(@DrawableRes int drawableRes) {
        this.drawableRes = drawableRes;
        this.drawable = null;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        this.drawableRes = 0;
    }
}
