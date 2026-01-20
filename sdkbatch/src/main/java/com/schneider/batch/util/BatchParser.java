package com.schneider.batch.util;

import com.schneider.batch.resource.BatchResource;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SESA439295 on 6/14/2017.
 * This is a utility class for parsing different parts of BodyPart of a Multipart request
 *
 */
public class BatchParser {

    private static final Logger logger = LoggerFactory.getLogger(BatchParser.class);


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


    /**
     * This method parses the input stream o
     *
     * @param bodyPartNodes
     * @return
     */
    public static Map<String, List<String>> consumeHeaders(final List<String> bodyPartNodes) {
        logger.debug("Parsing headers from request");
        Map<String, List<String>> headersPerRequest = new HashMap<String, List<String>>();
        if (bodyPartNodes != null) {
            final Iterator<String> iterator = bodyPartNodes.iterator();
            String currentLine;
            while (iterator.hasNext()) {
                currentLine = iterator.next();
                //Get HeaderMatcher
                final Matcher headerMatcher = PATTERN_HEADER_LINE.matcher(currentLine.toString());
                if (org.apache.commons.lang3.StringUtils.isBlank(currentLine))
                    iterator.remove();
                // Ensure current line is valid HTTP header
                if (headerMatcher.matches() && headerMatcher.groupCount() == 2) {
                    iterator.remove();
                    List<String> headerValues = new ArrayList<String>();
                    String headerName = headerMatcher.group(1).trim();
                    String headerValue = headerMatcher.group(2).trim();
                    headerValues.add(headerValue);
                    //add to the list
                    headersPerRequest.put(headerName, headerValues);
                }
            }
        }
        return headersPerRequest;
    }


    public static String consumeHttpStatusLine(final List<String> message){
        if (message.size() > 0 && !message.get(0).toString().trim().equals("")) {
            final String method = message.get(0);
            message.remove(0);
            return method;
        } else {
            return "";
        }
    }


    public static List<String> prepareBodyPart(InputStream entityStream) throws IOException {
        logger.debug("Parsing body part input stream ");
        List<String> bodyPart = new LinkedList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(entityStream));
        String line;
        while ((line = br.readLine()) != null) {
            bodyPart.add(line);
        }
        return bodyPart;
    }



    public static void consumeBlankLine(final List<String> remainingMessage)
    {
        if (remainingMessage.size() > 0 && remainingMessage.get(0).toString().matches("\\s*\r?\n\\s*")) {
            remainingMessage.remove(0);
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

}
