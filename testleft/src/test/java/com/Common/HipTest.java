package com.Common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.jayway.jsonpath.JsonPath;

public class HipTest {

	private String hipTestProjectId = "145571";
	private String hipTestRunID = "309625";
	private String hipTestSnapshotID = "";
	public String hipTestCaseID = "";
	private String hipTestCaseName = "";
	private String hipTestBaseURL = "https://app.hiptest.com/api/";
	private String accessToken="gjDXFQ3-swMzDTq72fZZqQ";
	private String UUID="jesus.romo@itexico.com";
	private String client="XV5dIyaBFZI4X5HWv4iSEg";
	

	
	public void addHipTestCaseToRun() {
		String url = hipTestBaseURL + "projects/" + hipTestProjectId + "/test_runs/" + hipTestRunID;
		String body = "{\"data\": {\"type\": \"test_runs\", \"id\": " + hipTestRunID
				+ ", \"attributes\": {\"scenario_id\": " + hipTestCaseID + "}}}";

		String response = postCall(url, body, "PATCH");
		hipTestSnapshotID = parseJSON(response.toString(), "$.data.links.self").replace("/test-runs/", "");
	}
	
	private String postCall(String url, String body, String method) 
	{
		try{
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			
			if (method.equals("PATCH")){
				con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
			}
			
			con.setRequestMethod("POST");
	
			//add request header
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/vnd.api+json; version=1");
			con.setRequestProperty("access-token", accessToken);
			con.setRequestProperty("uid", UUID);
			con.setRequestProperty("client", client);
			con.setDoOutput(true);
	
			String jsonInputString = body;
			
			try(OutputStream os = con.getOutputStream()) {
			    byte[] input = jsonInputString.getBytes("utf-8");
			    os.write(input, 0, input.length);           
			}
			
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.flush();
			wr.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			return response.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "FAILED";
		}

	}
	
	private String parseJSON(String jsonString, String jsonPath) {
		Object dataObject = JsonPath.parse(jsonString).read(jsonPath);
		return dataObject.toString();
	}

	private void getHipTestCaseName(){
		try{	
			String url = hipTestBaseURL + "projects/" + hipTestProjectId + "/scenarios/" + hipTestCaseID;		
			String response = getCall(url);
			
			hipTestCaseName = parseJSON(response.toString(), "$.data.attributes.name");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void getHipTestSnapshotIDFromName(){
		try{
			getHipTestCaseName();
			Thread.sleep(5000);
			String url = hipTestBaseURL + "projects/" + hipTestProjectId + "/test_runs/" + hipTestRunID  + "/test_snapshots";
			String response = getCall(url);
		
			hipTestSnapshotID = parseJSON(response.toString(), "$.data[*][?(@.attributes.name == '" + hipTestCaseName + "')].id");
			hipTestSnapshotID = hipTestSnapshotID.substring(2, hipTestSnapshotID.length() - 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void addResultToHipTest(String hipTestCaseStatus, String testCaseMessage){
		getHipTestSnapshotIDFromName();
		//if (testCaseStatus == 5){
		//	hipTestCaseStatus = "failed";
		//}
		
		String url = hipTestBaseURL + "projects/" + hipTestProjectId + "/test_runs/" + hipTestRunID + "/test_snapshots/"
				+ hipTestSnapshotID + "/test_results";
		String body = "{\"data\": {\"type\": \"test-results\", \"attributes\": {\"status\": \"" + hipTestCaseStatus + "\", \"status-author\": \"Cucumber\", \"description\": \""
				+ testCaseMessage + "\"}}}";
		postCall(url, body);

	}

	private String postCall(String url, String body) {
		return postCall(url, body, "POST");
	}

	private String getCall(String url) {
		
		try{
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
			con.setRequestMethod("GET");
	
			//add request header
			con.setRequestProperty("Accept", "application/vnd.api+json; version=1");
			con.setRequestProperty("access-token", accessToken);
			con.setRequestProperty("uid", UUID);
			con.setRequestProperty("client", client);
	
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			return response.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "FAILED";
		}
	}	

}
