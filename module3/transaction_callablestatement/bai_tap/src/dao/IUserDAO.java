package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public void addUserTransaction(User user, int[] permision);

    public User selectUser(int id);
    List <User>  selectUserByCountry(String country);

    public List<User> selectAllUsers();
    public List<User>seeAllUsers();

    public boolean deleteUser(int id) throws SQLException;
    public boolean delteteProcedure(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
    public boolean updateUserProcedure(User user)throws SQLException;

    public User getUserById(int id);




}
