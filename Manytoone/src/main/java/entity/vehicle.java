package entity;


import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long id;

    @Column(name = "vehicle_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private brand brand;

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

	public brand getBrand() {
		return brand;
	}

	public void setBrand(brand brand) {
		this.brand = brand;
	}

	public vehicle(Long id, String name, entity.brand brand) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
	}

	public vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and setters
    // Constructors
    // Other methods
}

