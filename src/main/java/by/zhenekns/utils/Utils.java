package by.zhenekns.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {
    public static ResultSet getDataFromTable(Statement statement, String table, String data) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT " + data + " FROM " + table);
        } catch (SQLException e) {
            System.out.println("Sql request is incorrect");
        }
        return resultSet;
    }
    public static boolean isDataExistsInDatabase(ResultSet resultSet, String columnName, String data) throws Exception {
        if(resultSet == null){
            throw new Exception("Result set can't be null!");
        }
        while (resultSet.next()){
            if(resultSet.getString(columnName).equals(data)){
                return false;
            }
        }
        return true;
    }
}
