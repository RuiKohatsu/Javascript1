package app.service;

import app.ProductNotFoundException;
import app.dao.ProductDao;
import app.record.ProductRecord;
import app.util.DbUtil;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    ProductDao productDao;

    public ProductService(){
        var connection = DbUtil.getConnection();
        this.productDao = new ProductDao(connection);
    }

    public ProductRecord findById(int id){
        var product =  productDao.findById(id);
        if(product == null) {
            throw new ProductNotFoundException();
        }else{
            return product;
        }
    }

    public List<ProductRecord> findByName(String name) {
        try(var connection = DbUtil.getConnection();) {
            var productDao = new ProductDao(connection);
            return productDao.findByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public int insert(ProductRecord record) {
        try{
            var result =  productDao.insert(record);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(ProductRecord record1){
        try{
            var result = productDao.update(record1);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int id){
        try{
            var result =  productDao.delete(id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void close(){
        try {
            productDao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}