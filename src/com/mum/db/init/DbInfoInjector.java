package com.mum.db.init;

import com.mum.db.pojo.DbInfo;
import static com.mum.constant.IConstant.*;

/**
 * 初始化数据库信息
 * @author 王超
 */
public class DbInfoInjector {
	
	/**
	 * @see com.mum.db.pojo.DbInfo
	 */
	private DbInfo dbInfo;
	
	/**
	 * 初始化{@link #dbInfo}
	 */
	public DbInfoInjector() {
		dbInfo = new DbInfo();
		dbInfo.setDriver(MYSQL_DRIVER).setUrl(MYSQL_URL).setUser(MYSQL_USER).setPwd(MYSQL_PASSWORD);
	}

	/**
	 * 获得{@link #dbInfo}
	 * @return {@link #dbInfo}
	 */
	public DbInfo getDbInfo() {
		return dbInfo;
	}
}
