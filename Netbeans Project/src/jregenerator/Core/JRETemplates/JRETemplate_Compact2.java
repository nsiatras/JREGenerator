package jregenerator.Core.JRETemplates;

import jregenerator.Core.JDK.JavaModule;

/**
 *
 * @author Nikos Siatras
 */
public class JRETemplate_Compact2 extends JRETemplate
{

    public JRETemplate_Compact2()
    {
        super("Compact 2");
        super.getModules().add(new JavaModule("java.base"));
        super.getModules().add(new JavaModule("java.logging"));
        super.getModules().add(new JavaModule("java.naming"));
        super.getModules().add(new JavaModule("java.xml"));
        super.getModules().add(new JavaModule("java.management"));
        super.getModules().add(new JavaModule("java.scripting"));

    }
}
