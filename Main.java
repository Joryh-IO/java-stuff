import java.util.Scanner;

public class Main {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the menu driven program!!");
        int choice;
        do {
            System.out.print("--------------------------------------------------------------------------" +
                    "\nChoose from the options:\n1.Swap (with third variable)" +
                    "\n2.Swap (without third variable)" +
                    "\n3.Factorial (f -> b)" +
                    "\n4.Factorial (b -> f)" +
                    "\n5.Tables" +
                    "\n6.Sum of even and product of odds" +
                    "\n7.Palindrome" +
                    "\n8.Sum of digits" +
                    "\n0.Exit\nChoice: ");
            choice = sc.nextInt();
            System.out.println("--------------------------------------------------------------------------");
            switch (choice){
                case 1:{
                    System.out.println("Enter A number: ");
                    int a = sc.nextInt();
                    System.out.println("Enter B number: ");
                    int b = sc.nextInt();
                    int c ;
                    c = a;
                    a = b;
                    b = c;
                    System.out.println("A: "+a+"\nB: "+b);
                    break;
                }
                case 2:{
                    System.out.println("Enter A number: ");
                    int a = sc.nextInt();
                    System.out.println("Enter B number: ");
                    int b = sc.nextInt();
                    a = a+b;
                    b = a-b;
                    a = a-b;
                    System.out.println("A: "+a+"\nB: "+b);
                    break;
                }
                case 3:{
                    System.out.println("Enter a number: ");
                    int n = sc.nextInt();
                    int ans = 1;
                    for(int i=2; i<=n; i++) ans =ans* i;
                    System.out.println("Ans = "+ans);
                    break;
                }
                case 4:{
                    System.out.println("Enter a number: ");
                    int n = sc.nextInt();
                    int ans = 1;
                    for(int i=n; i<=2; i--) ans =ans* i;
                    System.out.println("Ans = "+ans);
                    break;
                }
                case 5:{
                    System.out.println("Enter a number: ");
                    int n = sc.nextInt();
                    for(int i=0;i<=10;i++) System.out.println(n+" x "+ i +" = "+ n*i);
                    break;
                }
                case 6:{
                    int eve = 0, odd = 0;
                    System.out.println("Enter a number: ");
                    int n = sc.nextInt();
                    for(int i=0; i<=n; i++){
                        if(i%2 == 0)eve = eve +i;
                        else odd = odd +i;
                    }
                    System.out.println("Even: "+eve+"\nOdd: "+odd);
                    break;
                }
                case 7:{
                    System.out.println("Enter a number: ");
                    int n = sc.nextInt();
                    int temp = n, ans = 0;
                    while(n != 0){
                        int d = n%10;
                        ans = ans*10+d;
                        n = n/10;
                    }
                    System.out.println("Reverse = "+ans);
                    if(ans == temp) System.out.println("Palindrome");
                    else System.out.println("Not a palindrome");
                    break;
                }
                case 8:{
                    System.out.println("Enter a number: ");
                    int n = sc.nextInt();
                    int ans = 0;
                    while(n != 0){
                        int d = n%10;
                        ans = ans + d;
                        n = n/10;
                    }
                    System.out.println("Sum = "+ans);
                    break;
                }
            }
        }while(choice!=0);
        System.out.println("Enter height: ");
        int n = sc.nextInt();
        //art 1
        for(int i = 1; i<=n; i++){
            for(int j= 1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
        System.out.println("\n");

        //art2
        for(int i = n; i>=1; i--){
            for(int j = 1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
        System.out.println("\n");

        //art 3
        for(int i = 1; i<=n; i++){
            char c = 'a';
            for(int j= 1; j<=i; j++){
                System.out.print(c+" ");
                c++;
            }
            System.out.println("");
        }
        System.out.println("\n");

        //art 4
        char c = 'a';
        for(int i = 1; i<=n; i++){
            for(int j= 1; j<=i; j++){
                System.out.print(c+" ");
            }
            c++;
            System.out.println("");
        }
        System.out.println("\n");

        //art 5
        c = 'a';
        for(int i = 1; i<=n; i++){
            for(int j= 1; j<=i; j++){
                System.out.print(c+" ");
                c++;
            }
            System.out.println("");
        }
        System.out.println("\n");
    }
}