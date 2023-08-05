package VAT_BG_Calculation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VAT_Calculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] generalInfArray = scanner.nextLine().split("\\*\\*");
        String clientName = generalInfArray[0];
        String clientVAT = generalInfArray[1];
        String sellerName = "TRADE LIMITED LTD";
        String sellerVAT = "BG202345123";
        int soldGoodsCount = Integer.parseInt(generalInfArray[2]);
        System.out.println("***************************RECEIPT********************************");
        System.out.println("**");
        System.out.printf("** CLIENT: %s    VAT No: %s%n", clientName, clientVAT);
        System.out.printf("** SELLER: %s    VAT No: %s%n", sellerName, sellerVAT);
        System.out.println("**");
        double totalSumNoVAT = 0;
        int lineCounter = 0;

        List<String> productsList = new ArrayList<>();
        for (int i = 1; i <= soldGoodsCount; i++) {
            String [] inputInfArray = scanner.nextLine().split("\\*\\*");
            String productName = inputInfArray[0];
            double totalNoVAT = Double.parseDouble(inputInfArray[2]) * Integer.parseInt(inputInfArray[1]);
            totalSumNoVAT += totalNoVAT;
            lineCounter++;
            productsList.add("** " + lineCounter + ". " + productName + " -> " + totalNoVAT);
        }

        for (String element: productsList) {
            System.out.println(element);
        }

        System.out.println("**");
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.printf("** TOTAL NET: %s%n", df.format(totalSumNoVAT));
        System.out.printf("** VAT AMOUNT: %.2f%n", totalSumNoVAT * 0.2);
        System.out.printf("** TOTAL (VAT INCL.): %.2f%n", totalSumNoVAT + (totalSumNoVAT * 0.2));
        System.out.println("****************************************************************");


//        input:
//        MARVEL LTD.**BG876345123**6
//        Beer**3**1.56
//        Juice**12**1.23
//        Mango**23**4.56
//        Cola**5698**0.87
//        Banana**987**3.49
//        Bread**240**1.09

    }
}


