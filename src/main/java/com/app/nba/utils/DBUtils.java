package com.app.nba.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBUtils {

    private final String DB_URL = "jdbc:mysql://localhost:3306/javaexam?autoReconnect=true&useUnicode=true&serverTimezone=Asia/Seoul";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "naru";

    public PreparedStatement getConnection(String query) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        System.out.println("DBUtils getConn query : " + query);
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            pstmt = conn.prepareStatement(query);
            System.out.println("DBUtils getConn conn : " + conn);
            System.out.println("DBUtils getConn pstmt : " + pstmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pstmt;
    }
}
