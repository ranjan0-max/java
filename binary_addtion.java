import java.util.Scanner;

/**
 * hello
 */
public class hello {
    static int expo(int base){
      int re=1;
      if(base==0){
        return 1;
      }
      else{
        for(int i=0;i<base;i++){
          re=re*2;
        }
      }
      return re;
    }
    static int bnry_to_deci(int no){
      int r,sum=0,po=0;
      while(no!=0){
        r=no%10;
        no=no/10;
        if(r==0){
          sum=sum+0;
          po++;
        }
        else{
          sum=sum+r*expo(po);
          po++;
        }
      }
      return sum;
    }
    static int deci_to_any(int b,int any){
      int r,sum=0;
      while(b!=0){
        r=b%any;
        b=b/any;
        sum=(sum*10)+r;
      }
      return sum;
    }
    public static void main(String[] args) {
      System.out.println("This is binary addtion program");
      System.out.println("Enter two binary values");
      Scanner inp=new Scanner(System.in);
      int a,b,n=1,z=0,t=0;
      a=inp.nextInt();
      b=inp.nextInt();
      int result=bnry_to_deci(a)+bnry_to_deci(b);
      while(n<result+1){
        n=n+n;
        z++;
        if(n==result){
          t=1;
          System.out.println("Sum of these two two binary number is "+n);
          System.out.print(1);
          for(int i=0;i<z;i++){
            System.out.print(0);
          }
        }
      }
      if(t==0){
        System.out.println("sum of these two binary number is "+result);
        System.out.println("and there binary form is "+deci_to_any(result, 2));
      }
    }
}