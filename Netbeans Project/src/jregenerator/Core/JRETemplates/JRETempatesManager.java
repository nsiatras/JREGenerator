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

import java.util.LinkedList;

/**
 *
 * @author Nikos Siatras - https://github.com/nsiatras
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
        fJRETemplates.add(new JRETemplate_Full());
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
