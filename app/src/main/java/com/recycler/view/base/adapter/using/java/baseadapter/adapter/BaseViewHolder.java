package com.recycler.view.base.adapter.using.java.baseadapter.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views = new SparseArray();

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    /*public <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = getViewOrNull(viewId);
            assert view == null : "view == null";
            views.put(viewId, view);
        }
        return (T) view;
    }*/

    public <T extends View> T getViewOrNull(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public <T extends View> T findView(@IdRes int viewId) {
        return itemView.findViewById(viewId);
    }

    public BaseViewHolder setText(@IdRes int viewId, CharSequence value) {
        TextView textView = getViewOrNull(viewId);
        textView.setText(value);
        return this;
    }

    public BaseViewHolder setText(@IdRes int viewId, @StringRes int resId) {
        TextView textView = getViewOrNull(viewId);
        textView.setText(resId);
        return this;
    }

    public BaseViewHolder setTextColor(@IdRes int viewId, @ColorInt int color) {
        TextView textView = getViewOrNull(viewId);
        textView.setTextColor(color);
        return this;
    }

    public BaseViewHolder setTextColorRes(@IdRes int viewId, @ColorRes int resId) {
        TextView textView = getViewOrNull(viewId);
        textView.setTextColor(itemView.getResources().getColor(resId));
        return this;
    }

    public BaseViewHolder setImageResource(@IdRes int viewId, @DrawableRes int imageResId) {
        ImageView imageView = getViewOrNull(viewId);
        imageView.setImageResource(imageResId);
        return this;
    }

    public BaseViewHolder setImageDrawable(@IdRes int viewId, Drawable drawable) {
        ImageView imageView = getViewOrNull(viewId);
        imageView.setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setImageBitmap(@IdRes int viewId, Bitmap bitmap) {
        ImageView imageView = getViewOrNull(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setBackgroundColor(@IdRes int viewId, @ColorInt int color) {
        View view = getViewOrNull(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public BaseViewHolder setBackgroundColorRes(@IdRes int viewId, @ColorRes int resId) {
        View view = getViewOrNull(viewId);
        view.setBackgroundColor(itemView.getResources().getColor(resId));
        return this;
    }

    public BaseViewHolder setBackgroundResource(@IdRes int viewId, @DrawableRes int backgroundRes) {
        View view = getViewOrNull(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public BaseViewHolder setVisible(@IdRes int viewId, Boolean isVisible) {
        View view = getViewOrNull(viewId);
        view.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
        return this;
    }

    public BaseViewHolder setGone(@IdRes int viewId, Boolean isGone) {
        View view = getViewOrNull(viewId);
        view.setVisibility(isGone ? View.GONE : View.VISIBLE);
        return this;
    }

    public BaseViewHolder setEnabled(@IdRes int viewId, Boolean isEnabled) {
        View view = getViewOrNull(viewId);
        view.setEnabled(isEnabled);
        return this;
    }
}
