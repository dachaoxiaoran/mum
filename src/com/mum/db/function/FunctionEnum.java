package com.mum.db.function;

/**
 * 函数枚举
 * @author 王超
 */
public enum FunctionEnum {
	
	/**
	 * ASCII(arg) 返回arg的最左面字符的ASCII代码值。如果arg是空字符串，返回0。如果str是NULL，返回NULL。 
	 */
	ASCII,
	
	/**
	 * ORD(arg) 如果arg最左面字符是一个多字节字符，通过以格式((first byte ASCII code)*256+(second byte ASCII code))[*256+third byte ASCII code...]返回字符的ASCII代码值来返回多字节字符代码。如果最左面的字符不是一个多字节字符。返回与ASCII()函数返回的相同值。
	 */
	ORD,
	
	/**
	 * BIN(N) 返回二进制值N的一个字符串表示，在此N是一个长整数(BIGINT)数字，如果N是NULL，返回NULL。 
	 */
	BIN,
	
	/**
	 * OCT(N) 返回八进制值N的一个字符串的表示，在此N是一个长整型数字，如果N是NULL，返回NULL。 
	 */
	OCT,
	
	/**
	 * 如果arg是一个数字，则返回一个 十六进制值arg的 字符串表示，在这里， arg是一个longlong (BIGINT) 数。如果arg是一个字符串，则返回值为一个arg的十六进制字符串表示，其中每个arg里的每个字符被转化为两个十六进制数字。如果arg是NULL，返回NULL
	 */
	HEX,
	
	/**
	 * 返回arg的长度。单位为字节。一个多字节字符算作多字节
	 */
	LENGTH,
	
	/**
	 * 返回arg的长度。单位为字节。一个多字节字符算作多字节
	 */
	OCTET_LENGTH,
	
	/**
	 * 返回arg的长度，长度的单位为字符。一个多字节字符算作一个单字符
	 */
	CHAR_LENGTH,
	
	/**
	 * 返回arg的长度，长度的单位为字符。一个多字节字符算作一个单字符
	 */
	CHARACTER_LENGTH,
	
	/**
	 * 返回删除了其前置空格字符的arg。 
	 */
	LTRIM,
	
	/**
	 * 返回删除了其拖后空格字符的arg。
	 */
	RTRIM,
	
	/**
	 * 返回arg的一个同音字符串。听起来“大致相同”的2个字符串应该有相同的同音字符串。一个“标准”的同音字符串长是4个字符，但是SOUNDEX()函数返回一个任意长的字符串。你可以在结果上使用SUBSTRING()得到一个“标准”的 同音串。所有非数字字母字符在给定的字符串中被忽略。所有在A-Z之外的字符国际字母被当作元音。 
	 */
	SOUNDEX,
	
	/**
	 * 返回由N个空格字符组成的一个字符串。 
	 */
	SPACE,
	
	/**
	 * 返回颠倒字符顺序的字符串str。
	 */
	REVERSE,
	
	/**
	 * 返回字符串str，根据当前字符集映射(缺省是ISO-8859-1 Latin1)把所有的字符改变成小写。 
	 */
	LCASE,
	
	/**
	 * 返回字符串str，根据当前字符集映射(缺省是ISO-8859-1 Latin1)把所有的字符改变成小写。 
	 */
	LOWER,
	
	/**
	 * 返回字符串str，根据当前字符集映射(缺省是ISO-8859-1 Latin1)把所有的字符改变成大写。
	 */
	UCASE,
	
	/**
	 * 返回字符串str，根据当前字符集映射(缺省是ISO-8859-1 Latin1)把所有的字符改变成大写。
	 */
	UPPER,
	
	/**
	 * 读入文件并且作为一个字符串返回文件内容。文件必须在服务器上，你必须指定到文件的完整路径名，而且你必须有file权限。文件必须所有内容都是可读的并且小于max_allowed_packet。如果文件不存在或由于上面原因之一不能被读出，函数返回NULL。 
	 */
	LOAD_FILE,
	
	/**
	 * 返回日期date的星期索引(1=星期天，2=星期一, ……7=星期六)
	 */
	DAYOFWEEK,
	
	/**
	 * 返回date的星期索引(0=星期一，1=星期二, ……6= 星期天)
	 */
	WEEKDAY,
	
	/**
	 * 返回date的月份中日期，在1到31范围内
	 */
	DAYOFMONTH,
	
	/**
	 * 返回date在一年中的日数, 在1到366范围内
	 */
	DAYOFYEAR,
	
	/**
	 * 返回date的月份，范围1到12
	 */
	MONTH,
	
	/**
	 * 返回date的星期名字
	 */
	DAYNAME,
	
	/**
	 * 返回date的月份名字
	 */
	MONTHNAME,
	
	/**
	 * 返回date一年中的季度，范围1到4
	 */
	QUARTER,
	
	/**
	 * 返回date的年份，范围在1000到9999
	 */
	YEAR,
	
	/**
	 * 返回time的小时，范围是0到23
	 */
	HOUR,
	
	/**
	 * 返回time的分钟，范围是0到59
	 */
	MINUTE,
	
	/**
	 * 返回time的秒数，范围是0到59
	 */
	SECOND,
	
	/**
	 * 给出一个日期date，返回一个天数(从0年的天数)
	 */
	TO_DAYS,
	
	/**
	 * 给出一个天数N，返回一个DATE值
	 */
	FROM_DAYS,
	
	/**
	 * 以'YYYY-MM-DD HH:MM:SS'或YYYYMMDDHHMMSS格式返回unix_timestamp参数所表示的值，取决于函数是在一个字符串还是或数字上下文中被使用
	 */
	FROM_UNIXTIME,
	
	/**
	 * 返回seconds参数，变换成小时、分钟和秒，值以'HH:MM:SS'或HHMMSS格式化，取决于函数是在一个字符串还是在数字上下文中被使用
	 */
	SEC_TO_TIME,
	
	/**
	 * 返回time参数，转换成秒
	 */
	TIME_TO_SEC,
	
	/**
	 * 压缩一个字符串。这个函数要求 MySQL已经用一个诸如zlib的压缩库压缩过。否则，返回值始终是 NULL
	 */
	COMPRESS,
	
	/**
	 * 引证一个字符串，由此产生一个在SQL语句中可用作完全转义数据值的结果。 返回的字符串由单引号标注，每例都带有单引号 (‘'’) 、 反斜线符号 (‘\’) 、 ASCII NUL以及前面有反斜线符号的Control-Z。如果自变量的值为NULL, 则返回不带单引号的单词 “NULL” 。
	 */
	QUOTE
	;
}
