package jregenerator.Core.JRETemplates;

import jregenerator.Core.JDK.JavaModule;

/**
 *
 * @author Nikos Siatras
 */
public class JRETemplate_Compact3 extends JRETemplate
{

    public JRETemplate_Compact3()
    {
        super("Compact 3");
        super.getModules().add(new JavaModule("java.base"));
        super.getModules().add(new JavaModule("java.logging"));
        super.getModules().add(new JavaModule("java.naming"));
        super.getModules().add(new JavaModule("java.xml"));
        super.getModules().add(new JavaModule("java.management"));
        super.getModules().add(new JavaModule("java.scripting"));
        super.getModules().add(new JavaModule("java.rmi"));

    }
}
