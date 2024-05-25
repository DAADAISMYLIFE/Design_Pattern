package deu.cse.pccafe_management_system.FoodSystem.decorator;

import deu.cse.pccafe_management_system.FoodSystem.composite.FoodComponent;

public class EggDecorator extends FoodDecorator {
    public EggDecorator(FoodComponent decoratedFood) {
        super(decoratedFood);
    }

    @Override
    public String getName() {
        return decoratedFood.getName() + " + 계란";
    }

    @Override
    public int getPrice() {
        return decoratedFood.getPrice() + 300;
    }

    @Override
    public void print() {
        decoratedFood.print();
        System.out.println("  -> 토핑: 계란, 추가 가격: 300원");
    }
}
