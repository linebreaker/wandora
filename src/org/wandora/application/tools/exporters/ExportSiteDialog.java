/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2015 Wandora Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 
 * ExportSiteDialog.java
 *
 * Created on 6. tammikuuta 2005, 18:36
 */

package org.wandora.application.tools.exporters;


import java.io.*;
import javax.swing.*;


import org.wandora.application.gui.*;
import org.wandora.application.gui.simple.*;
import org.wandora.application.*;


/**
 *
 * @author  akivela
    <key>pageTemplate</key><value>classes/gui/export/sitepage.vhtml</value>
    <key>indexTemplate</key><value>classes/gui/export/siteindex.vhtml</value>
    <key>templateEncoding</key><value>ISO-8859-1</value>
    <key>fetchUrls</key><value>false</value>
    <key>resizeImages</key><value>true</value>
    <key>imageWidth</key><value>800</value>
    <key>imageHeight</key><value>600</value>
 *
 */



public class ExportSiteDialog extends javax.swing.JDialog {
    
    private Wandora admin;
    public boolean accept = false;
    
    
    
    
    
    /** Creates new form ExportSiteDialog */
    public ExportSiteDialog(Wandora parent, boolean modal) {
        super(parent, modal);
        admin = parent;
        initComponents();
        hideSubjectLocatorPanels();
        admin.centerWindow(this);
    }
    
    
    
    
    public void hideSubjectLocatorPanels() {
        optionsTabbedPanel.remove(imagePanel);
    }
    
    
    public void viewSubjectLocatorPanels() {
        optionsTabbedPanel.addTab("Images", imagePanel);
    }
    
    public void toggleSubjectLocatorPanels() {
        if(importSLsCheckBox.isSelected()) {
            viewSubjectLocatorPanels();
        }
        else {
            hideSubjectLocatorPanels();
        }
    }
    

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        dialogPanel = new javax.swing.JPanel();
        exportDirectoryPanel = new javax.swing.JPanel();
        exportDirectoryLabel = new SimpleLabel();
        exportDirectoryField = new SimpleField();
        browseExportDirectoryButton = new SimpleButton();
        optionsTabbedPanel = new SimpleTabbedPane();
        subjectLocatorPanel = new javax.swing.JPanel();
        importSLsCheckBox = new SimpleCheckBox();
        templatePanel = new javax.swing.JPanel();
        pageTemplatePanel = new javax.swing.JPanel();
        pageTemplateLabel = new SimpleLabel();
        pageTemplateField = new SimpleField();
        browsePageTemplateButton = new SimpleButton();
        indexTemplatePanel = new javax.swing.JPanel();
        indexTemplateLabel = new SimpleLabel();
        indexTemplateField = new SimpleField();
        browseIndexTemplateButton = new SimpleButton();
        templateEncodingPanel = new javax.swing.JPanel();
        templateEncodingLabel = new SimpleLabel();
        templateEncodingComboBox = new SimpleComboBox();
        jPanel5 = new javax.swing.JPanel();
        imagePanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        resizeImagesCheckBox = new SimpleCheckBox();
        jPanel7 = new javax.swing.JPanel();
        newWidthLabel = new SimpleLabel();
        newWidthField = new SimpleField();
        jPanel8 = new javax.swing.JPanel();
        newHeightLabel = new SimpleLabel();
        newHeightField = new SimpleField();
        buttonPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        exportButton = new SimpleButton();
        cancelButton = new SimpleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Export site");
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(640, 300));
        getContentPane().setLayout(new java.awt.BorderLayout(10, 0));

        dialogPanel.setMinimumSize(new java.awt.Dimension(400, 200));
        dialogPanel.setLayout(new java.awt.GridBagLayout());

        exportDirectoryPanel.setLayout(new java.awt.GridBagLayout());

        exportDirectoryLabel.setText("Export into a directory");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        exportDirectoryPanel.add(exportDirectoryLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        exportDirectoryPanel.add(exportDirectoryField, gridBagConstraints);

        browseExportDirectoryButton.setText("Browse");
        browseExportDirectoryButton.setMargin(new java.awt.Insets(2, 8, 2, 8));
        browseExportDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseExportDirectoryButtonActionPerformed(evt);
            }
        });
        exportDirectoryPanel.add(browseExportDirectoryButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        dialogPanel.add(exportDirectoryPanel, gridBagConstraints);

        optionsTabbedPanel.setMinimumSize(new java.awt.Dimension(410, 150));
        optionsTabbedPanel.setPreferredSize(new java.awt.Dimension(410, 150));

        subjectLocatorPanel.setLayout(new java.awt.BorderLayout());

        importSLsCheckBox.setText("Import Subject Locators");
        importSLsCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        importSLsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importSLsCheckBoxActionPerformed(evt);
            }
        });
        subjectLocatorPanel.add(importSLsCheckBox, java.awt.BorderLayout.CENTER);

        optionsTabbedPanel.addTab("Options", subjectLocatorPanel);

        templatePanel.setLayout(new java.awt.GridBagLayout());

        pageTemplatePanel.setLayout(new java.awt.GridBagLayout());

        pageTemplateLabel.setText("Page template");
        pageTemplateLabel.setMinimumSize(new java.awt.Dimension(100, 14));
        pageTemplateLabel.setPreferredSize(new java.awt.Dimension(100, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        pageTemplatePanel.add(pageTemplateLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        pageTemplatePanel.add(pageTemplateField, gridBagConstraints);

        browsePageTemplateButton.setLabel("Browse");
        browsePageTemplateButton.setMargin(new java.awt.Insets(2, 8, 2, 8));
        browsePageTemplateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsePageTemplateButtonActionPerformed(evt);
            }
        });
        pageTemplatePanel.add(browsePageTemplateButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        templatePanel.add(pageTemplatePanel, gridBagConstraints);

        indexTemplatePanel.setLayout(new java.awt.GridBagLayout());

        indexTemplateLabel.setText("Index template");
        indexTemplateLabel.setMinimumSize(new java.awt.Dimension(100, 14));
        indexTemplateLabel.setPreferredSize(new java.awt.Dimension(100, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        indexTemplatePanel.add(indexTemplateLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        indexTemplatePanel.add(indexTemplateField, gridBagConstraints);

        browseIndexTemplateButton.setLabel("Browse");
        browseIndexTemplateButton.setMargin(new java.awt.Insets(2, 8, 2, 8));
        browseIndexTemplateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseIndexTemplateButtonActionPerformed(evt);
            }
        });
        indexTemplatePanel.add(browseIndexTemplateButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        templatePanel.add(indexTemplatePanel, gridBagConstraints);

        templateEncodingPanel.setLayout(new java.awt.GridBagLayout());

        templateEncodingLabel.setText("Encoding");
        templateEncodingLabel.setMinimumSize(new java.awt.Dimension(100, 14));
        templateEncodingLabel.setPreferredSize(new java.awt.Dimension(100, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        templateEncodingPanel.add(templateEncodingLabel, gridBagConstraints);

        templateEncodingComboBox.setEditable(true);
        templateEncodingComboBox.setModel(getEncodings());
        templateEncodingComboBox.setMinimumSize(new java.awt.Dimension(200, 20));
        templateEncodingComboBox.setPreferredSize(new java.awt.Dimension(200, 25));
        templateEncodingPanel.add(templateEncodingComboBox, new java.awt.GridBagConstraints());

        jPanel5.setPreferredSize(new java.awt.Dimension(75, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        templateEncodingPanel.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        templatePanel.add(templateEncodingPanel, gridBagConstraints);

        optionsTabbedPanel.addTab("Templates", templatePanel);

        imagePanel.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.GridBagLayout());

        resizeImagesCheckBox.setText("Resize images");
        resizeImagesCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        resizeImagesCheckBox.setMinimumSize(new java.awt.Dimension(120, 23));
        resizeImagesCheckBox.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel10.add(resizeImagesCheckBox, new java.awt.GridBagConstraints());

        jPanel7.setMinimumSize(new java.awt.Dimension(115, 30));

        newWidthLabel.setText("New width");
        jPanel7.add(newWidthLabel);

        newWidthField.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel7.add(newWidthField);

        jPanel10.add(jPanel7, new java.awt.GridBagConstraints());

        jPanel8.setMinimumSize(new java.awt.Dimension(115, 30));

        newHeightLabel.setText("New height");
        jPanel8.add(newHeightLabel);

        newHeightField.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel8.add(newHeightField);

        jPanel10.add(jPanel8, new java.awt.GridBagConstraints());

        imagePanel.add(jPanel10, java.awt.BorderLayout.CENTER);

        optionsTabbedPanel.addTab("Images", imagePanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        dialogPanel.add(optionsTabbedPanel, gridBagConstraints);

        buttonPanel.setPreferredSize(new java.awt.Dimension(410, 30));
        buttonPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        buttonPanel.add(jPanel1, gridBagConstraints);

        exportButton.setText("Export");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        buttonPanel.add(exportButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        buttonPanel.add(cancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        dialogPanel.add(buttonPanel, gridBagConstraints);

        getContentPane().add(dialogPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void importSLsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importSLsCheckBoxActionPerformed
        toggleSubjectLocatorPanels();
    }//GEN-LAST:event_importSLsCheckBoxActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        accept = true;
        this.setVisible(false);
    }//GEN-LAST:event_exportButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        accept = false;
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void browseIndexTemplateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseIndexTemplateButtonActionPerformed
        String indexTemplateFile = selectFile(indexTemplateField.getText(), "Use page template...");
        if(indexTemplateFile != null) indexTemplateField.setText(indexTemplateFile);
    }//GEN-LAST:event_browseIndexTemplateButtonActionPerformed

    private void browseExportDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseExportDirectoryButtonActionPerformed
        String newDirectory = selectDirectory(exportDirectoryField.getText(), "Export site to directory...");
        if(newDirectory != null) exportDirectoryField.setText(newDirectory);
    }//GEN-LAST:event_browseExportDirectoryButtonActionPerformed

    private void browsePageTemplateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsePageTemplateButtonActionPerformed
        String pageTemplateFile = selectFile(pageTemplateField.getText(), "Use page template...");
        if(pageTemplateFile != null) pageTemplateField.setText(pageTemplateFile);
    }//GEN-LAST:event_browsePageTemplateButtonActionPerformed
    

    
    
    
    private String selectDirectory(String currentDirectoryString, String title) {
        SimpleFileChooser chooser=UIConstants.getFileChooser();

        File currentDirectory;
        if(currentDirectoryString != null && currentDirectoryString.length() > 0) {
            try {
                currentDirectory = new File(currentDirectoryString);
                if(currentDirectory != null) {
                    chooser.setCurrentDirectory(currentDirectory.getParentFile());
                    chooser.setSelectedFile(currentDirectory);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        chooser.setDialogTitle(title);
        chooser.setFileSelectionMode(SimpleFileChooser.DIRECTORIES_ONLY);
        chooser.setFileHidingEnabled(true);
        chooser.setDialogType(SimpleFileChooser.CUSTOM_DIALOG);
        chooser.setApproveButtonToolTipText("Select directory");

        if(chooser.open(admin, "Select")==SimpleFileChooser.APPROVE_OPTION) {
            currentDirectory = chooser.getSelectedFile();
            return currentDirectory.getPath();
        }
        return null;
    }
    
    
    
    
    private String selectFile(String currentFileString, String title) {
        SimpleFileChooser chooser=new SimpleFileChooser();

        File currentFile;
        if(currentFileString != null && currentFileString.length() > 0) {
            try {
                currentFile = new File(currentFileString);
                if(currentFile != null) {
                    chooser.setCurrentDirectory(currentFile.getParentFile());
                    chooser.setSelectedFile(currentFile);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        chooser.setDialogTitle(title);
        chooser.setFileSelectionMode(SimpleFileChooser.FILES_ONLY);

        if(chooser.open(admin, "Select")==SimpleFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            return currentFile.getPath();
        }
        return null;
    }
    
    
    
    public ComboBoxModel getEncodings() {
        return new DefaultComboBoxModel(
            new String[] {
                "UTF-8",
                "ISO-8859-1",
                "US-ASCII",
                "UTF-16"
            }
        );
    }
    
    
    
    public String getExportDirectory() {
        return exportDirectoryField.getText();
    }
    public String getPageTemplate() {
        return pageTemplateField.getText();
    }
    public String getIndexTemplate() {
        return indexTemplateField.getText();
    }
    public String getTemplateEncoding() {
        return templateEncodingComboBox.getSelectedItem().toString();
    }
    public boolean shouldImportSubjectLocators() {
        return importSLsCheckBox.isSelected();
    }
    public boolean shouldResizeImages() {
        return resizeImagesCheckBox.isSelected();
    }
    public int resizeImageWidth() {
        try { return Integer.parseInt(newWidthField.getText()); }
        catch (Exception e) {}
        return 100;
    }
    public int resizeImageHeight() {
        try { return Integer.parseInt(newHeightField.getText()); }
        catch (Exception e) {}
        return 100;
    }
    
    
    
    public void setExportDirectory(String val) {
        exportDirectoryField.setText(val);
    }
    public void setPageTemplate(String val) {
        pageTemplateField.setText(val);
    }
    public void setIndexTemplate(String val) {
        indexTemplateField.setText(val);
    }
    public void setTemplateEncoding(String val) {
        templateEncodingComboBox.setSelectedItem(val);
    }
    public void shouldImportSubjectLocators(boolean val) {
        importSLsCheckBox.setSelected(val);
    }
    public void resizeImages(boolean val) {
        resizeImagesCheckBox.setSelected(val);
    }
    public void resizeImageWidth(int val) {
        newWidthField.setText("" + val);
    }
    public void resizeImageHeight(int val) {
        newHeightField.setText("" + val);
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseExportDirectoryButton;
    private javax.swing.JButton browseIndexTemplateButton;
    private javax.swing.JButton browsePageTemplateButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel dialogPanel;
    private javax.swing.JButton exportButton;
    private javax.swing.JTextField exportDirectoryField;
    private javax.swing.JLabel exportDirectoryLabel;
    private javax.swing.JPanel exportDirectoryPanel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JCheckBox importSLsCheckBox;
    private javax.swing.JTextField indexTemplateField;
    private javax.swing.JLabel indexTemplateLabel;
    private javax.swing.JPanel indexTemplatePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField newHeightField;
    private javax.swing.JLabel newHeightLabel;
    private javax.swing.JTextField newWidthField;
    private javax.swing.JLabel newWidthLabel;
    private javax.swing.JTabbedPane optionsTabbedPanel;
    private javax.swing.JTextField pageTemplateField;
    private javax.swing.JLabel pageTemplateLabel;
    private javax.swing.JPanel pageTemplatePanel;
    private javax.swing.JCheckBox resizeImagesCheckBox;
    private javax.swing.JPanel subjectLocatorPanel;
    private javax.swing.JComboBox templateEncodingComboBox;
    private javax.swing.JLabel templateEncodingLabel;
    private javax.swing.JPanel templateEncodingPanel;
    private javax.swing.JPanel templatePanel;
    // End of variables declaration//GEN-END:variables
    
}
