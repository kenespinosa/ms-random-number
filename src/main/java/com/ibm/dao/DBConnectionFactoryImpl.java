package com.ibm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import com.ibm.properties.DatabaseProperties;

@Service
@Import(DatabaseProperties.class)
public class DBConnectionFactoryImpl implements DBConnectionFactory {
	
	@Autowired
	private DatabaseProperties db;
	
	public Connection getConnection() {
		
		System.out.println("Getting Connection using the following properties.");
		System.out.println("URL: " + db.getDatabaseUrl());
		System.out.println("Username: " + db.getDatabaseUsername());
		System.out.println("Password: " + db.getDatabasePassword());
		System.out.println("Driver: " + db.getDatabasePassword());
		
		try {
			Class.forName(db.getDriverName());
			Connection conn = DriverManager.getConnection(db.getDatabaseUrl(), db.getDatabaseUsername(),
					db.getDatabasePassword());
			return conn;
		} catch (ClassNotFoundException | SQLException io) {
			Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, io);
		} catch (Exception e) {
			Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	@Override
	public void closeConnection(Connection conn, PreparedStatement ps) {
		if (conn != null) {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("DATABASE ERROR: CLOSING");
			}
		}
	}
}