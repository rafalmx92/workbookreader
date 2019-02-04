package pl.rafal.mazurek.app.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.rafal.mazurek.app.dto.WorkbookRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    @PostMapping("/process-file")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, Model model) {

        BufferedReader br;
        List<String> result = new ArrayList<>();
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            result.size();

            List<WorkbookRecord> records = new ArrayList<WorkbookRecord>(result.size());
            records.add(new WorkbookRecord("Johnson, John", "Voorstraat 32","3122gg","020 3849381","10000","01/01/1987"));
            records.add(new WorkbookRecord("ACS, John", "Voorstraat 32","3122gg","020 3849381","10000","01/01/1987"));
            records.add(new WorkbookRecord("BKJLJOI, John", "Voorstraat 32","3122gg","020 3849381","10000","01/01/1987"));

            model.addAttribute("records", records);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }
}
