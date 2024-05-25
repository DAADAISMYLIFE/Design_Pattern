package deu.cse.pccafe_management_system.FoodSystem.util;

class Stock {
    private int[] stockArray;

    public Stock(int size) {
        stockArray = new int[size];
    }

    public void addStock(int foodIndex, int quantity) {
        stockArray[foodIndex] += quantity;
    }

    public void updateStock(int foodIndex, int quantity) {
        stockArray[foodIndex] = quantity;
    }

    public void printStock(String[] foodNames) {
        System.out.println("재고량:");
        for (int i = 0; i < stockArray.length; i++) {
            System.out.println(foodNames[i] + ": " + stockArray[i] + "개");
        }
    }
}
