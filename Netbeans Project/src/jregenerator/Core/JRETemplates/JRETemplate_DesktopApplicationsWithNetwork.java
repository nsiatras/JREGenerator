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

import jregenerator.Core.JDK.JavaModule;

/**
 *
 * @author Nikos Siatras - https://github.com/nsiatras
 */
public class JRETemplate_DesktopApplicationsWithNetwork extends JRETemplate
{

    public JRETemplate_DesktopApplicationsWithNetwork()
    {
        super("Desktop Applications with Network");

        super.getModules().add(new JavaModule("java.base"));
        //super.getModules().add(new JavaModule("java.compiler"));
        super.getModules().add(new JavaModule("java.datatransfer"));
        super.getModules().add(new JavaModule("java.xml"));
        super.getModules().add(new JavaModule("java.prefs"));
        super.getModules().add(new JavaModule("java.desktop"));
        super.getModules().add(new JavaModule("java.instrument"));
        super.getModules().add(new JavaModule("java.logging"));
        super.getModules().add(new JavaModule("java.management"));
        super.getModules().add(new JavaModule("java.security.sasl"));
        super.getModules().add(new JavaModule("java.naming"));
        super.getModules().add(new JavaModule("java.rmi"));
        super.getModules().add(new JavaModule("java.management.rmi"));
        super.getModules().add(new JavaModule("java.net.http"));
        super.getModules().add(new JavaModule("java.scripting"));
        super.getModules().add(new JavaModule("java.security.jgss"));
        super.getModules().add(new JavaModule("java.transaction.xa"));
        super.getModules().add(new JavaModule("java.sql"));
        super.getModules().add(new JavaModule("java.sql.rowset"));
        super.getModules().add(new JavaModule("java.xml.crypto"));
        super.getModules().add(new JavaModule("java.se"));
        //super.getModules().add(new JavaModule("java.smartcardio"));

        super.getModules().add(new JavaModule("jdk.crypto.ec"));
        super.getModules().add(new JavaModule("jdk.crypto.cryptoki"));
        super.getModules().add(new JavaModule("jdk.crypto.mscapi"));

    }
}
