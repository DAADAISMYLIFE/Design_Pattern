package deu.ces.pattern_test.Forms.Product;

public interface Observer {

    void update(String productName, int productPrice);
    void delete();
}
