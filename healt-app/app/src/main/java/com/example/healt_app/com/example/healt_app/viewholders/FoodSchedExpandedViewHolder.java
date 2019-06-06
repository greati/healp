package com.example.healt_app.com.example.healt_app.viewholders;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.healt_app.R;
import com.example.healt_app.com.example.healt_app.adapters.FoodSchedItemAdapter;
import com.example.healt_app.com.example.healt_app.models.FoodScheduleAccordionItem;
import com.example.healt_app.com.example.healt_app.models.FoodScheduleItem;
import com.sysdata.widget.accordion.ExpandableItemHolder;
import com.sysdata.widget.accordion.ExpandedViewHolder;
import com.sysdata.widget.accordion.ItemAdapter;

import java.util.Arrays;

public class FoodSchedExpandedViewHolder extends ExpandedViewHolder {


    private TextView mTitleTextView;
    private TextView mDescriptionTextView;
    private ListView lvScheduleItems;

    private FoodSchedExpandedViewHolder(View itemView) {
        super(itemView);

        mTitleTextView = (TextView) itemView.findViewById(R.id.sample_layout_expanded_title);
        //mDescriptionTextView = (TextView) itemView.findViewById(R.id.sample_layout_expanded_description);
        lvScheduleItems = itemView.findViewById(R.id.lv_schedule_items);
    }

    @Override
    protected void onBindItemView(ExpandableItemHolder itemHolder) {
        mTitleTextView.setText(((FoodScheduleAccordionItem) itemHolder.item).getTitle());
        //mDescriptionTextView.setText(((FoodScheduleAccordionItem) itemHolder.item).getDescription());

        FoodScheduleAccordionItem item = (FoodScheduleAccordionItem) itemHolder.item;

        FoodSchedItemAdapter adapter = new FoodSchedItemAdapter(lvScheduleItems.getContext(),
                R.layout.food_schedule_list_item, item.getFoodSchedItems().toArray(new FoodScheduleItem[item.getFoodSchedItems().size()]));
        lvScheduleItems.setAdapter(adapter);
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

        public static FoodSchedExpandedViewHolder.Factory create(@LayoutRes int itemViewLayoutId) {
            return new Factory(itemViewLayoutId);
        }

        @LayoutRes
        private final int mItemViewLayoutId;

        public Factory(@LayoutRes int itemViewLayoutId) {
            mItemViewLayoutId = itemViewLayoutId;
        }

        @Override
        public ItemAdapter.ItemViewHolder<?> createViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false /* attachToRoot */);
            return new FoodSchedExpandedViewHolder(itemView);
        }

        @Override
        public int getItemViewLayoutId() {
            return mItemViewLayoutId;
        }
    }

}
