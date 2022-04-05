package Race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String[] input=scan.nextLine().split(", ");
        ArrayList<String> races=new ArrayList<>(Arrays.asList(input));
        HashMap<String ,Integer> res=new HashMap<>();
        Pattern word=Pattern.compile("[A-Z]|[a-z]");
        Pattern score=Pattern.compile("[0-9]");



        String info=scan.nextLine();
        while (!info.equals("end of race")){
            Matcher matcher = word.matcher(info);
            StringBuilder name=new StringBuilder();
            while (matcher.find()){
                name.append(matcher.group());

            }
            if (races.contains(name.toString())){
                res.putIfAbsent(name.toString(),0);
                int oldRes=res.get(name.toString());
                int newRes=0;
                Matcher scoreM = score.matcher(info);
                while (scoreM.find()){
                    newRes+=Integer.parseInt(scoreM.group());
                }
                res.put(name.toString(),newRes+oldRes);
            }
            info=scan.nextLine();
        }
        int[] numb={1};

        res.entrySet().stream().sorted((m1,m2)->
                m2.getValue().compareTo(m1.getValue())).limit(3)
                .forEach(e-> {
                    switch (numb[0]){
                        case 1:
                            System.out.println(String.format("1st place: %s",e.getKey()));
                            break;
                        case 2:
                            System.out.println(String.format("2nd place: %s",e.getKey()));
                            break;
                        case 3:
                            System.out.println(String.format("3rd place: %s",e.getKey()));
                            break;
                    }
                    numb[0]++;

                });



    }


}
