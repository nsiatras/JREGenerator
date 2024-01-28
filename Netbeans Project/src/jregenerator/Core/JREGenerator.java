package jregenerator.Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Nikos Siatras
 */
public class JREGenerator
{

    private final String fJREExportCommand = "jlink --output \"#JRE_PATH#\" --module-path ..\\jmods --add-modules #MODULES#";

    public JREGenerator()
    {

    }

    public void GenerateJRE(ArrayList<String> modules, String jreExportPath) throws IOException
    {
        String modulesString = "";
        for (String module : modules)
        {
            modulesString += module + ",";
        }
        modulesString = modulesString.substring(0, modulesString.length() - 1);

        String dosCommand = fJREExportCommand.replace("#JRE_PATH#", jreExportPath);
        dosCommand = dosCommand.replace("#MODULES#", modulesString);

        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", dosCommand);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true)
        {
            line = r.readLine();
            if (line == null)
            {
                break;
            }
            
            

            System.out.println(line);
        }
      

    }
}
