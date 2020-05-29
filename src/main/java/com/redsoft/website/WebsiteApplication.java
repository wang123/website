package com.redsoft.website;

import com.redsoft.starters.jpa.anno.EnableBaseJpaRepositories;
import com.redsoft.starters.sys.anno.EnableBaseFramework;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableBaseFramework(caching = false)
@EnableBaseJpaRepositories(basePackages = "com.redsoft.website.dao")
@EntityScan("com.redsoft.website.entity")
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}
