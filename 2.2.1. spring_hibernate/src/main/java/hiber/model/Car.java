package hiber.model;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carId")
	private long id;
	private String model;
	private int series;
	
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", series=" + series + "]";
	}

	public Car() {
		
	}
	
	public Car(String model, int series) {
		this.model = model;
		this.series = series;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}
	
	
}
