package com.example.healt_app.com.example.healt_app.viewholders;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.healt_app.R;
import com.example.healt_app.com.example.healt_app.models.FoodScheduleAccordionItem;
import com.sysdata.widget.accordion.CollapsedViewHolder;
import com.sysdata.widget.accordion.ExpandableItemHolder;
import com.sysdata.widget.accordion.ItemAdapter;

public class FoodSchedCollapsedViewHolder extends CollapsedViewHolder {

    private TextView mTitleTextView;

    private FoodSchedCollapsedViewHolder(View itemView) {
        super(itemView);

        mTitleTextView = (TextView) itemView.findViewById(R.id.sample_layout_collapsed_title);
    }

    @Override
    protected void onBindItemView(ExpandableItemHolder itemHolder) {
        mTitleTextView.setText(((FoodScheduleAccordionItem) itemHolder.item).getTitle());
    }

    @Override
    protected void onRecycleItemView() {
        // do nothing
    }

    @Override
    protected ItemAdapter.ItemViewHolder.Factory getViewHolderFactory() {
        return null;
    }

    public static class Factory implements ItemAdapter.ItemViewHolder.Factory {

        public static Factory create(@LayoutRes int itemViewLayoutId) {
            return new Factory(itemViewLayoutId);
        }

        @LayoutRes
        private final int mItemViewLayoutId;

        Factory(@LayoutRes int itemViewLayoutId) {
            mItemViewLayoutId = itemViewLayoutId;
        }

        @Override
        public ItemAdapter.ItemViewHolder<?> createViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false /* attachToRoot */);
            return new FoodSchedCollapsedViewHolder(itemView);
        }

        @Override
        public int getItemViewLayoutId() {
            return mItemViewLayoutId;
        }
    }

}
