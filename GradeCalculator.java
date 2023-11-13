import java.util.Scanner;
class GradeCalculator
{
	public static void main(String arg[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter School name :");
		String School=s.nextLine();
		System.out.println("enter exam:");
		String exam=s.next();
		s.next() ;
		System.out.println("enter name: ");
		String name=s.next();
		s.next() ;
		System.out.println("enter section ");
		char sec=s.next().charAt(0);
		System.out.println("enter class:");
		int Class=s.nextInt();
		System.out.println("enter Roll no:");
		int rollno=s.nextInt();
		
		System.out.println("enter English marks:");
		int english=s.nextInt();
		System.out.println("enter Marathi marks:");
		int marathi=s.nextInt();
		System.out.println("enter Hindi marks:");
		int hindi=s.nextInt();
		System.out.println("enter Mathematics marks:");
		int maths=s.nextInt();
		System.out.println("enter Science marks:");
		int science=s.nextInt();
		
		String gradeEnglish =calculateGrade(english) ;
		String gradeMarathi =calculateGrade(marathi) ;
		String gradeHindi =calculateGrade(hindi) ;
		String gradeMaths =calculateGrade(maths) ;
		String gradeScience =calculateGrade(science) ;
		
		
		int total=english+marathi+hindi+maths+science;
		double per=total/5.0;
		
		String remark;
		if (per<35 || gradeEnglish.equals("Fail")||gradeMarathi.equals("Fail")||gradeHindi.equals("Fail")||gradeMaths.equals("Fail")||gradeScience.equals("Fail"))
			remark="Fail";
		else if (per>35&&per<50)
			remark="Pass";
		else if (per>50&&per<75)
			remark="Good";
		else if (per>75&&per<85)
			remark="Very Good";
		else if (per>85&&per<95)
			remark="Better";
		else
			remark="BEST";
		
		System.out.println("your marksheet is below .....");
		System.out.println();
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("             "+School);
		System.out.println("                             "+exam);
		System.out.println("Name  :"+name+"                                 "+"section  :"+sec);
		System.out.println("Class :"+Class+"                                           "+"Roll no  :"+rollno);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Subject"+"   |   "+"total marks"+"    |   "+"obtained marks"+"   |    "+"Grade");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("English  "+"      "+"    100    "+"         "+    english     +"                       "+  gradeEnglish);
		
		System.out.println();
		System.out.println("Marathi  "+"      "+"    100    "+"         "+    marathi     +"                       "+  gradeMarathi);
		
		System.out.println();
		System.out.println("Hindi    "+"      "+"    100    "+"         "+    hindi       +"                       "+  gradeHindi);
		
		System.out.println();
		System.out.println("Mathematics"+"    "+"    100    "+"         "+    maths       +"                       "+  gradeMaths);
		
		System.out.println();
		System.out.println("Science  "+"      "+"    100    "+"         "+    science     +"                       "+  gradeScience);
		
		System.out.println();
		System.out.println("---------------------------------------------------------------------");
		System.out.println();
		System.out.println("Percentage :"+per+"%"+"                                 "+"Remarks:"+remark );
		if(remark.equals("Fail"))
		{
			Class = Class ;
		}
		else if(Class < 12 )
		{
			System.out.println("Result: Promoted class "+ (Class+1) );
		}
		else 
		{
			System.out.println("Eligible for Graduation") ;
		}
		
		System.out.println("---------------------------------------------------------------------");
	}
	public static String calculateGrade(int marks)
	{
		if(marks<35)
			return "Fail" ;
		else if(marks<50)
			return "D" ;
		else if(marks <75)
			return "C" ;
		else if(marks <85)
			return "B" ;
		else if(marks <95)
			return "A" ;
		else
			return "A+" ;
	}
}