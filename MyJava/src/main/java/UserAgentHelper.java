import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

public class UserAgentHelper {
    private static UserAgentAnalyzer uaa = UserAgentAnalyzer.newBuilder().hideMatcherLoadStats().withCache(10000)
            .build();
    public static void main(String[] args) {
        UserAgent userAgent = uaa.parse("Chrome");
        for (String fieldName : userAgent.getAvailableFieldNamesSorted()) {
            String value = userAgent.getValue(fieldName);
            System.out.println("fieldName:   "+fieldName+"   :: "+value);
        }
    }
}
