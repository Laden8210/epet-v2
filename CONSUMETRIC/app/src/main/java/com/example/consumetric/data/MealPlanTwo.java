package com.example.consumetric.data;

import com.example.consumetric.model.FoodItem;
import com.example.consumetric.model.MealPlan;

import java.util.ArrayList;
import java.util.List;

public class MealPlanTwo {

    public static List<MealPlan> weekOne() {
        List<MealPlan> mealPlan = new ArrayList<>();


        List<FoodItem> sundayBreakfast = new ArrayList<>();
        sundayBreakfast.add(new FoodItem(1, "Club House Sandwich", "1 & 1/2 pc", 350, "A delicious club house sandwich."));
        sundayBreakfast.add(new FoodItem(2, "Fried Egg", "1 pc med size", 90, "Fried egg cooked to perfection."));
        sundayBreakfast.add(new FoodItem(3, "Lettuce", "2-3 leaves", 5, "Fresh lettuce leaves."));
        sundayBreakfast.add(new FoodItem(4, "Slice Tomatoes", "1 pc med size", 20, "Juicy tomato slice."));
        sundayBreakfast.add(new FoodItem(5, "Mayo", "1 tsp", 10, "Creamy mayonnaise."));
        sundayBreakfast.add(new FoodItem(6, "Low Fat Milk", "¾ Cup", 100, "Refreshing low-fat milk."));

        // Sunday AM Snack
        List<FoodItem> sundayAMSnack = new ArrayList<>();
        sundayAMSnack.add(new FoodItem(1, "In Season Fruits", "80g", 60, "Fresh seasonal fruits."));
        sundayAMSnack.add(new FoodItem(2, "Almonds", "12 pcs", 70, "Nutritious almonds."));

        // Sunday Lunch
        List<FoodItem> sundayLunch = new ArrayList<>();
        sundayLunch.add(new FoodItem(1, "Brown Rice", "¾ Cup (120g)", 200, "Steamed brown rice."));
        sundayLunch.add(new FoodItem(2, "Chicken Veggie Soup", "Chicken Breast 120g Raw", 300, "Hearty chicken veggie soup."));
        sundayLunch.add(new FoodItem(3, "Carrots", "60g Raw", 25, "Fresh raw carrots."));
        sundayLunch.add(new FoodItem(4, "Broccoli", "60g Raw", 20, "Healthy broccoli."));
        sundayLunch.add(new FoodItem(5, "Parsley", "1 tbsp", 5, "Fresh parsley."));
        sundayLunch.add(new FoodItem(6, "Water", "1 Cup", 0, "Fresh drinking water."));
        sundayLunch.add(new FoodItem(7, "In Season Fruits", "80g", 60, "Fresh seasonal fruits."));

        // Sunday PM Snack
        List<FoodItem> sundayPMSnack = new ArrayList<>();
        sundayPMSnack.add(new FoodItem(1, "Beef Nachos", "6-8 nachos", 250, "Crispy beef nachos."));
        sundayPMSnack.add(new FoodItem(2, "Ground Beef", "40g Raw", 100, "Ground beef topping."));
        sundayPMSnack.add(new FoodItem(3, "Chopped Cabbage", "90g Thinly", 20, "Fresh chopped cabbage."));
        sundayPMSnack.add(new FoodItem(4, "Knorr Seasoning", "1 tsp", 5, "Seasoning for flavor."));
        sundayPMSnack.add(new FoodItem(5, "Salt & Pepper", "pinch", 0, "Basic seasoning."));

        // Sunday Dinner
        List<FoodItem> sundayDinner = new ArrayList<>();
        sundayDinner.add(new FoodItem(1, "Mashed Potatoes", "250g Cooked", 210, "Creamy mashed potatoes."));
        sundayDinner.add(new FoodItem(2, "Sauteed Air Fried Tokwa", "6 Slices", 150, "Crispy tofu slices."));
        sundayDinner.add(new FoodItem(3, "Tomatoes", "2 pcs", 30, "Fresh tomatoes."));
        sundayDinner.add(new FoodItem(4, "Rosemary", "pinch", 0, "Aromatic rosemary."));

        // Adding meal plans to the list
        mealPlan.add(new MealPlan(sundayBreakfast, false, false, 2000, "Breakfast", "Sunday"));
        mealPlan.add(new MealPlan(sundayAMSnack, false, false, 2000, "AM Snack", "Sunday"));
        mealPlan.add(new MealPlan(sundayLunch, false, false, 2000, "Lunch", "Sunday"));
        mealPlan.add(new MealPlan(sundayPMSnack, false, false, 2000, "PM Snack", "Sunday"));
        mealPlan.add(new MealPlan(sundayDinner, false, false, 2000, "Dinner", "Sunday"));


        List<FoodItem> mondayBreakfast = new ArrayList<>();
        mondayBreakfast.add(new FoodItem(2, "Cornflakes", "37g Dry Weight", 150, "Crunchy cornflakes."));
        mondayBreakfast.add(new FoodItem(3, "Crushed Cashew Nuts", "7 pcs Whole", 50, "Delicious crushed cashew nuts."));
        mondayBreakfast.add(new FoodItem(4, "Chia Seeds", "1 tbsp", 60, "Nutritious chia seeds."));
        mondayBreakfast.add(new FoodItem(5, "Low Fat Milk", "¾ Cup", 100, "Low-fat milk for a healthy breakfast."));

        List<FoodItem> mondayAMSnack = new ArrayList<>();
        mondayAMSnack.add(new FoodItem(6, "In Season Fruits", "80g", 50, "Fresh seasonal fruits."));
        mondayAMSnack.add(new FoodItem(7, "Cashew Nuts", "14 pcs Whole", 90, "Roasted cashew nuts."));

        List<FoodItem> mondayLunch = new ArrayList<>();
        mondayLunch.add(new FoodItem(8, "Brown Rice", "¾ Cup (120g)", 150, "Healthy brown rice."));
        mondayLunch.add(new FoodItem(9, "Stir Fried Salmon", "120g Raw", 250, "Delicious stir-fried salmon."));
        mondayLunch.add(new FoodItem(10, "Salt & Pepper", "pinch", 0, "Basic seasoning."));
        mondayLunch.add(new FoodItem(11, "Cauliflower", "90g", 30, "Fresh cauliflower."));
        mondayLunch.add(new FoodItem(12, "Bell Pepper", "1 pc", 30, "Crunchy bell pepper."));
        mondayLunch.add(new FoodItem(13, "Garlic", "3 cloves", 10, "Flavorful garlic."));
        mondayLunch.add(new FoodItem(14, "Onion", "1 pc", 40, "Savory onion."));
        mondayLunch.add(new FoodItem(15, "In Season Fruits", "80g", 50, "Fresh seasonal fruits."));

        List<FoodItem> mondayPMSnack = new ArrayList<>();
        mondayPMSnack.add(new FoodItem(16, "Fresh Air Fried Potato Fries", "165g Cooked", 220, "Crispy air-fried potato fries."));
        mondayPMSnack.add(new FoodItem(17, "Sauteed Chicken Breast", "40g Raw", 80, "Tender sautéed chicken."));

        List<FoodItem> mondayDinner = new ArrayList<>();
        mondayDinner.add(new FoodItem(18, "Brown Rice", "¾ Cup (120g)", 150, "Healthy brown rice."));
        mondayDinner.add(new FoodItem(19, "Ginisang Baguio Beans", "120g Raw", 100, "Sautéed Baguio beans."));
        mondayDinner.add(new FoodItem(20, "Chicken Breast", "120g Raw", 200, "Grilled chicken breast."));
        mondayDinner.add(new FoodItem(21, "Garlic", "3 cloves", 10, "Flavorful garlic."));

        // Add Monday meal plan to the list
        mealPlan.add(new MealPlan(mondayBreakfast, false, false, 2000, "Breakfast", "Monday"));
        mealPlan.add(new MealPlan(mondayAMSnack, false, false, 2000, "AM Snack", "Monday"));
        mealPlan.add(new MealPlan(mondayLunch, false, false, 2000, "Lunch", "Monday"));
        mealPlan.add(new MealPlan(mondayPMSnack, false, false, 2000, "Pm Snack", "Monday"));
        mealPlan.add(new MealPlan(mondayDinner, false, false, 2000, "Dinner", "Monday"));


        List<FoodItem> tuesdayBreakfast = new ArrayList<>();
        tuesdayBreakfast.add(new FoodItem(1, "Egg Apple Fried Rice", "¾ Cup (120g)", 350, "A flavorful fried rice with egg and apple."));
        tuesdayBreakfast.add(new FoodItem(2, "Egg", "1 pc med size", 70, "A fresh boiled egg."));
        tuesdayBreakfast.add(new FoodItem(3, "Carrots", "60g Raw", 25, "Raw carrot sticks."));
        tuesdayBreakfast.add(new FoodItem(4, "Low Fat Milk", "¾ Cup", 100, "Low-fat milk for a healthy start."));

        // Tuesday AM Snack
        List<FoodItem> tuesdayAMSnack = new ArrayList<>();
        tuesdayAMSnack.add(new FoodItem(1, "In Season Fruits", "80g", 60, "A selection of fresh seasonal fruits."));
        tuesdayAMSnack.add(new FoodItem(2, "Avocado", "60g", 100, "Creamy avocado for healthy fats."));

        // Tuesday Lunch
        List<FoodItem> tuesdayLunch = new ArrayList<>();
        tuesdayLunch.add(new FoodItem(1, "Brown Rice", "¾ Cup (120g)", 180, "Steamed brown rice."));
        tuesdayLunch.add(new FoodItem(2, "Sauteed Boiled Kidney Beans", "½ Cup Cooked", 120, "Cooked kidney beans sautéed with spices."));
        tuesdayLunch.add(new FoodItem(3, "Pechay", "30g Cooked", 10, "Cooked bok choy."));
        tuesdayLunch.add(new FoodItem(4, "Chayote", "60g Raw", 20, "Raw chayote for crunch."));
        tuesdayLunch.add(new FoodItem(5, "Tomatoes", "2 pcs", 30, "Fresh tomatoes."));

        // Tuesday PM Snack
        List<FoodItem> tuesdayPMSnack = new ArrayList<>();
        tuesdayPMSnack.add(new FoodItem(1, "Whole Wheat Bread", "1 pc", 80, "A slice of whole wheat bread."));
        tuesdayPMSnack.add(new FoodItem(2, "Tuna Spread", "1 Tbsp", 60, "Tuna spread for a protein boost."));
        tuesdayPMSnack.add(new FoodItem(3, "Lettuce", "1 Leaf", 5, "Crisp lettuce leaf."));
        tuesdayPMSnack.add(new FoodItem(4, "Tomato", "Half", 15, "Half a fresh tomato."));

        // Tuesday Dinner
        List<FoodItem> tuesdayDinner = new ArrayList<>();
        tuesdayDinner.add(new FoodItem(1, "Chicken Olive Oil Pasta", "115g Cooked Noodles", 250, "Pasta with chicken and olive oil."));
        tuesdayDinner.add(new FoodItem(2, "Ground Pepper", "pinch", 1, "Freshly ground pepper."));
        tuesdayDinner.add(new FoodItem(3, "Bellpepper", "1 pc", 20, "Sliced bell pepper."));

        // Adding Tuesday Meal Plan
        mealPlan.add(new MealPlan(tuesdayBreakfast, false, false, 2000, "Breakfast", "Tuesday"));
        mealPlan.add(new MealPlan(tuesdayAMSnack, false, false, 2000, "AM Snack", "Tuesday"));
        mealPlan.add(new MealPlan(tuesdayLunch, false, false, 2000, "Lunch", "Tuesday"));
        mealPlan.add(new MealPlan(tuesdayPMSnack, false, false, 2000, "PM Snack", "Tuesday"));
        mealPlan.add(new MealPlan(tuesdayDinner, false, false, 2000, "Dinner", "Tuesday"));

        List<FoodItem> wednesdayBreakfast = new ArrayList<>();
        wednesdayBreakfast.add(new FoodItem(1, "Brown Rice", "¾ Cup (120g)", 150, "A healthy serving of brown rice."));
        wednesdayBreakfast.add(new FoodItem(2, "Ginisang Ampalaya w/ Boiled Chicken", "120g Raw", 300, "Stir-fried bitter melon with chicken."));
        wednesdayBreakfast.add(new FoodItem(3, "Mince Cucumber", "35g", 10, "Fresh minced cucumber."));
        wednesdayBreakfast.add(new FoodItem(4, "Low Fat Milk", "¾ Cup", 100, "Creamy low fat milk."));

        List<FoodItem> wednesdayAMSnack = new ArrayList<>();
        wednesdayAMSnack.add(new FoodItem(1, "In Season Fruits", "80g", 60, "A serving of seasonal fruits."));
        wednesdayAMSnack.add(new FoodItem(2, "Almonds", "12 pcs", 80, "Healthy almond snacks."));

        List<FoodItem> wednesdayLunch = new ArrayList<>();
        wednesdayLunch.add(new FoodItem(1, "Brown Rice", "¾ Cup (120g)", 150, "A healthy serving of brown rice."));
        wednesdayLunch.add(new FoodItem(2, "Beef Sinigang", "90g Cooked", 250, "Sinigang made with beef."));
        wednesdayLunch.add(new FoodItem(3, "Okra", "30g Cooked", 15, "Cooked okra."));
        wednesdayLunch.add(new FoodItem(4, "Sitaw", "40g Raw", 10, "Raw string beans."));
        wednesdayLunch.add(new FoodItem(5, "Pusit", "80g Raw", 120, "Raw squid."));

        List<FoodItem> wednesdayPMSnack = new ArrayList<>();
        wednesdayPMSnack.add(new FoodItem(1, "Avocado Shrimp Rolls", "1-2 pcs", 200, "Fresh shrimp rolls with avocado."));
        wednesdayPMSnack.add(new FoodItem(2, "Rice Paper", "1-2 pcs", 30, "Rice paper for rolls."));
        wednesdayPMSnack.add(new FoodItem(3, "Shrimp", "3 pcs", 60, "Fresh shrimp."));
        wednesdayPMSnack.add(new FoodItem(4, "Garlic/Onion", "3 cloves", 10, "Garlic and onion for flavor."));

        List<FoodItem> wednesdayDinner = new ArrayList<>();
        wednesdayDinner.add(new FoodItem(1, "Air Fried Slice Potatoes", "250g", 200, "Crispy air-fried potatoes."));
        wednesdayDinner.add(new FoodItem(2, "Sauteed Kangkong", "120g Raw", 30, "Stir-fried water spinach."));
        wednesdayDinner.add(new FoodItem(3, "Ground Pepper", "pinch", 0, "A pinch of ground pepper."));
        wednesdayDinner.add(new FoodItem(4, "Salt & Pepper", "pinch", 0, "A pinch of salt and pepper."));

        mealPlan.add(new MealPlan(wednesdayBreakfast, false, false, 2000, "Breakfast", "Wednesday"));
        mealPlan.add(new MealPlan(wednesdayAMSnack, false, false, 2000, "AM Snack", "Wednesday"));
        mealPlan.add(new MealPlan(wednesdayLunch, false, false, 2000, "Lunch", "Wednesday"));
        mealPlan.add(new MealPlan(wednesdayPMSnack, false, false, 2000, "PM Snack", "Wednesday"));
        mealPlan.add(new MealPlan(wednesdayDinner, false, false, 2000, "Dinner", "Wednesday"));


        List<FoodItem> thursdayBreakfast = new ArrayList<>();
        thursdayBreakfast.add(new FoodItem(1, "Chicken Macaroni", "115g Cooked Noodles", 400, "A hearty chicken macaroni dish."));
        thursdayBreakfast.add(new FoodItem(2, "Peanut Butter", "1 tbsp", 90, "Creamy peanut butter spread."));
        thursdayBreakfast.add(new FoodItem(3, "Chayote", "40g Raw", 15, "Fresh chayote vegetable."));
        thursdayBreakfast.add(new FoodItem(4, "Low Fat Milk", "¾ Cup", 100, "Nutritious low fat milk."));

        List<FoodItem> thursdayAMSnack = new ArrayList<>();
        thursdayAMSnack.add(new FoodItem(5, "In Season Fruits", "80g", 50, "Fresh seasonal fruits."));
        thursdayAMSnack.add(new FoodItem(6, "Cashew Nuts", "14 pcs Whole", 150, "Roasted cashew nuts."));

        List<FoodItem> thursdayLunch = new ArrayList<>();
        thursdayLunch.add(new FoodItem(7, "Brown Rice", "¾ Cup (120g)", 150, "Steamed brown rice."));
        thursdayLunch.add(new FoodItem(8, "Chicken Afritada", "120g Raw", 320, "Filipino chicken afritada."));
        thursdayLunch.add(new FoodItem(9, "Bellpepper", "1 pc", 30, "Fresh bell pepper."));
        thursdayLunch.add(new FoodItem(10, "Patis", "1 tsp", 5, "Fish sauce for flavor."));
        thursdayLunch.add(new FoodItem(11, "Fried Tokwa", "4 Slices", 150, "Crispy tofu slices."));
        thursdayLunch.add(new FoodItem(12, "In Season Fruits", "80g", 50, "Fresh seasonal fruits."));

        List<FoodItem> thursdayPMSnack = new ArrayList<>();
        thursdayPMSnack.add(new FoodItem(13, "Asian Chicken Wrap", "1-2 pcs", 200, "Delicious Asian chicken wrap."));
        thursdayPMSnack.add(new FoodItem(14, "Lettuce", "1 Leaf", 5, "Fresh lettuce leaf."));
        thursdayPMSnack.add(new FoodItem(15, "Sesame Oil", "1 tsp", 40, "Flavorful sesame oil."));

        List<FoodItem> thursdayDinner = new ArrayList<>();
        thursdayDinner.add(new FoodItem(16, "Brown Rice", "¾ Cup (120g)", 150, "Steamed brown rice."));
        thursdayDinner.add(new FoodItem(17, "Beef Adobo", "120g Raw", 400, "Savory beef adobo."));
        thursdayDinner.add(new FoodItem(18, "Fried Tokwa", "6 Slices", 150, "Crispy tofu slices."));
        thursdayDinner.add(new FoodItem(19, "Carrots", "60g Raw", 25, "Fresh raw carrots."));

        // Add Thursday Meal Plan
        mealPlan.add(new MealPlan(thursdayBreakfast, false, false, 2000, "Thursday", "Thursday"));
        mealPlan.add(new MealPlan(thursdayAMSnack, false, false, 2000, "Thursday", "Thursday"));
        mealPlan.add(new MealPlan(thursdayLunch, false, false, 2000, "Thursday", "Thursday"));
        mealPlan.add(new MealPlan(thursdayPMSnack, false, false, 2000, "Thursday", "Thursday"));
        mealPlan.add(new MealPlan(thursdayDinner, false, false, 2000, "Thursday", "Thursday"));


        // Breakfast for Friday
        List<FoodItem> fridayBreakfast = new ArrayList<>();
        fridayBreakfast.add(new FoodItem(1, "Overnight Rolled Oats", "60g Dry Weight", 300, "Healthy rolled oats soaked overnight."));
        fridayBreakfast.add(new FoodItem(2, "Sauteed Mix Veggies", "1 serving", 150, "Mix of vegetables sautéed in olive oil."));
        fridayBreakfast.add(new FoodItem(3, "Low Fat Milk", "¾ Cup", 100, "Low fat milk for a nutritious start."));

        // AM Snack for Friday
        List<FoodItem> fridayAMSnack = new ArrayList<>();
        fridayAMSnack.add(new FoodItem(4, "In Season Fruits", "80g", 80, "Fresh seasonal fruits."));
        fridayAMSnack.add(new FoodItem(5, "Avocado", "60g", 100, "Creamy avocado for healthy fats."));

        // Lunch for Friday
        List<FoodItem> fridayLunch = new ArrayList<>();
        fridayLunch.add(new FoodItem(6, "Brown Rice", "¾ Cup (120g)", 220, "Nutritious brown rice."));
        fridayLunch.add(new FoodItem(7, "Seafood Chopseuy", "120g", 300, "Mixed seafood with vegetables."));
        fridayLunch.add(new FoodItem(8, "Fried Tokwa", "6 slices", 200, "Tofu fried to perfection."));
        fridayLunch.add(new FoodItem(9, "In Season Fruits", "80g", 80, "Fresh seasonal fruits."));

        // PM Snack for Friday
        List<FoodItem> fridayPMSnack = new ArrayList<>();
        fridayPMSnack.add(new FoodItem(10, "Whole Wheat Bread", "1 pc", 80, "Healthy whole wheat bread."));
        fridayPMSnack.add(new FoodItem(11, "Chicken Spread", "1 Tbsp", 50, "Spread made from chicken."));
        fridayPMSnack.add(new FoodItem(12, "Cucumber", "50g", 15, "Fresh cucumber for crunch."));

        // Dinner for Friday
        List<FoodItem> fridayDinner = new ArrayList<>();
        fridayDinner.add(new FoodItem(13, "Brown Rice", "¾ Cup (120g)", 220, "Nutritious brown rice."));
        fridayDinner.add(new FoodItem(14, "Beef Adobo", "120g Raw", 350, "Delicious beef adobo cooked in soy sauce."));
        fridayDinner.add(new FoodItem(15, "Fried Tokwa", "6 Slices", 200, "Tofu fried to perfection."));
        fridayDinner.add(new FoodItem(16, "Chayote", "60g Raw", 25, "Fresh chayote for crunch."));
        fridayDinner.add(new FoodItem(16, "Carrots", "60g Raw", 25, "Fresh carrots for extra vitamins."));

        // Add Friday meal plan
        mealPlan.add(new MealPlan(fridayBreakfast, false, false, 2000, "Breakfast", "Friday"));
        mealPlan.add(new MealPlan(fridayAMSnack, false, false, 2000, "AM Snack", "Friday"));
        mealPlan.add(new MealPlan(fridayLunch, false, false, 2000, "Lunch", "Friday"));
        mealPlan.add(new MealPlan(fridayPMSnack, false, false, 2000, "PM Snack", "Friday"));
        mealPlan.add(new MealPlan(fridayDinner, false, false, 2000, "Dinner", "Friday"));


        List<FoodItem> saturdayBreakfast = new ArrayList<>();
        saturdayBreakfast.add(new FoodItem(1, "Brown Rice", "¾ Cup (120g)", 180, "Cooked brown rice."));
        saturdayBreakfast.add(new FoodItem(2, "Banana", "1 pc", 105, "A ripe banana."));
        saturdayBreakfast.add(new FoodItem(3, "Green Peas", "40g Raw", 40, "Fresh green peas."));
        saturdayBreakfast.add(new FoodItem(4, "Low Fat Milk", "¾ Cup", 80, "Low-fat milk."));

        // Saturday AM Snack
        List<FoodItem> saturdayAMSnack = new ArrayList<>();
        saturdayAMSnack.add(new FoodItem(1, "In Season Fruits", "80g", 50, "Seasonal fresh fruits."));
        saturdayAMSnack.add(new FoodItem(2, "Almonds", "12 pcs", 70, "Roasted almonds."));

        // Saturday Lunch
        List<FoodItem> saturdayLunch = new ArrayList<>();
        saturdayLunch.add(new FoodItem(1, "Brown Rice", "¾ Cup (120g)", 180, "Cooked brown rice."));
        saturdayLunch.add(new FoodItem(2, "Kare-Kare", "Chicken Breast, 120g Raw", 300, "Traditional Filipino peanut stew."));
        saturdayLunch.add(new FoodItem(3, "Paprika", "pinch", 0, "Seasoning."));
        saturdayLunch.add(new FoodItem(4, "Pineapple", "100g", 50, "Fresh pineapple."));

        // Saturday PM Snack
        List<FoodItem> saturdayPMSnack = new ArrayList<>();
        saturdayPMSnack.add(new FoodItem(1, "Air Fried Lumpiang Togue", "Togue, 50g", 150, "Fried bean sprouts wrapped in rice paper."));
        saturdayPMSnack.add(new FoodItem(2, "Sliced Cucumber Thinly", "Canola Oil, 2 tsp", 20, "Fresh cucumber slices."));

        // Saturday Dinner
        List<FoodItem> saturdayDinner = new ArrayList<>();
        saturdayDinner.add(new FoodItem(1, "Chicken Hawaiian Fried Rice", "¾ Cup (120g)", 350, "Fried rice with chicken and pineapple."));
        saturdayDinner.add(new FoodItem(2, "Carrots", "60g Raw", 25, "Fresh raw carrots."));
        saturdayDinner.add(new FoodItem(3, "Green Peas", "60g Raw", 40, "Fresh green peas."));

        // Add Saturday meal plan
        mealPlan.add(new MealPlan(saturdayBreakfast, false, false, 2000, "Breakfast", "Saturday"));
        mealPlan.add(new MealPlan(saturdayAMSnack, false, false, 2000, "AM Snack", "Saturday"));
        mealPlan.add(new MealPlan(saturdayLunch, false, false, 2000, "Lunch", "Saturday"));
        mealPlan.add(new MealPlan(saturdayPMSnack, false, false, 2000, "PM Snack", "Saturday"));
        mealPlan.add(new MealPlan(saturdayDinner, false, false, 2000, "Dinner", "Saturday"));


        return mealPlan;
    }


}
