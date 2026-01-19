package ExceptionHandling;

public class Application {
    public static void main(String[] args) {
        try {
        IProcess iProcess=(int a  ,int b)-> (a/b);
        System.out.println(iProcess.process(10,0));
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }

}
