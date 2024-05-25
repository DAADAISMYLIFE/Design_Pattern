package deu.cse.pccafe_management_system.FoodSystem.composite;

// 음식 항목을 나타내는 인터페이스

public abstract class FoodComponent {
    protected String name;

    public FoodComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();
    public abstract void print();

    public void addFood(FoodComponent food) {
    }
    public void removeFood(String name) {
    }
    public void updateFood(String name, int price, int stock) {
    }
    
}

