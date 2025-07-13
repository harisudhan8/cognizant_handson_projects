package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final ApplicationContext context;

    public CountryService() {
        context = new ClassPathXmlApplicationContext("country.xml");
    }

    public Country getCountryByCode(String code) {
        List<Country> countryList = (List<Country>) context.getBean("countryList");
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public Country getIndia() {
        return (Country) context.getBean("in");
    }
}
