package org.runner;

import org.base.Global;
import org.testng.annotations.AfterSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "D:\\Automation\\Laptop Script\\SalesIntel_Portal_Prod_Automation-master\\src\\test\\resources\\Features\\New_UI_View\\" +
		"" +
		"" +
		"" +
		"" +
		"" +
		"", glue = {
		"org.stepdefinition", "org.runner" }, dryRun = false, monochrome = true, tags = { "@First,@Sanity" +
		"" }, plugin = {
		"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty",
		"html:src\\test\\resources\\Reports\\HTML", "json:src\\test\\resources\\Reports\\Json\\cucumber.json",
		"junit:src\\test\\resources\\Reports\\XML\\cucumber.xml" })
public class Runner extends AbstractTestNGCucumberTests {

	@AfterSuite
	public void cucumberReportGenerate() {
		Global.generateJVMReport(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\Json\\cucumber.json");
	}

}
