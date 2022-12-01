/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.query;

/**
 *
 * @author dulshan
 */
public class GuidelineQuery {
    public static final String LOAD_ALL_GUIDELINE_DATA = "SELECT * FROM guideline ORDER BY gLVersionID DESC";
    public static final String LOAD_LATEST_GUIDELINE_DATA = "SELECT * FROM guideline ORDER BY gLVersionID DESC LIMIT 1";
    public static final String LOAD_SPECIFIC_GUIDELINE_DATA = "SELECT * FROM guideline where gLVersionID = ?";
    public static final String INSERT_GUIDELINE_DATA = "INSERT INTO guideline (gLTitle, gLDescription, gLFile, gLUploadDate, gLModifyDate) VALUES (?, ?, ?, ?, ?)";
}
