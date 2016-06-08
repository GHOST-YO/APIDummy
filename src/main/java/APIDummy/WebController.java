package APIDummy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Created by prashant.gu on 5/30/2016.
 *
 */

@CrossOrigin(maxAge = 3600)
@Controller
@EnableAutoConfiguration
@ResponseBody
public class WebController {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @RequestMapping(value="/atropos/1.0/getLawEnforcementDetails/{phoneNumber}", produces = "application/json")
    @ResponseBody
    public List<ViewOneBundle> loadViewOne(@PathVariable long phoneNumber, HttpServletResponse response, HttpServletRequest request) {
        ViewOne viewOne = new ViewOne();
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");

        System.out.println("Request Number = " + phoneNumber);

        viewOne.insertInList(1451606400 ,1454198400);
        viewOne.insertInList(1454284800 ,1456704000);
        viewOne.insertInList(1456790400 ,1459382400);
        viewOne.insertInList(1459468800 ,1461974400);
        viewOne.insertInList(1462060800 ,1464652800);

        return viewOne.getViewOneData();
    }

    /*@RequestMapping(value="/atropos/1.0/getMediaList/", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public List<ViewTwoBundle> loadViewTwo(@RequestBody String json, HttpServletResponse response, HttpServletResponse request) throws IOException {

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "10000");


        RequestBundle requestBundle;
        ObjectMapper mapper = new ObjectMapper();
        requestBundle = mapper.readValue(json, RequestBundle.class);


        ViewTwo viewTwo = new ViewTwo();

        Random rand = new Random();
        int x = rand.nextInt(30) + 1;

        for(int i = 0; i < x; i++)
            viewTwo.insertInList(requestBundle.getStart(), requestBundle.getEnd());

        return viewTwo.getViewTwoData();
    }*/

}

class RequestBundle
{
    private long number, start, end;

    public RequestBundle() {
    }

    public RequestBundle(long number, long start, long end) {
        this.number = number;
        this.start = start;
        this.end = end;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
