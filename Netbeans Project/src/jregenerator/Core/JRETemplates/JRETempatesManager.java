package jregenerator.Core.JRETemplates;

import java.util.LinkedList;

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
public class JRETempatesManager
{

    private static LinkedList<JRETemplate> fJRETemplates;

    static
    {
        fJRETemplates = new LinkedList<>();

        fJRETemplates.add(new JRETemplate_Standard());
        fJRETemplates.add(new JRETemplate_Compact1());
        fJRETemplates.add(new JRETemplate_Compact2());
        fJRETemplates.add(new JRETemplate_Compact3());
        fJRETemplates.add(new JRETemplate_DesktopApplications());
         fJRETemplates.add(new JRETemplate_DesktopApplicationsWithNetwork());
    }

    public static LinkedList<JRETemplate> getTemplates()
    {
        return fJRETemplates;
    }

    public static JRETemplate getByTitle(String title)
    {
        for (JRETemplate template : fJRETemplates)
        {
            if (template.getTitle().equals(title))
            {
                return template;
            }
        }
        return null;
    }

}
