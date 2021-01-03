/**
  * @filename SimpleMockServer.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.mock;

import org.mockserver.integration.ClientAndServer;

import com.hua.util.ClassPathUtil;
import com.hua.util.FileUtil;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.Parameter.param;

import java.nio.charset.StandardCharsets;

/**
 * @type SimpleMockServer
 * @description 
 * @author qianye.zheng
 */
public final class SimpleMockServer {
    
    private  static final int port = 7070;
    
    /**
     * @description 
     * @param args
     * @author qianye.zheng
     */
    public static void main(String[] args) {
        final ClientAndServer server = new ClientAndServer(port);
        server.when(request().withMethod("GET").withPath("/mock/get/info")
                .withQueryStringParameters(param("id", "1")))
        .respond(response().withBody(FileUtil.getString(ClassPathUtil.getClassPath("/demo.json")), 
                StandardCharsets.UTF_8));
        
        server.when(request().withMethod("POST").withPath("/mock/post/info")
                .withBody("{\"id\": 1}"))
        .respond(response().withBody(FileUtil.getString(ClassPathUtil.getClassPath("/demo.json")), 
                StandardCharsets.UTF_8));
        
        
        //server.close();
    }
    
}
