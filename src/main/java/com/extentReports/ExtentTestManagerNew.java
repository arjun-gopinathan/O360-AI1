package com.extentReports;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;

	import java.util.Map;
	import java.util.concurrent.ConcurrentHashMap;

	public class ExtentTestManagerNew {
	    private static final Map<Long, ExtentTest> extentTestMap = new ConcurrentHashMap<>();
	    private static final ExtentReports extent = ExtentManager.getInstance();

	    public static synchronized ExtentTest startTest(String testName) {
	        ExtentTest test = extent.createTest(testName);

	        // Auto-assign category based on module/package
	        String category = getCallingClassModule();
	        if (category != null) {
	            test.assignCategory(category);
	        }

	        extentTestMap.put(Thread.currentThread().getId(), test);
	        return test;
	    }

	    public static synchronized ExtentTest getTest() {
	        return extentTestMap.get(Thread.currentThread().getId());
	    }

	    public static synchronized void endTest() {
	        // Optional if ExtentReports v4+
	    }

	    private static String getCallingClassModule() {
	        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
	        for (StackTraceElement element : stack) {
	            if (element.getClassName().startsWith("com.test.")) {
	                String[] parts = element.getClassName().split("\\.");
	                if (parts.length >= 3) {
	                    return parts[2];  // e.g., LeaveModule, ProjectModule
	                }
	            }
	        }
	        return null;
	    }
	}

