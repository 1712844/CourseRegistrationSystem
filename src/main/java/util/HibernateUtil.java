package util;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.lang.Class;
import java.util.Properties;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        }catch (Throwable ex) {
            System.err.println("Session Factory could not be created." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
//    private static SessionFactory sessionFactory;
//    public static SessionFactory getSessionFactory(){
//        if(sessionFactory == null){
//            try{
//                Configuration configuration = new Configuration();
//
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/courseregistrationsystem_db?useSSL=false");
//                settings.put(Environment.USER, "root");
//                settings.put(Environment.PASS, "lmfao#123");
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//
//                settings.put(Environment.SHOW_SQL, "true");
//
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//
//                configuration.setProperties(settings);
//
//                configuration.addAnnotatedClass(Account.class);
//                configuration.addAnnotatedClass(Class.class);
//                configuration.addAnnotatedClass(Course.class);
//                configuration.addAnnotatedClass(CourseRegistrationSession.class);
//                configuration.addAnnotatedClass(Department.class);
//                configuration.addAnnotatedClass(Room.class);
//                configuration.addAnnotatedClass(Semester.class);
//                configuration.addAnnotatedClass(Shift.class);
//                configuration.addAnnotatedClass(Student.class);
//                configuration.addAnnotatedClass(Teacher.class);
//                configuration.addAnnotatedClass(User.class);
//                configuration.addAnnotatedClass(Staff.class);
//
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//
//                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            } catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
//    }
}