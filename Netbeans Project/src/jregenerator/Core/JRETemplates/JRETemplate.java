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
package jregenerator.Core.JRETemplates;

import java.util.ArrayList;
import jregenerator.Core.JDK.JavaModule;

/**
 *
 * @author Nikos Siatras - https://github.com/nsiatras
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
