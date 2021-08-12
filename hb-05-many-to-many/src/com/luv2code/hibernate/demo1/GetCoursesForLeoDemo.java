package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForLeoDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Instructor.class)
                                 .addAnnotatedClass(InstructorDetail.class)
                                 .addAnnotatedClass(Course.class)
                                 .addAnnotatedClass(Review.class)
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();


        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the student Leo from the database
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);

            System.out.println("\nLoaded student: " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourses());


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        } finally {

            // add clean up code
            session.close();

            factory.close();
        }



    }
}
