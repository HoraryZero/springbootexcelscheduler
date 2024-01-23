package ao.klever.springbootexcelscheduler.exceltoweb;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RemoveWarnings {
    public static void removeHtmlFile(File htmlFile, String lineToRemove, String newFileName) throws IOException {
        String htmlString = new String(Files.readAllBytes(Paths.get(htmlFile.getPath())));
        String updatedHtmlString = htmlString.replace(lineToRemove, "<meta http-equiv=\"Refresh\" content=\"8\" />");
        File newHtmlFile = new File(htmlFile.getParentFile(), newFileName);
        Files.write(Paths.get(newHtmlFile.getPath()), updatedHtmlString.getBytes());
    }

    public void runHTML2Free() {
        String directory = "src/main/resources/templates/";
        String filename1 = "TempBeanAndonOne.html";
        String filename2 = "TempBeanAndonTwo.html";
        Path path1 = Paths.get(directory, filename1);
        Path path2 = Paths.get(directory, filename2);
        File inputOne = new File(path1.toString());
        File inputTwo = new File(path2.toString());

        String lineToRemove = "<h2 style=\"color:red\">Evaluation&nbsp;Warning&nbsp;:&nbsp;The&nbsp;document&nbsp;was&nbsp;created&nbsp;with&nbsp;&nbsp;Spire.XLS&nbsp;for&nbsp;Java</h2>"; // строка для удаления
        String newFileName1 = "BeanAndonOne.html";
        String newFileName2 = "BeanAndonTwo.html";

        try {
            removeHtmlFile(inputOne, lineToRemove, newFileName1);
            removeHtmlFile(inputTwo, lineToRemove, newFileName2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
