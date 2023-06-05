package dao;

import exception.DaoException;
import model.ProductCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public List<ProductCategory> showCategory() throws DaoException {
        List<ProductCategory> productCategoryList = new ArrayList<>();
        try {
            String query = "select * from product_category";
            PreparedStatement stmt4 = DbConnection.getInstance().getConnection().prepareStatement(query);
            ResultSet resultSet1 = stmt4.executeQuery();
            while (resultSet1.next()) {
                Integer productCategoryId = resultSet1.getInt("product_category_id");
                String categoryName = resultSet1.getString("category_name");
                ProductCategory productCategory = new ProductCategory(productCategoryId, categoryName);
                productCategoryList.add(productCategory);
            }
        } catch (SQLException e) {
            throw new DaoException("oops something went wrong", e);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
        return productCategoryList;
    }
}
