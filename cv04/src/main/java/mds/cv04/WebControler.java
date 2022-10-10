package mds.cv04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebControler {

    StudentsWork studentsWork;


    @GetMapping("static_page")
    public String staticPage(){
        return "staticpage";
    }

    @GetMapping("dynamic_page")
    public String dynamicPage(Model model){
        model.addAttribute("name", "Karel");
        model.addAttribute("id", "231110");
        return "dynamicpage";
    }

    public String student(Model model, @RequestParam(required = false) Integer id) {
        model.addAttribute("id", id);
        model.addAttribute("students", studentsWork);
        return "students";
    }

    @GetMapping("myself")
    public String myselfPage(){return "myselfpage";}

    @GetMapping("alice")
    public String alicePage(Model model){
        model.addAttribute("name", "Alice");
        return "template.html";
    }
    @GetMapping("bob")
    public String bobPage(Model model){
        model.addAttribute("name", "Bob");
        return "template.html";
    }
}
