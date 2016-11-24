package com.example;

import com.example.Repository.InternalServerErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by anthonyrey on 23/11/2016.
 */
@Controller
public class TestController {

    @Autowired
    private InternalServerErrorRepository internalServerErrorRepo;

    @RequestMapping(method= GET, value = "/inc")
    public String inc(){


        internalServerErrorRepo.increment();
        return internalServerErrorRepo.getTodayCount();
    }

}
