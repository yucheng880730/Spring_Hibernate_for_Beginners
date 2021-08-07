package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();


        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // query the students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display the students
            extracted(theStudents);

            //query students: lastName="Lin"
            theStudents = session.createQuery("from Student s where s.lastName='Lin'").getResultList();

            // display the students
            System.out.println("\n\nStudents who have last name of Lin");
            extracted(theStudents);

            // query students: lastName="Lin" OR firstName="Amy"
            theStudents =
                    session.createQuery("from Student s where"
                            + " s.lastName='Lin' OR s.firstName='Alice'").getResultList();

            System.out.println("\n\nStudents who have last name of Lin OR first name Amy");
            extracted(theStudents);

            // query students where email LIKE '%gmail.com.tw'
            theStudents = session.createQuery("from Student s where"
                    + " s.email LIKE '%gmail.com.tw'").getResultList();

            System.out.println("\n\nStudents who email ends with gmail.com");
            extracted(theStudents);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        } finally {
            factory.close();
        }



    }

    private static void extracted(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
