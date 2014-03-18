package utils;

import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CustomHTMLReporter {
    public static void main (String[] args) {
        File reportOutputDirectory = new File("build/reports/pretty");
        List<String> jsonReportFiles = new ArrayList();
        jsonReportFiles.add("build/reports/cucumber-json-report.json");

        String buildNumber = "1";
        String buildProjectName = "cuke-jvm-sample";
        String pluginURL = "";
        Boolean skippedFails = false;
        Boolean undefinedFails = false;
        Boolean flashCharts = true;
        Boolean runWithJenkins = false;
        Boolean artifactsEnabled = true;
        Boolean highCharts = false;

        ReportBuilder reportBuilder = null;
        try {
            reportBuilder = new ReportBuilder(jsonReportFiles,reportOutputDirectory,"","1",
                    "buildProjectName",false,false, true,true, false, "",
                    false);

        reportBuilder.generateReports();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
