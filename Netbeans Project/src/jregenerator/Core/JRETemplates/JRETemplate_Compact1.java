package jregenerator.Core.JRETemplates;

import jregenerator.Core.JDK.JavaModule;

/**
 *
 * @author Nikos Siatras
 */
public class JRETemplate_Compact1 extends JRETemplate
{

    public JRETemplate_Compact1()
    {
        super("Compact 1");
        super.getModules().add(new JavaModule("java.base"));
        super.getModules().add(new JavaModule("java.logging"));
      

    }
}
