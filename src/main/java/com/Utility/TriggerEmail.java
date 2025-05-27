package com.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.extentReports.ExtentManager;

public class TriggerEmail extends ExtentManager {

	public static void sendTestReportEmail() {
		try {
			// Construct the full report path dynamically
			String reportFileName = "Automation_Report_" + formatter.format(date) + ".html";
			String reportFilePath = System.getProperty("user.dir") + "\\TestReport\\";
			String reportFileLocation = reportFilePath + reportFileName;

			// Ensure correct path formatting for PowerShell
			reportFileLocation = reportFileLocation.replace("\\", "/");

			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy"); // Example: Thu Dec 19
																								// 17:04:39 IST 2024
			String currentTime = dateFormat.format(new Date());

			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\config.properties");
			prop.load(fis);

			String triggerEmail = prop.getProperty("triggerEmail");
			if (!"Yes".equalsIgnoreCase(triggerEmail)) {
				System.out.println("📧 Email trigger is disabled.");
				return;
			}

			// PowerShell command (direct execution)
			String powershellCommand = "powershell.exe -Command \"$Outlook = New-Object -ComObject Outlook.Application; "
					+ "$Mail = $Outlook.CreateItem(0); " + "$Mail.To = '" + prop.getProperty("emailTo") + "'; "
					+ "$Mail.CC = '" + prop.getProperty("emailCC1") + "'; "
					+ "$Mail.Subject = 'O360 Automation Report - " + currentTime + "'; "
					+ "$Mail.Body = 'Hello, Test execution is completed. Please find the results attached.'; "
					+ "$attachmentPath = '" + reportFileLocation + "'; "
					+ "if (Test-Path $attachmentPath) { $Mail.Attachments.Add($attachmentPath) | Out-Null }; "
					+ "$Mail.Send(); " + "Write-Host '✅ Email Sent Successfully!'\"";

			// Execute PowerShell command directly
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", powershellCommand);
			builder.redirectErrorStream(true);
			Process process = builder.start();

			// Capture output for debugging
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			process.waitFor();
			System.out.println("✅ Test Report Email Sent!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
