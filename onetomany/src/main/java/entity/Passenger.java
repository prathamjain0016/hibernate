package entity;


import jakarta.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long id;

    @Column(name = "passenger_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private vehicle vehicle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Passenger(Long id, String name, entity.vehicle vehicle) {
		super();
		this.id = id;
		this.name = name;
		this.vehicle = vehicle;
	}

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

