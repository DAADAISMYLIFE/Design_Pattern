package deu.cse.pccafe_management_system.FoodSystem.composite;

public class FoodItem extends FoodComponent {
    private int price;
    private int stock;

    public FoodItem(String name, int price, int stock) {
        super(name);
        this.price = price;
        this.stock = stock;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void print() {
        System.out.println("음식: " + name + ", 가격: " + price + "원, 재고량: " + stock + "개");
    }
}
