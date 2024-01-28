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
package jregenerator;

import com.formdev.flatlaf.FlatLightLaf;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jregenerator.Core.JDK.JDK;
import jregenerator.Core.JREExporter;
import jregenerator.Core.JRETemplates.JRETempatesManager;
import jregenerator.Core.JRETemplates.JRETemplate;
import jregenerator.Core.JDK.JavaModule;
import jregenerator.UI.UITools.UITools;

/**
 *
 * @author Nikos Siatras - https://github.com/nsiatras
 */
public class frmJREExport extends javax.swing.JFrame
{

    private final JDK fJDK;

    /**
     * Creates new form frmMain
     */
    public frmJREExport(JDK jdkToUse)
    {
        initComponents();
        fJDK = jdkToUse;
        this.setLocationRelativeTo(null);
    }

    private void InitializeUI()
    {
        jLabelJavaHome.setText("JAVA_HOME: " + fJDK.getPath());

        // Initialize templateComboBox
        for (JRETemplate template : JRETempatesManager.getTemplates())
        {
            jComboBoxTemplates.addItem(template.getTitle());
        }

        UITools.ShowPleaseWaitDialog("Please Wait", "Loading JDK Modules", this, () ->
        {
            UpdateJavaModulesTable();
        });

        //SetJDK(System.getenv("JAVA_HOME"));
    }

    private void UpdateJavaModulesTable()
    {
        JRETemplate selectedTemplate = JRETempatesManager.getByTitle(jComboBoxTemplates.getSelectedItem().toString());

        DefaultTableModel model = (DefaultTableModel) jTableModules.getModel();
        try
        {
            // Clear Rows
            model.setNumRows(0);

            for (JavaModule mod : fJDK.getModules())
            {
                boolean selected = selectedTemplate.ContainsModule(mod);
                model.addRow(new Object[]
                {
                    mod.getTitle(), mod.getVersion(), selected
                });
            }
        }
        catch (Exception ex)
        {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableModules = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxTemplates = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabelJavaHome = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemExportJRE = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JRE Generator");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Template Java Modules", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jTableModules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Module", "Version", "Selected"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }
        });
        jTableModules.setRowHeight(24);
        jTableModules.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableModules.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableModules);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("JRE Template:");

        jComboBoxTemplates.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBoxTemplatesActionPerformed(evt);
            }
        });

        jLabelJavaHome.setText("JAVA_HOME: Not Found!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelJavaHome)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelJavaHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItemExportJRE.setText("Export JRE");
        jMenuItemExportJRE.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItemExportJREActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExportJRE);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTemplates, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 347, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxTemplates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTemplatesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBoxTemplatesActionPerformed
    {//GEN-HEADEREND:event_jComboBoxTemplatesActionPerformed
        UpdateJavaModulesTable();
    }//GEN-LAST:event_jComboBoxTemplatesActionPerformed

    private void jMenuItemExportJREActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemExportJREActionPerformed
    {//GEN-HEADEREND:event_jMenuItemExportJREActionPerformed
        ArrayList<JavaModule> selectedModules = new ArrayList<>();
        for (int i = 0; i < jTableModules.getRowCount(); i++)
        {
            String moduleTitle = jTableModules.getValueAt(i, 0).toString();
            boolean selected = (boolean) jTableModules.getValueAt(i, 2);
            if (selected)
            {
                selectedModules.add(fJDK.getJavaModuleByTitle(moduleTitle));
            }
        }

        try
        {
            JREExporter exporter = new JREExporter();
            exporter.Export(fJDK, selectedModules);
        }
        catch (Exception ex)
        {

        }


    }//GEN-LAST:event_jMenuItemExportJREActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenu1ActionPerformed
    {//GEN-HEADEREND:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        InitializeUI();
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxTemplates;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelJavaHome;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemExportJRE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableModules;
    // End of variables declaration//GEN-END:variables
}
