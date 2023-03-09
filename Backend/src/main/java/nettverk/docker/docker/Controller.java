package nettverk.docker.docker;


import nettverk.docker.docker.Model.Code;
import nettverk.docker.docker.Service.CompilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private CompilerService compilerService;

    @GetMapping("/Test")
    public String testConnection(){
        return "Success";
    }

    @PostMapping("/Compile")
    public String compileCode(@RequestBody Code code) throws IOException {
        System.out.println(code);
        return compilerService.compileCodeService(code);
    }

}
