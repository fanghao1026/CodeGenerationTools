package fh.love.cyh.codegenerationtools.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("/file")
public class FileController extends BaseController{

    @RequestMapping("xml")
    public ResponseEntity<byte[]> xml(){

    }

    @RequestMapping("pojo")
    public ResponseEntity<byte[]> pojo(String name , Map<Class,String> field){

    }

    @RequestMapping("controller")
    public ResponseEntity<byte[]> controller(){

    }

    @RequestMapping("service")
    public ResponseEntity<byte[]> service(){

    }

    @RequestMapping("dao")
    public ResponseEntity<byte[]> dao(){

    }

}
