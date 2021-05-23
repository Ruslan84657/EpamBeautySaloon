package net.epamproj.dao;

import net.epamproj.model.Master;
import net.epamproj.model.Services;
import net.epamproj.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDAO {

    //INSERT_CLIENT_SQL
    void insertUser(User user);

    //DELETE_CLIENT_SQL
    boolean deleteUser(int id) throws SQLException;

    //SELECT_ALL_MASTERS
    List<Master> selectAllMasters();

    //SELECT_MASTERS_TIMETABLE
    List<User> selectMasterTimetable(int id1);

    //SELECT_ALL_SERVICES
//    List<Services> selectAllServices();
    Map<Integer, Services> selectAllServices();

    //REGISTRATION_FOR_SERVICE
    void serviceRegistration(int id1, int id2, int id3);

    //SELECT_CLIENT_REGISTRATION
    List<User> selectUserService(int id1);

    //CANCEL_CLIENT_REGISTRATION
    void cancelServiceRegistration(int id);
}