package by.zhenekns.dao.database;

class DatabaseProperties {
    static String URL = "jdbc:mysql://localhost:3306/servlet_db?serverTimezone=Europe/Moscow";
    static String USERNAME = "admin_zhenekns";
    static String PASSWORD = "em50475047";
    static String DRIVER = "com.mysql.cj.jdbc.Driver";


    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        DatabaseProperties.URL = URL;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static void setUSERNAME(String USERNAME) {
        DatabaseProperties.USERNAME = USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        DatabaseProperties.PASSWORD = PASSWORD;
    }

    public static String getDRIVER() {
        return DRIVER;
    }

    public static void setDRIVER(String DRIVER) {
        DatabaseProperties.DRIVER = DRIVER;
    }
}
