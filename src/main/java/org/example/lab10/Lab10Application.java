package org.example.lab10;

import org.example.lab10.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, FlywayAutoConfiguration.class})
public class Lab10Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab10Application.class, args);
    }

    @Bean
    public CommandLineRunner demoRunner() {
        return args -> {
            University university = University.builder()
                    .name("ВГУ")
                    .build();

            Lecturer lecturer = Lecturer.builder()
                    .name("Sos")
                    .email("123@mimimi.ru")
                    .researchArea("Mathematics")
                    .hireDate(LocalDate.now())
                    .build();

            Faculty faculty = Faculty.builder()
                    .name("Faculty of Mathematics")
                    .build();

            Department department = Department.builder()
                    .name("Mathematics Department")
                    .address("Lenina 1")
                    .faculty(faculty)
                    .build();

            Course course = Course.builder()
                    .title("Calculus 101")
                    .department(department)
                    .build();

            Student student = Student.builder()
                    .name("Ivan Ivanov")
                    .email("ivan@example.com")
                    .matriculationNumber("M123456")
                    .build();

            Researcher researcher = Researcher.builder()
                    .name("Dr. Smith")
                    .email("smith@uni.example")
                    .researchArea("Artificial Intelligence")
                    .build();

            Project project = Project.builder()
                    .title("AI Research")
                    .build();

            ResearcherProject rp = new ResearcherProject();
            rp.setResearcher(researcher);
            rp.setProject(project);

            researcher.getProjects().add(rp);
            project.getResearcherProjects().add(rp);

            Lecturer lecturer2 = Lecturer.builder()
                    .name("Prof. Parker")
                    .email("parker@uni.example")
                    .researchArea("Algebra")
                    .hireDate(LocalDate.now())
                    .build();

            TeachingAssignment ta = new TeachingAssignment();
            ta.setLecturer(lecturer2);
            ta.setCourse(course);

            lecturer2.getTeachingAssignments().add(ta);
            course.getTeachingAssignments().add(ta);

            faculty.getDepartments().add(department);
            university.getFaculties().add(faculty);
            department.getCourses().add(course);

            System.out.println("==== Demo objects created ====");
            System.out.println("University: " + university.getName() + ", faculties=" + university.getFaculties().size());
            System.out.println("Faculty: " + faculty.getName() + ", departments=" + faculty.getDepartments().size());
            System.out.println("Department: " + department.getName() + ", address=" + department.getAddress() + ", courses=" + department.getCourses().size() + ", employees=" + department.getEmployees().size());
            System.out.println("Course: " + course.getTitle() + ", teachingAssignments=" + course.getTeachingAssignments().size());
            System.out.println("Lecturer (created earlier): " + lecturer.getName() + ", email=" + lecturer.getEmail() + ", researchArea=" + lecturer.getResearchArea());
            System.out.println("Lecturer2: " + lecturer2.getName() + ", teachingAssignments=" + lecturer2.getTeachingAssignments().size());
            System.out.println("Student: " + student.getName() + ", matriculationNumber=" + student.getMatriculationNumber());
            System.out.println("Researcher: " + researcher.getName() + ", researchArea=" + researcher.getResearchArea() + ", projects=" + researcher.getProjects().size());
            System.out.println("Project: " + project.getTitle() + ", researcherProjects=" + project.getResearcherProjects().size());
            System.out.println("==== End of demo ====");
        };
    }

}
