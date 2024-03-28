package entity;

import jakarta.persistence.*;


import java.util.*;


@Entity
@Table(name = "vehicle")
public class vehicle {

    public vehicle(Long id, String name, List<Passenger> passengers) {
		super();
		this.id = id;
		this.name = name;
		this.passengers = passengers;
	}

	public vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long id;

    @Column(name = "vehicle_name")
    private String name;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList<>();

    // Getters and setters
    // Constructors
    // Other methods
}
