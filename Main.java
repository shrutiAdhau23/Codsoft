import java.util.*;
class BankAccount2
{
	private double balance ;

	public BankAccount2(double balance)
	{
		this.balance=balance;
	}
	public double Check()
	{
		return balance;
	}

	public void deposit(double money)
	{
		if(money>0)
		{
			balance+=money;
			System.out.println("money deposited susessfully!");
		}
		else
		{
			System.out.println("Invalid Transaction ");
		}
	}

	public void withdrawl(double amount)
	{
		if(amount>0 && amount<=balance)
		{
			balance-=amount;
			System.out.println("Money withdrawl sucseeful!");
		}
		else
		{
		System.out.println("your withdrawl is not valid");
		}
	}
}

class Atm
{
	private BankAccount2  account;
	public Atm(BankAccount2  account)
	{
		this.account=account;
	}

	public void menu()
	{
		System.out.println("1: check Balance");
		System.out.println("2: depositing amount");
		System.out.println("3:withdrawal amount");
		System.out.println("4:Exit");

	}

	public void excute()
	{
		Scanner sc=new Scanner(System.in);
		boolean exit=false;
		while(!exit)
		{
			menu();
			System.out.println("enter ur choice");
			int choice=sc.nextInt();


			switch(choice)
			{
				case 1:System.out.println("your account balance is :" +account.Check());
				break;

				case 2:
				System.out.println("enter depositing amount");
				double amt=sc.nextDouble();
				account.deposit(amt);
				break;

				case 3:
				System.out.println("enter withdrawl amount");
				double wamt=sc.nextDouble();
				account.withdrawl(wamt);
				break;

				case 4:
                    System.out.println("Exiting the ATM program.");
                    exit = true;
                    break;

				default:
				System.out.println("Invaliid choice");

			}
		}
	}
}
public class AccountDriver
{
	public static void main (String [] args)
	{
		BankAccount2 user =new BankAccount2(0);
		Atm atm=new Atm(user);
		atm.excute();
	}
}
