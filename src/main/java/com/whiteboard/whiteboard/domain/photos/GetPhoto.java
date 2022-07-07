package com.whiteboard.whiteboard.domain.photos;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Configuration
public class GetPhoto {
    @Value("${api_key}")
    public String api_key;

    OkHttpClient client = new OkHttpClient();
    Request.Builder builder = new Request.Builder();

    private String url = "";

}
