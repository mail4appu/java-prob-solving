package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WissenTest {
    Map<String, List<Double>> symbolNPrices= new ConcurrentHashMap<>();
    public static void main(String[] args) {





    }

    public void putNewPrice(String symbol, Double price){

        if(symbolNPrices.get(symbol)!=null) {
            symbolNPrices.get(symbol).add(price);
        }
        else{
            List<Double> priceList= new ArrayList<>();
            priceList.add(price);
            symbolNPrices.put(symbol, priceList);


        }

    }

    public double getAvgPrice(String symbol){
        int count=symbolNPrices.get(symbol).size();
       return  (symbolNPrices.get(symbol).stream().mapToDouble(d->d.doubleValue()).sum())/count;

    }


}
