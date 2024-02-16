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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import jregenerator.Core.JDK.JDK;
import jregenerator.Core.JDK.JavaModule;
import jregenerator.Utilities.DosPromt;

/**
 *
 * @author Nikos Siatras - https://github.com/nsiatras
 */
public class JREExporter
{

    public JREExporter()
    {

    }

    public void Export(JDK jdkToExport, ArrayList<JavaModule> modules, String exportPath, boolean stripDebug, boolean noManPages) throws IOException
    {
        //String command = jdkToExport.getPath() + "\\bin\\jlink.exe --output \"C:\\Users\\nsiat\\Desktop\\jre\" --module-path ..\\jmods --add-modules #MODULES# --strip-debug --no-man-pages";
        // C:\GraalVM\bin\jlink --output "C:\Users\nsiat\Desktop\jre" --module-path ..\jmods --add-modules #MODULES# --no-man-pages
        String command = jdkToExport.getPath() + File.separator + "bin" + File.separator + "jlink --output \"" + exportPath + File.separator + "jre\" --module-path .." + File.separator + "jmods --add-modules #MODULES# #STRIP_DEBUG# #NO_MAN_PAGES#";

        command = stripDebug ? command.replace("#STRIP_DEBUG#", "--strip-debug") : command.replace("#STRIP_DEBUG#", "");
        command = stripDebug ? command.replace("#NO_MAN_PAGES#", "--no-man-pages") : command.replace("#NO_MAN_PAGES#", "");

        // Replace double space with single
        command = command.replace("  ", " ");
        command = command.trim();

        String modulesStr = "";
        for (JavaModule m : modules)
        {
            modulesStr += m.getTitle() + ",";
        }

        if (modulesStr.endsWith(","))
        {
            modulesStr = modulesStr.substring(0, modulesStr.length() - 1);
        }

        command = command.replace("#MODULES#", modulesStr);
        DosPromt.ExecuteDOSPromt(command);

    }

}
