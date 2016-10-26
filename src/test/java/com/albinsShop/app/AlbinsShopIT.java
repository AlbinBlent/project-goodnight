package com.albinsShop.app;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestDesigner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;

/**
 * Created by albinblent on 26/10/16.
 */
public class AlbinsShopIT extends TestNGCitrusTestDesigner{

    @Autowired
    private HttpClient albinsShopClient;

    @Test
    @CitrusTest
    public void testGetProduct(){
        http()
                .client(albinsShopClient)
                .send()
                .get("/product")
                .accept("application/json");

        http()
                .client(albinsShopClient)
                .receive()
                .response(HttpStatus.OK)
                .messageType(MessageType.JSON)
                .payload("[{\"id\":1,\"name\":\"Sylt\",\"price\":20,\"description\":\"Sylt med smak av hallon\"}]");


    }
}
