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
package jregenerator.Core.JDK;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import jregenerator.Utilities.DosPromt;

/**
 *
 * @author Nikos Siatras - https://github.com/nsiatras
 */
public class JDK
{

    private String fPath;
    private static ArrayList<JavaModule> fModules;

    /**
     * Initializes a new JDK instance
     *
     * @param path is the JDK folder path
     */
    public JDK(String path)
    {
        fPath = path;
        fModules = new ArrayList<>();
    }

    /**
     * Returns a list with the Java modules of the JDK
     *
     * @param jdk
     * @return
     * @throws IOException
     */
    public ArrayList<JavaModule> getModules() throws IOException, Exception
    {
        if (fModules.isEmpty())
        {
            if (!Files.exists(Paths.get(this.getPath() + "\\bin\\java.exe")))
            {
                throw new Exception("Invalid JDK path");
            }

            String result = DosPromt.ExecuteDOSPromt(this.getPath() + "\\bin\\java.exe --list-modules");
            String[] lines = result.split("\n");
            for (String line : lines)
            {
                if (line.contains("@"))
                {
                    String parts[] = line.split("@");
                    String title = parts[0].trim();
                    String version = parts[1].trim();
                    if (!title.equals("") && !title.equals("null"))
                    {
                        fModules.add(new JavaModule(title, version));
                    }
                }
                else
                {
                    String title = line;
                    if (!title.equals("") && !title.equals("null"))
                    {
                        fModules.add(new JavaModule(title, ""));
                    }
                }
            }
        }

        return fModules;
    }

    /**
     * Returns a Java module by title
     *
     * @param title
     * @return
     */
    public JavaModule getJavaModuleByTitle(String title)
    {
        if (fModules != null)
        {
            for (JavaModule m : fModules)
            {
                if (m.getTitle().equals(title))
                {
                    return m;
                }
            }
        }
        return null;
    }

    /**
     * Returns the directory path of the JDK
     *
     * @return
     */
    public String getPath()
    {
        return fPath;
    }
}
