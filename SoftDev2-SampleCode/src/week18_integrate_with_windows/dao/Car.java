package week18_integrate_with_windows.dao;

public class Car {
	long id;
	String regNum;
	String make;
	int engineCC;
	public Car(long id, String regNum, String make, int engineCC) {
		super();
		this.id = id;
		this.regNum = regNum;
		this.make = make;
		this.engineCC = engineCC;
	}
	public Car() {
		super();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRegNum() {
		return regNum;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getEngineCC() {
		return engineCC;
	}
	public void setEngineCC(int engineCC) {
		this.engineCC = engineCC;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + engineCC;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((regNum == null) ? 0 : regNum.hashCode());
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
		Car other = (Car) obj;
		if (engineCC != other.engineCC)
			return false;
		if (id != other.id)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (regNum == null) {
			if (other.regNum != null)
				return false;
		} else if (!regNum.equals(other.regNum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", regNum=" + regNum + ", make=" + make + ", engineCC=" + engineCC + "]";
	}
	

}
