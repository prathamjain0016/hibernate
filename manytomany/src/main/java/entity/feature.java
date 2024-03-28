package entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "feature")
public class feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feature_id")
    private Long id;

    @Column(name = "feature_name")
    private String name;

    @ManyToMany(mappedBy = "features")
    private List<vehicle> vehicles = new ArrayList<>();

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

	public List<vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public feature(Long id, String name, List<vehicle> vehicles) {
		super();
		this.id = id;
		this.name = name;
		this.vehicles = vehicles;
	}

	public feature() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

