/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jregenerator.Core.JDK;

import java.io.IOException;
import java.util.ArrayList;
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
    public ArrayList<JavaModule> getModules() throws IOException
    {
        if (fModules.isEmpty())
        {
            String result = DosPromt.ExecuteDOSPromt(this.getPath() + "\\bin\\java --list-modules");
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
