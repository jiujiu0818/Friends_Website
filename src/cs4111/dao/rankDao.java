package cs4111.dao;


import cs4111.form.rankForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

public class rankDao {

    public List queryRank(rankForm form, int page, int pageSize) throws Exception {
        List<rankForm> list = new ArrayList();
        int num1 = pageSize * (page - 1) + 1;
        int num2 = num1 + (pageSize - 1);

        try {
            //connnect
        	//-----------------------------character------------------------
    		Connection conn = null; 
    		ResultSet rset = null; 
    		Statement stmt = null;
    		String error_msg = ""; 
    		try {
    		OracleDataSource ods = new OracleDataSource();
    		ods.setURL("jdbc:oracle:thin:qj2131/YddgaHVC@//w4111f.cs.columbia.edu:1521/ADB"); 
    		conn = ods.getConnection();
    		stmt = conn.createStatement();
    		
            String sql = "select * " +
                    "from user_ranks_character ";
            if(form.getUsername()!=null&&!form.getUsername().equals("")){
                sql+="where user_name = '"+form.getUsername()+"'";
            }
            System.out.println(sql);
    		rset = stmt.executeQuery(sql);
    		} catch (SQLException e) 
    		{ 
    		error_msg = e.getMessage(); 
    		if( conn != null ) {
    		conn.close();
    		}
    		}
    		
            while (rset.next()) {
            	rankForm tempForm = new rankForm();
                tempForm.setUsername(judgeNull(rset.getString(1)));
                tempForm.setCharacter_name(judgeNull(rset.getString(2)));
                tempForm.setPionts(judgeNull(rset.getString(3)));
                list.add(tempForm);
            }
    		if( conn != null ) {
    			conn.close();
    		}
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        try {
        	//-----------------------------episode------------------------
            Connection conn1 = null; 
            ResultSet rset1 = null; 
            Statement stmt1 = null;
        	String error_msg1 = ""; 
        	try {
        	OracleDataSource ods1 = new OracleDataSource();
        	ods1.setURL("jdbc:oracle:thin:qj2131/YddgaHVC@//w4111f.cs.columbia.edu:1521/ADB"); 
        	conn1 = ods1.getConnection();
        	stmt1 = conn1.createStatement();
        	
            String sql = "select * " +
                    "from user_ranks_episode ";
            if(form.getUsername()!=null&&!form.getUsername().equals("")){
                sql+="where user_name = '"+form.getUsername()+"'";
            }
            System.out.println(sql);
        	rset1 = stmt1.executeQuery(sql);
        	} catch (SQLException e) 
        	{ 
        	error_msg1 = e.getMessage(); 
        	if( conn1 != null ) {
        	conn1.close();
        	}
        	}
        	
            while (rset1.next()) {
            	rankForm tempForm = new rankForm();
                tempForm.setUsername(judgeNull(rset1.getString(1)));
                tempForm.setEpisode_name(judgeNull(rset1.getString(2)));
                tempForm.setPionts(judgeNull(rset1.getString(3)));
                list.add(tempForm);
            }
        	if( conn1 != null ) {
        		conn1.close();
        	}
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        try {
        	 Connection conn2 = null; 
        	    ResultSet rset2 = null; 
        	    Statement stmt2 = null;
        		String error_msg2 = ""; 
        		//-----------------------------music------------------------
        		try {
        		OracleDataSource ods2 = new OracleDataSource();
        		ods2.setURL("jdbc:oracle:thin:qj2131/YddgaHVC@//w4111f.cs.columbia.edu:1521/ADB"); 
        		conn2 = ods2.getConnection();
        		stmt2 = conn2.createStatement();
        		
        	    String sql = "select * " +
        	            "from user_ranks_music ";
        	    if(form.getUsername()!=null&&!form.getUsername().equals("")){
        	        sql+="where user_name = '"+form.getUsername()+"'";
        	    }
        	    System.out.println(sql);
        		rset2 = stmt2.executeQuery(sql);
        		} catch (SQLException e) 
        		{ 
        		error_msg2 = e.getMessage(); 
        		if( conn2 != null ) {
        		conn2.close();
        		}
        		}
        		
        	    while (rset2.next()) {
        	    	rankForm tempForm = new rankForm();
        	        tempForm.setUsername(judgeNull(rset2.getString(1)));
        	        tempForm.setMusic_name(judgeNull(rset2.getString(2)));
        	        tempForm.setPionts(judgeNull(rset2.getString(3)));
        	        list.add(tempForm);
        	    }
        		if( conn2 != null ) {
        			conn2.close();
        		}
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        return list;
    	
    }
    public List giveMusicRank(rankForm form, int page, int pageSize) throws Exception {
        List<rankForm> list = new ArrayList();
        int num1 = pageSize * (page - 1) + 1;
        int num2 = num1 + (pageSize - 1);
        
        try {
        	 Connection conn2 = null; 
        	    ResultSet rset2 = null; 
        	    Statement stmt2 = null;
        		String error_msg2 = ""; 
        		//-----------------------------music------------------------
        		try {
        		OracleDataSource ods2 = new OracleDataSource();
        		ods2.setURL("jdbc:oracle:thin:qj2131/YddgaHVC@//w4111f.cs.columbia.edu:1521/ADB"); 
        		conn2 = ods2.getConnection();
        		stmt2 = conn2.createStatement();
        		
        	    String sql = "insert into user_ranks_music (user_name,music_name,POINTS_NUMBER) " +
        	            "values ";
        	    if(form.getUsername()!=null&&!form.getUsername().equals("")){
        	        sql+="('"+form.getUsername()+"',";
        	    }
        	    if(form.getMusic_name()!=null&&!form.getMusic_name().equals("")){
        	        sql+="'"+form.getMusic_name()+"',";
        	    }
        	    if(form.getPionts()!=null&&!form.getPionts().equals("")){
        	        sql+="'"+form.getPionts()+"')";
        	    }
        	    System.out.println(sql);
        		rset2 = stmt2.executeQuery(sql);
        		} catch (SQLException e) 
        		{ 
        		error_msg2 = e.getMessage(); 
        		if( conn2 != null ) {
        		conn2.close();
        		}
        		}
        		
        		if( conn2 != null ) {
        			conn2.close();
        		}
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        return list;
    	
    }
    
    public String judgeNull(String str) {
        if (str == null) {
            return "";
        } else {
            return str;
        }
    }

    
 }

