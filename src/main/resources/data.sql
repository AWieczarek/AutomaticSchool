INSERT INTO PARENT VALUES
                            (1, 'Wojciech', 'Basiura', '987207631', 'wojciech.kucharz@gmail.com'),
                            (2, 'Niels', 'Lis', '804973858', 'Niels.Lis@gmail.com'),
                            (3, 'Catalina', 'Michalak', '171835940', 'Catalina.Michalak@gmail.com'),
                            (4, 'Jagna', 'Kaczmarczyk', '631489989', 'Jagna.Kaczmarczyk@gmail.com');

INSERT INTO STUDENT VALUES
                            (1, 'Heronim', 'Mazurek', '2006-02-13', 'Heronim.Mazurek@gmail.com', 2),
                            (2, 'Adam', 'Makowski', '2004-03-24', 'Adam.Makowski@gmail.com', 4),
                            (3, 'Robert', 'Sadowska', '2002-07-03', 'Robert.Michalak@gmail.com', 1),
                            (4, 'Gustaw', 'Zakrzewska', '2009-01-10', 'Gustaw.Zakrzewska@gmail.com', 1),
                            (5, 'Emanuel', 'Kucharski', '2010-10-07', 'Emanuel.Kucharski@gmail.com', 3);

INSERT INTO TEACHER VALUES
                            (1, 'Michał', 'Stępień', '2001-05-13', '801307582', 'Michał.Stępień@gmail.com'),
                            (2, 'Krzysztof', 'Adamska', '1999-12-24', '086881919', 'Krzysztof.Adamska@gmail.com'),
                            (3, 'Konrad', 'Pietrzak', '2002-07-01', '892813616', 'Konrad.Pietrzak@gmail.com');

INSERT INTO COURSE VALUES
                            (1, 'Python', 'Nauczanie języka python. Easy to enter, hard to master', 10, 10, 16, 800),
                            (2, 'Java', 'Nauczanie języka java. Hard to enter.', 16, 12, 18, 1800),
                            (3, 'GameDev', 'Taki sracz tylko ze troszke lepszy', 8, 8, 12, 500);

INSERT INTO GROUPS VALUES
                            (1, 2, 3, '2022-02-16', '2022-04-27', 40),
                            (2, 1, 1, '2022-02-11', '20022-04-22', 34);

INSERT INTO GROUPS_STUDENT VALUES
                            (1, 3),
                            (1, 4),
                            (1, 2),
                            (2, 3),
                            (2, 1),
                            (2, 5);
