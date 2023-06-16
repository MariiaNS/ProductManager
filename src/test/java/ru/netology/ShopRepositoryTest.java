package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    @Test
    public void mustRemoveTheExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 40);
        Product product2 = new Product(73, "Холодильник", 45_000);
        Product product3 = new Product(666, "Компьютер", 150_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(666);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void attemptToRemoveNonExistentProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 40);
        Product product2 = new Product(73, "Холодильник", 45_000);
        Product product3 = new Product(666, "Компьютер", 150_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(50));
    }
}

