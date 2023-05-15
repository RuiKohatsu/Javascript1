package app.dao;

import app.record.ProductRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public ProductRecord findById(int id) {
        ProductRecord product = null;
        final var SQL = "SELECT id, name, price FROM products WHERE id = '" + id + "' ORDER BY id";

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                product = new ProductRecord(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return product;
    }

    public List<ProductRecord> findByName(String name){
        final var SQL = "SELECT id, name, price FROM products WHERE name LIKE '%" + name + "%' ORDER BY id";

        var list = new ArrayList<ProductRecord>();

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var product = new ProductRecord(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public int insert(ProductRecord record) throws SQLException {
        final var SQL = "INSERT INTO products VALUES ('" + record.id() + "', '" + record.name() + "', '" + record.price() + "')";
            PreparedStatement stmt = this.connection.prepareStatement(SQL);
            stmt.executeUpdate();


        return 1;
    }

    public int update(ProductRecord record) throws SQLException{
        final var SQL = "UPDATE products SET name = '" + record.name()
                + "', price = '" + record.price()
                + "'WHERE id = '"+ record.id() +"'";

            PreparedStatement stmt = this.connection.prepareStatement(SQL);
            stmt.executeUpdate();

        return 1;
    }

    public int delete(int id) throws SQLException{
        final var SQL = "DELETE FROM products WHERE id = '"+ id +"'";

            PreparedStatement stmt = this.connection.prepareStatement(SQL);
            stmt.executeUpdate();

        return 1;
    }


}