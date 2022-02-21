INSERT INTO PARENT (name , surname, phone_number, email) VALUES
                            ('Wojciech', 'Basiura', '987207631', 'wojciech.kucharz@gmail.com'),
                            ('Niels', 'Lis', '804973858', 'Niels.Lis@gmail.com'),
                            ('Catalina', 'Michalak', '171835940', 'Catalina.Michalak@gmail.com'),
                            ('Jagna', 'Kaczmarczyk', '631489989', 'Jagna.Kaczmarczyk@gmail.com');

INSERT INTO STUDENT (name , surname, dob, email, parent_id) VALUES
                            ('Heronim', 'Mazurek', '2006-02-13', 'Heronim.Mazurek@gmail.com', 2),
                            ('Adam', 'Makowski', '2004-03-24', 'Adam.Makowski@gmail.com', 4),
                            ('Robert', 'Sadowska', '2002-07-03', 'Robert.Michalak@gmail.com', 1),
                            ('Gustaw', 'Zakrzewska', '2009-01-10', 'Gustaw.Zakrzewska@gmail.com', 1),
                            ('Emanuel', 'Kucharski', '2010-10-07', 'Emanuel.Kucharski@gmail.com', 3);

INSERT INTO TEACHER (name , surname, dob, phone_number, email) VALUES
                            ('Michał', 'Stępień', '2001-05-13', '801307582', 'Michał.Stępień@gmail.com'),
                            ('Krzysztof', 'Adamska', '1999-12-24', '086881919', 'Krzysztof.Adamska@gmail.com'),
                            ('Konrad', 'Pietrzak', '2002-07-01', '892813616', 'Konrad.Pietrzak@gmail.com');

INSERT INTO COURSE (name, description, number_of_lessons, min_age, max_age, cost) VALUES
                            ('Python', 'Nauczanie języka python. Easy to enter, hard to master', 10, 10, 16, 800),
                            ('Java', 'Nauczanie języka java. Hard to enter.', 16, 12, 18, 1800),
                            ('GameDev', 'Taki sracz tylko ze troszke lepszy', 8, 8, 12, 500);

INSERT INTO GROUPS (course_id, teacher_id, start_date, expected_end_date, rate_per_hour) VALUES
                            (2, 3, '2022-02-16', '2022-04-27', 40),
                            (1, 1, '2022-02-11', '20022-04-22', 34);

INSERT INTO GROUPS_STUDENT VALUES
                            (1, 3),
                            (1, 4),
                            (1, 2),
                            (2, 3),
                            (2, 1),
                            (2, 5);

INSERT INTO users (username, password, enabled)
values ('admin','$2a$12$v/QlG19Nq5X0iArBPNhHtO194qe0qSypjkBJaieFH9iB1TBrLSUre', TRUE);

INSERT INTO authorities (username, authority)
values ('admin', 'USER');
