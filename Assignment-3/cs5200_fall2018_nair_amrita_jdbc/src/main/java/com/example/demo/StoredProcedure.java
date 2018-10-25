package com.example.demo;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.boot.SpringApplication;

public class StoredProcedure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.sql.Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		SpringApplication.run(hw_jdbc_last_first.class, args);
		
		try {
			CallableStatement statement= connection.prepareCall("{call getUnansweredQuestions() }");
			Boolean hasResult = statement.execute();
			if(hasResult) {
				ResultSet results=statement.getResultSet();
				while(results.next()) {
					int questionId= results.getInt("question_id");
					int count= results.getInt("Max(COUNT)");
					String questionText = results.getString("text");
					System.out.println(questionText+ " : "+count+"\n");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			CallableStatement statement= connection.prepareCall("{call endorsedUsersForWeek(?,?) }");
			
			Calendar calendar = Calendar.getInstance();
			java.util.Date utilDate = new java.util.Date();
			Date firstDate=new Date(utilDate.getTime());
			calendar.setTime(firstDate);
			calendar.add(Calendar.DAY_OF_YEAR,7);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			java.sql.Date lastDate = new java.sql.Date(calendar.getTimeInMillis());
			
			statement.setDate(1, firstDate);
			statement.setDate(2, lastDate);
			
			Boolean hasResult = statement.execute();
			if(hasResult) {
				ResultSet results=statement.getResultSet();
				while(results.next()) {
					int userId= results.getInt("user_id");
					String userName = results.getString("posted_by");
					System.out.println(userId+ " : "+userName+"\n");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
