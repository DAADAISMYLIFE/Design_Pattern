package deu.cse.pccafe_management_system.FoodSystem.decorator;

import deu.cse.pccafe_management_system.FoodSystem.composite.FoodComponent;

public class ShotDecorator extends FoodDecorator {
    public ShotDecorator(FoodComponent decoratedFood) {
        super(decoratedFood);
    }

    @Override
    public String getName() {
        return decoratedFood.getName() + " + 샷 추가";
    }

    @Override
    public int getPrice() {
        return decoratedFood.getPrice() + 400;
    }

    @Override
    public void print() {
        decoratedFood.print();
        System.out.println("  -> 토핑: 샷 추가, 추가 가격: 400원");
    }
}
