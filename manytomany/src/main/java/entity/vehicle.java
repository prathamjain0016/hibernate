package entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long id;

    @Column(name = "vehicle_name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "vehicle_feature",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private List<feature> features = new ArrayList<>();

	public vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public vehicle(Long id, String name, List<feature> features) {
		super();
		this.id = id;
		this.name = name;
		this.features = features;
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

	public List<feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<feature> features) {
		this.features = features;
	}

}

