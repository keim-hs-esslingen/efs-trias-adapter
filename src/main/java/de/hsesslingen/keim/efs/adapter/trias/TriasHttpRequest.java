/*
 * MIT License
 * 
 * Copyright (c) 2020 Hochschule Esslingen
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE. 
 */
package de.hsesslingen.keim.efs.adapter.trias;

import de.hsesslingen.keim.restutils.Request;
import de.vdv.trias.Trias;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * This class converts the Request Trias to a Request XML and the Response Trias
 * to a Response XML
 *
 * @author Ben Oesch and Emanuel Reichsöllner
 */
public class TriasHttpRequest {

    private static final Logger logger = LoggerFactory.getLogger(TriasHttpRequest.class);
    private static final String CONTENT_TYPE = MediaType.APPLICATION_XML_VALUE;

    private static JAXBContext jaxbContext;

    static {
        try {
            jaxbContext = JAXBContext.newInstance(Trias.class);
        } catch (JAXBException ex) {
            logger.error("{}", ex);
        }
    }

    private final Request<byte[]> request;

    public TriasHttpRequest(HttpMethod method, String uri) {
        this.request = new Request(method, uri);
    }

    public TriasHttpRequest(HttpMethod method, URI uri) {
        this.request = new Request(method, uri);
    }

    public TriasHttpRequest(HttpMethod method) {
        this.request = new Request(method);
    }

    /**
     * This creates a new Request object with the specified URI and the default
     * http method GET.
     *
     * @param uri
     */
    public TriasHttpRequest(String uri) {
        this.request = new Request(uri);
    }

    /**
     * This creates a new Request object with the specified URI and the default
     * http method GET.
     *
     * @param uri
     */
    public TriasHttpRequest(URI uri) {
        this.request = new Request(uri);
    }

    /*
     * The static methods in this group allow easy access through the class name.
     */
    //<editor-fold defaultstate="collapsed" desc="Static factory methods for easy access.">
    public static TriasHttpRequest get(String uri) {
        return new TriasHttpRequest(HttpMethod.GET, uri);
    }

    public static TriasHttpRequest get(URI uri) {
        return new TriasHttpRequest(HttpMethod.GET, uri);
    }

    public static TriasHttpRequest post(String uri) {
        return new TriasHttpRequest(HttpMethod.POST, uri);
    }

    public static TriasHttpRequest post(URI uri) {
        return new TriasHttpRequest(HttpMethod.POST, uri);
    }

    public static TriasHttpRequest put(String uri) {
        return new TriasHttpRequest(HttpMethod.PUT, uri);
    }

    public static TriasHttpRequest put(URI uri) {
        return new TriasHttpRequest(HttpMethod.PUT, uri);
    }

    public static TriasHttpRequest delete(String uri) {
        return new TriasHttpRequest(HttpMethod.DELETE, uri);
    }

    public static TriasHttpRequest delete(URI uri) {
        return new TriasHttpRequest(HttpMethod.DELETE, uri);
    }

    public static TriasHttpRequest custom(HttpMethod method, String uri) {
        return new TriasHttpRequest(method, uri);
    }

    public static TriasHttpRequest custom(HttpMethod method, URI uri) {
        return new TriasHttpRequest(method, uri);
    }
    //</editor-fold>

    /*
     * The following methods simply delegate everything to the request member variable, without adding functionality.
     * They might be helpful for building requests.
     */
    //<editor-fold defaultstate="collapsed" desc="Overridden default methods...">
    public Map<String, ?> uriVariablesMap() {
        return request.uriVariablesMap();
    }

    public Object uriVariables() {
        return request.uriVariables();
    }

    public HttpHeaders headers() {
        return request.headers();
    }

    public String contentType() {
        return CONTENT_TYPE;
    }

    public HttpMethod method() {
        return request.method();
    }

    public UriComponentsBuilder uriBuilder() {
        return request.uriBuilder();
    }

    public TriasHttpRequest uriVariables(Map<String, ?> uriVariables) {
        request.uriVariables(uriVariables);
        return this;
    }

    public TriasHttpRequest uriVariables(Object... uriVariables) {
        request.uriVariables(uriVariables);
        return this;
    }

    public TriasHttpRequest query(MultiValueMap<String, String> params) {
        request.query(params);
        return this;
    }

    public TriasHttpRequest query(String key, Object... values) {
        request.query(key, values);
        return this;
    }

    public TriasHttpRequest query(String key, Object value) {
        request.query(key, value);
        return this;
    }

    public TriasHttpRequest query(String query) {
        request.query(query);
        return this;
    }

    public TriasHttpRequest header(String key, String value) {
        request.header(key, value);
        return this;
    }

    public TriasHttpRequest headers(String key, List<? extends String> values) {
        request.headers(key, values);
        return this;
    }

    public TriasHttpRequest headers(Map<String, String> headersToAdd) {
        request.headers(headersToAdd);
        return this;
    }

    public TriasHttpRequest uri(URI uri) {
        request.uri(uri);
        return this;
    }

    public TriasHttpRequest uri(String uri) {
        request.uri(uri);
        return this;
    }

    public TriasHttpRequest method(HttpMethod method) {
        request.method(method);
        return this;
    }

    public TriasHttpRequest preventUriEncoding() {
        request.preventUriEncoding();
        return this;
    }

    public TriasHttpRequest uriEncodeCharset(Charset charset) {
        request.uriEncodeCharset(charset);
        return this;
    }

    public URI buildUri() {
        return request.buildUri();
    }
    //</editor-fold>

    private Trias body;

    public Trias body() {
        return this.body;
    }

    public TriasHttpRequest body(Trias body) {
        this.body = body;
        return this;
    }

    /**
     * Used to kick off the request.
     * <p>
     * The provided body Trias will be marshalled to an XML string, which is
     * then sent to the TRIAS api.
     * <p>
     * The resposne is then unmarshalled into a Trias object.
     *
     * @return
     * @throws javax.xml.bind.JAXBException Either upon marshalling the request
     * or upon unmarshalling the response.
     */
    public ResponseEntity<Trias> go() throws JAXBException {
        // Generate request XML...
        StringWriter writer = new StringWriter();

        jaxbContext.createMarshaller().marshal(body, writer);
        String requestXml = writer.toString();

        if (logger.isTraceEnabled()) {
            logger.trace("Going to send the following Trias-Request:\n" + requestXml);
        }

        // Configure request...
        request.body(requestXml);
        request.contentType(CONTENT_TYPE);
        request.expect(byte[].class);

        // Send it...
        ResponseEntity<byte[]> response = request.go();

        // Extract raw bytes...
        byte[] bytes = response.getBody();

        // Convert to string with UTF-8 encoding...
        var xml = new String(bytes, Charset.forName("UTF-8"));

        // Deserialize xml string...
        var trias = (Trias) jaxbContext.createUnmarshaller().unmarshal(new StringReader(xml));

        // Build adapted response object...
        return ResponseEntity.status(response.getStatusCode()).body(trias);
    }

}
