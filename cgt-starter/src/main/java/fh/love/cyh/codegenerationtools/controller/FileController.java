package fh.love.cyh.codegenerationtools.controller;


import fh.love.cyh.codegenerationtools.BaseController;
import fh.love.cyh.codegenerationtools.constant.Constants;
import fh.love.cyh.codegenerationtools.domain.file.FileVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController extends BaseController {

    @RequestMapping("/xml")//@RequestBody FileVO fileInfo,
    public HttpServletResponse xml(HttpServletResponse response){
        FileVO filevo = new FileVO("test",".xml","/Users/nemo/Desktop");
        try {
            File file = new File(Constants.PATH+"abc.txt");
            String fileName = file.getName();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

            InputStream is = new BufferedInputStream(new FileInputStream(Constants.PATH + "abc.txt"));
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();

            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");

            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            os.write(buffer);
            os.flush();
            os.close();

        }catch (Exception e){

        }
        return null;
    }

    @RequestMapping("/pojo")
    @ResponseBody
    public String pojo(String name , Map<Class,String> field){
        return "hello";
    }

    @RequestMapping("/controller")
    public ResponseEntity<byte[]> controller(){
        return null;
    }

    @RequestMapping("/service")
    public ResponseEntity<byte[]> service(){
        return null;
    }

    @RequestMapping("/dao")
    public ResponseEntity<byte[]> dao(){
        return null;
    }

}
