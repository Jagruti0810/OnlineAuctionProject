package dao;

import exception.DaoException;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public void addProductDetails(Product product, int sellerId) throws DaoException {
        try {
            String query3 = "insert into product (product_name, description, seller_id, product_category_id) " +
                    "values (?, ?, ?, ?)";
            PreparedStatement stmt2 = DbConnection.getInstance().getConnection().prepareStatement(query3);
            stmt2.setString(1, product.getProductName());
            stmt2.setString(2, product.getProductDescription());
            stmt2.setInt(3, sellerId);
            stmt2.setInt(4, product.getProductCategoryId());
            stmt2.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("oops something went wrong", e);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
    }
    //showProducts
//    public List<Product> fetchRecordsFromDatabase() throws DaoException {
//        List<Product> products = new ArrayList<>();
//        try {
//            Statement stmt3 = DbConnection.getInstance().getConnection().createStatement();
//            ResultSet resultSet = stmt3.executeQuery("select * from product");
//            while (resultSet.next()) {
//                String productName = resultSet.getString("product_name");
//                int amount = resultSet.getInt("amount");
//                String category = resultSet.getString("category");
//                String description = resultSet.getString("description");
//                Product product = new Product(productName, amount, category, description);
//                products.add(product);
//            }
//        } catch (SQLException e) {
//            throw new DaoException("oops something went wrong", e);
//        } catch (Exception e) {
//            throw new DaoException("oops something went wrong", e);
//        }
//        return products;
//    }

    public List<Product> showProducts(int seller_id) throws DaoException {
        List<Product> products = new ArrayList<>();
        try {
            String query = "select * from product where seller_id = ?";
            PreparedStatement stmt4 = DbConnection.getInstance().getConnection().prepareStatement(query);
            stmt4.setInt(1, seller_id);
            ResultSet resultSet1 = stmt4.executeQuery();
            while (resultSet1.next()) {
                Integer productId = resultSet1.getInt("product_id");
                String productName = resultSet1.getString("product_name");
                String description = resultSet1.getString("description");
                Product product = new Product(productId, productName, description);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new DaoException("oops something went wrong", e);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
        return products;
    }

//    public List<Product> showProductsDescending(int seller_id) throws DaoException {
//        List<Product> products = new ArrayList<>();
//        try {
//            String query = "select * from product where seller_id = ?";
//            PreparedStatement stmt4 = DbConnection.getInstance().getConnection().prepareStatement(query);
//            stmt4.setInt(1, seller_id);
//            ResultSet resultSet1 = stmt4.executeQuery();
//            ResultSetMetaData metaData = resultSet1.getMetaData();
//            int columnCount = metaData.getColumnCount();
//            Object[][] data = new Object[columnCount][columnCount];
//            int rowCount = 0;
//            while (resultSet1.next()) {
//                Object[] row = new Object[columnCount];
//                for (int i = 1; i <= columnCount; i++) {
//                    row[i - 1] = resultSet1.getObject(i);
//                }
//                data[rowCount] = row;
//                rowCount++;
//                Integer productId = resultSet1.getInt("product_id");
//                String productName = resultSet1.getString("product_name");
//                String description = resultSet1.getString("description");
//                Product product = new Product(productId, productName, description);
//                products.add(product);
//            }
//            for (int i = rowCount - 1; i >= 0; i--) {
//                Object[] row = data[i];
//                for (Object value : row) {
//                    System.out.print(value + " ");
//                }
//                System.out.println();
//            }
//        } catch (SQLException e) {
//            throw new DaoException("oops something went wrong", e);
//        } catch (Exception e) {
//            throw new DaoException("oops something went wrong", e);
//        }
//        return products;
//    }


//    public List<Product> showProductDescending(int seller_id) throws DaoException {
//        List<Product> products = new ArrayList<>();
//        try {
//            String query = "select * from product where seller_id = ?";
//            PreparedStatement stmt5 = DbConnection.getInstance().getConnection().prepareStatement(query);
//            stmt5.setInt(1, seller_id);
//            ResultSet rs = stmt5.executeQuery();
//            while (rs.next()) {
//                String productName = rs.getString("product_name");
//                int amount = rs.getInt("amount");
//                String category = rs.getString("category");
//                String description = rs.getString("description");
//                Product product = new Product(productName, amount, category, description);
//                products.add(product);
//            }
//        } catch (SQLException e) {
//            throw new DaoException("oops something went wrong", e);
//        } catch (Exception e) {
//            throw new DaoException("oops something went wrong", e);
//        }
//        return products;
//    }

    public void editProductDetails(Product product) throws DaoException {
        try {
            String sql1 = "UPDATE product SET product_name = ?, description = ? where product_id = ?";
            PreparedStatement ps1 = DbConnection.getInstance().getConnection().prepareStatement(sql1);
            ps1.setString(1, product.getProductName());
            ps1.setString(2, product.getProductDescription());
            ps1.setInt(3, product.getProductId());
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("oops something went wrong", e);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
    }


    public void removeProduct(Product product) throws DaoException {
        try {
            String sql2 = "DELETE FROM product where product_id= ?";
            PreparedStatement ps2 = DbConnection.getInstance().getConnection().prepareStatement(sql2);
            ps2.setInt(1, product.getProductId());
            ps2.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("oops something went wrong", e);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
    }
}
