package com.example.healt_app;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.healt_app.com.example.healt_app.dialog.FoodSchedItemDialog;
import com.example.healt_app.com.example.healt_app.models.FoodScheduleAccordionItem;
import com.example.healt_app.com.example.healt_app.models.FoodScheduleItem;
import com.example.healt_app.com.example.healt_app.viewholders.FoodSchedCollapsedViewHolder;
import com.example.healt_app.com.example.healt_app.viewholders.FoodSchedExpandedViewHolder;
import com.sysdata.widget.accordion.ExpandableItemHolder;
import com.sysdata.widget.accordion.FancyAccordionView;
import com.sysdata.widget.accordion.Item;
import com.sysdata.widget.accordion.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class FoodInfoActivity extends AppCompatActivity {

    private static final String KEY_EXPANDED_ID = "expandedId";

    private FancyAccordionView accordionView;

    private ItemAdapter.OnItemClickedListener mListener = new ItemAdapter.OnItemClickedListener() {
        @Override
        public void onItemClicked(ItemAdapter.ItemViewHolder<?> viewHolder, int id) {
            ItemAdapter.ItemHolder itemHolder = viewHolder.getItemHolder();
            FoodScheduleAccordionItem item = ((FoodScheduleAccordionItem) itemHolder.item);

            switch (id) {
                case ItemAdapter.OnItemClickedListener.ACTION_ID_COLLAPSED_VIEW:
                    Toast.makeText(getApplicationContext(), String.format("Collapsed %s clicked!", item.getTitle()), Toast.LENGTH_SHORT);
                    break;
                case ItemAdapter.OnItemClickedListener.ACTION_ID_EXPANDED_VIEW:
                    Toast.makeText(getApplicationContext(), String.format("Expanded %s clickedd!", item.getTitle()), Toast.LENGTH_SHORT);
                    break;
                default:
                    // do nothing
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_info);

        setTitle("Hábitos alimentares");

        accordionView = (FancyAccordionView) findViewById(R.id.acc_food_profile);

        // bind the factory to create view holder for item collapsed
        accordionView.setCollapsedViewHolderFactory(FoodSchedCollapsedViewHolder.Factory.create(R.layout.sample_layout_collapsed), mListener);

        // bind the factory to create view holder for item expanded
        accordionView.setExpandedViewHolderFactory(FoodSchedExpandedViewHolder.Factory.create(R.layout.sample_layout_expanded), mListener);

        // restore the expanded item from state
        if (savedInstanceState != null) {
            accordionView.setExpandedItemId(savedInstanceState.getLong(KEY_EXPANDED_ID, Item.INVALID_ID));
        }

        // LOAD DATA
        loadData();

        FloatingActionButton fab = findViewById(R.id.fab_add_sched_item);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodSchedItemDialog diag = new FoodSchedItemDialog();
                diag.show(getSupportFragmentManager(), "FoodSchedAdd");
            }
        });

    }

    private void loadData() {
        final List<ExpandableItemHolder> itemHolders = new ArrayList<>(3);

        ArrayList<FoodScheduleItem> morningItems = new ArrayList<>();
        morningItems.add(new FoodScheduleItem(
                    "09:50",
                    "Café da manhã",
                    new ArrayList<String>() {
                        {add("Pão");add("Queijo");add("Leite");}
                    }
                )
        );
        morningItems.add(new FoodScheduleItem(
                        "10:50",
                        "Lanche",
                        new ArrayList<String>() {
                            {add("Biscoito");add("Suco");}
                        }
                )
        );
        Item morning = FoodScheduleAccordionItem.create("Manhã", "Sua alimentação matinal", morningItems);

        Item afternoon = FoodScheduleAccordionItem.create("Tarde", "Sua alimentação da tarde", morningItems);
        Item evening = FoodScheduleAccordionItem.create("Noite", "Sua alimentação da noite", morningItems);

        itemHolders.add(new ExpandableItemHolder(morning));
        itemHolders.add(new ExpandableItemHolder(afternoon));
        itemHolders.add(new ExpandableItemHolder(evening));

        accordionView.setAdapterItems(itemHolders);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_EXPANDED_ID, accordionView.getExpandedItemId());
    }



}
