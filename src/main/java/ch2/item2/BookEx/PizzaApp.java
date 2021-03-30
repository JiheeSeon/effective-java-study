package main.java.ch2.item2.BookEx;

import static main.java.ch2.item2.BookEx.NyPizza.Size.SMALL;
import static main.java.ch2.item2.BookEx.Pizza.Topping.*;

public class PizzaApp {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

    }
}
