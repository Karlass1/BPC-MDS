package mds.streamingserver;

import mds.streamingserver.components.MyResourceHttpRequestHandler;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.logging.Handler;

@Controller
public class WebController {
    private final static File MP4_FILE = new File("D:\\MDS\\files\\videos\\Canyon.mp4");
    private MyResourceHttpRequestHandler handler;

    @GetMapping("video")
    public String video() {
        return "videoMP4";
    }

    @ResponseBody
    @GetMapping(path = "file", produces = "video/mp4")
    public FileSystemResource file () {
        return new FileSystemResource(MP4_FILE);
    }

    @GetMapping("byterange")
    public void byterange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE);
        handler.handleRequest(request, response);
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping(path="player", method = {RequestMethod.POST, RequestMethod.GET})
        public String player(Model model, @RequestParam String url,
                             @RequestParam(defaultValue = "false") boolean muted,
                             @RequestParam String width,
                             @RequestParam(defaultValue = "false") boolean autoplay) {
        model.addAttribute("url", url);
        model.addAttribute("muted", muted ? "true" : "");
        model.addAttribute("autoplay", autoplay ? "true" : "");
        model.addAttribute("width", width);
        return "player";
    }
}
