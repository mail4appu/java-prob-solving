import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SESA439295 on 2/18/2017.
 */
public class FirstTestApp {

    public FirstTestApp() {
    }

    public static void main(String[] args) {
        boolean equals = Boolean.TRUE.equals(false);
        System.out.println("#####"+equals);
        List<String> names=new ArrayList<>();
        names=null;
        if(CollectionUtils.isEmpty(names)){
            System.out.println("empty list");
        }

    }



}
