
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;



public class MainClassforTesting {
public static void main(String args[]) throws Exception{

	XPathFactory factory;
	XPath xpath;
	factory = XPathFactory.newInstance();
	xpath = factory.newXPath();
	Document document = null;
	DocumentBuilder builder;
	//Simulate sim= new Simulate();
	String x= "'abc'";
	System.out.println("x is "+x);
	//sim.insertgetcamerasresponsexml("", "", "", "");
	StringBuffer response = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	response.append("<TraceRouteResponse><VSMS><vsmsIP>10.105.21.52</vsmsIP><vsmsID>123</vsmsID></VSMS><CAMERA><cameraIP>10.76.118.169</cameraIP><cameraID>456</cameraID></CAMERA><HOPS><HOP hopID=\" 1\"><serverName></serverName><serverHost>10.105.20.2</serverHost><time1>1.565 ms</time1><time2>1.652 ms</time2><time3>1.648 ms</time3></HOP><HOP hopID=\" 2\"><serverName></serverName><serverHost>10.64.58.165</serverHost><time1>0.423 ms</time1><time2>0.536 ms</time2><time3>0.653 ms</time3></HOP><HOP hopID=\" 3\"><serverName></serverName><serverHost>10.76.119.2</serverHost><time1>6.512 ms</time1><time2>6.856 ms</time2><time3>7.184 ms</time3></HOP><HOP hopID=\" 4\"><serverName></serverName><serverHost>10.76.118.169</serverHost><time1>6.218 ms</time1><time2>6.331 ms</time2><time3>6.328 ms</time3></HOP></HOPS></TraceRouteResponse>");
	
	String s=response.toString();
	
	DocumentBuilderFactory docBuilderFactory  = DocumentBuilderFactory.newInstance();
	docBuilderFactory.setIgnoringElementContentWhitespace(true);
	builder=docBuilderFactory.newDocumentBuilder();	
	//System.out.println("builder"+builder);
	
	//document = builder.parse(new InputSource(new StringReader(s)));
	document = builder.parse("C:\\Users\\vapparao\\Cisco\\workspace\\SampleProject\\src\\Example.xml");
	NodeList hops = (NodeList)xpath.evaluate("//HOP[1]/serverHost with '10.2.3.6'",document, XPathConstants.NODESET);
	System.out.println("##################"+hops.getLength());
	for(int i=0;i<hops.getLength();i++){
		System.out.println(hops.item(i).getTextContent()+"\n");
	}
	System.out.println("$$$$$$$$$$$$"+hops.getLength());
	//camips.item(0).setTextContent("123");
	NodeList camids = (NodeList)xpath.evaluate("/TraceRouteResponse/HOPS/HOP",document, XPathConstants.NODESET);
	System.out.println("$$$$$$$$$$$"+camids.getLength());
	//System.out.println("404040404040400"+camids.item(0).s);
	//camids.item(0).get

	Transformer xformer = TransformerFactory.newInstance().newTransformer();
    StringWriter writer = new StringWriter();
    StreamResult result = new StreamResult(writer);
    xformer.transform(new DOMSource(document), result);
    //System.out.println(writer.toString());
}
}
