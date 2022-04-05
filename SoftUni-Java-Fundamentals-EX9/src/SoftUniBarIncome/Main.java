package SoftUniBarIncome;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        Pattern path=Pattern.compile("^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quant>[0-9]*)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$");
        double finalPrice=0.00;



        while (!input.equals("end of shift")){
            Matcher match = path.matcher(input);
            while (match.find()){
                String name=match.group("name");
                String product=match.group("product");
                String quan=match.group("quant");
                String price=match.group("price");



                double income=Double.parseDouble(price)*Integer.parseInt(quan);
                finalPrice+=income;
                System.out.printf("%s: %s - %.2f%n",name,product,income);
            }
            input=sc.nextLine();

        }
        System.out.printf("Total income: %.2f",finalPrice);
    }
}
