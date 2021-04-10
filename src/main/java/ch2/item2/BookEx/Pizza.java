package main.java.ch2.item2.BookEx;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        // 재귀적 타입 한정 -> 나를 상속받고 자기자신을 제네릭 파라미터로 준 애만 허용할래
        // 하위 클래스의 타입을 검증하기 위한 제네릭, 자식 클래스에서는 해당 제네릭을 사용하지 않음.
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self(); //원래라면 return this
        }

        abstract Pizza build();

        // 하위 클래스는 이 메서드를 overriding 해서 this를 반환하도록
        protected abstract T self(); // abstract class의 this 가 없기 때문에 틀만 정하기
    }

    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }
}