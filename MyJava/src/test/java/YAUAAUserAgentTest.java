import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.junit.Test;

public class YAUAAUserAgentTest {

    @Test
    public void deriveUserAgent(){
         UserAgentAnalyzer uaa = UserAgentAnalyzer.newBuilder().hideMatcherLoadStats().withCache(10000)
                .build();
        UserAgent userAgent = uaa.parse("Chrome");
         for (String fieldName : userAgent.getAvailableFieldNamesSorted()) {
            String value = userAgent.getValue(fieldName);
            System.out.println("fieldName:   "+fieldName+"   :: "+value);
        }
    }
}
