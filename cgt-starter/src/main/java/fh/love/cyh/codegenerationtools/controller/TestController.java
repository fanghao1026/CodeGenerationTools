package fh.love.cyh.codegenerationtools.controller;

import fh.love.cyh.codegenerationtools.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    public TestMapper testMapper;

    @RequestMapping("/love")
    @ResponseBody
    public String test(){
        return testMapper.getMyLoveCyh();
    }
}
