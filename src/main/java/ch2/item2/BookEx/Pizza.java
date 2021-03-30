package main.java.ch2.item2.BookEx;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
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
