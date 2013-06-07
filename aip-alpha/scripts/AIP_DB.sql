CREATE DATABASE /*!32312 IF NOT EXISTS*/`AIP` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `AIP`;


/*Table structure for table `education` */

CREATE TABLE mm_education (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(10) NOT NULL,
  PRIMARY KEY (id)
);

/*Table structure for table `job_role` */

CREATE TABLE job_role (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL,
  PRIMARY KEY (id)
);

/*Table structure for table `job_location' */

CREATE TABLE job_location (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(10) NOT NULL,
  PRIMARY KEY (id)
);

/*Table structure for table `job_post' */

CREATE TABLE job_post (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(10) NOT NULL,
  company_name varchar(50) NOT NULL,
  company_url varchar(50) NOT NULL,
  company_profile TEXT NOT NULL,
  experience  varchar(50) NOT NULL,
  skill_requried text NOT NULL,
  job_role_id int(11) NOT NULL,
  education_id int(11) NOT NULL,
  reviewer_id int(11) NOT NULL,
  job_location_id int(11) NOT NULL,
  salary_offered varchar(20) NOT NULL,
  year_of_passing varchar(20) NOT NULL,
  candidate_profile text NOT NULL,
  interview_date datetime DEFAULT NULL,
  last_date datetime DEFAULT NULL,
  job_description text NOT NULL,
  posted_date datetime DEFAULT NULL,
  PRIMARY KEY (id),
  KEY role (job_role_id),
  CONSTRAINT role FOREIGN KEY (job_role_id) REFERENCES job_role (id),
  KEY edu (education_id),
  CONSTRAINT edu FOREIGN KEY (education_id) REFERENCES education (id),
  KEY location (job_location_id),
  CONSTRAINT location FOREIGN KEY (job_location_id) REFERENCES job_location (id),
  KEY rev (reviewer_id),
  CONSTRAINT rev FOREIGN KEY (reviewer_id) REFERENCES reviewer (id)
);


/*Table structure for table `category` */

CREATE TABLE category (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(10) NOT NULL,
  PRIMARY KEY (id)
);

/*Table structure for table `questionnaire` */

CREATE TABLE questionnaire (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(50) NOT NULL,
  skill varchar(100) NOT NULL,
  category_id int(11) NOT NULL,
  created_date TIMESTAMP(6) NOT NULL,
  updated_date TIMESTAMP(6) NOT NULL,
  created_by varchar(50) NOT NULL,
  PRIMARY KEY (id),
  KEY ques_category (category_id),
  CONSTRAINT ques_category FOREIGN KEY (category_id) REFERENCES category (id)
);

/*Table structure for table `question_type` */

CREATE TABLE question_type (
  id int(11) NOT NULL,
  name varchar(100) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

/*Table structure for table `question_level` */

CREATE TABLE question_level (
  id int(11) NOT NULL AUTO_INCREMENT,
  level varchar(10) NOT NULL,
  PRIMARY KEY (id)
);

/*Table structure for table `questions` */

CREATE TABLE questions (
  id int(11) NOT NULL AUTO_INCREMENT,
  question varchar(50) NOT NULL,
  alloted_time int(10) NOT NULL,
  level_id int(11) NOT NULL,
  type_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY ques_level (level_id),
  CONSTRAINT ques_level FOREIGN KEY (level_id) REFERENCES question_level (id),
  KEY ques_type (type_id),
  CONSTRAINT ques_type FOREIGN KEY (type_id) REFERENCES question_type (id)
);

/*Table structure for table `questionnaire_questions` */

CREATE TABLE questionnaire_questions (
  question_id int(11) NOT NULL,
  questionnaire_id int(11) NOT NULL,
  KEY questionnaire (questionnaire_id),
  CONSTRAINT questionnaire FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id),
  KEY ques (question_id),
  CONSTRAINT ques FOREIGN KEY (question_id) REFERENCES question (id)
);


/*Table structure for table `question_options` */

CREATE TABLE question_options (
  id int(11) NOT NULL AUTO_INCREMENT,
  ques_option  varchar(50) NOT NULL,
  question_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY ques_id (question_id),
  CONSTRAINT ques_id FOREIGN KEY (question_id) REFERENCES question (id)
);

/*Table structure for table `question_answer` */

CREATE TABLE question_answer (
  id int(11) NOT NULL AUTO_INCREMENT,
  answer  text NOT NULL,
  question_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY ques_id (question_id),
  CONSTRAINT ques_id FOREIGN KEY (question_id) REFERENCES question (id)
);

/*Table structure for table `video_answer` */

CREATE TABLE video_answer (
  id int(11) NOT NULL AUTO_INCREMENT,
  answer_path  text NOT NULL,
  PRIMARY KEY (id)
);

/*Table structure for table `schedule` */

CREATE TABLE schedule (
  id int(11) NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  mobile bigint(20) DEFAULT NULL,
  schedule_date TIMESTAMP(0) DEFAULT NULL,
  expiry_date TIMESTAMP(0) DEFAULT NULL,
  questionnaire_id int(11) NOT NULL,
  reviewer_id int(11) NOT NULL,
  interview_type_name varchar(35) NOT NULL,
  user_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY emp_shedule_tbl (questionnaire_id),
  CONSTRAINT emp_shedule_tbl FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id),
  KEY reviwer_tbl (reviewer_id),
  CONSTRAINT reviwer_tbl FOREIGN KEY (reviewer_id) REFERENCES reviwer (id),
  KEY interview_type_tbl (interview_type_name),
  CONSTRAINT interview_type_tbl FOREIGN KEY (interview_type_name) REFERENCES interview_type (name),
  KEY recruiter_tbl (user_id),
  CONSTRAINT recruiter_tbl FOREIGN KEY (user_id) REFERENCES interview_type (name),
);

/*Table structure for table `interview_type` */

CREATE TABLE interview_type (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(35) NOT NULL,
  PRIMARY KEY (id)
);

/*Table structure for table `reviewer` */

CREATE TABLE reviewer (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

/*Table structure for table `skill` */

CREATE TABLE skill (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

/*Table structure for table `skill_other` */

CREATE TABLE skill_other (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
);
s
/*Table structure for table `jobseeker` */

CREATE TABLE jobseeker (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(50) DEFAULT NULL,
  mobile bigint(20) DEFAULT NULL,
  job_location_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY jobseeker_tbl (job_location_id),
  CONSTRAINT jobseeker_tbl FOREIGN KEY (job_location_id) REFERENCES job_location (id)
);
