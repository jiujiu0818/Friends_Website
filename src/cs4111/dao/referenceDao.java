package cs4111.dao;


import cs4111.form.referenceForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

public class referenceDao {

    public List queryReference(referenceForm form, int page, int pageSize) throws Exception {
        List<referenceForm> list = new ArrayList();
        int num1 = pageSize * (page - 1) + 1;
        int num2 = num1 + (pageSize - 1);

        try {
            //connnect
    		Connection conn = null; 
    		ResultSet rset = null; 
    		String error_msg = ""; 
    		try {
    		OracleDataSource ods = new OracleDataSource();
    		ods.setURL("jdbc:oracle:thin:qj2131/YddgaHVC@//w4111f.cs.columbia.edu:1521/ADB"); 
    		conn = ods.getConnection();
    		Statement stmt = conn.createStatement();
            String sql = "select * " +
                    "from quizzes_reference ";
            if(form.getQuiz_no()!=null&&!form.getQuiz_no().equals("")){
                sql+="where quiz_no = '"+form.getQuiz_no()+"'";
            }
            System.out.println(sql);
    		rset = stmt.executeQuery(sql);
    		} catch (SQLException e) 
    		{ 
    		error_msg = e.getMessage(); if( conn != null ) {
    		conn.close();
    		}
    		}
    		
            while (rset.next()) {
            	referenceForm tempForm = new referenceForm();
                tempForm.setQuiz_no(judgeNull(rset.getString(1)));
                tempForm.setCharacter_name(judgeNull(rset.getString(2)));
                tempForm.setMusic_name(judgeNull(rset.getString(3)));
                tempForm.setEp_id(judgeNull(rset.getString(4)));
                list.add(tempForm);
            }
            
    		if( conn != null ) {
    			conn.close();
    		}
            return list;
            
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

