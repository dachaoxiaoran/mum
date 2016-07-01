package com.mum.db.function;

/**
 * 函数枚举，根据参数个数的不同，一个函数可能有多种调用方式。默认调用方式，优先级为：多参数>单参数>零参数>无参数
 * @author 王超
 */
public enum FunctionEnum {
	
	/**
	 * ASCII(arg) 返回arg的最左面字符的ASCII代码值。如果arg是空字符串，返回0。如果str是NULL，返回NULL。 
	 */
	ASCII("name"),
	
	/**
	 * ORD(arg) 如果arg最左面字符是一个多字节字符，通过以格式((first byte ASCII code)*256+(second byte ASCII code))[*256+third byte ASCII code...]返回字符的ASCII代码值来返回多字节字符代码。如果最左面的字符不是一个多字节字符。返回与ASCII()函数返回的相同值。
	 */
	ORD("name"),
	
	/**
	 * BIN(N) 返回二进制值N的一个字符串表示，在此N是一个长整数(BIGINT)数字，如果N是NULL，返回NULL。 
	 */
	BIN("name"),
	
	/**
	 * OCT(N) 返回八进制值N的一个字符串的表示，在此N是一个长整型数字，如果N是NULL，返回NULL。 
	 */
	OCT("name"),
	
	/**
	 * 如果arg是一个数字，则返回一个 十六进制值arg的 字符串表示，在这里， arg是一个longlong (BIGINT) 数。如果arg是一个字符串，则返回值为一个arg的十六进制字符串表示，其中每个arg里的每个字符被转化为两个十六进制数字。如果arg是NULL，返回NULL
	 */
	HEX("name"),
	
	/**
	 * 返回arg的长度。单位为字节。一个多字节字符算作多字节
	 */
	LENGTH("name"),
	
	/**
	 * 返回arg的长度。单位为字节。一个多字节字符算作多字节
	 */
	OCTET_LENGTH("name"),
	
	/**
	 * 返回arg的长度，长度的单位为字符。一个多字节字符算作一个单字符
	 */
	CHAR_LENGTH("name"),
	
	/**
	 * 返回arg的长度，长度的单位为字符。一个多字节字符算作一个单字符
	 */
	CHARACTER_LENGTH("name"),
	
	/**
	 * 返回删除了其前置空格字符的arg。 
	 */
	LTRIM("name"),
	
	/**
	 * 返回删除了其拖后空格字符的arg。
	 */
	RTRIM("name"),
	
	/**
	 * 返回arg的一个同音字符串。听起来“大致相同”的2个字符串应该有相同的同音字符串。一个“标准”的同音字符串长是4个字符，但是SOUNDEX()函数返回一个任意长的字符串。你可以在结果上使用SUBSTRING()得到一个“标准”的 同音串。所有非数字字母字符在给定的字符串中被忽略。所有在A-Z之外的字符国际字母被当作元音。 
	 */
	SOUNDEX("name"),
	
	/**
	 * 返回由N个空格字符组成的一个字符串。 
	 */
	SPACE("name"),
	
	/**
	 * 返回颠倒字符顺序的字符串str。
	 */
	REVERSE("name"),
	
	/**
	 * 返回字符串str，根据当前字符集映射(缺省是ISO-8859-1 Latin1)把所有的字符改变成小写。 
	 */
	LCASE("name"),
	
	/**
	 * 返回字符串str，根据当前字符集映射(缺省是ISO-8859-1 Latin1)把所有的字符改变成小写。 
	 */
	LOWER("name"),
	
	/**
	 * 返回字符串str，根据当前字符集映射(缺省是ISO-8859-1 Latin1)把所有的字符改变成大写。
	 */
	UCASE("name"),
	
	/**
	 * 返回字符串str，根据当前字符集映射(缺省是ISO-8859-1 Latin1)把所有的字符改变成大写。
	 */
	UPPER("name"),
	
	/**
	 * 读入文件并且作为一个字符串返回文件内容。文件必须在服务器上，你必须指定到文件的完整路径名，而且你必须有file权限。文件必须所有内容都是可读的并且小于max_allowed_packet。如果文件不存在或由于上面原因之一不能被读出，函数返回NULL。 
	 */
	LOAD_FILE("name"),
	
	/**
	 * 返回日期date的星期索引(1=星期天，2=星期一, ……7=星期六)
	 */
	DAYOFWEEK("name"),
	
	/**
	 * 返回date的星期索引(0=星期一，1=星期二, ……6= 星期天)
	 */
	WEEKDAY("name"),
	
	/**
	 * 返回date的月份中日期，在1到31范围内
	 */
	DAYOFMONTH("name"),
	
	/**
	 * 返回date在一年中的日数, 在1到366范围内
	 */
	DAYOFYEAR("name"),
	
	/**
	 * 返回date的月份，范围1到12
	 */
	MONTH("name"),
	
	/**
	 * 返回date的星期名字
	 */
	DAYNAME("name"),
	
	/**
	 * 返回date的月份名字
	 */
	MONTHNAME("name"),
	
	/**
	 * 返回date一年中的季度，范围1到4
	 */
	QUARTER("name"),
	
	/**
	 * 返回date的年份，范围在1000到9999
	 */
	YEAR("name"),
	
	/**
	 * 返回time的小时，范围是0到23
	 */
	HOUR("name"),
	
	/**
	 * 返回time的分钟，范围是0到59
	 */
	MINUTE("name"),
	
	/**
	 * 返回time的秒数，范围是0到59
	 */
	SECOND("name"),
	
	/**
	 * 给出一个日期date，返回一个天数(从0年的天数)，不打算用于使用格列高里历(1582)出现前的值
	 */
	TO_DAYS("name"),
	
	/**
	 * 给出一个天数N，返回一个DATE值
	 */
	FROM_DAYS("name"),
	
	/**
	 * 以'YYYY-MM-DD HH:MM:SS'或YYYYMMDDHHMMSS格式返回unix_timestamp参数所表示的值，取决于函数是在一个字符串还是或数字上下文中被使用
	 */
	FROM_UNIXTIME("name"),
	
	/**
	 * 返回seconds参数，变换成小时、分钟和秒，值以'HH:MM:SS'或HHMMSS格式化，取决于函数是在一个字符串还是在数字上下文中被使用
	 */
	SEC_TO_TIME("name"),
	
	/**
	 * 返回time参数，转换成秒
	 */
	TIME_TO_SEC("name"),
	
	/**
	 * 压缩一个字符串。这个函数要求 MySQL已经用一个诸如zlib的压缩库压缩过。否则，返回值始终是 NULL
	 */
	COMPRESS("name"),
	
	/**
	 * 引证一个字符串，由此产生一个在SQL语句中可用作完全转义数据值的结果。 返回的字符串由单引号标注，每例都带有单引号 (‘'’) 、 反斜线符号 (‘\’) 、 ASCII NUL以及前面有反斜线符号的Control-Z。如果自变量的值为NULL, 则返回不带单引号的单词 “NULL” 。
	 */
	QUOTE("name"),
	
	/**
	 * 函数使用说明：对经COMPRESS()函数压缩后的字符串进行解压缩。若参数为压缩值，则结果为 NULL。这个函数要求 MySQL 已被诸如zlib 之类的压缩库编译过。否则, 返回值将始终是 NULL
	 */
	UNCOMPRESS("name"),
	
	/**
	 * 返回压缩字符串压缩前的长度
	 */
	UNCOMPRESSED_LENGTH("name"),
	
	/**
	 * 执行从 HEX(arg) 的反向操作。就是说，它将参数中的每一对十六进制数字理解为一个数字，并将其转化为该数字代表的字符。结果字符以二进制字符串的形式返回
	 */
	UNHEX("name"),
	
	/**
	 * 返回 arg的绝对值
	 */
	ABS("name"),
	
	/**
	 * 返回 arg反余弦 , 即 , 余弦是arg的值。若 arg不在 -1 到 1 的范围之内，则返回 NULL
	 */
	ACOS("name"),
	
	/**
	 * 返回arg的反正弦，即，正弦为arg的值。若arg不在-1 到 1 的范围之内，则返回 NULL
	 */
	ASIN("name"),
	
	/**
	 * 返回arg的反正切，即，正切为 arg的值
	 */
	ATAN("name"),
	
	/**
	 * 返回不小于 arg的最小整数值
	 */
	CEILING("name"),
	
	/**
	 * 返回不小于 arg的最小整数值
	 */
	CEIL("name"),
	
	/**
	 * 返回 arg的余弦，其中 arg在弧度上已知
	 */
	COS("name"),
	
	/**
	 * 返回 arg的余切
	 */
	COT("name"),
	
	/**
	 * 计算循环冗余码校验值并返回一个 32 比特无符号值。若参数为 NULL ，则结果为 NULL 。该参数应为一个字符串，而且在不是字符串的情况下会被作为字符串处理（若有可能）
	 */
	CRC32("name"),
	
	/**
	 * 返回参数 arg, 该参数由弧度被转化为度
	 */
	DEGREES("name"),
	
	/**
	 * 返回 e的 arg乘方后的值 (自然对数的底 )
	 */
	EXP("name"),
	
	/**
	 * 返回不大于 arg的最大整数值
	 */
	FLOOR("name"),
	
	/**
	 * 返回 arg的自然对数 , 即 , arg相对于基数 e 的对数
	 */
	LN("name"),
	
	/**
	 * 返回 arg的基数为 2 的对数
	 */
	LOG2("name"),
	
	/**
	 * 返回 arg的基数为 10 的对数
	 */
	LOG10("name"),
	
	/**
	 * 返回由度转化为弧度的参数 arg, ( 注意 ? 弧度等于 180 度）
	 */
	RADIANS("name"),
	
	/**
	 * 返回参数作为 -1 、 0 或 1 的符号，该符号取决于 arg的值为负、零或正
	 */
	SIGN("name"),
	
	/**
	 * 返回 arg正弦，其中arg在弧度中被给定
	 */
	SIN("name"),
	
	/**
	 * 返回非负数 arg的二次方根
	 */
	SQRT("name"),
	
	/**
	 * 返回 arg的正切，其中 arg在弧度中被给定
	 */
	TAN("name"),
	
	/**
	 * 提取日期或时间日期表达式arg中的日期部分
	 */
	DATE("name"),
	
	/**
	 * 返回date的月份中日期，在1到31范围内
	 */
	DAY("name"),
	
	/**
	 * 获取一个日期或日期时间值，返回该月最后一天对应的值。若参数无效，则返回 NULL
	 */
	LAST_DAY("name"),
	
	/**
	 * 从时间或日期时间表达式 arg返回微秒值，其数字范围从 0 到 999999
	 */
	CROSECOND("name"),
	
	/**
	 * 提取一个时间或日期时间表达式的时间部分，并将其以字符串形式返回
	 */
	TIME("name"),
	
	/**
	 * 将该日期的阳历周以数字形式返回，范围是从 1 到 53
	 */
	WEEKOFYEAR("name"),
	
	/**
	 * 为字符串算出一个 MD5 128 比特检查和。该值以 32 位十六进制数字的二进制字符串的形式返回 , 若参数为 NULL 则会返回 NULL
	 */
	MD5("name"),
	
	/**
	 * 当 PASSWORD() 的执行变为改善安全性时， OLD_PASSWORD() 会被添加到 MySQL 。 OLD_PASSWORD() 返回从前的 PASSWORD() 执行值 ( 4.1 之前 ) ，同时允许你为任何 4.1 之前的需要连接到你的 5.1 版本 MySQL 服务器前客户端设置密码，从而不至于将它们切断
	 */
	OLD_PASSWORD("name"),
	
	/**
	 * 从原文密码arg计算并返回密码字符串，当参数为 NULL 时返回 NULL 。这个函数用于用户授权表的Password 列中的加密MySQL 密码存储
	 */
	PASSWORD("name"),
	
	/**
	 * 返回arg自变量的字符集
	 */
	CHARSET("name"),
	
	/**
	 * 返回arg自变量的整序可压缩性值
	 */
	COERCIBILITY("name"),
	
	/**
	 * 返回arg参数的排序方式
	 */
	COLLATION("name"),
	
	/**
	 * 返回一个表列的默认值。若该列没有默认值则会产生错误
	 */
	DEFAULT("name"),
	
	/**
	 * 给出一个作为字符串的网络地址的点地址表示，返回一个代表该地址数值的整数。地址可以是 4 或 8 比特地址
	 */
	INET_ATON("name"),
	
	/**
	 * 给定一个数字网络地址 (4 或 8 比特 ), 返回作为字符串的该地址的电地址表示
	 */
	INET_NTOA("name"),
	
	/**
	 * 检查名为 arg的锁是否可以使用 ( 换言之 , 没有被封锁 ) 。若锁可以使用，则返回   1 ( 没有人在用这个锁 ), 若这个锁正在被使用，则返回 0 ，出现错误则返回 NULL ( 诸如不正确的参数 ) 。
	 */
	IS_FREE_LOCK("name"),
	
	/**
	 * 检查名为 arg的锁是否正在被使用 ( 换言之 , 被封锁 ) 。若被封锁，则返回使用该锁的客户端的连接标识符。否则返回 NULL
	 */
	IS_USED_LOCK("name"),
	
	/**
	 * 解开被 GET_LOCK() 获取的，用字符串 arg 所命名的锁。若锁被解开，则返回   1 ，若改线程尚未创建锁，则返回 0 ( 此时锁没有被解开 ), 若命名的锁不存在，则返回 NULL 。若该锁从未被对 GET_LOCK() 的调用获取，或锁已经被提前解开，则该锁不存在。
	 */
	RELEASE_LOCK("name"),
	
	/**
	 * 睡眠 ( 暂停 ) 时间为 duration 参数给定的秒数，然后返回 0 。若 SLEEP() 被中断 , 它会返回 1 。 duration 或许或包括一个给定的以微秒为单位的分数部分
	 */
	SLEEP("name"),
	
	/**
	 * 在一个 INSERT … ON DUPLICATE KEY UPDATE … 语句中，你可以在 UPDATE 子句中使用 VALUES(col_name ) 函数，用来访问来自该语句的 INSERT 部分的列值。换言之， UPDATE 子句中的 VALUES(col_name ) 访问需要被插入的 col_name 的值 , 并不会发生重复键冲突。这个函数在多行插入中特别有用。   VALUES() 函数只在 INSERT ... UPDATE 语句中有意义，而在其它情况下只会返回 NULL
	 */
	VALUES("name"),
	
	/**
	 * 返回arg 中所有比特的 bitwise AND 。计算执行的精确度为64 比特(BIGINT) 。若找不到匹配的行，则这个函数返回18446744073709551615 。( 这是无符号 BIGINT 值，所有比特被设置为 1 ）。
	 */
	BIT_AND("name"),
	
	/**
	 * 返回arg 中所有比特的bitwise OR 。计算执行的精确度为64 比特(BIGINT) 。若找不到匹配的行，则函数返回 0
	 */
	BIT_OR("name"),
	
	/**
	 * 返回arg 中所有比特的bitwise XOR 。计算执行的精确度为64 比特(BIGINT) 。若找不到匹配的行，则函数返回 0
	 */
	BIT_XOR("name"),
	
	/**
	 * 返回SELECT 语句检索到的行中非NULL 值的数目。若找不到匹配的行，则COUNT() 返回 0
	 */
	COUNT("name"),
	
	/**
	 * 该函数返回带有来自一个组的连接的非NULL 值的字符串结果。其完整的语法如下所示
	 */
	GROUP_CONCAT("name"),
	
	/**
	 * 返回 arg 的总体标准偏差。这是标准 SQL 的延伸。这个函数的 STDDEV() 形式用来提供和 Oracle 的兼容性。可使用标准 SQL 函数 STDDEV_POP() 进行代替
	 */
	STD("name"),
	
	/**
	 * 返回 arg 的总体标准偏差。这是标准 SQL 的延伸。这个函数的 STDDEV() 形式用来提供和 Oracle 的兼容性。可使用标准 SQL 函数 STDDEV_POP() 进行代替
	 */
	STDDEV("name"),
	
	/**
	 * 返回arg 的总体标准偏差(VAR_POP() 的平方根) 。你也可以使用 STD() 或STDDEV(), 它们具有相同的意义，然而不是标准的 SQL 。若找不到匹配的行，则STDDEV_POP() 返回 NULL
	 */
	STDDEV_POP("name"),
	
	/**
	 * 返回arg 的样本标准差 ( VAR_SAMP() 的平方根) 。若找不到匹配的行，则STDDEV_SAMP() 返回 NULL
	 */
	STDDEV_SAMP("name"),
	
	/**
	 * 返回 arg 总体标准方差。它将行视为总体，而不是一个样本， 所以它将行数作为分母。你也可以使用 VARIANCE(), 它具有相同的意义然而不是 标准的 SQL
	 */
	VAR_POP("name"),
	
	/**
	 * 返回arg 的样本方差。更确切的说，分母的数字是行数减去1 。若找不到匹配的行，则VAR_SAMP() 返回NULL
	 */
	VAR_SAMP("name"),
	
	/**
	 * 返回arg 的总体标准方差。这是标准SQL 的延伸。可使用标准SQL 函数 VAR_POP() 进行代替。若找不到匹配的项，则VARIANCE() 返回NULL
	 */
	VARIANCE("name"),
	
	/**
	 * 以'YYYY-MM-DD'或YYYYMMDD格式返回今天日期值，取决于函数是在一个字符串还是数字上下文被使用
	 */
	CURDATE,
	
	/**
	 * 以'YYYY-MM-DD'或YYYYMMDD格式返回今天日期值，取决于函数是在一个字符串还是数字上下文被使用
	 */
	CURRENT_DATE,
	
	/**
	 * 以'HH:MM:SS'或HHMMSS格式返回当前时间值，取决于函数是在一个字符串还是在数字的上下文被使用
	 */
	CURTIME,
	
	/**
	 * 以'HH:MM:SS'或HHMMSS格式返回当前时间值，取决于函数是在一个字符串还是在数字的上下文被使用
	 */
	CURRENT_TIME,
	
	/**
	 * 以'YYYY-MM-DD HH:MM:SS'或YYYYMMDDHHMMSS格式返回当前的日期和时间，取决于函数是在一个字符串还是在数字的上下文被使用
	 */
	NOW,
	
	/**
	 * 以'YYYY-MM-DD HH:MM:SS'或YYYYMMDDHHMMSS格式返回当前的日期和时间，取决于函数是在一个字符串还是在数字的上下文被使用
	 */
	SYSDATE,
	
	/**
	 * 以'YYYY-MM-DD HH:MM:SS'或YYYYMMDDHHMMSS格式返回当前的日期和时间，取决于函数是在一个字符串还是在数字的上下文被使用
	 */
	CURRENT_TIMESTAMP,
	
	/**
	 * 如果没有参数调用，返回一个Unix时间戳记(从'1970-01-01 00:00:00'GMT开 始的秒数)。如果UNIX_TIMESTAMP()用一个date参数被调用，它返回从'1970-01-01 00:00:00' GMT开始的秒数值。date可以是一个DATE字符串、一个DATETIME字符串、一个TIMESTAMP或以YYMMDD或YYYYMMDD格式的 本地时间的一个数字。当UNIX_TIMESTAMP被用于一个TIMESTAMP列，函数将直接接受值，没有隐含的“string-to-unix-timestamp”变换
	 */
	UNIX_TIMESTAMP("name"),
	
	/**
	 * 返回 (pi) 的值。默认的显示小数位数是 7 位 , 然而 MySQL 内部会使用完全双精度值
	 */
	PI,
	
	/**
	 * 返回一个随机浮点值 v ，范围在 0 到 1 之间 ( 即 , 其范围为 0 ≤ v ≤ 1.0) 。若已指定一个整数参数 N ，则它被用作种子值，用来产生重复序列
	 */
	RAND,
	
	/**
	 * 以'YYYY-MM-DD HH:MM:SS'或YYYYMMDDHHMMSS格式返回当前的日期和时间，取决于函数是在一个字符串还是在数字的上下文被使用
	 */
	LOCALTIME,
	
	/**
	 * 以'YYYY-MM-DD HH:MM:SS'或YYYYMMDDHHMMSS格式返回当前的日期和时间，取决于函数是在一个字符串还是在数字的上下文被使用
	 */
	LOCALTIMESTAMP,
	
	/**
	 * 返回当前 UTC 日期值，其格式为 'YYYY-MM-DD' 或 YYYYMMDD ，具体格式取决于函数是否用在字符串或数字语境中
	 */
	UTC_DATE,
	
	/**
	 * 返回当前 UTC 值，其格式为   'HH:MM:SS' 或 HHMMSS ，具体格式根据该函数是否用在字符串或数字语境而定
	 */
	UTC_TIME,
	
	/**
	 * 返回当前 UTC 日期及时间值，格式为 'YYYY-MM-DD HH:MM:SS' 或 YYYYMMDDHHMMSS ，具体格式根据该函数是否用在字符串或数字语境而定
	 */
	UTC_TIMESTAMP,
	
	/**
	 * 返回对于连接的连接 ID ( 线程 ID) 。每个连接都有各自的唯一 ID
	 */
	CONNECTION_ID,
	
	/**
	 * 返回当前话路被验证的用户名和主机名组合。这个值符合确定你的存取权限的 MySQL 账户。在被指定 SQL SECURITY DEFINER 特征的存储程序内， CURRENT_USER() 返回程序的创建者
	 */
	CURRENT_USER,
	
	/**
	 * 返回使用 utf8 字符集的默认 ( 当前 ) 数据库名。在存储程序里，默认数据库是同该程序向关联的数据库，但并不一定与调用语境的默认数据库相同
	 */
	DATABASE,
	
	/**
	 * A SELECT 语句可能包括一个 LIMIT 子句，用来限制服务器返回客户端的行数。在有些情况下，需要不用再次运行该语句而得知在没有 LIMIT 时到底该语句返回了多少行。为了知道这个行数 , 包括在 SELECT 语句中选择   SQL_CALC_FOUND_ROWS ，随后调用 FOUND_ROWS()
	 */
	FOUND_ROWS,
	
	/**
	 * 返回被前面语句更新的、插入的或删除的行数。 这个行数和 mysql 客户端显示的行数及 mysql_affected_rows() C API 函数返回的值相同
	 */
	ROW_COUNT,
	
	/**
	 * 返回使用 utf8 字符集的默认 ( 当前 ) 数据库名。在存储程序里，默认数据库是同该程序向关联的数据库，但并不一定与调用语境的默认数据库相同
	 */
	SCHEMA,
	
	/**
	 * 自动返回最后一个 INSERT 或 UPDATE 问询为 AUTO_INCREMENT 列设置的第一个 发生的值
	 */
	LAST_INSERT_ID("name"),
	
	/**
	 * 返回当前 MySQL 用户名和机主名
	 */
	USER,
	
	/**
	 * 返回当前 MySQL 用户名和机主名
	 */
	SESSION_USER,
	
	/**
	 * 返回当前 MySQL 用户名和机主名
	 */
	SYSTEM_USER,
	
	/**
	 * 返回指示 MySQL 服务器版本的字符串。这个字符串使用 utf8 字符集
	 */
	VERSION,
	
	/**
	 * 返回一个通用唯一标识符 (UUID) ， UUID 被设计成一个在时间和空间上都独一无二的数字。 2 个对 UUID() 的调用应产生 2 个不同的值，即使这些调用的执行是在两个互不相连的单独电脑上进行
	 */
	UUID,
	
	/**
	 * CONV(N,from_base,to_base)。在不同的数字基之间变换数字。返回数字N的字符串数字，从from_base基变换为to_base基，如果任何参数是NULL，返回NULL。参数N解释为一个整数，但是可以指定为一个整数或一个字符串。最小基是2且最大的基是36。如果to_base是一个负数，N被认为是一个有符号数，否则，N被当作无符号数。 CONV以64位点精度工作。 
	 */
	CONV("name", null, null),
	
	/**
	 * CHAR(N,...)。将参数解释为整数并且返回由这些整数的ASCII代码字符组成的一个字符串。NULL值被跳过
	 */
	CHAR("name"),
	
	/**
	 * CONCAT(str1,str2,...)。返回来自于参数连结的字符串。如果任何参数是NULL，返回NULL。可以有超过2个的参数。一个数字参数被变换为等价的字符串形式
	 */
	CONCAT("name"),
	
	/**
	 * LOCATE(substr,str)。LOCATE(substr,str,pos)。两个参数时：返回子串substr在字符串str第一个出现的位置，如果substr不是在str里面，返回0。该函数是多字节可靠的。三个参数时：返回子串substr在字符串str第一个出现的位置，从位置pos开始。如果substr不是在str里面，返回0。这函数是多字节可靠的
	 */
	LOCATE("name", null, null),
	
	/**
	 * POSITION(substr IN str)。返回子串substr在字符串str第一个出现的位置，如果substr不是在str里面，返回0。该函数是多字节可靠的
	 */
	POSITION("name"),
	
	/**
	 * INSTR(str,substr)。返回子串substr在字符串str中的第一个出现的位置。这与有2个参数形式的LOCATE()相同，除了参数被颠倒。这函数是多字节可靠的
	 */
	INSTR("name", null),
	
	/**
	 * LPAD(str,len,padstr)。返回字符串str，左面用字符串padstr填补直到str是len个字符长
	 */
	LPAD("name", null, null),
	
	/**
	 * RPAD(str,len,padstr) 。返回字符串str，右面用字符串padstr填补直到str是len个字符长
	 */
	RPAD("name", null, null),
	
	/**
	 * LEFT(str,len)。返回字符串str的最左面len个字符。该函数是多字节可靠的
	 */
	LEFT("name", null),
	
	/**
	 * RIGHT(str,len)。返回字符串str的最右面len个字符。该函数是多字节可靠的
	 */
	RIGHT("name", null),
	
	/**
	 * 三个参数：SUBSTRING(str,pos,len)。SUBSTRING(str FROM pos FOR len)。从字符串str返回一个len个字符的子串，从位置pos开始。使用FROM的变种形式是ANSI SQL92语法。该函数是多字节可靠的。两个参数：SUBSTRING(str,pos)。SUBSTRING(str FROM pos)。从字符串str的起始位置pos返回一个子串。该函数是多字节可靠的
	 */
	SUBSTRING("name", null, null),
	
	/**
	 * MID(str,pos,len)。从字符串str返回一个len个字符的子串，从位置pos开始。该函数是多字节可靠的
	 */
	MID("name", null, null),
	
	/**
	 * SUBSTRING_INDEX(str,delim,count)。返回从字符串str的第count个出现的分隔符delim之后的子串。如果count是正数，返回最后的分隔符到左边(从左边数) 的所有字符。如果count是负数，返回最后的分隔符到右边的所有字符(从右边数)。 该函数对多字节是可靠的
	 */
	SUBSTRING_INDEX("name", null, null),
	
	/**
	 * TRIM([[BOTH | LEADING | TRAILING] [remstr] FROM] str) 返回字符串str，其所有remstr前缀或后缀被删除了。如果没有修饰符BOTH、LEADING或TRAILING给出，BOTH被假定。如果remstr没被指定，空格被删除，该函数对多字节是可靠的
	 */
	TRIM("name", null, null),
	
	/**
	 * REPLACE(str,from_str,to_str) 返回字符串str，其字符串from_str的所有出现由字符串to_str代替，该函数对多字节是可靠的
	 */
	REPLACE("name", null, null),
	
	/**
	 * 返回由重复count次的字符串str组成的一个字符串。如果count <= 0，返回一个空字符串。如果str或count是NULL，返回NULL
	 */
	REPEAT("name", null),
	
	/**
	 * 返回字符串str，在位置pos起始的子串且len个字符长的子串由字符串newstr代替，该函数对多字节是可靠的
	 */
	INSERT("name", null, null, null)
	;
	
	/**
	 * 函数参数列表
	 */
	private String[] args;
	
	/**
	 * 传值
	 * @param args {@link #args}
	 */
	private FunctionEnum(String... args) {
		this.args = args;
	}

	/**
	 * 获得{@link #args}
	 * @return {@link #args}
	 */
	public String[] getArgs() {
		return args;
	}

	/**
	 * 设置{@link #args}
	 * @param args {@link #args}
	 */
	public void setArgs(String[] args) {
		this.args = args;
	}
}
