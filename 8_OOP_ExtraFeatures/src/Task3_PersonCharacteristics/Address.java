package Task3_PersonCharacteristics;

public class Address {
	private String country;
	private String city;
	private String municipality;
	private short postalCode;
	private String street;
	private short number;
	private short floor;
	private short apartmentNo;
	
	public Address(String country, String city, String municipality, short postalCode,
			String street, short number, short floor, short apartmentNo) {
		this.country = country;
		this.city = city;
		this.municipality = municipality;
		this.postalCode = postalCode;
		this.street = street;
		this.number = number;
		this.floor = floor;
		this.apartmentNo = apartmentNo;
	}
	
	public Address(String country, String city, String municipality, short postalCode,
			String street, short number) {
		this.country = country;
		this.city = city;
		this.municipality = municipality;
		this.postalCode = postalCode;
		this.street = street;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s Street\n%s%d %s\n%s, %s\n",
				this.number,
				this.street,
				(this.floor != 0 && this.apartmentNo !=0 ?
						String.format("fl. %d, ap. %d\n", this.floor, this.apartmentNo) : ""),
				this.postalCode,
				this.municipality,
				this.city,
				this.country);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (apartmentNo != other.apartmentNo)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (floor != other.floor)
			return false;
		if (municipality == null) {
			if (other.municipality != null)
				return false;
		} else if (!municipality.equals(other.municipality))
			return false;
		if (number != other.number)
			return false;
		if (postalCode != other.postalCode)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getMunicipality() {
		return municipality;
	}

	public short getPostalCode() {
		return postalCode;
	}

	public String getStreet() {
		return street;
	}

	public short getNumber() {
		return number;
	}

	public short getFloor() {
		return floor;
	}

	public short getApartmentNo() {
		return apartmentNo;
	}
}
