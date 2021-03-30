package main.java.ch2.item2.BookEx;

public class NutritionFactsApp {
    public static void main(String[] args) {
        // Java Beans Pattern -> invalid consistency
        NutritionFactsWithJavaBeans nutritionFactsWithJavaBeans = new NutritionFactsWithJavaBeans();
        nutritionFactsWithJavaBeans.setServingSize(240);
        nutritionFactsWithJavaBeans.setServings(8);
        nutritionFactsWithJavaBeans.setCalories(100);
        nutritionFactsWithJavaBeans.setSodium(35);
        nutritionFactsWithJavaBeans.setCarbohydrate(27);

        // Builder Pattern
        NutritionFactsWithBuilder nutritionFactsWithBuilder
                = new NutritionFactsWithBuilder.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27)
                .build();
    }
}
