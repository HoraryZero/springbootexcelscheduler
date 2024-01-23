package ao.klever.springbootexcelscheduler.exceltoweb;

import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import com.spire.xls.core.spreadsheet.HTMLOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class FileConvert {
    private static Properties properties;
    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void runConvertExcel2HTML() {

        try {
            String directory = "src/main/resources/templates/";
            String filename1 = "TempBeanAndonOne.html";
            String filename2 = "TempBeanAndonTwo.html";
            Path path1 = Paths.get(directory, filename1);
            Path path2 = Paths.get(directory, filename2);

            String fileDirectory = FileConvert.getProperty("app.pathToFile");
            String filename = FileConvert.getProperty("app.fileName");

            Path path123 = Paths.get(fileDirectory, filename);
            Workbook workbook = new Workbook();
            workbook.loadFromFile(String.valueOf(path123));
            Worksheet sheet0 = workbook.getWorksheets().get(1);
            Worksheet sheet2 = workbook.getWorksheets().get(2);
            HTMLOptions options = new HTMLOptions();
            options.setImageEmbedded(true);

            sheet0.saveToHtml(path1.toString(), options);
            sheet2.saveToHtml(path2.toString(), options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
