package com.example.javafxdb;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CompanyService {
    CompanyDao companyDao;

    public CompanyService(){
        var connection = DbUtil.getConnection();
        this.companyDao = new CompanyDao(connection);
    }

    public ObservableList<Company> tableView(){
        try{
            return companyDao.tableView();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}