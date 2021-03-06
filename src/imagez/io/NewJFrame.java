/*
 *  Copyright (c) 2011 Michael Zucchi
 *
 *  This file is part of ImageZ, a bitmap image editing appliction.
 *
 *  ImageZ is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ImageZ is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with ImageZ.  If not, see <http://www.gnu.org/licenses/>.
 */
package imagez.io;

/**
 *
 * @author notzed
 */
public class NewJFrame extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    public NewJFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setText("Layer Options");
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 15));
        jPanel1.add(jLabel1);

        jRadioButton1.setText("Merge with Alpha");
        jRadioButton1.setMaximumSize(new java.awt.Dimension(500, 23));
        jPanel1.add(jRadioButton1);

        jRadioButton2.setText("Merge with no Alpha");
        jRadioButton2.setMaximumSize(new java.awt.Dimension(500, 23));
        jPanel1.add(jRadioButton2);

        jLabel2.setText("JPEG Options");
        jLabel2.setMaximumSize(new java.awt.Dimension(500, 15));
        jPanel1.add(jLabel2);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Quality");
        jPanel2.add(jLabel4);
        jPanel2.add(jSlider1);

        jPanel1.add(jPanel2);

        jCheckBox1.setText("Write Thumbnail Image");
        jCheckBox1.setMaximumSize(new java.awt.Dimension(500, 23));
        jPanel1.add(jCheckBox1);

        jCheckBox2.setText("Progressive");
        jCheckBox2.setMaximumSize(new java.awt.Dimension(500, 23));
        jPanel1.add(jCheckBox2);

        jLabel3.setText("Comment");
        jLabel3.setMaximumSize(new java.awt.Dimension(500, 15));
        jPanel1.add(jLabel3);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setAlignmentX(0.0F);
        jTextArea1.setMaximumSize(new java.awt.Dimension(500, 2147483647));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
