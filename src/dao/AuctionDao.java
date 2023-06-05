package dao;

import exception.DaoException;
import model.Auction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuctionDao {
    public void addAuctionDetails(int userId, Auction auction) throws DaoException {
        try {
            String sql = "INSERT INTO auction(title, minimum_bid_price, start_date, end_date, seller_id, product_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, auction.getTitle());
            preparedStatement.setDouble(2, auction.getMinimumBidPrice());
            preparedStatement.setString(3, auction.getStartDate());
            preparedStatement.setString(4, auction.getEndDate());
            preparedStatement.setInt(5, userId);
            preparedStatement.setInt(6, auction.getProductId());
            preparedStatement.executeUpdate();
        } catch (SQLException se) {
            throw new DaoException("oops something went wrong", se);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
    }

    //showAuction(),
    public List<Auction> getAuction(int userId) throws DaoException {
        List<Auction> auctions = new ArrayList<>();
        try {
            String query = "select * from auction where seller_id=?";
            PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Integer auctionId = resultSet.getInt("auction_id");
                String title = resultSet.getString("title");
                int minimumBidPrice = resultSet.getInt("minimum_bid_price");
                Auction auction = new Auction(auctionId, title, minimumBidPrice);
                auctions.add(auction);
            }
        } catch (SQLException e) {
            throw new DaoException("oops something went wrong", e);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
        return auctions;
    }

    public Auction showAuctionDetails(int auctionId) throws DaoException {
        Auction auction = null;
        try {
            String query1 = "select * from auction where auction_id=?";
            PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query1);
            stmt.setInt(1, auctionId);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                auction = new Auction();
                auction.setAuctionId(resultSet.getInt(1));
                auction.setTitle(resultSet.getString(2));
                auction.setProductId(resultSet.getInt(3));
                auction.setMinimumBidPrice(resultSet.getDouble(4));
                auction.setStartDate(resultSet.getString(5));
                auction.setEndDate(resultSet.getString(6));
                auction.setSellerId(resultSet.getInt(7));
            }
            return auction;
        } catch (SQLException e) {
            throw new DaoException("oops something went wrong", e);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
    }

//    public void editAuctionDetails(EditProductsDetails editProductsDetails) throws DaoException {
//        try {
//            String sql1 = "UPDATE auction set title = ?, minimum_bid_price = ?, start_date = ?, end_date = ? where auction_id= ?";
//            PreparedStatement ps1 = DbConnection.getInstance().getConnection().prepareStatement(sql1);
//            ps1.setString(1, editProductsDetails.getProductname());
//            ps1.setString(2, editProductsDetails.getProductcategory());
//            ps1.setString(3, editProductsDetails.getProductdescription());
//            ps1.setInt(4, editProductsDetails.getProductid());
//            ps1.executeUpdate();
//        } catch (SQLException e) {
//            throw new DaoException("oops something went wrong", e);
//        } catch (Exception e) {
//            throw new DaoException("oops something went wrong", e);
//        }
//    }
//    public void removeAuction() throws DaoException {
//        try {
//            String sql2 = "DELETE FROM product where product_id= ?";
//            PreparedStatement ps2 = DbConnection.getInstance().getConnection().prepareStatement(sql2);
//            ps2.setInt(1, product.getProductid());
//            ps2.executeUpdate();
//        } catch (SQLException e) {
//            throw new DaoException("oops something went wrong", e);
//        } catch (Exception e) {
//            throw new DaoException("oops something went wrong", e);
//        }
//    }
}
