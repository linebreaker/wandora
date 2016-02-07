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
 * SimilarityMatrixExportDialog.java
 *
 * Created on Sep 9, 2011, 10:19:27 PM
 */

package org.wandora.application.tools.exporters;

import java.util.ArrayList;
import javax.swing.JDialog;
import org.wandora.application.Wandora;
import org.wandora.application.gui.UIBox;
import org.wandora.application.gui.simple.SimpleButton;
import org.wandora.application.gui.simple.SimpleCheckBox;
import org.wandora.application.gui.simple.SimpleComboBox;
import org.wandora.application.gui.simple.SimpleField;
import org.wandora.application.gui.simple.SimpleLabel;
import org.wandora.topicmap.similarity.TopicSimilarity;
import org.wandora.topicmap.similarity.TopicSimilarityHelper;

/**
 *
 * @author akivela
 */


public class SimilarityMatrixExportDialog extends javax.swing.JPanel {

    private boolean wasAccepted = false;
    private JDialog myDialog = null;
    private ArrayList<TopicSimilarity> similarityMeasures = null;
    
    
    /** Creates new form SimilarityMatrixExportDialog */
    public SimilarityMatrixExportDialog() {
        initComponents();
        similarityTypeComboBox.setEditable(false);
        outputFormatComboBox.setEditable(false);
        
        similarityMeasures = TopicSimilarityHelper.getTopicSimilarityMeasures();
        for(TopicSimilarity similarityMeasure : similarityMeasures) {
            similarityTypeComboBox.addItem(similarityMeasure.getName());
        }
        
        outputFormatComboBox.addItem(SimilarityMatrixExport.TAB_FORMAT);
        outputFormatComboBox.addItem(SimilarityMatrixExport.HTML_FORMAT);
    }
    
    
    
    public boolean wasAccepted() {
        return wasAccepted;
    }
    
    
    public void open() {
        myDialog = new JDialog(Wandora.getWandora(), true);
        myDialog.add(this);
        myDialog.setSize(600,320);
        myDialog.setTitle("Similarity matrix export options");
        UIBox.centerWindow(myDialog, Wandora.getWandora());
        wasAccepted = false;
        myDialog.setVisible(true);
    }
    
    
    
    
    public boolean shouldAddLabels() {
        return addLabelsCheckBox.isSelected();
    }
    
    public String getOutputFormat() {
        return outputFormatComboBox.getItemAt(outputFormatComboBox.getSelectedIndex()).toString();
    }
    
    public TopicSimilarity getSimilarityMeasure() {
        int index = similarityTypeComboBox.getSelectedIndex();
        if(index >= 0 && index < similarityMeasures.size()) {
            return similarityMeasures.get(index);
        }
        return null;
    }

    public int getNumberOfDecimals() {
        int d = 3;
        try {
            d = Integer.parseInt(noDecimalsTextField.getText());
            if(d > 10) d = 10;
        }
        catch(Exception e) {
            // DO NOTHING
        }
        return d;
    }
    
    
    
    public double getMaximizeAbove() {
        double m = 1.0;
        try {
            String mstr = maximizeAboveTextField.getText();
            if(mstr != null && mstr.trim().length() > 0) {
                m = Double.parseDouble(mstr);
            }
        }
        catch(Exception e) {
            // DO NOTHING
        }
        return m;
    }
    
    
    
    
    public double getFilterBelow() {
        double m = 0.0;
        try {
            String mstr = filterBelowTextField.getText();
            if(mstr != null && mstr.trim().length() > 0) {
                m = Double.parseDouble(mstr);
            }
        }
        catch(Exception e) {
            // DO NOTHING
        }
        return m;
    }
    
    
    public boolean getOutputZeros() {
        return outputZerosCheckBox.isSelected();
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        optionsPanel = new javax.swing.JPanel();
        infoLabel = new SimpleLabel();
        similarityTypeComboBox = new SimpleComboBox();
        outputFormatComboBox = new SimpleComboBox();
        additionsPanel = new javax.swing.JPanel();
        noDecimalsLabel = new SimpleLabel();
        noDecimalsTextField = new SimpleField();
        filterBelowLabel = new SimpleLabel();
        filterBelowTextField = new SimpleField();
        maximizeAboveLabel = new SimpleLabel();
        maximizeAboveTextField = new SimpleField();
        additions2Panel = new javax.swing.JPanel();
        addLabelsCheckBox = new SimpleCheckBox();
        outputZerosCheckBox = new SimpleCheckBox();
        buttonPanel = new javax.swing.JPanel();
        buttonFillerPanel = new javax.swing.JPanel();
        exportButton = new SimpleButton();
        cancelButton = new SimpleButton();

        setLayout(new java.awt.GridBagLayout());

        optionsPanel.setLayout(new java.awt.GridBagLayout());

        infoLabel.setText("<html>This tools is used to export similarity matrix. Similarity matrix is an adjacency matrix where each row and column represent single topic. Matrix cell holds a number representing similarity of the row-topic and the column-topic. Similarity value 1 means topics are maximally similar. Similarity value 0 means topics are maximally different. Select used similarity metric, used output format and other options below. To begin export, click Export button.</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        optionsPanel.add(infoLabel, gridBagConstraints);

        similarityTypeComboBox.setMinimumSize(new java.awt.Dimension(300, 23));
        similarityTypeComboBox.setPreferredSize(new java.awt.Dimension(300, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        optionsPanel.add(similarityTypeComboBox, gridBagConstraints);

        outputFormatComboBox.setMinimumSize(new java.awt.Dimension(300, 23));
        outputFormatComboBox.setPreferredSize(new java.awt.Dimension(300, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        optionsPanel.add(outputFormatComboBox, gridBagConstraints);

        additionsPanel.setLayout(new java.awt.GridBagLayout());

        noDecimalsLabel.setText("Number of decimals");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        additionsPanel.add(noDecimalsLabel, gridBagConstraints);

        noDecimalsTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noDecimalsTextField.setText("3");
        noDecimalsTextField.setMinimumSize(new java.awt.Dimension(40, 23));
        noDecimalsTextField.setPreferredSize(new java.awt.Dimension(40, 23));
        additionsPanel.add(noDecimalsTextField, new java.awt.GridBagConstraints());

        filterBelowLabel.setText("Filter values below");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 4);
        additionsPanel.add(filterBelowLabel, gridBagConstraints);

        filterBelowTextField.setMinimumSize(new java.awt.Dimension(40, 23));
        filterBelowTextField.setPreferredSize(new java.awt.Dimension(40, 23));
        additionsPanel.add(filterBelowTextField, new java.awt.GridBagConstraints());

        maximizeAboveLabel.setText("Maximize values above");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 4);
        additionsPanel.add(maximizeAboveLabel, gridBagConstraints);

        maximizeAboveTextField.setMinimumSize(new java.awt.Dimension(40, 23));
        maximizeAboveTextField.setPreferredSize(new java.awt.Dimension(40, 23));
        additionsPanel.add(maximizeAboveTextField, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        optionsPanel.add(additionsPanel, gridBagConstraints);

        additions2Panel.setLayout(new java.awt.GridBagLayout());

        addLabelsCheckBox.setSelected(true);
        addLabelsCheckBox.setText("Add labels");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        additions2Panel.add(addLabelsCheckBox, gridBagConstraints);

        outputZerosCheckBox.setSelected(true);
        outputZerosCheckBox.setText("Write zeros");
        additions2Panel.add(outputZerosCheckBox, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        optionsPanel.add(additions2Panel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(optionsPanel, gridBagConstraints);

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        buttonFillerPanel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        buttonPanel.add(buttonFillerPanel, gridBagConstraints);

        exportButton.setText("Export");
        exportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exportButtonMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        buttonPanel.add(exportButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelButtonMouseReleased(evt);
            }
        });
        buttonPanel.add(cancelButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        add(buttonPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

private void exportButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportButtonMouseReleased
    wasAccepted = true;
    if(myDialog != null) myDialog.setVisible(false);
}//GEN-LAST:event_exportButtonMouseReleased

private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
    wasAccepted = false;
    if(myDialog != null) myDialog.setVisible(false);
}//GEN-LAST:event_cancelButtonMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox addLabelsCheckBox;
    private javax.swing.JPanel additions2Panel;
    private javax.swing.JPanel additionsPanel;
    private javax.swing.JPanel buttonFillerPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JLabel filterBelowLabel;
    private javax.swing.JTextField filterBelowTextField;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel maximizeAboveLabel;
    private javax.swing.JTextField maximizeAboveTextField;
    private javax.swing.JLabel noDecimalsLabel;
    private javax.swing.JTextField noDecimalsTextField;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JComboBox outputFormatComboBox;
    private javax.swing.JCheckBox outputZerosCheckBox;
    private javax.swing.JComboBox similarityTypeComboBox;
    // End of variables declaration//GEN-END:variables
}
