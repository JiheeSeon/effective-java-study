package main.java.ch2.item2.BookEx;

public class NutritionFactsWithBuilder {
    private final int servingSize;  // (ml, 1회 제공량)      필수
    private final int servings;     // (회, 총 n회 제공량)   필수
    private final int calories;     // (1회 제공량당)        선택
    private final int fat;          // (g/ 1회 제공량)       선택
    private final int sodium;       // (mg/ 1회 제공량)      선택
    private final int carbohydrate; // (g/ 1회 제공량)       선택

    /* Builder 패턴 구조
    1. 여러 프로퍼티를 선택인자로 받는 클래스 생성자를 파하고자
       안에 static Builder class를 정의함.

    # 왜 static?
       외부 클래스의 인스턴스 생성은 내부 Builder 클래스를 우회하는 방식
       -> build() 가 호출될 때에야 비로소 이루어짐
       외부 클래스의 객체 없이도 내부의 클래스 객체를 만들려면
       static property로 접근 가능하게 지정해야 함.

    2. static builder class는 다음 프로퍼티와 메소드를 정의
        프로퍼티
        a. 필수인자 -> 무조건 받아야 하므로 final로 지정
        b. 선택인자 -> 일반 private 프로퍼티로 지정

        메소드
        a. 필수인자를 받는 생성자
        b. 선택인자를 builder에 세팅하는 메소드 -> 자기 자신(Builder) 반환
        c. build 메소드 -> 외부 클래스 인스턴스 생성, Builder에 있는 프로퍼티 값들을 그대로 복사
    * */
    public static class Builder{
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 - 기본 값으로 초기화
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        // 내부 클래스의 생성자
        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        // 자기 자신 객체를 반환
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
