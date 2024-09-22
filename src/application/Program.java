package application;

import javax.swing.JOptionPane;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		try {
			JOptionPane.showMessageDialog(null, "Enter account data:");
			int number = Integer.parseInt(JOptionPane.showInputDialog("Account number: "));
			String holder = JOptionPane.showInputDialog("Holder: ");
			double initialBalance = Double.parseDouble(JOptionPane.showInputDialog("Initial balance: "));
			double withdrawLimit = Double.parseDouble(JOptionPane.showInputDialog("Withdraw limit:"));
			Account account = new Account(number, holder, initialBalance, withdrawLimit);

			double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to withdraw:"));
			account.withdraw(amount);
			JOptionPane.showMessageDialog(null, "New balance: $ " + String.format("%.2f", account.getBalance()));
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Unexpected error.", null, JOptionPane.ERROR_MESSAGE);
		}
	}
}
