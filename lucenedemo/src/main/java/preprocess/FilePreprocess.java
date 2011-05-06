package preprocess;

import java.util.Properties;
import java.util.Map;
import java.io.*;

public class FilePreprocess {
    /**
     * @param file
     * @param outputDir
     */
    public static void preprocess(File file, String outputDir) {
        try {
            splitToSmallFiles(charactorProcess(file, outputDir + "output.all"), outputDir);
            File fileDelete = new File(outputDir + "output.all");
            if (fileDelete.exists())
                fileDelete.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param file
     * @param destFile
     * @return
     * @throws Exception
     */
    public static File charactorProcess(File file, String destFile)
            throws Exception {

        BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();

        while (line != null) {
            String newline = replace(line);
            writer.write(newline);
            writer.newLine();
            line = reader.readLine();
        }
        reader.close();
        writer.close();

        return new File(destFile);

    }

    /**
     * @param file
     * @param outputpath
     */
    public static void splitToSmallFiles(File file, String outputpath) throws IOException {

        int filePointer = 0;

        int MAX_SIZE = 10240;

        BufferedWriter writer = null;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuffer buffer = new StringBuffer();
        String line = reader.readLine();

        while (line != null) {
            buffer.append(line).append("\r\n");
            if (buffer.toString().getBytes().length >= MAX_SIZE) {
                writer = new BufferedWriter(new FileWriter(outputpath + "output" + filePointer + ".txt"));
                writer.write(buffer.toString());
                writer.close();
                filePointer++;

                buffer = new StringBuffer();
            }
            line = reader.readLine();
        }

        writer = new BufferedWriter(new FileWriter(outputpath + "output" + filePointer + ".txt"));
        writer.write(buffer.toString());
        writer.close();
    }

    private static String replace(String line) {

        Properties prop = new Properties();
        InputStream is = null;
        try {
             is = new FileInputStream(new File("notation.properties"));
            prop.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }finally{
            if (is!=null)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
        }
        Map map = (Map) prop;
        int length = line.length();
        for (int i = 0; i < length; i++) {
            String charat = line.substring(i, i + 1);
            if (map.get(charat) != null) {
                line = line.replace(charat, (String) map.get(charat));
            }
        }
        return line;
    }
}