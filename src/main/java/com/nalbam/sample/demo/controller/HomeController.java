package com.nalbam.sample.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

@Controller
public class HomeController {
    @Autowired
    BuildProperties buildProperties;
	
    @GetMapping("/")
    public String index(Map<String, Object> model) {
        String host;
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            host = "Unknown";
            e.printStackTrace();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

	    // Artifact's name from the pom.xml file
	    
	modle.put("build_name", buildProperties.getName());
	modle.put("build_version", buildProperties.getVersion());
	modle.put("build_time", buildProperties.getTime());
	modle.put("build_name", buildProperties.getArtifact());
	 modle.put("build_name", buildProperties.getArtifact());
    
        // host
	host += "<br>DevOps Application</br>";
        model.put("host", host);
        // date
        model.put("date", sdf.format(new Date()));

        return "index";
    }

}
