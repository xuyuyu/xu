package com.offcn.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {

    private static ComboPooledDataSource ds;

    public static DataSource getDataSource() {

        ds = new ComboPooledDataSource();
        return ds;
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {

            DataSource ds = getDataSource();
            conn = ds.getConnection();


        }catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(ResultSet rs,Statement st,Connection conn) {
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if(st!=null) {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}

