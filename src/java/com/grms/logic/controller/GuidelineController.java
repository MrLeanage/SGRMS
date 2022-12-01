/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.logic.controller;

import com.grms.data.model.Guideline;
import com.grms.data.services.GuidelineService;
import java.util.ArrayList;

public class GuidelineController {
    
    public static boolean addNewGuideline(Guideline guideline){
        GuidelineService guidelineService = new GuidelineService();
        return guidelineService.addNewGuideline(guideline);
    }
    
    public static ArrayList<Guideline> getAllGuidelines() {
         GuidelineService guidelineService = new GuidelineService();
        return guidelineService.loadGuidelineList();
    }
    
    public static Guideline getSpecificGuideline(int gLVersionID) {
         GuidelineService guidelineService = new GuidelineService();
        return guidelineService.loadSpecificGuideline(gLVersionID);
    }
    
    public static Guideline getLatestGuideline() {
        GuidelineService guidelineService = new GuidelineService();
        return guidelineService.loadLatestGuideline();
    }
    
}
