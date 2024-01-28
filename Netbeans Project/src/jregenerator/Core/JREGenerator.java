/*
    MIT License

    Copyright (c) 2024 Nikolaos Siatras

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
 */
package jregenerator.Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Nikos Siatras - https://github.com/nsiatras
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
