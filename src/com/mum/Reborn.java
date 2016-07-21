package com.mum;

import static com.mum.constant.IConstant.*;

import com.mum.db.init.Conn;
//import com.mum.db.init.Injection;
import com.mum.db.pojo.DbInfo;

/**
 * 
 * @author 王超
 */
public class Reborn {

	public static void main(String[] args) {
		try {
//			DbInfo dbInfo = new DbInfo();
//			dbInfo.setDriver(MYSQL_DRIVER);
//			dbInfo.setUrl(MYSQL_URL);
//			dbInfo.setUser(MYSQL_USER);
//			dbInfo.setPwd(MYSQL_PASSWORD);
//			
//			Conn conn = new Conn(dbInfo);
//			Injection injection = new Injection(conn, dbInfo);
//			injection.inject();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
