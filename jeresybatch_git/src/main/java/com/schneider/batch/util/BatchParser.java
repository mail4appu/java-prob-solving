package com.schneider.batch.util;

import org.apache.commons.codec.binary.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SESA439295 on 6/14/2017.
 */
public class BatchParser {


    // Multipart boundaries are defined in RFC 2046:
    //     boundary      := 0*69<bchars> bcharsnospace
    //     bchars        := bcharsnospace / " "
    //     bcharsnospace := DIGIT / ALPHA / "'" / "(" / ")" / "+" / "_" / "," / "-" / "." / "/" / ":" / "=" / "?"
    // The first alternative is for the case that only characters are used that don't need quoting.
    private static final Pattern PATTERN_BOUNDARY = Pattern.compile(
            "((?:\\w|[-.'+]){1,70})|"
                    + "\"((?:\\w|[-.'+(),/:=?]|\\s){0,69}(?:\\w|[-.'+(),/:=?]))\"");
    private static final Pattern PATTERN_LAST_CRLF = Pattern.compile("(.*)\\r\\n\\s*", Pattern.DOTALL);
    // HTTP header fields are defined in RFC 7230:
    //     header-field   = field-name ":" OWS field-value OWS
    //     field-name     = token
    //     field-value    = *( field-content / obs-fold )
    //     field-content  = field-vchar [ 1*( SP / HTAB ) field-vchar ]
    //     field-vchar    = VCHAR / obs-text
    //     obs-fold       = CRLF 1*( SP / HTAB )
    //     token          = 1*tchar
    //     tchar          = "!" / "#" / "$" / "%" / "&" / "'" / "*" / "+" / "-" / "." / "^" / "_" / "`" / "|" / "~"
    //                      / DIGIT / ALPHA
    // For the field-name the specification is followed strictly,
    // but for the field-value the pattern currently accepts more than specified.
    private static final Pattern PATTERN_HEADER_LINE = Pattern.compile("((?:\\w|[!#$%\\&'*+\\-.^`|~])+):\\s?(.*)\\s*");

    public static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";

    protected static final String BOUNDARY = "boundary";
    public static final String BINARY_ENCODING = "binary";


    public static Map<String, List<String>> consumeHeaders(final List<String> remainingMessage) {
        //final int headerLineNumber = remainingMessage.size() != 0 ? remainingMessage. : 0;
        //final Header headers = new Header(headerLineNumber);
        //System.out.println("Remaining message: @@@@@@@@@@@@@@@:  "+remainingMessage);
        final Iterator<String> iter = remainingMessage.iterator();
        Map<String, List<String>> headersPerRequest= new  HashMap<String, List<String>>();

        String currentLine;
       // boolean isHeader = true;

        while (iter.hasNext()) {
            currentLine = iter.next();

            final Matcher headerMatcher = PATTERN_HEADER_LINE.matcher(currentLine.toString());
            if(org.apache.commons.lang3.StringUtils.isBlank(currentLine))
                iter.remove();

            if (headerMatcher.matches() && headerMatcher.groupCount() == 2) {
                iter.remove();
                List<String> headerValues= new ArrayList<String>();
                String headerName = headerMatcher.group(1).trim();
                String headerValue = headerMatcher.group(2).trim();
                headerValues.add(headerValue);
                headersPerRequest.put(headerName, headerValues);
            }
        }


        return headersPerRequest;
    }

    public static void consumeBlankLine(final List<String> remainingMessage)
             {
        if (remainingMessage.size() > 0 && remainingMessage.get(0).toString().matches("\\s*\r?\n\\s*")) {
            remainingMessage.remove(0);
        }/* else {
            if (isStrict) {
                final int lineNumber = (remainingMessage.size() > 0) ? remainingMessage.get(0).getLineNumber() : 0;
                throw new BatchDeserializerException("Missing blank line",
                        BatchDeserializerException.MessageKeys.MISSING_BLANK_LINE, "[None]", Integer.toString(lineNumber));
            }
        }*/
    }


    public static String consumeHttpStatusLine(final List<String> message) throws Exception {
        if (message.size() > 0 && !message.get(0).toString().trim().equals("")) {
            final String method = message.get(0);
            message.remove(0);

            return method;
        } else {
            //final int line = (message.size() > 0) ? message.get(0).getLineNumber() : 0;
           // throw new Exception("Missing http request line");
            return "";
        }
    }



   /* private void parse(String statusLine) throws Exception {
        final String[] parts = statusLine.toString().split(" ");

        //Status line consists of 3 parts: Method, URI and HTTP Version
        if (parts.length == 3) {
            method = parts[0]);
            parseUri(parts[1], requestBaseUri);
            httpVersion = parseHttpVersion(parts[2]);
        } else {
            throw new Exception("Invalid status line", MessageKeys.INVALID_STATUS_LINE,
                    Integer.toString(statusLine.getLineNumber()));
        }
    }

    private void parseUri(final String rawUri, final String baseUri) throws BatchDeserializerException {
        try {
            final URI uri = new URI(rawUri);

            if (uri.isAbsolute()) {
                parseAbsoluteUri(rawUri, baseUri);
            } else {
                final URI base = URI.create(baseUri);
                if (rawUri.startsWith(base.getRawPath())) {
                    parseRelativeUri(removeLeadingSlash(rawUri.substring(base.getRawPath().length())));
                } else {
                    parseRelativeUri(rawUri);
                }
            }
        } catch (final URISyntaxException e) {
            throw new BatchDeserializerException("Malformed uri", e, MessageKeys.INVALID_URI,
                    Integer.toString(statusLine.getLineNumber()));
        }
    }

    private void parseAbsoluteUri(final String rawUri, final String baseUri) throws BatchDeserializerException {
        if (rawUri.startsWith(baseUri)) {
            final String relativeUri = removeLeadingSlash(rawUri.substring(baseUri.length()));
            parseRelativeUri(relativeUri);
        } else {
            throw new BatchDeserializerException("Base uri does not match", MessageKeys.INVALID_BASE_URI,
                    Integer.toString(statusLine.getLineNumber()));
        }
    }
*/


   /* public static void main(String[] args) throws Exception {
        List<String> request= new LinkedList<String>();
        request.add("Content-Type: application/http");
        request.add("Content-ID: 1");
        request.add(" ");
        request.add("GET /projects/123/products HTTP/1.1");
        request.add("Accept: application/json");
        request.add("Content-Type: application/json");
        request.add(" ");
        request.add("{\n" +
                "\"id\":4,\n" +
                "\"name\":\"Product FOUR\",\n" +
                "\"description\":\"Fourth product\"\n" +
                "}");
        System.out.println("request is"+request);
        //new BatchParser().consumeHeaders(request);
        new BatchRequestPart(request).parse();
    }*/

}
