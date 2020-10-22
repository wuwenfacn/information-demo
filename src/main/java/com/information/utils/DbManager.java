package com.information.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/*
* 连接数据库及关流的工具类
* */
public class DbManager {
    private static volatile DbManager instance = null;
    private static DataSource ds;
    public static final String DB_PROPERTIES_NAME = "db.properties";
    static {
        try {
            InputStream ras = DbManager.class.getClassLoader().getResourceAsStream(DB_PROPERTIES_NAME);
            Properties properties = new Properties();
            properties.load(ras);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println("创建数据库连接池失败！");
            e.printStackTrace();
        }
    }
    public static DbManager getInstance(){
        if(instance == null){
            synchronized (DbManager.class){
                instance = new DbManager();
            }
        }
        return instance;
    }
    public Connection getConn(){
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (Exception e) {
            System.out.println("获取数据库连接失败！");
            e.printStackTrace();
        }
        return conn;
    }
    //关流
    public void close(AutoCloseable... closeables){
        for (AutoCloseable closeable:closeables) {
            if(closeable != null){
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
