select * from nov29_student;

CREATE SEQUENCE nov29_student_seq;

CREATE TABLE nov29_student(
	s_no NUMBER(4) PRIMARY KEY,
	s_name varchar2(12 char) not null,
	s_nickname varchar2(16 char) not null
);

INSERT INTO nov29_student VALUES(nov29_student_seq.nextval,'지병천','Respina');