public class Program {
    public static boolean Checkprime(int num){
        if(num<=1)
            return false;
        for(int i = 2; i<num;++i){
            if(num%i==0)
                return false;
        }
    return true;
    }

    public static void main(String[] args) {
        int L = Integer.parseInt(args[0]);
        int H = Integer.parseInt(args[1]);
        System.out.printf("Total of Even number betweer %d and %d is: %d%n",L,H,Utility.Summation(L, H,(s-> s%2==0)));
        System.out.printf("Total of Odd Number between %d and %d is: %d%n",L,H,Utility.Summation(L, H, new CheckNumber() {

            public boolean checkNumber(int num){
                if(num%2==1){
                    return true;
                }
                return false;
            }

        }));
        System.out.printf("total of number of Primes between %d and %d is: %d%n",L,H,Utility.Summation(L, H, Program::Checkprime));

    }
}
