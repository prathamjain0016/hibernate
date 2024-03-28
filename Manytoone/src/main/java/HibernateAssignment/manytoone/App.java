package HibernateAssignment.manytoone;





import HibernateAssignment.manytoone.HibernateUtils;
import entity.vehicle;
import entity.brand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;


public class App
{
    public static void main( String[] args )
    {

        brand b1 = new brand();
        b1.setName("Hyundai");
        List<vehicle> list = new ArrayList<>();

        vehicle v1 = new vehicle();
        v1.setName("Creta");
        list.add(v1);

        vehicle v2 = new vehicle();
        v2.setName("venue");
        list.add(v2);

        v1.setBrand(b1);
        v2.setBrand(b1);
        b1.setVehicles(list);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(b1);

        session.getTransaction().commit();

        System.out.println("Printing from brand -: ");
        brand saved = session.get(brand.class, 1L);
        System.out.println(saved.getName());

        System.out.println("Printing from vehicle -: ");
        vehicle savedVehicle1 = session.get(vehicle.class, 1L);
        System.out.println(savedVehicle1.getName());

        vehicle savedVehicle2 = session.get(vehicle.class, 2L);
        System.out.println(savedVehicle2.getName());

    }
}