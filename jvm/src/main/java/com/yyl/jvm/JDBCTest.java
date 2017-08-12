package com.yyl.jvm;

import java.sql.*;

/**
 * Created by yuanyunl on 2017/8/7.
 */
public class JDBCTest {
    public static final String url = "jdbc:oracle:thin:@(DESCRIPTION =\n" +
            "\t\t\t(ADDRESS = (PROTOCOL = TCP)(HOST = eitracp-scan01.eit.ssn.hp.com)(PORT= 1521))\n" +
            "\t\t\t\t(CONNECT_DATA =\n" +
            "\t\t\t\t(SERVER = DEDICATED)\n" +
            "\t\t\t\t(SERVICE_NAME = EESLEIT_ESLAPPL)\n" +
            "\t\t\t\t(FAILOVER_MODE =\n" +
            "\t\t\t\t(TYPE = SELECT)\n" +
            "\t\t\t\t(METHOD = BASIC)\n" +
            "\t\t\t\t(RETRIES = 60)\n" +
            "\t\t\t\t(DELAY = 5)\n" +
            "\t\t\t\t)\n" +
            "\t\t\t)\n" +
            "\t\t)";
    public static final String name = "oracle.jdbc.driver.OracleDriver";
    public static final String user = "esl";
    public static final String password = "m0d3sl";


    public static void main(String[] args){
        StringBuilder builder=new StringBuilder();
        StringBuffer buffer=new StringBuffer();
        try {
            Class.forName(name);
            Connection connection= DriverManager.getConnection(url,user,password);
            Statement stmt = connection.createStatement();
            String sql="select * from server s where system_id=27909";
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                Integer id=rs.getInt("SYSTEM_ID");
                String primary_name=rs.getString("PRIMARY_NAME");
                String domain=rs.getString("ARPA_DOMAIN");
                System.out.println(primary_name+"."+domain);
            }
            connection.close();;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
