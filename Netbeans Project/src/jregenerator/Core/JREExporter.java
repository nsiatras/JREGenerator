/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jregenerator.Core;

import java.io.IOException;
import java.util.ArrayList;
import jregenerator.Core.JDK.JDK;
import jregenerator.Core.JDK.JavaModule;
import jregenerator.Utilities.DosPromt;

/*
    Copyright (C) 2024 Nikolaos Siatras
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This software is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.

    @author Nikos Siatras
 */
public class JREExporter
{

    public JREExporter()
    {

    }

    public void Export(JDK jdkToExport, ArrayList<JavaModule> modules) throws IOException
    {
        //String command = jdkToExport.getPath() + "\\bin\\jlink.exe --output \"C:\\Users\\nsiat\\Desktop\\jre\" --module-path ..\\jmods --add-modules #MODULES# --strip-debug --no-man-pages";
        String command = jdkToExport.getPath() + "\\bin\\jlink.exe --output \"C:\\Users\\nsiat\\Desktop\\jre\" --module-path ..\\jmods --add-modules #MODULES# --no-man-pages";

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
