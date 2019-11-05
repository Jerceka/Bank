import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DB make = new DB();
		Scanner input = new Scanner(System.in);
		System.out.println("");
		System.out.println("+--------------------------------+");
		System.out.println("|                                |");
		System.out.println("|          Welcome               |");
		System.out.println("|         City Bank              |");
		System.out.println("|                                |");
		System.out.println("+--------------------------------+");
		System.out.println("IF u have Account please press 1");
		System.out.println("IF it's your first time be here and would like make account please 2");
		int z = input.nextInt();
		if(z == 1) {
			System.out.println("Please put your Name");
			String URN = input.next();
			System.out.println("Welcome " + URN  +
					"\nYour Age : "+make.GetAge(URN)+ 
					"\nWhat you have now : "+make.GetMoney(URN));
			System.out.println("IF you want to put more money Please  press 1");
			System.out.println("IF you want to withdraw more money Please  press 2");
			System.out.println("IF you to Delete your account please press 3");
			int Choose = input.nextInt();
			if(Choose == 1) {
				System.out.println("How much Money you will put:");
				int add = input.nextInt();
				make.AddMoney(URN, add);
			}
			else if(Choose == 2) {
				System.out.println("how much money you want to withdraw");
				int W = input.nextInt();
				make.Withdraw(URN, W);
			}
			else if(Choose == 3) {
				make.DeleteAccount(URN);
			}
		}else if(z == 2) {
			System.out.println("Can you help us to make your Account");
			System.out.println("please enter you Name:");
			String NA = input.next();
			System.out.println("please Enter your Age:");
			int AA = input.nextInt();
			System.out.println("please Enter how much Money u will put:");
			int MA = input.nextInt();
			make.Setver(NA,AA , MA);
			System.out.println(make.get());
			make.MakeAccount();
		}
	}
}
  