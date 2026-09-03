package com.example;

import java.util.ArrayList;
import java.util.List;

public class App {

    
    public static class Voter {
        private String name;
        private int age;
        private String citizenship;
        private String voterId;
        private boolean isIdValid;

        public Voter(String name, int age, String citizenship, String voterId, boolean isIdValid) {
            this.name = name;
            this.age = age;
            this.citizenship = citizenship;
            this.voterId = voterId;
            this.isIdValid = isIdValid;
        }

        public String getName() {
            return name;
        }

       
        public List<String> evaluateEligibility() {
            List<String> reasons = new ArrayList<>();

            if (this.age < 18) {
                reasons.add("Underage (Age must be 18 or above)");
            }
            if (this.citizenship == null || !this.citizenship.trim().equalsIgnoreCase("Indian")) {
                reasons.add("Not a citizen (Must be an Indian citizen)");
            }
            if (this.voterId == null || this.voterId.trim().isEmpty() || !this.isIdValid) {
                reasons.add("Invalid ID (Must possess a valid, verified Voter ID)");
            }

            return reasons;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Voting Eligibility System ===");

        
        Voter[] testVoters = {
            new Voter("Aarav Sharma", 25, "Indian", "VID100234", true),
            new Voter("John Smith", 17, "American", "VID883711", true),
            new Voter("Priya Patel", 19, "Indian", "EXPIRED_ID", false)
        };

        for (Voter voter : testVoters) {
            List<String> failureReasons = voter.evaluateEligibility();
            System.out.println("\n>> Assessment Profile for: " + voter.getName());
            
            if (failureReasons.isEmpty()) {
                System.out.println("STATUS: ELIGIBLE TO VOTE");
            } else {
                System.out.println("STATUS: INELIGIBLE TO VOTE");
                System.out.println("Reasons for Rejection:");
                for (String reason : failureReasons) {
                    System.out.println(" - " + reason);
                }
            }
        }
    }
}
