INSERT INTO user (about, domain_expertise, login, password) VALUES('New trainee, looking to learn more.','Programming','user1','$2a$10$z5OmCvAcosbYVGh/l.obWuyKjZDwNlMELRw2hDAdD1HMAeOrq0LMC');
INSERT INTO user (about, domain_expertise, login, password) VALUES('Experienced musician, trying to learn a new thing.','Music','user2','$2a$10$g2l2v8n4fLDUxG95De9LWOoTLKRegvaIha64jxUMmtMHvpRKufqqm');
INSERT INTO user (about, domain_expertise, login, password) VALUES('Looking for a great english course.','Language','user3','$2a$10$MLnGT0uzx766AUUx6JlFAeAdXtZ0my5.6Xexp3dX5.YypbBGgeyyy');

INSERT INTO authorities (authority,user_id) VALUES('ROLE_USER',1);
INSERT INTO authorities (authority,user_id) VALUES('ROLE_ADMIN',2);
INSERT INTO authorities (authority,user_id) VALUES('ROLE_USER',3);

INSERT INTO courses (course_name, description, domain, price) VALUES('Full Stack Development','Contains Microservices, Springboot, SQL','Programming',100.0);
INSERT INTO courses (course_name, description, domain, price) VALUES('English Advanced with Certification','Complete english course, includes certification','Language',85.0);
INSERT INTO courses (course_name, description, domain, price) VALUES('Guitar Course for Beginners','Full guitar course for beginners','Music',90.0);

INSERT INTO domains (domain) VALUES('Music');
INSERT INTO domains (domain) VALUES('Language');
INSERT INTO domains (domain) VALUES('Programming');