package jregenerator.Core.JDK;

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
public class JavaModule
{

    private final String fTitle, fVersion;

    public JavaModule(String title)
    {
        fTitle = title;
        fVersion = "";
    }

    public JavaModule(String title, String version)
    {
        fTitle = title;
        fVersion = version;
    }

    public String getTitle()
    {
        return fTitle;
    }
    
    public String getVersion()
    {
        return fVersion;
    }
}
