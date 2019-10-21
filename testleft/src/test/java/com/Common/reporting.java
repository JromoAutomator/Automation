package com.Common;

public class reporting {
	
	
	public String logLevel="all";
	public String testCaseMessage="";
	public String scenarioName="";
	public int testCaseStatus=1;
	
	public void executionReport(String status, String message) {
		
		if (!status.toLowerCase().equals("failed")) {
			if (logLevel.toLowerCase().equals("all")) {
				// testCaseMessage += "\n||" + status + "|" + message;
				testCaseMessage += scenarioName + ":" + status + " - " + message + "\n";
				System.out.println(scenarioName + ":" + status + " - " + message);
			} else if (logLevel.toLowerCase().equals("info") && !status.toLowerCase().equals("passed")) {
				// testCaseMessage += "\n||" + status + "|" + message;
				testCaseMessage += scenarioName + ":" + status + " - " + message + "\n";
				System.out.println(scenarioName + ":" + status + " - " + message);
			}
		} else {
			// testCaseMessage += "\n||" + status + "|" + message;
			testCaseMessage += scenarioName + ":" + status + " - " + message + "\n";
			System.out.println(scenarioName + ":" + status + " - " + message);
			testCaseStatus = 5;
		}
	}
}
