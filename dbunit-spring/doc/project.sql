




/* Oracle */

/* 学生表 */
CREATE TABLE student (
	oid number PRIMARY KEY,
	name varchar2(64) NOT NULL,
	credit number(5, 2),
	birthday date,
	address varchar2(128)
);

/* 创建序列 */
CREATE SEQUENCE seq_student_oid
START WITH 1
INCREMENT BY 1
MAXVALUE 999999999999999999999999
CACHE 10
ORDER
CYCLE;

/* 课程表 */
CREATE TABLE course (
	oid number PRIMARY KEY,
	name varchar2(64) NOT NULL,
	credit number(5, 2),
	description varchar2(128)
);

/* 创建序列 */
CREATE SEQUENCE seq_course_oid
START WITH 1
INCREMENT BY 1
MAXVALUE 999999999999999999999999
CACHE 10
ORDER
CYCLE;

INSERT course (oid, name, credit, description) INTO VALUES (seq_course_oid.nextVal, '数学', 4.5, '大学数学课程');




































