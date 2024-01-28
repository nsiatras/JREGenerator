package jregenerator.Core.JRETemplates;

import jregenerator.Core.JDK.JavaModule;

/**
 *
 * @author Nikos Siatras
 */
public class JRETemplate_DesktopApplications extends JRETemplate
{

    public JRETemplate_DesktopApplications()
    {
        super("Desktop Applications");
        super.getModules().add(new JavaModule("java.base"));
        super.getModules().add(new JavaModule("java.logging"));
        super.getModules().add(new JavaModule("java.naming"));
        super.getModules().add(new JavaModule("java.xml"));
        super.getModules().add(new JavaModule("java.management"));
        super.getModules().add(new JavaModule("java.scripting"));
        super.getModules().add(new JavaModule("java.rmi"));

        super.getModules().add(new JavaModule("java.desktop"));
        super.getModules().add(new JavaModule("java.se"));

    }
}
