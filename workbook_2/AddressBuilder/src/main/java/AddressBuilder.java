
import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {
        UserPrompt();
    }

    public static void UserPrompt(){
        String[] requestBill = {"Please provide the following information:\nFull name:","Billing Street:","Billing City:","Billing State:","Billing Zip:"};
        String[] requestShip = {"Shipping Street:","Shipping City:","Shipping State:","Shipping Zip:"};

        Scanner scannerIn = new Scanner(System.in);

        StringBuilder finalOut = new StringBuilder();

        int r = 0;

        for (String request:requestBill){
            System.out.println(request);
            finalOut.append(scannerIn.nextLine());

            switch (r){
                case 0:
                    finalOut.append("\n\nBilling Address:\n");
                    break;

                case 1:
                    finalOut.append("\n");
                    break;

                case 2:
                    finalOut.append(", ");
                    break;

                case 3:
                    finalOut.append(" ");
                    break;

                case 4:
                    finalOut.append("\n\nShipping Address:\n");
                    break;
            }
            r++;
        }

        r = 0;

        for (String request:requestShip){
            System.out.println(request);
            finalOut.append(scannerIn.nextLine());

            switch (r){
                case 0,3:
                    finalOut.append("\n");
                    break;

                case 1:
                    finalOut.append(", ");
                    break;

                case 2:
                    finalOut.append(" ");
                    break;
            }
            r++;
        }

        System.out.println(finalOut);
        scannerIn.close();
    }

}
