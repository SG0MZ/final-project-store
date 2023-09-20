INSERT INTO users (about, domain_expertise, login) VALUES('New trainee, looking to learn more.','Programming','user1');
INSERT INTO users (about, domain_expertise, login) VALUES('Experienced musician, trying to learn a new thing.','Music','user2');
INSERT INTO users (about, domain_expertise, login) VALUES('Looking for a great english course.','Language','user3');

INSERT INTO courses (course_name, description, domain, price) VALUES('Full Stack Development','Contains Microservices, Springboot, SQL','Programming',100.0);
INSERT INTO courses (course_name, description, domain, price) VALUES('English Advanced with Certification','Complete english course, includes certification','Language',85.0);
INSERT INTO courses (course_name, description, domain, price) VALUES('Guitar Course for Beginners','Full guitar course for beginners','Music',90.0);

INSERT INTO domains (domain) VALUES('Music');
INSERT INTO domains (domain) VALUES('Language');
INSERT INTO domains (domain) VALUES('Programming');