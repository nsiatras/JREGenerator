package jregenerator.Core.JRETemplates;

import java.util.ArrayList;
import jregenerator.Core.JDK.JavaModule;

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
public class JRETemplate
{

    private String fTitle;
    private ArrayList<JavaModule> fMyModules = new ArrayList<>();

    public JRETemplate(String title)
    {
        fTitle = title;
    }

    public ArrayList<JavaModule> getModules()
    {
        return fMyModules;
    }

    public String getTitle()
    {
        return fTitle;
    }

    public boolean ContainsModule(JavaModule module)
    {
        for (JavaModule mod : fMyModules)
        {
            if (mod.getTitle().equals(module.getTitle()))
            {
                return true;
            }
        }
        return false;
    }
}
