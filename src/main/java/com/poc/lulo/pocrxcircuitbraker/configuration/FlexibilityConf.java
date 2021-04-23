package com.poc.lulo.pocrxcircuitbraker.configuration;

import flexibility.client.FlexibilitySdkFactory;
import flexibility.client.models.Credentials;
import flexibility.client.sdk.FlexibilitySdk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlexibilityConf {

    @Bean
    public FlexibilitySdk flexibilitySdk() {
        Credentials credentials = new Credentials();
        credentials.setSecret("fRrdj0JD1zDLLcPHpVkCsKRKPG5C4kafaTW5PUSy");
        credentials.setClientId("ABTr4YVFhas8Yfq1uGfR");
        return new FlexibilitySdkFactory().getSdk("http://flex-internal-nlb-sand-7780f47397c1c3fc.elb.us-east-1.amazonaws.com", credentials);
    }
}
