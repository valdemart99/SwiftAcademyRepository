import java.util.*;

public class Task3_VehicleMonitor {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		double f = input.nextDouble();
		input.nextLine();
		int regNo = 0;
		Vehicle[] vehList = new Vehicle[n];
		double[] distance = new double[n];
		
		for (int i = 0; i < n; ++i) {
			String[] tempArr = input.nextLine().split(", ");
			vehList[i] = new Vehicle(tempArr[0], tempArr[1], Short.valueOf(tempArr[2]),
					Float.valueOf(tempArr[3]),Short.valueOf(tempArr[4]), regNo);
			distance[i] = Double.valueOf(tempArr[5]);
			if (tempArr.length == 8) {
				vehList[i].setWeight(Float.valueOf(tempArr[6]));
				vehList[i].setColor(tempArr[7]);
			}
			regNo++;
		}
		
		input.close();
		
		for (int j = 0; j < n; ++j) {
			System.out.format("%04d - %s, %d, %s\nInsurance cost: %.2f - Travel cost: %.2f\n",
					vehList[j].getLicenseNo(), vehList[j].getModel(), vehList[j].getYearProduced(),
					vehList[j].getColor(), vehList[j].getInsurancePrice(),
					vehList[j].calculateTripPrice(f, distance[j]));
		}
		
	}
	
}

class Vehicle {
	private String type;
	private String model;
	private short power;
	private float fuelConsumption;
	private short yearProduced;
	private int licenseNo;
	private float weight = -1;
	private String color = "N/A";
	
	public Vehicle(String type,	String model, short power, 
			float fuelConsumption, short yearProduced, int licenseNo) {
		this.type = type;
		this.model = model;
		this.power = power;
		this.fuelConsumption = fuelConsumption;
		this.yearProduced = yearProduced;
		this.licenseNo = licenseNo;
	}
	
	public Vehicle(String type,	String model, short power, 
			float fuelConsumption, short yearProduced, int licenseNo,
			float weight, String color) {
		this.type = type;
		this.model = model;
		this.power = power;
		this.fuelConsumption = fuelConsumption;
		this.yearProduced = yearProduced;
		this.licenseNo = licenseNo;
		this.weight = weight;
		this.color = color;
	}
	
	double calculateTripPrice (double fuelPrice, double distance) {
		return (distance / 100) * this.fuelConsumption * fuelPrice;
	}
	
	double getInsurancePrice() {
		double typeCoefficient = 1;
		
		if (this.type.equals("suv")) {
			typeCoefficient = 1.12;
		} else if (this.type.equals("truck")) {
			typeCoefficient = 1.20;
		} else if (this.type.equals("motorcycle")){
			typeCoefficient = 1.50;
		}  else if (this.type.equals("car")){
			typeCoefficient = 1;
		}
		return (0.16 * this.power) * ( 1.25 * (2016 - this.yearProduced)) * 
				(0.05 * this.fuelConsumption) * typeCoefficient;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public short getPower() {
		return power;
	}

	public void setPower(short power) {
		this.power = power;
	}

	public float getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(float fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public short getYearProduced() {
		return yearProduced;
	}

	public void setYearProduced(short yearProduced) {
		this.yearProduced = yearProduced;
	}

	public int getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(int licenseNo) {
		this.licenseNo = licenseNo;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}