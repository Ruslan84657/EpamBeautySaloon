package net.epamproj.servlets;

import net.epamproj.model.Master;
import net.epamproj.model.Services;
import net.epamproj.model.User;
import net.epamproj.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(getClass());

    private static final long serialVersionUID = 1L;
    private UserService service = new UserService();

    public UserServlet() {
    }

    public UserServlet(UserService userService) {
        this.service = userService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(req, resp);
                break;
            case "/select_service":
                try {
                    serviceList(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/select_master":
                try {
                    masterList(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/insert":
                try {
                    insertUser(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete":
                try {
                    deleteUser(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/service_registration":
                try {
                    serviceRegistration(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/select_registration":
                try {
                    selectRegistration(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/cancel_registration":
                try {
                    cancelRegistration(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/select_timetable":
                try {
                    selectTimetable(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                defaultForm(req, resp);
                break;
        }
    }

    private void defaultForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("guest-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("guest-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (first_name.isEmpty() || last_name.isEmpty() || login.isEmpty() ||
                password.isEmpty()) {
            RequestDispatcher req = request.getRequestDispatcher("guest-form.jsp");
            req.include(request, response);
        } else {
            User newUser = new User(first_name, last_name, login, password);
            service.insertUser(newUser);
            RequestDispatcher req = request.getRequestDispatcher("user-form.jsp");
            req.forward(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteUser(id);
        response.sendRedirect("/");
    }

    private void serviceList(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        Map<Integer, Services> serviceList = service.selectAllServices();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service-list.jsp");
        dispatcher.forward(request, response);
    }

    private void masterList(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        List<Master> masterList = service.selectAllMasters();
        request.setAttribute("masterList", masterList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("master-list.jsp");
        dispatcher.forward(request, response);
    }

    private void serviceRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id1 = Integer.parseInt(request.getParameter("id"));
        int id2 = Integer.parseInt(request.getParameter("id"));
        int id3 = Integer.parseInt(request.getParameter("id"));
        service.serviceRegistration(id1, id2, id3);
        response.sendRedirect("/");
    }

    private void selectRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<User> userReg = service.selectUserService(id);
        request.setAttribute("userReg", userReg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("registered_user_service.jsp");
        dispatcher.forward(request, response);
    }

    private void cancelRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.cancelServiceRegistration(id);
        response.sendRedirect("/");
    }

    private void selectTimetable(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<User> userRegList = service.selectMasterTimetable(id);
        request.setAttribute("userRegList", userRegList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("master-timetable.jsp");
        dispatcher.forward(request, response);
    }
}
