package app;

import app.record.ProductRecord;
import app.service.ProductService;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        var productService = new ProductService();
        var product = productService.findById(101);
        System.out.println(product);

        var productList1 = productService.findByName("地球");
        productList1.stream().forEach(System.out::println);

        var record = new ProductRecord(104, "教科書", 1500);
        var insert = productService.insert(record);
        System.out.println(insert + "件のレコードを追加しました");

        var record1 = new ProductRecord(104, "シャーペン", 800);
        var update = productService.update(record1);
        System.out.println(update + "件のレコードを更新しました");

        var delete = productService.delete(104);
        System.out.println(delete + "件のレコードを削除しました");

        productService.close();
    }
}
