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
package jregenerator.UI.UITools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.net.URI;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author Nikos Siatras - https://github.com/nsiatras
 */
public class UITools
{

    static
    {
    }

    public static void Initialize()
    {
        System.out.println("UI Tools Initialized");
    }

    public static void ShowPleaseWaitDialog(String dialogTitle, String description, javax.swing.JFrame parentForm, Runnable workToDo)
    {
        // Σπάσε το description σε γραμμές και πέρασε το στο descriptionLines Array
        final String[] descriptionLines = description.split("\n");
        final int totalLines = descriptionLines.length + 2;

        final JDialog loading = new JDialog(parentForm);
        final JPanel p1 = new JPanel(new GridLayout(totalLines, 1));
        p1.add(new JLabel(" "), BorderLayout.CENTER);
        for (String line : descriptionLines)
        {
            final JLabel lbl = new JLabel("   " + line + "  ");
            lbl.setForeground(Color.WHITE);
            p1.add(lbl, BorderLayout.CENTER);
        }
        p1.add(new JLabel(" "), BorderLayout.CENTER);
        //p1.add(new JLabel("  "), BorderLayout.CENTER);
        loading.setTitle(dialogTitle);
        loading.setUndecorated(false);
        loading.getContentPane().add(p1);
        loading.pack();
        loading.setLocationRelativeTo(parentForm);
        loading.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        loading.setModal(true);

        // Create a new Swing Worker in order to run
        // the "workToDo" runnable and then displose the "loading dialog"
        SwingWorker<String, Void> worker = new SwingWorker<String, Void>()
        {
            @Override
            protected String doInBackground() throws Exception
            {
                workToDo.run();
                return null;
            }

            @Override
            protected void done()
            {
                loading.dispose();
            }
        };
        worker.execute();

        // Show the loading dialog
        loading.setVisible(true);

        try
        {
            // Wait for workier to finish and then dispose the loading form
            worker.get(); //here the parent thread waits for completion
            loading.dispose();
        }
        catch (Exception ex)
        {

        }
    }

    public static boolean OpenWebpage(String url)
    {
        try
        {
            URI uri = new URI(url);
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
            {
                try
                {
                    desktop.browse(uri);
                    return true;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception ex)
        {

        }

        return false;
    }

}
