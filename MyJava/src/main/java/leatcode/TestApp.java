package leatcode;


import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class TestApp {
    public static void main(String[] args) {

        String blLocationEPC="urn:epc:id:sgln:4056019.00312.0";
        String rpLocationEPC="00FFFFFFF111111000105D8E";
        String childLocationEPC = (blLocationEPC != null && !"".equals(blLocationEPC)) ? blLocationEPC : rpLocationEPC;
        System.out.println(childLocationEPC);
        String s=":urn:epc:id:sgln:4056019.00312.0";
        String gln = s.split("sgln:")[1];
        gln=gln.replaceAll(".0+$", "");
        System.out.println(gln);
        List<String> names=null;
        if(names.isEmpty()){
            System.out.println("empty list");
        }


    }
}
