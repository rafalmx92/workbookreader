package pl.rafal.mazurek.app.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import pl.rafal.mazurek.app.dto.ParsedWorkbook;
import pl.rafal.mazurek.app.parser.ParserFactory;

@RestController
public class FileController {

    @PostMapping("/process-file")
    public RedirectView handleFileUpload(@RequestParam("file") MultipartFile file,
                                         RedirectAttributes redirectAttributes) {
        ParsedWorkbook parsedWorkbook = ParserFactory.getParser(file.getOriginalFilename()).parseWorkbookFile(file);

        redirectAttributes.addFlashAttribute("fileName", file.getOriginalFilename());
        redirectAttributes.addFlashAttribute("headers", parsedWorkbook.getHeaders());
        redirectAttributes.addFlashAttribute("records", parsedWorkbook.getWorkbookRecords());
        return new RedirectView("data", true);
    }

    @GetMapping(value = "/data")
    public ModelAndView showData(Model model) {
        ModelAndView mav = new ModelAndView("data.html");
        mav.addObject("fileName", model.asMap().get("fileName"));
        mav.addObject("headers", model.asMap().get("headers"));
        mav.addObject("records", model.asMap().get("records"));
        return mav;
    }

}
