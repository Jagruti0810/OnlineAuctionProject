package dao;

import model.User;
import exception.DaoException;

import java.sql.*;

public class UserDao {
    public void addUserDetails(User user) throws DaoException {
        try {
            String query = "insert into users (user_name, mobile_no, email, address, password, verification_code, " +
                    "is_verified, role_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getMobileNo());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getVerificationCode());
            stmt.setBoolean(7, user.isVerified());
            stmt.setInt(8, user.getRoleId());
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new DaoException("oops something went wrong", se);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
    }

//    public boolean showUser(User user1) throws DaoException {
//        try {
//            String query2 = "select * from users where email = ? AND password = ?";
//            PreparedStatement ps = DbConnection.getInstance().getConnection().prepareStatement(query2);
//            ps.setString(1, user1.getEmail());
//            ps.setString(2, user1.getPassword());
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException e) {
//            throw new DaoException("oops something went wrong", e);
//        } catch (Exception e) {
//            throw new DaoException("oops something went wrong", e);
//        }
//    }

    public User getUserCredentials(String email, String password) throws DaoException {
        User user = null;
        try {
            String query3 = "select * from users u join role r on r.role_id=u.role_id where email = ? AND password = ?";
            PreparedStatement ps = DbConnection.getInstance().getConnection().prepareStatement(query3);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setMobileNo(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setAddress(rs.getString(5));
                user.setPassword(rs.getString(6));
                user.setVerificationCode(rs.getString(7));
                user.setVerified(rs.getBoolean(8));
                user.setRoleId(rs.getInt(9));
            }
            return user;
        } catch (SQLException e) {
            throw new DaoException("oops something went wrong", e);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
    }

    public boolean checkUserVerified(Boolean isVerified, String email) throws DaoException {
        try {
            String query = "UPDATE users SET is_verified = ? where email=?";
            PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setBoolean(1, isVerified);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("oops something went wrong", e);
        } catch (Exception e) {
            throw new DaoException("oops something went wrong", e);
        }
        return true;
    }
    //    public Role getRoleById(int roleId) throws SQLException {
//        String sql = "SELECT * FROM role WHERE roleId = ?";
//        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
//        try {
//            preparedStatement.setInt(1, roleId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                int roleID = resultSet.getInt("roleId");
//                String roleType = resultSet.getString("roleType");
//                return new Role(roleID, roleType);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public void UpdateUserByRole(int roleId, String email) throws DaoException {
//        try {
//            String query = "update users set role_id=? where email=?";
//            PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
//            preparedStatement.setInt(1, roleId);
//            preparedStatement.setString(2, email);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new DaoException("oops something went wrong", e);
//        } catch (Exception e) {
//            throw new DaoException("oops something went wrong", e);
//        }
//    }
//    public User getRoleType(String email) throws DaoException {
//        User user = null;
//        try {
//            String query = "select r.role_type from role r join users u on r.role_id=u.role_id where u.email=?";
//            PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
//            preparedStatement.setString(1, email);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                user = new User();
//                user.setRoleType(resultSet.getString("role_type"));
//            }
//        } catch (SQLException e) {
//            throw new DaoException("oops something went wrong", e);
//        } catch (Exception e) {
//            throw new DaoException("oops something went wrong", e);
//        }
//        return user;
//    }
}




