/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.data.query;


public class FeedbackQuery {
    public static final String LOAD_ALL_FEEDBACK_DATA = "SELECT * FROM feedback ORDER BY fID DESC";
    public static final String LOAD_LATEST_FEEBACK_DATA = "SELECT * FROM feedback ORDER BY fID DESC LIMIT 1";
    public static final String LOAD_SPECIFIC_FEEDBACK_DATA = "SELECT * FROM feedback where fID = ?";
    public static final String GIVE_FEEDBACK = "INSERT INTO feedback (fTitle, fNote, fGID, fDate, fTime) VALUES (?, ?, ?, ?, ?)";
}
