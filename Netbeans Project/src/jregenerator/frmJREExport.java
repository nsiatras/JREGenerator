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

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import jregenerator.Core.JDK.JDK;
import jregenerator.Core.JREExporter;
import jregenerator.Core.JRETemplates.JRETempatesManager;
import jregenerator.Core.JRETemplates.JRETemplate;
import jregenerator.Core.JDK.JavaModule;
import jregenerator.Core.Settings.SettingsManager;
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
     *
     * @param jdkToUse
     */
    public frmJREExport(JDK jdkToUse)
    {
        initComponents();
        fJDK = jdkToUse;
        this.setLocationRelativeTo(null);
        this.setTitle("JREGenerator - v" + SettingsManager.APP_VERSION);
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

        if (selectedTemplate != null)
        {
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
        UpdateSelectedModulesCount();
    }

    private ArrayList<JavaModule> getUserSelectedModules()
    {
        ArrayList<JavaModule> result = new ArrayList<>();
        for (int i = 0; i < jTableModules.getRowCount(); i++)
        {
            String moduleTitle = jTableModules.getValueAt(i, 0).toString();
            boolean selected = (boolean) jTableModules.getValueAt(i, 2);
            if (selected)
            {
                result.add(fJDK.getJavaModuleByTitle(moduleTitle));
            }
        }

        return result;
    }

    private void UpdateSelectedModulesCount()
    {
        jLabelSelectedModulesCount.setText("Selected: " + String.valueOf(this.getUserSelectedModules().size()));
    }

    private void ExportJRE()
    {
        final String jreExportPath;
        JFileChooser chooser;
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose the directory to export the JRE");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            jreExportPath = chooser.getSelectedFile().toString();
        }
        else
        {
            jreExportPath = "";
            System.out.println("No Selection ");
        }

        if (!jreExportPath.equals(""))
        {
            UITools.ShowPleaseWaitDialog("JRE Export", "Please wait. This can take some time...", this, () ->
            {
                final ArrayList<JavaModule> selectedModules = this.getUserSelectedModules();

                try
                {
                    JREExporter exporter = new JREExporter();
                    exporter.Export(fJDK, selectedModules, jreExportPath, jCheckBoxStripDebug.isSelected(), jCheckBoxNoManPages.isSelected());
                }
                catch (Exception ex)
                {

                }
            });

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxTemplates = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableModules = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabelJavaHome = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelSelectedModulesCount = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonExportNow = new javax.swing.JButton();
        jCheckBoxStripDebug = new javax.swing.JCheckBox();
        jCheckBoxNoManPages = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemExportJRE = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JRE Generator");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setRollover(true);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jregenerator/Resources/template-64x64.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Select Template");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText(" Template: ");

        jComboBoxTemplates.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTemplates.setMaximumSize(new java.awt.Dimension(150, 22));
        jComboBoxTemplates.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBoxTemplatesActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jregenerator/Resources/module-64x64.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Choose Java Modules");

        jTableModules.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        jTableModules.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                jTableModulesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableModules);

        jLabelJavaHome.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelJavaHome.setText("JAVA_HOME: Not Found!");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Created by Nikos Siatras - ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("https://github.com/nsiatras");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelJavaHome, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(jLabel7))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addComponent(jLabelJavaHome))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel8.setText("Select the JRE template you want to export");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel9.setText("Select which Java Modules you want to export with the JRE");

        jLabelSelectedModulesCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSelectedModulesCount.setText("Selected: 0");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jregenerator/Resources/export-64x64.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Export JRE");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel12.setText("Export JRE with the above selected Java Modules");

        jButtonExportNow.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonExportNow.setText("Export Now !");
        jButtonExportNow.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonExportNowActionPerformed(evt);
            }
        });

        jCheckBoxStripDebug.setText("Strip Debug - Will remove debugging information out of the output runtime image");

        jCheckBoxNoManPages.setText("No Man Pages - Excludes man pages");

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

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSelectedModulesCount, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxTemplates, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonExportNow)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBoxStripDebug)
                                    .addComponent(jCheckBoxNoManPages))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxTemplates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSelectedModulesCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxStripDebug)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBoxNoManPages)
                .addGap(10, 10, 10)
                .addComponent(jButtonExportNow)
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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


    }//GEN-LAST:event_jMenuItemExportJREActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenu1ActionPerformed
    {//GEN-HEADEREND:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        InitializeUI();
    }//GEN-LAST:event_formWindowOpened

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabel7MouseClicked
    {//GEN-HEADEREND:event_jLabel7MouseClicked
        try
        {
            Desktop.getDesktop().browse(new URI("https://github.com/nsiatras"));
        }
        catch (IOException | URISyntaxException ex)
        {

        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jTableModulesMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableModulesMouseReleased
    {//GEN-HEADEREND:event_jTableModulesMouseReleased
        final JRETemplate selectedTemplate = JRETempatesManager.getByTitle(jComboBoxTemplates.getSelectedItem().toString());
        final ArrayList<JavaModule> selectedModules = this.getUserSelectedModules();

        /*for (JavaModule mod : selectedModules)
        {
            if (!selectedTemplate.ContainsModule(mod))
            {
                selectedModulesBelongsToTemplate = false;
                break;
            }
        }*/
        UpdateSelectedModulesCount();

    }//GEN-LAST:event_jTableModulesMouseReleased

    private void jButtonExportNowActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonExportNowActionPerformed
    {//GEN-HEADEREND:event_jButtonExportNowActionPerformed
        ExportJRE();
    }//GEN-LAST:event_jButtonExportNowActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem2ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExportNow;
    private javax.swing.JCheckBox jCheckBoxNoManPages;
    private javax.swing.JCheckBox jCheckBoxStripDebug;
    private javax.swing.JComboBox<String> jComboBoxTemplates;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelJavaHome;
    private javax.swing.JLabel jLabelSelectedModulesCount;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemExportJRE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableModules;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
