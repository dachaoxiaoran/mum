package com.mum.constant;

public interface IConstant {
	
	
	String CONFIG_PROPERTIES = "/config.properties";
	
	
	String BEGIN_DATE = "beginDate";
	
	
	String HISTORY_URL = "http://bf.win007.com/ft.aspx?type=0&date=%s&Edition=1&lang=0&ad=360%%E7%%9B%%B4%%E6%%92%%AD%%E7%%BD?&adurl=http://gg.360-bo.com/gg.php?id=1000&color=F0F0E0&sound=0";

	
	String TABLE = "table";
	
	
	String EMPTY = "";
	
	
	String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	
	
	String MYSQL_URL = "jdbc:mysql://localhost/mum";
	
	
	String MYSQL_USER = "root";
	
	
	String MYSQL_PASSWORD = "root";
	
	
	String SHOW_TABLES = "SHOW TABLES";
	
	
	String TABLES_IN_MUM = "Tables_in_mum";
	
	
	String FIELD = "Field";
	
	
	String TYPE = "Type";
	
	
	String COLLATION = "Collation";
	
	
	String NULL = "Null";
	
	
	String KEY = "Key";
	
	
	String DEFAULT = "Default";
	
	
	String EXTRA = "Extra";
	
	
	String PRIVILEGES = "Privileges";
	
	
	String COMMENT = "Comment";
	
	
	String SHOW_FIELDS = "SHOW FULL FIELDS FROM %s";
	
	
	String SHOW_FOREIGNS = "SELECT * FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE REFERENCED_TABLE_NAME = ?";
	
	
	String MASTER_TABLE_NAME = "REFERENCED_TABLE_NAME";
	
	
	String MASTER_FIELD_NAME = "REFERENCED_COLUMN_NAME";
	
	
	String SUBJECT_TABLE_NAME = "TABLE_NAME";
	
	
	String SUBJECT_FIELD_NAME = "COLUMN_NAME";
	
	
	String PRIMARY_KEY = "PRI";
	
	
	
	
	
	String UPDATE_CONFIG_BEGINDATE = "UPDATE config SET beginDate = ?";
	
	
	String INSERT_GAME = "INSERT INTO game(name) SELECT ? FROM DUAL WHERE NOT EXISTS(SELECT name FROM game WHERE name = ?)";
	
	
	String INSERT_STATE = "INSERT INTO state(name) SELECT ? FROM DUAL WHERE NOT EXISTS(SELECT name FROM state WHERE name = ?)";
	
	
	String INSERT_TEAM = "INSERT INTO team(name) SELECT ? FROM DUAL WHERE NOT EXISTS(SELECT name FROM team WHERE name = ?)";
	
	
	String INSERT_RACE = "INSERT INTO race(gameId, stateId, principalTeamId, subordinateTeamId, principalTeamScore, subordinateTeamScore, halfPrincipalTeamScore, halfSubordinateTeamScore, dateTime) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
