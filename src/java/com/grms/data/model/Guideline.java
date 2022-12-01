/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.model;

import com.grms.logic.utility.UtilityMethod;
import java.io.InputStream;

public class Guideline {
    private String gLVersionID = null;
    private String gLTitle = null;;
    private String gLDescription = null;;
    private InputStream gLFile;
    private String gLUploadDate = null;;
    private String gLModifyDate= null;

    public Guideline() {
    }

    public Guideline(String gLVersionID,
            String gLTitle,
            String gLDescription,
            InputStream gLFile,
            String gLUploadDate,
            String gLModifyDate) {
        this.gLVersionID = UtilityMethod.addPrefix("v", gLVersionID);
        this.gLTitle = gLTitle;
        this.gLDescription = gLDescription;
        this.gLFile = gLFile;
        this.gLUploadDate = gLUploadDate;
        this.gLModifyDate = gLModifyDate;
    }
    
    public Guideline(String gLVersionID,
            String gLTitle,
            String gLDescription,
            String gLUploadDate,
            String gLModifyDate) {
        this.gLVersionID = UtilityMethod.addPrefix("v", gLVersionID);
        this.gLTitle = gLTitle;
        this.gLDescription = gLDescription;
        this.gLUploadDate = gLUploadDate;
        this.gLModifyDate = gLModifyDate;
    }

    public String getgLVersionID() {
        return gLVersionID;
    }

    public Integer getIntegergLVersionID() {
        return UtilityMethod.seperateID(gLVersionID);
    }
    
    public void setgLVersionID(String gLVersionID) {
        this.gLVersionID = gLVersionID;
    }

    public String getgLTitle() {
        return gLTitle;
    }

    public void setgLTitle(String gLTitle) {
        this.gLTitle = gLTitle;
    }

    public String getgLDescription() {
        return gLDescription;
    }

    public void setgLDescription(String gLDescription) {
        this.gLDescription = gLDescription;
    }
    
    

    public InputStream getgLFile() {
        return gLFile;
    }

    public void setgLFile(InputStream gLFile) {
        this.gLFile = gLFile;
    }

    public String getgLUploadDate() {
        return gLUploadDate;
    }

    public void setgLUploadDate(String gLUploadDate) {
        this.gLUploadDate = gLUploadDate;
    }

    public String getgLModifyDate() {
        return gLModifyDate;
    }

    public void setgLModifyDate(String gLModifyDate) {
        this.gLModifyDate = gLModifyDate;
    }
    
    
    
    
    
}
