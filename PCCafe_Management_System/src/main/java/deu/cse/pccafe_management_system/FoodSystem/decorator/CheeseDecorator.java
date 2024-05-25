package deu.cse.pccafe_management_system.FoodSystem.decorator;

import deu.cse.pccafe_management_system.FoodSystem.composite.FoodComponent;

public class CheeseDecorator extends FoodDecorator {
    public CheeseDecorator(FoodComponent decoratedFood) {
        super(decoratedFood);
    }

    @Override
    public String getName() {
        return decoratedFood.getName() + " + 치즈";
    }

    @Override
    public int getPrice() {
        return decoratedFood.getPrice() + 500;
    }

    @Override
    public void print() {
        decoratedFood.print();
        System.out.println("  -> 토핑: 치즈, 추가 가격: 500원");
    }
}
