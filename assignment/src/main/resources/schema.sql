CREATE TABLE TBL_POST
(
  POST_NO NUMBER PRIMARY KEY,
  TITLE VARCHAR2(300) NOT NULL,
  CONTENTS VARCHAR2(3000),
  WRITER VARCHAR2(200),
  REG_DT VARCHAR2(20),
  FIN_MDFY_DT VARCHAR2(20),
  VIEW_COUNT NUMBER,
  POST_PWD VARCHAR2(20)
);

CREATE TABLE TBL_MEMBER
(
  USER_ID VARCHAR2(50) PRIMARY KEY,
  USER_PWD VARCHAR2(50) NOT NULL,
  USER_NM VARCHAR2(10)
);