package com.example.t2009m1java.model;

import com.example.t2009m1java.constant.SqlConstant;
import com.example.t2009m1java.entity.Product;
import com.example.t2009m1java.entity.myenum.ProductStatus;
import com.example.t2009m1java.service.ConnectionHelper;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel {

    @Override
    public boolean save(Product obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(SqlConstant.PRODUCT_INSERT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getThumbnail());
            preparedStatement.setDouble(3, obj.getPrice());
            preparedStatement.setInt(4, obj.getCategoryId());
            preparedStatement.setString(5, obj.getDescription());
            preparedStatement.setString(6, obj.getDetail());
            preparedStatement.setString(7, obj.getCreatedAt().toString());
            preparedStatement.setString(8, obj.getUpdatedAt().toString());
            preparedStatement.setInt(9, obj.getCreatedBy());
            preparedStatement.setInt(10, obj.getUpdatedBy());
            preparedStatement.setInt(11, obj.getStatus().getValue());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Product updateObj) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.PRODUCT_UPDATE);
            preparedStatement.setString(1, updateObj.getName());
            preparedStatement.setString(2, updateObj.getThumbnail());
            preparedStatement.setDouble(3, updateObj.getPrice());
            preparedStatement.setInt(4, updateObj.getCategoryId());
            preparedStatement.setString(5, updateObj.getDescription());
            preparedStatement.setString(6, updateObj.getDetail());
            preparedStatement.setString(7, updateObj.getUpdatedAt().toString());
            preparedStatement.setInt(8, updateObj.getUpdatedBy());
            preparedStatement.setInt(9, updateObj.getStatus().getValue());
            preparedStatement.setInt(10, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.PRODUCT_DELETE);
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        List<Product> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.PRODUCT_SELECT_ALL);
            preparedStatement.setInt(1, ProductStatus.ACTIVE.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = convertResultSetToProduct(resultSet);
                if (product != null) {
                    listObj.add(product);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listObj;
    }

    @Override
    public Product findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.PRODUCT_SELECT_BY_ID);
            preparedStatement.setInt(1, ProductStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return convertResultSetToProduct(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findByProductName(String productName) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.PRODUCT_SELECT_BY_NAME);
            preparedStatement.setInt(1, ProductStatus.ACTIVE.getValue());
            preparedStatement.setString(2, productName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return convertResultSetToProduct(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Product convertResultSetToProduct(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(SqlConstant.PRODUCT_FIELD_ID);
            String name = resultSet.getString(SqlConstant.PRODUCT_FIELD_NAME);
            String thumbnail = resultSet.getString(SqlConstant.PRODUCT_FIELD_THUMBNAIL);
            Double price = resultSet.getDouble(SqlConstant.PRODUCT_FIELD_PRICE);
            int categoryId = resultSet.getInt(SqlConstant.PRODUCT_FIELD_CATEGORY_ID);
            String description = resultSet.getString(SqlConstant.PRODUCT_FIELD_DESCRIPTION);
            String detail = resultSet.getString(SqlConstant.PRODUCT_FIELD_DETAIL);
            int status = resultSet.getInt(SqlConstant.PRODUCT_FIELD_STATUS);
            LocalDateTime createdAt = resultSet.getTimestamp(SqlConstant.FIELD_CREATED_AT).toLocalDateTime();
            LocalDateTime updatedAt = resultSet.getTimestamp(SqlConstant.FIELD_UPDATED_AT).toLocalDateTime();
            LocalDateTime deletedAt = null;
            Timestamp timestamp = resultSet.getTimestamp(SqlConstant.FIELD_DELETED_AT);
            if (timestamp != null) {
                deletedAt = timestamp.toLocalDateTime();
            }
            int createdBy = resultSet.getInt(SqlConstant.FIELD_CREATED_BY);
            int updatedBy = resultSet.getInt(SqlConstant.FIELD_UPDATED_BY);
            int deletedBy = resultSet.getInt(SqlConstant.FIELD_DELETED_BY);
//            return Product.ProductBuilder.aProduct()
            Product Product = new Product(id, name, thumbnail, price, categoryId, description, detail, ProductStatus.of(status));
            Product.setCreatedAt(createdAt);
            Product.setUpdatedAt(updatedAt);
            Product.setDeletedAt(deletedAt);
            Product.setCreatedBy(createdBy);
            Product.setUpdatedBy(updatedBy);
            Product.setDeletedBy(deletedBy);
            return Product;
        } catch (SQLException ex) {
            return null;
        }
    }
}
