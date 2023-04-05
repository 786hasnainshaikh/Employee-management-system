import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("=============================================");
        System.out.println("Employee Management system");
        System.out.println("1.ADD DATA");
        System.out.println("2.SHOW DATA");
        System.out.println("3.SEARCH EMPLOYEE");
        System.out.println("4.DELETE DATA");
        System.out.println("5.UPDATE DATA");
        System.out.println("6.EXIT");
        System.out.println("=============================================");
    }  // menu function

    public static void show_data(ArrayList <employee> arr){
        for (employee items: arr) {
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("employee id : " + items.id);
            System.out.println("employee name  :" + items.name);
            System.out.println("employee salary  :" + items.salary);
            System.out.println("employee contact  :" + items.contact_no);
            System.out.println("employee email :" + items.email);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        }
    }  // show data function

    public static void search(ArrayList <employee> arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the id to search");
        int ID=sc.nextInt();

        for (employee items: arr) {
            if (items.id == ID){
                System.out.println("Id found");
                System.out.println("employee id : " + items.id +
                        ", employee name  :" + items.name +
                        ", employee salary  :" + items.salary +
                        ", employee contact  :" + items.contact_no +
                        " ,employee email :" + items.email);
            }
            else {
                System.out.println("record not found");
            }
        }
    }  // SEARCH DATA FUNCTION

    public static void delete(ArrayList <employee> arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the id to delete record");
        int Id=sc.nextInt();

        int i=0;
        try {
            for (employee items: arr)
                if (items.id == Id){
                    arr.remove(items);
                    System.out.println("record has been deleted");
                    i++;
                }
            if (i==0) {
                System.out.println("record not found");
            }
        } catch (Exception e) {
            System.out.println("record deleted");
        }
     }
     //DELETE DATA

    public static void update_menu(){
        System.out.println("1.UPDATE ID");
        System.out.println("2.UPDATE NAME");
        System.out.println("3.UPDATE SALARY");
        System.out.println("4.UPDATE CONTACT NUMBER");
        System.out.println("5.UPDATE EMAIL");
        System.out.println("6.GO BACK");
    }  // created menu for update data

    public static void update(ArrayList <employee> arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the id to update record");
        int Id=sc.nextInt();

        for (employee items:arr) {
            if (items.id == Id){
                int option;
                int j=0;
                do {
                    update_menu();
                    System.out.println("enter the choice");
                    option= sc.nextInt();

                    switch (option){
                        case (1):
                            System.out.println("enter new id ");
                            items.id= sc.nextInt();
                            System.out.println(items.id + " has been updated");
                            break;

                        case (2):
                            System.out.println("enter new name ");
                            items.name= sc.next();
                            System.out.println(items.name + " has been updated");
                            break;
                        case (3):
                            System.out.println("enter new salary ");
                            items.salary=sc.nextInt();
                            System.out.println(items.salary + " has been updated");
                            break;

                        case(4):
                            System.out.println("enter new contact");
                            items.contact_no= sc.nextLong();
                            System.out.println(items.contact_no + " has been updated");
                            break;

                        case(5):
                            System.out.println("enter new email id");
                            sc.next();
                            items.email= sc.next();
                            System.out.println(items.email + " has been updated");
                            break;

                        case (6):
                            j++;
                            break;

                        default:
                            System.out.println("please enter correct option");

                    }

                } while (j==0);
            }
        }
    }  // UPDATE DATA FUNCTION



    // this is main class
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ArrayList <employee> emp_data= new  ArrayList<employee>();  // created employee data array

        int id;
        String name;
        int salary;
        long contact_no;
        String email;

        int option;
        do {
            menu();
            System.out.println("enter the choice");
            option=sc.nextInt();

            switch (option){

                  case (1):
                         // case 1 add employee data
                          System.out.println("enter employee id");
                          id= sc.nextInt();
                          System.out.println("enter employee name");
                          name=sc.next();
                          System.out.println("enter the salary");
                          salary=sc.nextInt();
                          System.out.println("enter the contact");
                          contact_no= sc.nextLong();
                          System.out.println("enter the email id");
                          email=sc.next();

                          emp_data.add(new  employee(id, name, salary,contact_no,email)); // added employee class constructer in employee array
                          break;


                 case (2):
                    show_data(emp_data);  // created  show data function obove which takes takes an array in parameter here we it an array
                    break;

                 case (3):
                    search(emp_data);  // created search  function obove which takes takes an array in parameter here we it an array
                    break;

                 case(4):
                   delete(emp_data);  // created delete  function obove which takes takes an array in parameter here we it an array
                    break;

                 case(5):
                    update(emp_data); // created update  function obove which takes takes an array in parameter here we it an array

                case (6):
                    System.exit(0);
            }
        } while (option!=0);  // body of do while loop

    }
}