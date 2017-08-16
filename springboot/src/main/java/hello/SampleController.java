package hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Administrator on 2017/8/15.
 */
@EnableAutoConfiguration
@RestController
public class SampleController {

    @RequestMapping(value = "/{name}")
    @ResponseBody
    String home(@PathVariable(value = "name") String name){
        return "hello "+name;
    }

    public static void main(String[] args){
        SpringApplication.run(SampleController.class,args);
    }
}
