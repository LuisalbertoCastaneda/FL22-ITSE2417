import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Castaneda implements FinalProject {
    @Override
    public void begin(){
        boolean Exit = false;
        message("hello friend",1);
        System.out.print("Do You Like Math? (yes/no): ");

        // I'm not typing this ↓↓ over and over
        Scanner in = Itse2417Main.myScan;
        do{
            var decision = in.next();
            switch (decision.toLowerCase().trim()) {
                case "exit" -> Exit = true;
                case "yes" -> yesMath();
                case "no" -> noMath();
                default -> System.out.println("not valid Input");
            }
            System.out.println("Yes: Math | No: No Math | Exit ");
            System.out.print(">");
        }while(!Exit);
        System.out.println("GoodBye friend ^_^ ");
    }

    private void noMath(){
        Scanner in = Itse2417Main.myScan;
        ArrayList<String> l = new ArrayList<>();
        String[] vary = {"Adjective","Name","Adjective","Type of Pet",
                        "Adjective","Adjective","Liquid","Room in a House","Verb","Adverb","Relatives Name"};
        String Total;
        message("Don't Worry Math isn't for everyone.",2);
        message("So Lets do some MadLibs!",1);

        for (String a:vary) {
            System.out.print("Pick a "+a+": ");
            l.add(in.next());
        }

        // String interpolation go brr
        Total = MessageFormat.format("""
                        It was a {0}, cold December Night. I wake to find {1}, looking {2} like they always do.
                        "Finally Awake I see." Your {3} is looking mighty {4} and quite {5} to see you.
                        Finally getting more aware, you hear "Can I get some {6}, but hold the liquid?" coming from the {7}.
                        You {8} to the noise only to find a site you {9} see, {10}.
                        """,l.get(0),l.get(1),l.get(2),l.get(3),l.get(4),l.get(5),l.get(6),l.get(7),l.get(8),l.get(9),l.get(10));
        System.out.println(Total);
    }

    private void yesMath(){
        Scanner in = Itse2417Main.myScan;
        boolean Exit = false;
        String[] items = {"force","energy","velocity","density","momentum"};

        message("This is a Physics Calculator.",2);
        message("Why Physics?",1);
        message("Because I like Physics and because its simpler than normal math.",1);

        for(int i = 0; i < 4; i++){
            System.out.print(".");
            waitC(1);
        }

        System.out.println("\nAnyway to the Math!");
        System.out.println("First, Pick what you want to find.");

        do {
            for (String a:items) {
                System.out.print(a + "|");
            }
            System.out.print("\n>");
            String op = in.next();
            String k = op.toLowerCase().trim();
            switch (k) {
                case "force" -> {
                    calc(1,"Newtons","Mass","Acceleration","Force","N");
                    Exit = true;
                }
                case "energy" -> {
                    calc(3,"Joules","Mass","Velocity","Energy","j");
                    Exit = true;
                }
                case "density" -> {
                    calc(2,"Pounds per Cubic Inch","Mass","Volume","Density","lb/cb in");
                    Exit = true;
                }
                case "velocity" -> {
                    calc(2,"Meters Per Second","Distance","Time","Velocity","m/s");
                    Exit = true;
                }
                case "momentum" -> {
                    calc(1,"Kilograms Meters per Second","Mass","Velocity","Momentum","kg m/s");
                    Exit = true;
                }
                default -> System.out.println("Invalid Input");
            }
        }while(!Exit);
    }

    private void calc(int check, String message1, String message2,String message3, String x, String measurement){
        double val1;
        double val2;
        double val3 = 0;
        System.out.println("Measurements are Done in "+message1+".");
        System.out.print("Enter "+message2+": ");
        val1 = numCheck("Enter "+message2+": ");
        System.out.print("Enter "+message3+": ");
        val2 = numCheck("Enter "+message3+": ");
        switch (check){
            case 1 -> val3 = val1 * val2;
            case 2 -> val3 = val1 / val2;
            case 3 -> val3  = ((0.5 * val1) * Math.pow(val2, 2));
        }
        System.out.println(x+":"+val3+" "+measurement);
    }

    private double numCheck(String message){
        double temp;
        Scanner in = Itse2417Main.myScan;
        do{
            temp = TryParseDouble(in.next());
            if(temp < 1){
                System.out.print(message);
            }
        }while(temp < 1);
        return temp;
    }

    private double TryParseDouble(String x){
        try {
            return Double.parseDouble(x);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void message(String message,int time){
        System.out.println(message);
        waitC(time);
    }

    private void waitC(int time){
        time *= 1000;
        try{
            Thread.sleep(time);
        }catch (Exception e){
            System.out.println("oops");
        }
    }
}