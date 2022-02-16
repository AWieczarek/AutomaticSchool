package pl.edu.amu.automaticschoolapi;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import pl.edu.amu.automaticschoolapi.course.Course;
import pl.edu.amu.automaticschoolapi.group.Group;
import pl.edu.amu.automaticschoolapi.parent.Parent;
import pl.edu.amu.automaticschoolapi.student.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.joda.time.LocalDate;
import pl.edu.amu.automaticschoolapi.teacher.Teacher;

import java.util.Set;

@SpringBootApplication
@Slf4j
public class AutomaticSchoolApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(AutomaticSchoolApiApplication.class, args);

		EntityManager entityManager;

		EntityManagerFactory entityManagerFactory;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

			entityManager = entityManagerFactory.createEntityManager();
			Session session = entityManager.unwrap(Session.class);

			session.beginTransaction();

			Student wojciechBasiura = new Student(
					"Wojciech",
					"Basiura",
					new LocalDate(2007,7,14),
					"wojtek.kucharz@gmail.com"
			);

			Student tomHohland = new Student(
					"Tom",
					"Hohland",
					new LocalDate(2005,2,23),
					"spiderman@wp.pl"
			);

			Parent kurtScheller = new Parent(
					"Kurt",
					"Scheller",
					"213576199",
					"kurt.Scheller@gmail.com"
			);

			Parent augustinCauchy = new Parent(
					"Augustin",
					"Cauchy",
					"312336611",
					"augustin.cauchy@matematika.com"
			);

			kurtScheller.setStudents(Set.of(wojciechBasiura));
			augustinCauchy.setStudents(Set.of(tomHohland));

			Teacher adamWieczarek = new Teacher(
					"Adam",
					"Wieczarek",
					new LocalDate(2001,5,24),
					"123456789",
					"adamw@gamil.com"
			);

			Teacher jakubKuziemski = new Teacher(
					"Jakub",
					"Kuziemski",
					new LocalDate(2001,3,20),
					"987654321",
					"kubus@gamil.com"
			);

			Course python = new Course(
					"Python",
					"Nauczanie języka Python. Prosta składnia. Easy to enter, hard to master.",
					10,
					18,
					10,
					800
			);

			Course java = new Course(
					"Java",
					"Nauczanie języka Java. Jak myślisz, że java ma prosta składnie to napisz działającego Hello Wordla z pamięci.",
					16,
					20,
					15,
					1200
			);

			Group adamJava = new Group(
					new LocalDate(2022,2, 17),
					new LocalDate(2022,5, 17),
					36
			);

			Group kubaPython = new Group(
					new LocalDate(2022,2, 27),
					new LocalDate(2022,4, 12),
					32
			);

			adamJava.setTeacher(adamWieczarek);
			kubaPython.setTeacher(jakubKuziemski);

			adamJava.setCourse(java);
			kubaPython.setCourse(python);

			session.save(wojciechBasiura);
			session.save(tomHohland);

			session.save(kurtScheller);
			session.save(augustinCauchy);

			session.save(adamWieczarek);
			session.save(jakubKuziemski);

			session.save(java);
			session.save(python);

			session.save(adamJava);
			session.save(kubaPython);


			session.flush();

			session.getTransaction().commit();
			session.close();

		} catch (Throwable ex) {
			log.error("Initial SessionFactory creation failed." + ex);
		}
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AutomaticSchoolApiApplication.class);
	}

}
