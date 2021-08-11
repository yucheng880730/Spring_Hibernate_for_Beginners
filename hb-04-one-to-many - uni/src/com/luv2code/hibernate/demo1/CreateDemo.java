package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Instructor.class)
                                 .addAnnotatedClass(InstructorDetail.class)
                                 .buildSessionFactory();


        // create session
        Session session = factory.getCurrentSession();

        try {

            // create the objects

            /*
            Instructor tempInstructor =
                    new Instructor("Leo", "Lin", "yucheng2k13@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "https://wwwluv2code.com.youtube",
                            "love to code!!!"
                    );

            */

            Instructor tempInstructor =
                    new Instructor("Amy", "Lin", "Amy2k13@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "https://wwwluv3code.com.youtube",
                            "love to eat!!!"
                    );

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            //
            // Note: this will ALSO save the details object
            // because of CascadeType.ALL
            //
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        } finally {
            factory.close();
        }



    }
}
