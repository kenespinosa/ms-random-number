package com.ibm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.model.Dice;
import com.ibm.model.RandomNumberConstants;

public class NumberDao {
	public void insertDice(List<Dice> d) {
		String query = "INSERT INTO random_number(dice1, dice2, dice3, timestamp) VALUES(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(RandomNumberConstants.DATE_TIME_FORMAT);
		DBConnectionFactory myFactory = new DBConnectionFactoryImpl();
		
		try {
			conn = myFactory.getConnection();

			if (conn != null) {
				int i = 1;
				pstmt = conn.prepareStatement(query);

				pstmt.setInt(i++, d.get(0).getValue());
				pstmt.setInt(i++, d.get(1).getValue());
				pstmt.setInt(i++, d.get(2).getValue());
				pstmt.setString(i++, sdf.format(dt));
				pstmt.executeUpdate();
			}
		} catch (SQLException ex) {
			Logger.getLogger(NumberDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			myFactory.closeConnection(conn, pstmt);
		}
	}
}