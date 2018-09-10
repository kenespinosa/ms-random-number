package com.ibm.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseProperties {

	@Value("${use.database}")
	private String useDatabase;

	@Value("${db.drivername}")
	private String driverName;

	@Value("${db.mysql.url}")
	private String databaseUrl;

	@Value("${db.mysql.username}")
	private String databaseUsername;

	@Value("${db.mysql.password}")
	private String databasePassword;

	
	public String getUseDatabase() {
		return useDatabase;
	}

	public void setUseDatabase(String useDatabase) {
		this.useDatabase = useDatabase;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	public String getDatabaseUsername() {
		return databaseUsername;
	}

	public void setDatabaseUsername(String databaseUsername) {
		this.databaseUsername = databaseUsername;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}
}
