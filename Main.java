import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static final MyLinkedList myList = new MyLinkedList();
    public static int count = 0;

    public static void main(String[] args) {

        Node node = new Node("c" + count);
        myList.addFirst(node);
        myList.head = node;
        count++;

        while (true) {
            int chosen;
            Scanner choose = new Scanner(System.in);

            System.out.print("\n---------------------\n");

            System.out.printf("our header now is %s\n", myList.head.name);

            System.out.print("1- git commit\n");
            System.out.print("2- git switch\n");
            System.out.print("3- git time\n");
            System.out.print("4- exit\n\n");
//            System.out.print("5- next of...\n\n");

            System.out.print("Enter the desired number: ");
            chosen = choose.nextInt();
            System.out.print("\n---------------------\n");



            switch (chosen) {
                case 1:
                    gitCommit(myList.head);
                    break;
                case 2:
                    gitSwitch();
                    break;
                case 3:
                    gitTime();
                    break;
                case 4:
                    System.exit(0);
                    break;
//                case 5:
//                    gitNext();
//                    break;
                default:
                    System.out.print("The number you entered is incorrect!");
            }
        }


    } // main

    private static void gitCommit(Node head) {

        Node node = new Node("c" + count);
        node.father = head;
        myList.addLast(node);
        myList.head = node;
        node.Time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        count++;

        printBranch(node);

    }


    private static void gitSwitch() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the node: ");
        String str = input.nextLine();
        String[] part = str.split("(?<=\\D)(?=\\d)");

        myList.head = myList.get(Integer.parseInt(part[1]));
        printBranch(myList.head);

    }

    private static void gitTime() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the node: ");
        String str = input.nextLine();
        String[] part = str.split("(?<=\\D)(?=\\d)");

        Node node = myList.get(Integer.parseInt(part[1]));
        System.out.print(node.Time);
    }

//    private static void gitNext() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter the name of the node: ");
//        String str = input.nextLine();
//        String[] part = str.split("(?<=\\D)(?=\\d)");
//
//        Node node = myList.get(Integer.parseInt(part[1]));
//        if (node.next != null){
//            System.out.print(node.next.name);
//        } else {
//            System.out.print("Null");
//        }
//
//    }

    public static void printBranch(Node node) {
        Node branch = node;
        System.out.print(node.name);
        while (branch.father != null) {
            System.out.printf(" ==> %s", branch.father.name);
            branch = branch.father;
        }
    }

}















