package pl.rafal.mazurek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import pl.rafal.mazurek.app.dto.WorkbookRecord;
import pl.rafal.mazurek.app.parser.ParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    private ParserFactory parserFactory;

    @Autowired
    FileController(ParserFactory parserFactory){
        this.parserFactory = parserFactory;
    }

    @PostMapping("/process-file")
    public RedirectView handleFileUpload(@RequestParam("file") MultipartFile file,
                                         RedirectAttributes redirectAttributes) {

        BufferedReader br;
        List<String> result = new ArrayList<>();
        List<WorkbookRecord> records = null;
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            result.size();

            records = new ArrayList<WorkbookRecord>(result.size());
            records.add(new WorkbookRecord("Johnson, John", "Voorstraat 32","3122gg","020 3849381","10000","01/01/1987"));
            records.add(new WorkbookRecord("ACS, John", "Voorstraat 32","3122gg","020 3849381","10000","01/01/1987"));
            records.add(new WorkbookRecord("BKJLJOI, John", "Voorstraat 32","3122gg","020 3849381","10000","01/01/1987"));

            //model.addAttribute("records", records);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        redirectAttributes.addFlashAttribute("records", records);
        redirectAttributes.addFlashAttribute("fileName", file.getName());

        return new RedirectView("data", true);
    }

    @GetMapping(value = "/data")
    public ModelAndView showData(Model model) {
        String fileName = (String) model.asMap().get("fileName");
        List<WorkbookRecord> records = (List<WorkbookRecord>) model.asMap().get("records");
        ModelAndView mav = new ModelAndView("data.html");
        mav.addObject("fileName", fileName);
        mav.addObject("records", records);
        return mav;
    }

}
