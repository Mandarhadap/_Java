public class Utility {

    static int Summation(int l,int h,CheckNumber chk){
        int sum = 0;
        for(int i=l;i<=h;++i){
            if(chk.checkNumber(i))
                sum +=1;
        }
        return sum;

    }    
}
