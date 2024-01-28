package jregenerator.Core.JRETemplates;

import jregenerator.Core.JDK.JavaModule;

/**
 *
 * @author Nikos Siatras
 */
public class JRETemplate_Standard extends JRETemplate
{

    public JRETemplate_Standard()
    {
        super("Standard");
        super.getModules().add(new JavaModule("java.base"));
        super.getModules().add(new JavaModule("java.compiler"));
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
        super.getModules().add(new JavaModule("jdk.accessibility"));
        super.getModules().add(new JavaModule("jdk.internal.jvmstat"));
        super.getModules().add(new JavaModule("jdk.attach"));
        super.getModules().add(new JavaModule("jdk.charsets"));
        super.getModules().add(new JavaModule("jdk.compiler"));
        super.getModules().add(new JavaModule("jdk.crypto.ec"));
        super.getModules().add(new JavaModule("jdk.crypto.cryptoki"));
        super.getModules().add(new JavaModule("jdk.crypto.mscapi"));
        super.getModules().add(new JavaModule("jdk.dynalink"));
        super.getModules().add(new JavaModule("jdk.internal.ed"));
        super.getModules().add(new JavaModule("jdk.editpad"));
        super.getModules().add(new JavaModule("jdk.hotspot.agent"));
        super.getModules().add(new JavaModule("jdk.httpserver"));
        super.getModules().add(new JavaModule("jdk.incubator.foreign"));
        super.getModules().add(new JavaModule("jdk.incubator.vector"));
        super.getModules().add(new JavaModule("jdk.internal.le"));
        super.getModules().add(new JavaModule("jdk.internal.opt"));
        super.getModules().add(new JavaModule("jdk.internal.vm.ci"));
        super.getModules().add(new JavaModule("jdk.internal.vm.compiler"));
        super.getModules().add(new JavaModule("jdk.internal.vm.compiler.management"));
        super.getModules().add(new JavaModule("jdk.jartool"));
        super.getModules().add(new JavaModule("jdk.javadoc"));
        super.getModules().add(new JavaModule("jdk.jcmd"));
        super.getModules().add(new JavaModule("jdk.management"));
        super.getModules().add(new JavaModule("jdk.management.agent"));
        super.getModules().add(new JavaModule("jdk.jconsole"));
        super.getModules().add(new JavaModule("jdk.jdeps"));
        super.getModules().add(new JavaModule("jdk.jdwp.agent"));
        super.getModules().add(new JavaModule("jdk.jdi"));
        super.getModules().add(new JavaModule("jdk.jfr"));
        super.getModules().add(new JavaModule("jdk.jlink"));
        super.getModules().add(new JavaModule("jdk.jpackage"));
        super.getModules().add(new JavaModule("jdk.jshell"));
        super.getModules().add(new JavaModule("jdk.jsobject"));
        super.getModules().add(new JavaModule("jdk.jstatd"));
        super.getModules().add(new JavaModule("jdk.localedata"));
        super.getModules().add(new JavaModule("jdk.management.jfr"));
        super.getModules().add(new JavaModule("jdk.naming.dns"));
        super.getModules().add(new JavaModule("jdk.naming.rmi"));
        super.getModules().add(new JavaModule("jdk.net"));
        super.getModules().add(new JavaModule("jdk.nio.mapmode"));
        super.getModules().add(new JavaModule("jdk.random"));
        super.getModules().add(new JavaModule("jdk.sctp"));
        super.getModules().add(new JavaModule("jdk.security.auth"));
        super.getModules().add(new JavaModule("jdk.security.jgss"));
        super.getModules().add(new JavaModule("jdk.unsupported"));
        super.getModules().add(new JavaModule("jdk.unsupported.desktop"));
        super.getModules().add(new JavaModule("jdk.xml.dom"));
        super.getModules().add(new JavaModule("jdk.zipfs"));

    }
}
