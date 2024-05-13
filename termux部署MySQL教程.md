## termux玩转MySQL
### 安装
```sh
pkg install mariadb -y
```

### 启动
```sh
nohup mysqld_safe -u root >/dev/null 2>&1 &
```

### 登录
```sql
mysql -uroot
```

### 设置密码为1234
```sql
ALTER USER 'root'@'localhost' IDENTIFIED BY '1234';
```

### 建表
```sql
CREATE DATABASE mydatabase;
```

### 执行SQL
```sql
use mydatabase;
source mydatabase.sql;
```
