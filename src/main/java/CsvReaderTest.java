import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;


import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class CsvReaderTest {


    public static void main(String[] args) throws IOException {

        File srcFile = new File("./src/main/SampleCSVFile_2kb.csv");
        File copied = Paths.get("./src/main/", "SampleCSVFile_" + FilenameUtils.getBaseName(srcFile.toString()) + ".csv").toFile();
        FileUtils.copyFile(srcFile, copied);
        List<String[]> csvBody = null;

        File[] listOfFiles = new File("./src/main/").listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".csv");
            }
        });

        assert listOfFiles != null;
        Arrays.sort(listOfFiles, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
        System.out.println(Arrays.toString(listOfFiles));
        try (CSVReader reader = new CSVReader(new FileReader(copied))) {
            csvBody = reader.readAll();
            csvBody.get(0)[0] = "saurabh";
            csvBody.get(0)[2] = "mishra";

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(copied))) {
            writer.writeAll(csvBody);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
