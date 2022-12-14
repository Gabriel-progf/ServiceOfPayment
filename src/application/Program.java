package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalPaymentServices;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		Double totalvalue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalvalue);
		
		
		System.out.print("Enter number of installments: ");
		int n = sc.nextInt();
		
		ContractService cs = new ContractService(new PaypalPaymentServices());
		
		cs.processConstract(contract, n);
		
		
		System.out.println("Installments: ");
		for (Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		
		
		sc.close();
	}

}
