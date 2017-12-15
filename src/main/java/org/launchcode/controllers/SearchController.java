package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.HashMap;

import static org.launchcode.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }


    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    //uses the query parameter passed in as column to determine which values to fetch from JobData
    public String searchJobsByColumnAndValue(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        ArrayList<HashMap<String, String>> jobs;
        if (searchType.equals("all")|| searchTerm == "")
            jobs = JobData.findByValue(searchTerm);
            else
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);

            model.addAttribute("columns", columnChoices);
            model.addAttribute("jobs", jobs);

        return "search";
    }

}
