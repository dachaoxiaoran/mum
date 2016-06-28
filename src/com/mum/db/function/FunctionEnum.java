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
	 * HEX(N) 返回十六进制值N一个字符串的表示，在此N是一个长整型(BIGINT)数字，如果N是NULL，返回NULL。 
	 */
	HEX,
	
	/**
	 * 返回arg的长度。 
	 */
	LENGTH,
	
	/**
	 * 返回arg的长度。 
	 */
	OCTET_LENGTH,
	
	/**
	 * 返回arg的长度。 
	 */
	CHAR_LENGTH,
	
	/**
	 * 返回arg的长度。 
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
	LOAD_FILE
	;
}
