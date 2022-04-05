package Furniture;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> shoplift=new ArrayList<>();
        double price=0.00;

        Pattern pattern=Pattern.compile(">>(?<name>\\w+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quant>[0-9]+)");

        String string=sc.nextLine();

        while (!string.equals("Purchase")){

            Matcher matcher=pattern.matcher(string);

            if (matcher.find()){
                String item=matcher.group("name");
                shoplift.add(item);
                Double itemPrice=Double.parseDouble(matcher.group("price"));
                Double quant=Double.parseDouble(matcher.group("quant"));

                price+=itemPrice*quant;
            }

            string=sc.nextLine();
        }

        System.out.println("Bought furniture:");

        for (String e:shoplift) {

            System.out.println(e);
        }

        System.out.printf("Total money spend: %.2f",price);
    }
}