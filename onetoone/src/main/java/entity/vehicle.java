package entity;

import jakarta.persistence.*;



@Entity
@Table(name = "vehicle")
public class vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int id;

    @Column(name = "vehicle_name")
    private String name;

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private registrationNumber registrationNumber;

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public registrationNumber getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(registrationNumber registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public vehicle(int id, String name, entity.registrationNumber registrationNumber) {
		super();
		this.id = id;
		this.name = name;
		this.registrationNumber = registrationNumber;
	}

	public vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
