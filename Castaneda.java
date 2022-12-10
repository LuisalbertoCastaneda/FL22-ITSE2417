public class Castaneda implements FinalProject {
    @Override
    public void begin(){
        boolean Exit = false;

        fib();
        System.out.println("hello friend");

        do{
            var a = Itse2417Main.myScan.next();
            if (a.equals("exit")){
                Exit = true;
            }
        }while(!Exit);
        System.out.println("GoodBye friend ^_^ ");
    }
    private void fib(){
        int a;
        int b = 1;
        int c = 0;
        while(c<255){
            System.out.println(c);
            a = b;
            b=c;
            c = a + b;
        }
    }
}
