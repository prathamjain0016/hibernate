package HibernateAssignment.manytomany;

import HibernateAssignment.manytomany.HibernateUtils;
import entity.vehicle;
import entity.feature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;


public class App
{
    public static void main( String[] args )
    {

        feature f1 = new feature();
        f1.setName("ADAS");
        
        feature f2 = new feature();
        f2.setName("ABS");
        List<feature> f_list = new ArrayList<>();
        f_list.add(f1);
        f_list.add(f2);

        vehicle v1 = new vehicle();
        v1.setName("Creta");
        vehicle v2 = new vehicle();
        v2.setName("venue");
        List<vehicle> v_list = new ArrayList<>();
        
        v_list.add(v1);
        v_list.add(v2);

        f1.setVehicles(v_list);
        f2.setVehicles(v_list);
        
        v1.setFeatures(f_list);
        v2.setFeatures(f_list);
        

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(f1);
        session.persist(f2);
        session.persist(v1);
        session.persist(v2);

        session.getTransaction().commit();

        System.out.println("Printing from feature -: ");
        feature saved = session.get(feature.class, 1L);
        System.out.println(saved.getName());
        
        feature saved1 = session.get(feature.class, 2L);
        System.out.println(saved1.getName());
        
        

        System.out.println("Printing from vehicle -: ");
        vehicle savedVehicle1 = session.get(vehicle.class, 1L);
        System.out.println(savedVehicle1.getName());

        vehicle savedVehicle2 = session.get(vehicle.class, 2L);
        System.out.println(savedVehicle2.getName());

    }
}
