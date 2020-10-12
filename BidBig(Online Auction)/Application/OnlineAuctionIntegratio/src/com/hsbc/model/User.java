package com.hsbc.model;

public class User {

	private long uniqueId;
	private String name;
	private String dateOfBirth;
	private long phoneNo;
	private String address;
	private boolean userType;
	private double walletAmount;

	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(long uniqueId, String name, String dateOfBirth, long phoneNo, String address, boolean userType,
			double walletAmount) {
		super();
		this.uniqueId = uniqueId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phoneNo = phoneNo;
		this.address = address;
		this.userType = userType;
		this.walletAmount = walletAmount;
	}

	
	
	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isUserType() {
		return userType;
	}

	public void setUserType(boolean userType) {
		this.userType = userType;
	}

	public double getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (phoneNo ^ (phoneNo >>> 32));
		result = prime * result + (int) (uniqueId ^ (uniqueId >>> 32));
		result = prime * result + (userType ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(walletAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNo != other.phoneNo)
			return false;
		if (uniqueId != other.uniqueId)
			return false;
		if (userType != other.userType)
			return false;
		if (Double.doubleToLongBits(walletAmount) != Double.doubleToLongBits(other.walletAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [uniqueId=" + uniqueId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", userType=" + userType + ", walletAmount=" + walletAmount + "]";
	}

}
