import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {
        UserPrompt();
    }

    public static void UserPrompt(){
        String[] requestBill = {"Please provide the following information:\nFull name:","Billing Street:","Billing City:","Billing State:","Billing Zip:"};
        String[] requestShip = {"Shipping Street:","Shipping City:","Shipping State:","Shipping Zip:"};

        List<String> userInput = new ArrayList<String>();
        Scanner scannerIn = new Scanner(System.in);

        StringBuilder finalOut = new StringBuilder();

        for (String request:requestBill){
            System.out.println(request);
            userInput.add(scannerIn.nextLine());
        }

        for (String request:requestShip){
            System.out.println(request);
            userInput.add(scannerIn.nextLine());
        }

        userInput.add(1,"\nBilling Address:\n");
        userInput.add(5,"\nShipping Address:\n");


        for (String output:userInput){
            finalOut.append(output);
            finalOut.append(" ");
        }


        System.out.println(finalOut);
        scannerIn.close();
    }

}
