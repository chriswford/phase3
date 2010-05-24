import java.util.HashMap;

public class CalendarCalc
{

	static final HashMap<String,Integer> MONTH_NAME_VALUES = new HashMap<String,Integer>()
	{{
		put("January",1);
		put("February",2);
		put("March",3);
		put("April",4);
		put("May",5);
		put("June",6);
		put("July",7);
		put("August",8);
		put("September",9);
		put("October",10);
		put("November",11);
		put("December",12);
	}};


	static final HashMap<Integer,String> MONTH_NUM_VALUES = new HashMap<Integer,String>()
	{{
		put(1,"January");
		put(2,"February");
		put(3,"March");
		put(4,"April");
		put(5,"May");
		put(6,"June");
		put(7,"July");
		put(8,"August");
		put(9,"September");
		put(10,"October");
		put(11,"November");
		put(12,"December");
	}};
	static final HashMap<Integer,Integer> START_DAYS_OF_MONTHS = new HashMap<Integer,Integer>()
	{{
		put(1,0);
		put(2,3);
		put(3,3);
		put(4,6);
		put(5,1);
		put(6,4);
		put(7,6);
		put(8,2);
		put(9,5);
		put(10,0);
		put(11,3);
		put(12,5);
	}};
	static final HashMap<Integer,Integer> START_DAYS_OF_MONTHS_LEAP = new HashMap<Integer,Integer>()
	{{
		put(1,6);
		put(2,2);
		put(3,3);
		put(4,6);
		put(5,1);
		put(6,4);
		put(7,6);
		put(8,2);
		put(9,5);
		put(10,0);
		put(11,3);
		put(12,5);
	}};
	static final HashMap<Integer,Integer> CENTURIES = new HashMap<Integer,Integer>()
	{{
		put(1700,4);
		put(1800,2);
		put(1900,0);
		put(2000,6);
		put(2100,4);
		put(2200,2);
		put(2300,0);
		put(2400,6);
		put(2500,4);
		put(2600,2);
	}};
	static final HashMap<String,Integer> DAY_NAMES = new HashMap<String,Integer>()
	{{
		put("Sunday",0);
		put("Monday",1);
		put("Tuesday",2);
		put("Wednesday",3);
		put("Thursday",4);
		put("Friday",5);
		put("Saturday",6);
	}};
	static final HashMap<Integer,String> DAY_NUMS = new HashMap<Integer,String>()
	{{
		put(0,"Sunday");
		put(1,"Monday");
		put(2,"Tuesday");
		put(3,"Wednesday");
		put(4,"Thursday");
		put(5,"Friday");
		put(6,"Saturday");
	}};
	//abbreviated day names
	static final HashMap<Integer,String> DAY_NUMS_SHORT = new HashMap<Integer,String>()
	{{
		put(0,"Sun");
		put(1,"Mon");
		put(2,"Tue");
		put(3,"Wed");
		put(4,"Thu");
		put(5,"Fri");
		put(6,"Sat");
	}};
	static final HashMap<Integer,Integer> DAYS_IN_MONTH = new HashMap<Integer,Integer>()
	{{
		put(1,31);
		put(2,28);
		put(3,31);
		put(4,30);
		put(5,31);
		put(6,30);
		put(7,31);
		put(8,31);
		put(9,30);
		put(10,31);
		put(11,30);
		put(12,31);
	}};
	static final HashMap<Integer,Integer> DAYS_IN_MONTH_LEAP = new HashMap<Integer,Integer>()
	{{
		put(2,29);
	}};
/*
	public static void main(String[] args)
	{
		int day_num=CalendarCalc.getDayNumOfWeek(2010,5,20);
		String day=CalendarCalc.getDayName(day_num);
		System.out.println(day+" "+day_num);

		System.out.println("\n\nWeeks in May: "+CalendarCalc.calcWeeks(2010, 5, 1,30));

		System.out.println("\n\nDays in Feb: "+CalendarCalc.calcEndDay(2000,2));


	}
*/
	public static String getDayName(int day_num)
	{
		return DAY_NUMS.get(day_num);
	}
	public static String getDayNameShort(int day_num)
	{
		return DAY_NUMS_SHORT.get(day_num);
	}
	public static int calcWeeks(int year,int month,int start_day,int end_day)
	{
		int weeks=1;
		int day_start_week=getDayNumOfWeek(year,month,start_day);
		//loop from start_day to end_day and get day of week, everytime we see a monday, we have a new week
		for(int c=start_day+1;c<=end_day;c++)
		{
			if(getDayNumOfWeek(year,month,c)==1)
				weeks++;
		}
		//returns # of weeks in the month in the rage of 4-6
		return weeks;
	}
	public static Boolean isLeapYear(int year)
	{
		return (year % 400 == 0) || ( (year % 4 == 0) && (year % 100 != 0));
	}
	public static int getDayNumOfWeek(Integer year,int month,int day_of_month)
	{
		//returns 1-7 based on the name of the day of the month

//		Now for an example of the complete algorithm, let's use April 24, 1982.
		int century=Integer.parseInt(year.toString().substring(0,2)+"00");
		int last_two_digits_of_year=year-century;

//	1)	Look up the 1900s in the centuries table: 0
		int step1=CENTURIES.get(century);
//	2)	Note the last two digits of the year: 82
		int step2=last_two_digits_of_year;
//	3)	Divide the 82 by 4: 82/4 = 20.5 and drop the fractional part: 20
		int step3=(int) Math.floor(step2/4);
//	4)	Look up April in the months table: 6
		int step4=0;
		if(isLeapYear(year))
			step4=START_DAYS_OF_MONTHS_LEAP.get(month);
		else
			step4=START_DAYS_OF_MONTHS.get(month);
//	5)	Add all numbers from steps 1Ð4 to the day of the month (in this case, 24): 0+82+20+6+24=132.
		int step5=(day_of_month)+step1+step2+step3+step4;
//	6)	Divide the sum from step 5 by 7 and find the remainder: 132/7=18 remainder 6
		int day_num_of_week=step5%7;
//	7)	Find the remainder in the days table: 6=Saturday.

		return day_num_of_week;
	}
	public static int monthNum(String name)
	{
		//returns # value of month when given corresponding string name
		return MONTH_NAME_VALUES.get(name);
	}
	public static String monthName(int month)
	{
		return MONTH_NUM_VALUES.get(month);
	}
	public static int calcEndDay(int year,int month)
	{
		//returns last day of month in number form based on month m (1-12)
		if(isLeapYear(year))
			return DAYS_IN_MONTH_LEAP.get(month);
		else
			return DAYS_IN_MONTH.get(month);
	}

}
