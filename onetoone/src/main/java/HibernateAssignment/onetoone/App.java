package HibernateAssignment.onetoone;

import HibernateAssignment.onetoone.HibernateUtils; 
import entity.vehicle;
import entity.registrationNumber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        vehicle v1 = new vehicle();
        v1.setName("Creta");
        

        registrationNumber r1 = new registrationNumber();
        r1.setRegistrationNumber("UK08BM5158");

        v1.setRegistrationNumber(r1);
        r1.setVehicle(v1);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(v1);

        session.getTransaction().commit();

        System.out.println("Printing from vehicle -: ");
        vehicle savedVehicle = session.get(vehicle.class, 1);
        System.out.println(savedVehicle.getName());

        System.out.println("Printing from RegistrationNumber -: ");
        registrationNumber number = session.get(registrationNumber.class, 1);
        System.out.println(number.getRegistrationNumber());

        session.close();
    }
}