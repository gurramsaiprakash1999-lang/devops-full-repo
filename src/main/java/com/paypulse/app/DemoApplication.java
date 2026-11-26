package com.paypulse.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        String hostname = "Unknown";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            hostname = "Container Host";
        }

        return "<html><head><style>" +
               "body { background-color: #0b132b; color: #ffffff; font-family: sans-serif; text-align: center; padding-top: 50px; }" +
               ".card { background-color: #1c2541; display: inline-block; padding: 40px; border-radius: 12px; border: 1px solid #48cae4; }" +
               "h1 { color: #48cae4; }" +
               ".badge { background: #00b4d8; color: #000; padding: 6px 12px; border-radius: 20px; font-weight: bold; }" +
               "</style></head><body>" +
               "<div class='card'>" +
               "<h1>💳 PayPulse Financial Portal</h1>" +
               "<p><span class='badge'>STATUS: LIVE PRODUCTION</span></p>" +
               "<p><strong>Engine:</strong> Spring Boot 3 on Java 21 (Ubuntu 24.04 LTS)</p>" +
               "<p><strong>Pod Hostname:</strong> " + hostname + "</p>" +
               "<p><strong>Server Time:</strong> " + LocalDateTime.now() + " UTC</p>" +
               "</div></body></html>";
    }
}
