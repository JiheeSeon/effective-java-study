package main.java.ch2.item2.BookEx;

public class Calzone extends Pizza{
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        // Builder를 CalzoneBuilder로 바꾸면 잘 보임
        private boolean sauceInside = false; // optional 인자, 기본 false 로 초기화

        public Builder sauceInside(){ //addTopping과 유사, 선택인자
            sauceInside = true;
            return this;
        }

        @Override public Pizza build(){
            return new Calzone(this);
        }

        @Override protected Builder self() { return this; }
    }

    private Calzone(Builder builder){
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
