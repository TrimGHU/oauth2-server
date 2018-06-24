DROP TABLE IF EXISTS sys_authority;
CREATE TABLE sys_authority (
  id BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  auth_name VARCHAR(255) DEFAULT NULL,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
  id BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(255) DEFAULT NULL,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
  id BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(255) DEFAULT NULL,
  PASSWORD VARCHAR(255) DEFAULT NULL,
  mobile VARCHAR(255) DEFAULT NULL,
  age TINYINT(1) UNSIGNED ,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;




DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role (
  id BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id BIGINT(11) UNSIGNED DEFAULT NULL,
  role_id BIGINT(11) UNSIGNED DEFAULT NULL,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS sys_role_auth;
CREATE TABLE sys_role_auth (
  id BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  role_id BIGINT(11) UNSIGNED DEFAULT NULL,
  auth_id BIGINT(11) UNSIGNED DEFAULT NULL,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

