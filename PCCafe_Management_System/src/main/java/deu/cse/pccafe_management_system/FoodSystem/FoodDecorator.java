/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.FoodSystem;

public abstract class FoodDecorator extends FoodComponent {
    protected FoodComponent decoratedFood;

    public FoodDecorator(FoodComponent decoratedFood) {
        super(decoratedFood.getName());
        this.decoratedFood = decoratedFood;
    }

    @Override
    public abstract String getName();

    @Override
    public abstract int getPrice();

    @Override
    public abstract void print();

    @Override
    public void addFood(FoodComponent food) {
        decoratedFood.addFood(food);
    }

    @Override
    public void removeFood(String name) {
        decoratedFood.removeFood(name);
    }

    @Override
    public void updateFood(String name, int price, int stock) {
        decoratedFood.updateFood(name, price, stock);
    }
}
