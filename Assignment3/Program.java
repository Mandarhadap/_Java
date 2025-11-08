

public class Program {
    public static void main(String[] args) {
        CheckNumber echk = new EvenCheck();
        CheckNumber ochk = new OddCheck();
        int LL = Integer.parseInt(args[0]);
        int HL = Integer.parseInt(args[1]);
        int evenresult = Utility.Summation(LL, HL, echk);
        System.out.println("Checking Even");
        System.out.println("lower limit:"+LL+" "+"higher limit:"+" "+HL+"result is"+" "+evenresult);
        System.out.println("Checking Odd");
        int oddresult = Utility.Summation(LL, HL, ochk);
        System.out.println("lower limit:"+LL+" "+"higher limit:"+" "+HL+"result is"+" "+oddresult);
    }
    
}
