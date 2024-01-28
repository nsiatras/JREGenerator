package jregenerator.Core.JRETemplates;

import jregenerator.Core.JDK.JavaModule;

/**
 *
 * @author Nikos Siatras
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
        super.getModules().add(new JavaModule("java.smartcardio"));

        super.getModules().add(new JavaModule("jdk.crypto.ec"));
        super.getModules().add(new JavaModule("jdk.crypto.cryptoki"));
        super.getModules().add(new JavaModule("jdk.crypto.mscapi"));

    }
}
