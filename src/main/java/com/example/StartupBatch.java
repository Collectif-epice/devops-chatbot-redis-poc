package com.example;

import com.example.Repository.InternalServerErrorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by anthonyrey on 23/11/2016.
 */
@Component
public class StartupBatch implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private InternalServerErrorRepository internalServerErrorRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        final Logger logger = LoggerFactory.getLogger(this.getClass());

        internalServerErrorRepo.increment();
        System.out.println(internalServerErrorRepo.getTodayCount());

        logger.info(internalServerErrorRepo.getTodayCount());
    }
}
