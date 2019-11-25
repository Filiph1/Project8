import java.util.Scanner;

public class ReadFileDemo {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        ReadFile s = new ReadFile();
        boolean flag = false;

        while (flag == false) {
            System.out.print("Enter the file name: ");
            String file = input.nextLine();
            flag = s.setFile(file);
        }

        System.out.println("------------------------------------------------");
        System.out.println("Best decade for each name");
        s.bestDecade();


        System.out.println("------------------------------------------------");
        System.out.println("The number of decades that a name has been in the top 1000.");
        s.numOfDecades();


        System.out.println("------------------------------------------------");
        System.out.println("whether a name has become increasingly popular over each");
        s.increasing();


        System.out.println("------------------------------------------------");
        System.out.println("whether a name has become decreasingly popular over each");
        s.decreasing();

        System.out.print("Enter the decade: ");
        int decade = input.nextInt();
        s.popularity(decade);

    }
}

