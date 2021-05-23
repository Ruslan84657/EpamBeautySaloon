package net.epamproj.service;

import net.epamproj.bl.Util;
import net.epamproj.dao.UserDAO;
import net.epamproj.model.Master;
import net.epamproj.model.Services;
import net.epamproj.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserService extends Util implements UserDAO {
//    private final Logger logger = Logger.getLogger(getClass());

    @Override
    public void insertUser(User user) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)){
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Ошибка регистрации пользователя!!!");
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteUser(int id) throws SQLException{
        boolean isDeleted;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);){
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        }
        return isDeleted;
    }

    @Override
    public List<Master> selectAllMasters() {
        List<Master> masters = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MASTERS);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                masters.add(new Master(id, firstName, lastName));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return masters;
    }

    @Override
    public List<User> selectMasterTimetable(int id1) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MASTERS_TIMETABLE)){
            preparedStatement.setInt(1, id1);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String login = rs.getString("login");

                users.add(new User(id, firstName, lastName, login));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Map<Integer, Services> selectAllServices() {
        Map<Integer, Services> servicesMap = new LinkedHashMap<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                for (Services s : Services.values()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    servicesMap.put(s.getId(), s);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return servicesMap;
    }

    @Override
    public void serviceRegistration(int id1, int id2, int id3) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REGISTRATION_FOR_SERVICE)) {
            preparedStatement.setInt(1, id1);
            preparedStatement.setInt(2, id2);
            preparedStatement.setInt(3, id3);
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectUserService(int id1) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_REGISTRATION)){
            preparedStatement.setInt(1, id1);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String login = rs.getString("login");

                users.add(new User(id, firstName, lastName, login));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void cancelServiceRegistration(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CANCEL_CLIENT_REGISTRATION)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
