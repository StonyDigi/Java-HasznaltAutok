package usedCar;

public class usedCarStorage {
	
	private String id;
	private String brand;
	private String type;
	private Integer engineVolume;
	private Integer numberOfPersonsTransported;
	private Integer vintage;
	private Integer price;
	private Integer kilometer;
	private String fuel;
	
	
	public usedCarStorage(String id, String brand, String type, Integer engineVolume,
			Integer numberOfPersonsTransported, Integer vintage, Integer price, Integer kilometer, String fuel) {
		super();
		this.id = id;
		this.brand = brand;
		this.type = type;
		this.engineVolume = engineVolume;
		this.numberOfPersonsTransported = numberOfPersonsTransported;
		this.vintage = vintage;
		this.price = price;
		this.kilometer = kilometer;
		this.fuel = fuel;
	}
	
	public String getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public String getType() {
		return type;
	}
	public Integer getEngineVolume() {
		return engineVolume;
	}
	public Integer getNumberOfPersonsTransported() {
		return numberOfPersonsTransported;
	}
	public Integer getVintage() {
		return vintage;
	}
	public Integer getPrice() {
		return price;
	}
	public Integer getKilometer() {
		return kilometer;
	}
	public String getFuel() {
		return fuel;
	}

	public String toString() {
		return this.id + "\t"+this.brand + "\t"+this.type + "\t"+this.engineVolume +
				"\t"+this.numberOfPersonsTransported + "\t"+this.vintage +
				"\t"+this.price + "\t"+this.kilometer + "\t"+this.kilometer;	
	}
}
