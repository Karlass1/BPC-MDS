package mds.uvod;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basic")
public class BasicController {

    @GetMapping
    public String testBasic(){
        return "<h3><b>Hello World!</b></h3>";
    }
    @GetMapping("list")
    public List<String> testList(){
        return List.of("Hello", "world", "in", "JSON");
    }

    @GetMapping("test1")
    public String testParam1(@RequestParam String name){
        return "Hello " + name + ". Welcome to our page.";
    }

    @GetMapping("test2")
    public String testParam2(@RequestParam(defaultValue = "user") String name){
        return "Hello " + name + ". Welcome to our page.";
    }

    @GetMapping("test3")
    public String testParam3(@RequestParam(name="n", defaultValue = "user") String name){
        return "Hello " + name + ". Welcome to our page.";
    }

    @GetMapping("test4")
    public String testParam4(@RequestParam(defaultValue = "user") String name,
                             @RequestParam(defaultValue = "-1") int id){
        return "Hello " + name + ". Welcome to our page. Your ID is: " + id;
    }

    @GetMapping("test5")
    public String testParam5(@RequestParam List<String> id){
//        return "All IDs are: " + id;
        String w = "";
                for (String s : id) {
                    w += s + "<br>";
                }
                return w;
    }

    public String helloForm(){
        String html =
                "<html>" +
                        "<body>" +
                            "<form>" +
                                "<input type='text name='name/>" +
                                "<input type='submit' value ='Pozdrav!'/>" +
                            "</form>" +
                        "</body>" +
                "</html>";
        return html;
    }

    @RequestMapping(value = "test2", method= {RequestMethod.POST, RequestMethod.GET})
    public String testParam6(@RequestParam(defaultValue = "user") String name){
        return "Hello " + name + ". Welcome to our page.";
    }
}
