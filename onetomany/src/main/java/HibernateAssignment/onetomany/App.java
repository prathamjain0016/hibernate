package HibernateAssignment.onetomany;



import HibernateAssignment.onetomany.HibernateUtils;
import entity.vehicle;
import entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;


public class App
{
    public static void main( String[] args )
    {

        vehicle v1 = new vehicle();
        v1.setName("Creta");
        List<Passenger> list = new ArrayList<>();

        Passenger pc1 = new Passenger();
        pc1.setName("Ankit");
        list.add(pc1);

        Passenger pc2 = new Passenger();
        pc2.setName("Tanishq");
        list.add(pc2);

        pc1.setVehicle(v1);
        pc2.setVehicle(v1);
        v1.setPassengers(list);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(v1);

        session.getTransaction().commit();

        System.out.println("Printing from vehicle -: ");
        vehicle saved = session.get(vehicle.class, 1L);
        System.out.println(saved.getName());

        System.out.println("Printing from Passenger -: ");
        Passenger savedPess = session.get(Passenger.class, 1L);
        System.out.println(savedPess.getName());

        Passenger savedPess2 = session.get(Passenger.class, 2L);
        System.out.println(savedPess2.getName());

        session.close();
    }
}