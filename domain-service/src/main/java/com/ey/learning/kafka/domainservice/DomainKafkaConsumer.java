package com.ey.learning.kafka.domainservice;

import com.ey.learning.kafka.domaincrawler.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DomainKafkaConsumer {

    @Bean
    public Consumer<KStream<String, Domain>> domainService(){
        return kstream -> kstream.foreach((key, domain) -> {
            System.out.println(String.format("Domain consumed: [%s] ACTIVE: [%s]", domain.getDomain(), !domain.isDead()));
        });
    }
}
