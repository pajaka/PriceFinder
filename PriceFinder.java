import java.util.ArrayList;
import java.util.List;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class PriceFinder {
    
    

    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.print("enter file name: ");
        String name = in.nextLine();
        SimpleReader file = new SimpleReader1L(name);
        List<Double> prices = new ArrayList<>();
        while (!file.atEOS()) {
            String line = file.nextLine();
            if (line.contains("$")) {
                String price = line.substring(15, line.length());
                price = price.substring(0, price.indexOf('"'));
                double newPrice = Double.parseDouble(price);
                prices.add(newPrice);
            }
        }
       
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (double x : prices) {
            if (x >= max) {
                max = x;
            } else if (x <= min) {
                min = x;
            }
        }
        
        out.println(max);
        out.println(min);
        
        
        in.close();
        out.close();
        file.close();
    }
}
