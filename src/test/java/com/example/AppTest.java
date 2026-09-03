package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class AppTest {

    @Test
    public void testVoterFullyEligible() {
        App.Voter voter = new App.Voter("Aarav Sharma", 25, "Indian", "VID100234", true);
        List<String> violations = voter.evaluateEligibility();
        assertTrue("Voter satisfies all criteria.", violations.isEmpty());
    }

    @Test
    public void testVoterUnderageAndForeigner() {
        App.Voter voter = new App.Voter("John Smith", 17, "American", "VID883711", true);
        List<String> violations = voter.evaluateEligibility();
        
        assertEquals("Should trigger two violations.", 2, violations.size());
        assertTrue(violations.contains("Underage (Age must be 18 or above)"));
        assertTrue(violations.contains("Not a citizen (Must be an Indian citizen)"));
    }

    @Test
    public void testVoterWithInvalidVoterId() {
        App.Voter voter = new App.Voter("Priya Patel", 19, "Indian", "EXPIRED_ID", false);
        List<String> violations = voter.evaluateEligibility();
        
        assertEquals(1, violations.size());
        assertTrue(violations.contains("Invalid ID (Must possess a valid, verified Voter ID)"));
    }
}
