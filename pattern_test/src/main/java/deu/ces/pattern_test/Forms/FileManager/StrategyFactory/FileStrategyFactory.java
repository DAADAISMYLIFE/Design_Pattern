/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.FileManager.StrategyFactory;

/**
 *
 * @author gka
 */
public class FileStrategyFactory {

    public static FileStrategy getStrategy(String fileName) {
        switch (fileName) {
            case "user.txt" -> {
                return new UserStrategy();
            }
            case "product.txt" -> {
                return new ProductStrategy();
            }
            case "shopping_cart.txt" -> {
                return new ShoppingCartStrategy();
            }
            case "shopping_history.txt" -> {
                return new ShoppingHistoryStrategy();
            }
            default ->
                throw new IllegalArgumentException("잘못된 파일 이름: " + fileName);
        }
    }
}
