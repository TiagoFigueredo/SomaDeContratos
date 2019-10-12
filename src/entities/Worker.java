package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	public Worker(String name, WorkerLevel level, Double basesalary, Department department) {
		this.name = name;
		this.level = level;
		this.basesalary = basesalary;
		this.department = department;
	}
	private String name;
	private WorkerLevel level;
	private Double basesalary;
	private Department department;
	List<HourContract> list = new ArrayList<>();
	

	public void AddContracts(HourContract contract) {
		list.add(contract);
	}
	public void RemoveContract(HourContract contract) {
		list.remove(contract);
	}
	public double income(int year,int month) {
		double sum= basesalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract y : list) {
			cal.setTime(y.getDate());
			Integer yearcontract = cal.get(Calendar.YEAR);
			Integer monthcontract = 1 + cal.get(Calendar.MONTH); 
			if(yearcontract == year && monthcontract == month) {
				sum += y.totalValue();
			}
		}
		return sum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public Double getBasesalary() {
		return basesalary;
	}
	public void setBasesalary(Double basesalary) {
		this.basesalary = basesalary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<HourContract> getList() {
		return list;
	}
	public void setList(List<HourContract> list) {
		this.list = list;
	}

}

