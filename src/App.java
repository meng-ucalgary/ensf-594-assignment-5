import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Implements the logic to solve the given problem statement
 *
 * @author Bhavyai Gupta
 */
public class App {
    private FileReader inputFile;
    private FileWriter outputFile1;
    private FileWriter outputFile2;

    /**
     * Constructs App object with default initializations
     */
    private App() {
        try {
            this.inputFile = new FileReader(new File("input.txt"));
            this.outputFile1 = new FileWriter(new File("output1.txt"));
            this.outputFile2 = new FileWriter(new File("output2.txt"));
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
            Runtime.getRuntime().exit(1);
        }

        catch (IOException e) {
            e.printStackTrace();
            Runtime.getRuntime().exit(1);
        }
    }

    /**
     * Read the input file, processes it and writes output in output file
     */
    private void main() {
        StudentTree st = new StudentTree();

        System.out.printf("%nProcessing...%n");

        try (BufferedReader br = new BufferedReader(this.inputFile)) {
            String str;

            // read all the records till EOF is reached
            while ((str = br.readLine()) != null) {
                // skip the empty or blank lines
                if (str.length() == 0 || str.isBlank()) {
                    continue;
                }

                // insert only if operation code is 'I'
                if (str.charAt(0) == 'I') {
                    Student student = this.stringToStudent(str);
                    st.insert(student);
                }

            }

            // System.out.println(st.inOrder());
            // System.out.println(st.levelOrder());

            // write the processed output in the desired forms
            this.writeFile(st);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            System.out.printf("%nDone!%n");
        }
    }

    /**
     * Read string into Student object
     *
     * @param str string with Student data in specified format
     * @return Student object
     */
    private Student stringToStudent(String str) {
        Student student = new Student();

        student.setNumber(str.substring(1, 8));
        student.setLastName(str.substring(8, 33));
        student.setHomeDepartment(str.substring(33, 37));
        student.setProgram(str.substring(37, 41));
        student.setYear(Integer.parseInt(str.substring(41, 42)));

        return student;
    }

    /**
     * Writes the StudentTree to the output files using in-order traversal and
     * level-order traversal
     */
    public void writeFile(StudentTree st) {
        PrintWriter pw1 = new PrintWriter(new BufferedWriter(this.outputFile1), true);
        pw1.print(st.inOrder());

        PrintWriter pw2 = new PrintWriter(new BufferedWriter(this.outputFile2), true);
        pw2.print(st.levelOrder());

        pw1.close();
        pw2.close();
    }

    /**
     * Entry point of the program
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        App app = new App();
        app.main();
    }
}
