package main.java.ch2.item2.BookEx;

public class NutritionFactsWithBuilder {
    private final int servingSize;  // (ml, 1회 제공량)      필수
    private final int servings;     // (회, 총 n회 제공량)   필수
    private final int calories;     // (1회 제공량당)        선택
    private final int fat;          // (g/ 1회 제공량)       선택
    private final int sodium;       // (mg/ 1회 제공량)      선택
    private final int carbohydrate; // (g/ 1회 제공량)       선택

    // 외부 인스턴스 없이 내부클래스의 인스턴스를 바로 생성할 수 있다.
    public static class Builder{
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 - 기본 값으로 초기화
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) { calories = val; return this; }
        public Builder fat(int val) { fat = val; return this; }
        public Builder sodium(int val) { sodium = val; return this; }
        public Builder carbohydrate(int val) { carbohydrate = val; return this; }

        public NutritionFactsWithBuilder build(){
            return new NutritionFactsWithBuilder(this);
        }
    }

    private NutritionFactsWithBuilder(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
