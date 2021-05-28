package by.zhenekns.controller;

import by.zhenekns.dao.DAOFactory;
import by.zhenekns.dao.database.DatabaseDAO;
import by.zhenekns.dao.user.UserDAO;
import by.zhenekns.entity.User;
import by.zhenekns.utils.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegistrationController extends HttpServlet {
    private User user;
    private static final String URL = "jdbc:mysql://localhost:3306/servlet_db?autoReconnect=true&useSSL=FALSE&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "admin_zhenekns";
    private static final String PASSWORD = "em50475047";
    private DAOFactory daoFactory = DAOFactory.getInstance();
    private UserDAO userDAO = daoFactory.getUserDAO();
    private DatabaseDAO databaseDAO = daoFactory.getDatabaseDAO();

    @Override
    public void init() throws ServletException {
        super.init();
        user = new User("", "", "");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String nickname = req.getParameter("nickname");
        String password = req.getParameter("password");
        user = new User(email, nickname, password);
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = Utils.getDataFromTable(statement, "users", "user_nickname");
            if(!Utils.isDataExistsInDatabase(resultSet,"user_nickname", nickname)){
                PrintWriter printWriter = resp.getWriter();
                printWriter.println("<h2>User is exists!</h2>");
                printWriter.close();
            }else{
                statement.addBatch("INSERT INTO users(user_email, user_nickname, user_password)" +
                        " VALUES ('" + email + "', '" + nickname + "', '" + password + "')");
                statement.executeBatch();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
        doGet(req, resp);
    }
}
