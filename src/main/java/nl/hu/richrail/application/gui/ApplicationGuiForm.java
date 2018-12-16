package nl.hu.richrail.application.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import nl.hu.richrail.application.gui.items.ComponentComboItem;
import nl.hu.richrail.domain.rollingcomponent.RollingComponentType;

import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

public class ApplicationGuiForm {
    private JPanel containerView;
    private JButton buttonCreate;
    private JTextField newTrainName;
    private JComboBox<String> availableTrains;
    private JLabel selectedTrain;
    private JButton buttonDelete;
    private JTextField wagonName;
    private JButton buttonCreateWagon;
    private JComboBox<ComponentComboItem> wagonTypes;
    private JSpinner wagonSeats;
    private JPanel drawPanel;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        containerView = new JPanel();
        containerView.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1, true, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        containerView.add(panel1, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.add(panel2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, 1, null, null, null, 0, false));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        final JLabel label1 = new JLabel();
        label1.setText("Geselecteerde trein");
        panel2.add(label1);
        selectedTrain = new JLabel();
        Font selectedTrainFont = this.$$$getFont$$$(null, Font.PLAIN, -1, selectedTrain.getFont());
        if (selectedTrainFont != null) selectedTrain.setFont(selectedTrainFont);
        selectedTrain.setText("Geen");
        panel2.add(selectedTrain);
        drawPanel = new JPanel();
        drawPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        drawPanel.setBackground(new Color(-13158601));
        drawPanel.setEnabled(true);
        panel1.add(drawPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        containerView.add(panel3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 5), null));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FormLayout("fill:d:noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        panel3.add(panel4, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonCreate = new JButton();
        buttonCreate.setText("Aanmaken");
        CellConstraints cc = new CellConstraints();
        panel4.add(buttonCreate, cc.xy(5, 1));
        newTrainName = new JTextField();
        panel4.add(newTrainName, cc.xy(3, 1, CellConstraints.FILL, CellConstraints.DEFAULT));
        availableTrains = new JComboBox();
        panel4.add(availableTrains, cc.xy(3, 3));
        final JLabel label2 = new JLabel();
        label2.setText("Trein naam");
        panel4.add(label2, cc.xy(1, 1));
        buttonDelete = new JButton();
        buttonDelete.setText("Verwijder");
        panel4.add(buttonDelete, cc.xy(5, 3));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$(null, -1, 14, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Trein management");
        panel3.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        containerView.add(panel5, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10), null));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new FormLayout("fill:d:noGrow,left:4dlu:noGrow,fill:d:grow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        panel5.add(panel6, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Wagon naam");
        panel6.add(label4, cc.xy(1, 1));
        wagonName = new JTextField();
        panel6.add(wagonName, cc.xy(3, 1, CellConstraints.FILL, CellConstraints.DEFAULT));
        buttonCreateWagon = new JButton();
        buttonCreateWagon.setText("Aanmaken");
        panel6.add(buttonCreateWagon, cc.xy(3, 7));
        final JLabel label5 = new JLabel();
        label5.setText("Wagon type");
        panel6.add(label5, cc.xy(1, 3));
        wagonTypes = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        wagonTypes.setModel(defaultComboBoxModel1);
        panel6.add(wagonTypes, cc.xy(3, 3));
        final JLabel label6 = new JLabel();
        label6.setText("Stoelen");
        panel6.add(label6, cc.xy(1, 5));
        wagonSeats = new JSpinner();
        panel6.add(wagonSeats, cc.xy(3, 5, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label7 = new JLabel();
        Font label7Font = this.$$$getFont$$$(null, -1, 14, label7.getFont());
        if (label7Font != null) label7.setFont(label7Font);
        label7.setHorizontalAlignment(2);
        label7.setText("Wagon management");
        panel5.add(label7, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return containerView;
    }

    public JButton getButtonCreate() {
        return buttonCreate;
    }

    public JTextField getNewTrainName() {
        return newTrainName;
    }

    public JComboBox<String> getAvailableTrains() {
        return availableTrains;
    }

    public JLabel getSelectedTrain() {
        return selectedTrain;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public JTextField getWagonName() {
        return wagonName;
    }

    public JButton getButtonCreateWagon() {
        return buttonCreateWagon;
    }

    public JComboBox<ComponentComboItem> getWagonTypes() {
        return wagonTypes;
    }

    public JSpinner getWagonSeats() {
        return wagonSeats;
    }

}
