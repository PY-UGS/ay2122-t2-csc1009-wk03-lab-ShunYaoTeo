import java.util.Date;
import java.lang.Math;
import java.util.Scanner;


public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loadDate = new Date();

    public void Loan() {
        this.annualInterestRate = 2.5;
        this.numberOfYears = 1;
        this.loanAmount = 1000;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {
        double monthlyPayment = (this.loanAmount * ((this.annualInterestRate / 12)/100) / (1 - (1 / (Math.pow((1 + ((this.annualInterestRate / 12)/100)), (this.numberOfYears * 12))))));
        return monthlyPayment;
    }

    public double getTotalPayment(){
        double totalPayment = (this.getMonthlyPayment())*this.numberOfYears*12;
        return totalPayment;
    }

    public static void main(String args[]) {
        Loan loan1 = new Loan();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        double myInterest = input.nextFloat();
        System.out.print("\nEnter number of years as an integer: ");
        int myYears = input.nextInt();
        System.out.print("\nEnter loan amount, for example, 12000.95: ");
        double myLoan = input.nextFloat();

        loan1.setAnnualInterestRate(myInterest);
        loan1.setNumberOfYears(myYears);
        loan1.setLoanAmount(myLoan);

        System.out.println("The loan was created on " + loan1.getLoadDate());
        System.out.printf("The monthly payment is: %.2f.\n" ,loan1.getMonthlyPayment());
        System.out.printf("The total payment is: %.2f." ,loan1.getTotalPayment());


    }
}