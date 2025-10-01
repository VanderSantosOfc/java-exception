package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import model.entities.Account;

public class MainProgram {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int numAccount = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String nameHolder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw: ");
			double withdraw = sc.nextDouble();
			Account account = new Account(numAccount, nameHolder, balance, withdraw);
			
			System.out.println();
			System.out.print("Enter amonut for withdraw: ");
			withdraw = sc.nextDouble();
			account.withdraw(withdraw);
			System.out.println(account);
		}
		catch(AccountException a) {
			System.out.println(a.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid data. Check the completed fields.");
		}
		
		sc.close();
	}

}
