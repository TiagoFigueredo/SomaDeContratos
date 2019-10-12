package aplicattion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;



public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc =  new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter department's name: ");
		String namedepartmente = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String Level = sc.nextLine();
		System.out.println("Base salary: ");
		Double basesalary = sc.nextDouble();
		Worker worker = new Worker(name,WorkerLevel.valueOf(Level),basesalary,new Department(namedepartmente));
		System.out.print("How many contracts to this worker? ");	
		int numscontracts = sc.nextInt();
		for(int i=0;i<numscontracts;i++) {
			System.out.printf("Enter contract #%d data: ",i+1);
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Value per hour: ");
			Double valueperhour = sc.nextDouble();
			System.out.println("Duration (hours): ");
			Integer duration = sc.nextInt();
			HourContract contract = new HourContract(contractDate,valueperhour,duration);
			worker.AddContracts(contract);
		}
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthandyear = sc.next();
		int month = Integer.parseInt(monthandyear.substring(0, 2));
		int year = Integer.parseInt(monthandyear.substring(3));

		System.out.print("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		
		System.out.println("Income for " + monthandyear + worker.income(year, month));
		sc.close();
	
}
	
}
