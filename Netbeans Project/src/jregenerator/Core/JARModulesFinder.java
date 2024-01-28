package jregenerator.Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
public class JARModulesFinder
{
    // java -p "#JAR_PATH" --list-modules

    private final String fJarFilePath;
    private final String fListModulesDOSCommand = "java -p \"#JAR_PATH#\" --list-modules";
    //private final String fListModulesDOSCommand = "jar --file=\"#JAR_PATH#\" --describe-module";

    public JARModulesFinder(String jarFilePath)
    {
        fJarFilePath = jarFilePath;
    }

    public ArrayList<String> getJARModules() throws IOException
    {
        ArrayList<String> result = new ArrayList<>();

        String dosCommand = fListModulesDOSCommand.replace("#JAR_PATH#", fJarFilePath);

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
            
            if(!line.contains("file:"))
            {
                
            }

            /*if (line.startsWith("requires"))
            {
                String[] parts = line.split(" ");
                result.add(parts[1]);
            }*/

        }
        return result;
    }
}
