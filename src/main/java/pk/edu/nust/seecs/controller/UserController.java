package pk.edu.nust.seecs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pk.edu.nust.seecs.domain.UserReqModel;
import pk.edu.nust.seecs.service.UserService;

@RestController
//@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;


    // property get
    @Value(value = "${folder.path}")
    private String dummyPath;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Word cloud computing assignment 1";
    }

    @GetMapping("/login")
    public String login(@RequestBody UserReqModel userReqModel) {
        return userService.login(userReqModel);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserReqModel userReqModel) {
        return userService.save(userReqModel);
    }

    @PostMapping("/create-folder")
    public String createFolder() {
        return dummyPath;
    }

    @PostMapping("/upload-file")
    public String uploadFile() {
        return "upload file";
    }

    @PostMapping("/download-file")
    public String downloadFile() {
        return "download file";
    }

    @GetMapping("/get-available-storage")
    public String getAvailableStorage() {
        return "success";
    }


}
