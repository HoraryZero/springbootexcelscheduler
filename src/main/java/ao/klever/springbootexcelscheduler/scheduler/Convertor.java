package ao.klever.springbootexcelscheduler.scheduler;

import ao.klever.springbootexcelscheduler.exceltoweb.FileConvert;
import ao.klever.springbootexcelscheduler.exceltoweb.RemoveWarnings;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Convertor {
    @Scheduled(initialDelay = 1000, fixedDelayString = "10000")
    public void runProgramOne() {
        FileConvert fileConvert = new FileConvert();
        RemoveWarnings removeWarnings = new RemoveWarnings();
        fileConvert.runConvertExcel2HTML();
        removeWarnings.runHTML2Free();
    }

    @GetMapping("/")
    public String getHomepage() {
        return "MainPage.html";
    }
    @GetMapping("/AndonPageOne")
    public String getNextpageOne() {
        return "BeanAndonOne.html";
    }
    @GetMapping("/AndonPageTwo")
    public String getNextpageTwo() {
        return "BeanAndonTwo.html";
    }
}


