package com.cinteo.oneweb.mbusa.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableDiscoveryClient
@Profile(value = "cloud")
public class CloudConfiguration {

}
