package problems;

import java.util.HashMap;
import java.util.Scanner;

public class DateDifference {
	static HashMap<Integer, Integer> monthsNDays= new HashMap<Integer, Integer>();

	public static void main(String[] args) throws Exception {
		monthsNDays.put(1, 31);
		monthsNDays.put(2, 28);
		monthsNDays.put(3, 31);
		monthsNDays.put(4, 30);
		monthsNDays.put(5, 31);
		monthsNDays.put(6, 30);
		monthsNDays.put(7, 31);
		monthsNDays.put(8, 31);
		monthsNDays.put(9, 30);
		monthsNDays.put(10, 31);
		monthsNDays.put(11, 30);
		monthsNDays.put(12, 31);

		Scanner sc= new Scanner(System.in);

		System.out.println("Please enter the dates");
		String line="";
		while(sc.hasNextLine()){
			String[] dates=sc.nextLine().split(" ");
			if(dates.length==6){
				MyDate date1= new MyDate(Integer.parseInt(dates[0].trim()), Integer.parseInt(dates[1].trim()), Integer.parseInt(dates[2].trim()));
				MyDate date2= new MyDate(Integer.parseInt(dates[3].trim()), Integer.parseInt(dates[4].trim()), Integer.parseInt(dates[5].trim()));
				getDateDifferenceInDays(date1,date2);
			}
			else{
				throw new Exception("invalid input");
			}


		}

	}

	private static void getDateDifferenceInDays(MyDate date1, MyDate date2) {

		int diffWithMonths=0, diffWithDays=0, diffWithYears=0;
		int month1=date1.getMonth();
		int month2=date2.getMonth();
		int year1=date1.getYear();
		int year2=date2.getYear();
		if(year1==year2){

			for(int i=month1+1;i<month2;i++){
				diffWithMonths+=monthsNDays.get(i);
				System.out.println("diffwith months"+diffWithMonths);
			}
			System.out.println("diffwith months:  "+diffWithMonths);

		}
		else{
			if(year2>year1){
				int noOfMonths1=12-month1;
				System.out.println("total no of full months in first year "+noOfMonths1);
				for(int i=month1+1;i<=noOfMonths1;i++){
					diffWithMonths+=monthsNDays.get(i);
				}
				for(int j=1;j<=month2-1;j++){
					diffWithMonths+=monthsNDays.get(j);
				}
				//diffWithDays+=(monthsNDays.get(month1)-date1.getDay())+date2.getDay();
				if((year2-year1>1)){
					for(int i=year1;i<year2;i++){
						if(year1%4==0){
							diffWithYears+=1;
						}
						diffWithYears+=365;
					}

				}


			}
		}
		diffWithDays+=(monthsNDays.get(month1)-date1.getDay())+date2.getDay();
		System.out.println("diff with days:"+diffWithDays);
		System.out.println(diffWithDays+diffWithMonths+diffWithYears);

	}



}

class MyDate{
	int month, day, year;


	public MyDate() {
		// TODO Auto-generated constructor stub
	}

	public MyDate(int month, int day, int year) {
		this.month=month;
		this.day=day;
		this.year=year;

	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
