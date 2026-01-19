package validation;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class User implements Serializable {


    @NotBlank
    static private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        name=findName();

    }
    private static String findName(){
      return "appu";
    }
}
