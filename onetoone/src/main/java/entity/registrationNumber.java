package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registration_number")
public class registrationNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_number_id")
    private Long id;

    @Column(name = "reg_number")
    private String registrationNumber;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private vehicle vehicle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public registrationNumber(Long id, String registrationNumber, entity.vehicle vehicle) {
		super();
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.vehicle = vehicle;
	}

	public registrationNumber() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}

