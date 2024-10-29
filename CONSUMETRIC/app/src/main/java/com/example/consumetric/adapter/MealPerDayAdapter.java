package com.example.consumetric.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.consumetric.R;
import com.example.consumetric.model.FoodItem;
import com.example.consumetric.model.MealPlan;

import java.util.List;

public class MealPerDayAdapter extends RecyclerView.Adapter<MealPerDayAdapter.ViewHolder> {

    private Context context;
    private List<MealPlan> mealPlanList;

    public MealPerDayAdapter(Context context, List<MealPlan> mealPlanList) {
        this.context = context;
        this.mealPlanList = mealPlanList;
    }

    @Override
    public MealPerDayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_daily_meal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MealPerDayAdapter.ViewHolder holder, int position) {
        MealPlan mealPlan = mealPlanList.get(position);
        holder.tvMealName.setText(mealPlan.getMealType());
        holder.tlMealItems.removeAllViews();
        for (FoodItem foodItem : mealPlan.getFoodItems()) {
            TableRow row = new TableRow(context);
            TextView tvFoodName = new TextView(context);
            tvFoodName.setText(foodItem.getName());
            row.addView(tvFoodName);

            TextView tvPortionSize = new TextView(context);
            tvPortionSize.setText(String.valueOf(foodItem.getPortionSize()));
            row.addView(tvPortionSize);


            holder.tlMealItems.addView(row);
        }

    }

    @Override
    public int getItemCount() {
        return mealPlanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMealName;
        private TableLayout tlMealItems;
        public ViewHolder(View itemView) {
            super(itemView);
            tvMealName = itemView.findViewById(R.id.tv_meal_type);
            tlMealItems = itemView.findViewById(R.id.tl_food_list);
        }
    }
}
