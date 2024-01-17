package com.lex.memglobe.services;

import com.lex.memglobe.objects.CardSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckBrowser extends JFrame{

    public JPanel getPanelDeckBrowser() {
        return panelDeckBrowser;
    }

    CardSet currentSet;
    private JPanel panelDeckBrowser;
    private JLabel lblNextCard;
    private JTextField txtNextCard;
    private JButton btnNextCard;
    private JLabel lblQuestion;
    private JLabel lblQuestionDisplay;
    private JButton btnShowAnswer;
    private JLabel lblAnswer;
    private JTextArea txtAnswerDisplay;
    private JButton btnForgot;
    private JButton btnHard;
    private JButton btnEasy;

    public DeckBrowser(CardSet currentSet) {
        this.currentSet = currentSet;
        btnNextCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblQuestionDisplay.setText(currentSet.getDeck().get(Integer.parseInt(txtNextCard.getText())).getDisplay().getText());
                txtAnswerDisplay.setText("");
            }
        });
        btnShowAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAnswerDisplay.setText(currentSet.getDeck().get(Integer.parseInt(txtNextCard.getText())).displayAnswers());

            }
        });
    }
}
