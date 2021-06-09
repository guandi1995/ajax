package com.ajax.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * JDBC utils with executeQuery() and executeUpdate() methods
 *
 * @author Di Guan on 5/18/2021 11:11 PM
 */

public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static Connection connection;


    private JDBCUtils(){}

    //Driver Register
    static {
        try {
            //读取配置文件
            InputStream resourceAsStream = JDBCUtils.class.getResourceAsStream("/database.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            url = (String) properties.get("database.url");
            user = (String) properties.get("database.user");
            password = (String) properties.get("database.password");
            String className = (String) properties.get("database.className");
            Class.forName(className);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * executeUpdate the SQL syntax and Object...objects
     * @param SQL
     * @param objects
     * @return
     * @throws SQLException
     */
    public static int executeUpdate(String SQL, Object...objects) throws SQLException {
        //获取数据库连接connection
        connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement=null;
        try {
            //调用connection的prepareStatement()方法获取SQL执行对象preparedStatement
            preparedStatement = connection.prepareStatement(SQL);
            //调用preparedStatement的setObject()方法给?占位符进行赋值
            if (objects != null && objects.length > 0){
                for (int i = 0; i < objects.length; i++) {
                    preparedStatement.setObject(i+1, objects[i]);
                }
            }
            //调用preparedStatement的executeUpdate()方法执行SQL语句
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw throwables;
        }finally {
            //释放资源
            JDBCUtils.close(connection,preparedStatement);
        }
    }

    /**
     * executeQuery the SQL syntax and Object...objects
     * @param SQL
     * @param objects
     * @return List<Map>
     */
    public static List<Map> executeQuery(String SQL, Object...objects){
        //获取数据库连接connection
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Map> resultList = new ArrayList<>();
        try {
            //调用connection的prepareStatement()方法获取SQL执行对象preparedStatement
            preparedStatement = connection.prepareStatement(SQL);
            //调用preparedStatement的setObject()方法给?占位符进行赋值
            if (objects != null && objects.length > 0){
                for (int i = 0; i < objects.length; i++) {
                    preparedStatement.setObject(i+1, objects[i]);
                }
            }
            //调用preparedStatement的executeQuery()方法执行SQL语句
            resultSet = preparedStatement.executeQuery();
            //处理resultSet结果集，将columnName和对应的值封装到List<Map>集合中，并返回
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()){
                HashMap<Object, Object> map = new HashMap<>();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    map.put(metaData.getColumnName(i+1), resultSet.getObject(i+1));
                }
                resultList.add(map);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables);
        }finally {
            //释放资源
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return resultList;
    }

    /**
     * get the connection to database
     * @return return Connection object
     */
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Fail to connect database");
        }
        return connection;
    }

    /**
     * close the resource for the operation of query with resultSet
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        closeResultSet(resultSet);
        closeStatement(statement);
        closeConnection(connection);
    }

    /**
     * close the resource for the operation of updates without resultSet
     * @param connection
     * @param statement
     */
    public static void close(Connection connection, Statement statement){
        closeStatement(statement);
        closeConnection(connection);
    }

    public static void closeResultSet(ResultSet resultSet){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
