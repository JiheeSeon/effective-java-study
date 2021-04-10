package main.java.ch2.item2.BookEx;

import java.util.Objects;

public class NyPizza extends Pizza{
    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;

    // 부모클래스의 static 클래스는 자동 상속 X, 상속하려면 직접 지정
    public static class Builder extends Pizza.Builder<Builder> {
        // 위에서 나를 상속받고 자기자신을 제네릭 파라미터로 준 애만 허용하겠다고 했음
        // Pizza.Builder<T extends Pizza.Builder<T>>
        // Pizza.Builder<NyPizza.Builder>
        // NyPizza.Builder extends Pizza.Builder<NyPizza.Builder>

        private final Size size;

        public Builder(Size size){ this.size = Objects.requireNonNull(size); } //필수요소는 생성자에서 받음

        @Override public Pizza build(){ return new NyPizza(this); }

        @Override
        protected Builder self() { return this; }
        // 추상클래스에서 정의된 addTopping에서 self를 호출
        // -> 자식에서 구현한 self, 즉 자식클래스 객체 자체를 넘겨주게 됨.
    }

    private NyPizza(Builder builder){
        super(builder);
        size = builder.size;
    }
}
