
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TicTacToeGame implements ActionListener {
    JFrame window;
    JLabel label;
    JPanel panel;
    JButton[] numberButtons = new JButton[9];
    
    Font textFont = new Font("Ink Free", Font.BOLD, 40);
    Random random = new Random();
    Boolean playerTurn;
    
    GuiManeger gui;
    GameFrame game;
    

    TicTacToeGame() {
        window = new JFrame("TicTacToe Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.getContentPane().setBackground(new Color(0x181818));
        window.setResizable(false);
        window.setSize(800, 600);

        gui = new GuiManeger();

        label = new JLabel("Tic Tac Toe Game");
        label.setBounds(5, 10, 790, 100);
        label.setFont(textFont);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);

        panel = new JPanel();
        panel.setBounds(250, 125, 310, 300);
        panel.setLayout(new GridLayout(3, 3, 4, 4));
        panel.setBackground(new Color(0x181818));

        game = new GameFrame();

        /*
         * Image icon =
         * Toolkit.getDefaultToolkit().getImage("C:\\transparent_picture.png");
         * window.setIconImage(icon);
         */
        // imageTitle=new ImageIcon("C:\\transparent_picture.png");
        window.setIconImage(new ImageIcon("D:\\tic-tac-toe.png").getImage());

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton();
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.BLACK);
            numberButtons[i].setHorizontalAlignment(JButton.CENTER);

        }

        panel.add(numberButtons[0]);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);

      
       
        window.add(panel);
        window.add(label);
        window.setVisible(true);
        firstTurn();

    }

  

    public void firstTurn() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            playerTurn = true;
            label.setText("player X Turn");

        } else {
            playerTurn = false;
            label.setText("player O Turn");
        }
    }

    public void check() {

        if ((numberButtons[0].getText() == "X") &&
                (numberButtons[1].getText() == "X") &&
                (numberButtons[2].getText() == "X")) {
            playerXWin(0, 1, 2);

        } else if ((numberButtons[3].getText() == "X") &&
                (numberButtons[4].getText() == "X") &&
                (numberButtons[5].getText() == "X")) {
            playerXWin(3, 4, 5);

        } else if ((numberButtons[6].getText() == "X") &&
                (numberButtons[7].getText() == "X") &&
                (numberButtons[8].getText() == "X")) {
            playerXWin(6, 7, 8);

        } else if ((numberButtons[0].getText() == "X") &&
                (numberButtons[4].getText() == "X") &&
                (numberButtons[8].getText() == "X")) {
            playerXWin(0, 4, 8);

        } else if ((numberButtons[2].getText() == "X") &&
                (numberButtons[4].getText() == "X") &&
                (numberButtons[6].getText() == "X")) {
            playerXWin(2, 4, 6);

        } else if ((numberButtons[0].getText() == "X") &&
                (numberButtons[3].getText() == "X") &&
                (numberButtons[6].getText() == "X")) {
            playerXWin(0, 4, 6);

        } else if ((numberButtons[1].getText() == "X") &&
                (numberButtons[4].getText() == "X") &&
                (numberButtons[7].getText() == "X")) {
            playerXWin(1, 4, 7);

        } else if ((numberButtons[2].getText() == "X") &&
                (numberButtons[5].getText() == "X") &&
                (numberButtons[8].getText() == "X")) {
            playerXWin(2, 5, 8);

        } else if ((numberButtons[0].getText() == "O") &&
                (numberButtons[1].getText() == "O") &&
                (numberButtons[2].getText() == "O")) {
            playerOWin(0, 1, 2);

        } else if ((numberButtons[3].getText() == "O") &&
                (numberButtons[4].getText() == "O") &&
                (numberButtons[5].getText() == "O")) {
            playerOWin(3, 4, 5);

        } else if ((numberButtons[6].getText() == "O") &&
                (numberButtons[7].getText() == "O") &&
                (numberButtons[8].getText() == "O")) {
            playerOWin(6, 7, 8);

        } else if ((numberButtons[0].getText() == "O") &&
                (numberButtons[4].getText() == "O") &&
                (numberButtons[8].getText() == "O")) {
            playerOWin(0, 4, 8);

        } else if ((numberButtons[2].getText() == "O") &&
                (numberButtons[4].getText() == "O") &&
                (numberButtons[6].getText() == "O")) {
            playerOWin(2, 4, 6);

        } else if ((numberButtons[0].getText() == "O") &&
                (numberButtons[3].getText() == "O") &&
                (numberButtons[6].getText() == "O")) {
            playerOWin(0, 4, 6);

        } else if ((numberButtons[1].getText() == "O") &&
                (numberButtons[4].getText() == "O") &&
                (numberButtons[7].getText() == "O")) {
            playerOWin(1, 4, 7);

        } else if ((numberButtons[2].getText() == "O") &&
                (numberButtons[5].getText() == "O") &&
                (numberButtons[8].getText() == "O")) {
            playerOWin(2, 5, 8);
        }

    }

    public void playerXWin(int a, int b, int c) {

        numberButtons[a].setBackground(Color.green);
        numberButtons[b].setBackground(Color.green);
        numberButtons[c].setBackground(Color.green);

        for (int i = 0; i < numberButtons.length; i++) {
            if (numberButtons[i] == numberButtons[a] ||
                    numberButtons[i] == numberButtons[b] ||
                    numberButtons[i] == numberButtons[c]) {
                continue;
            }
            numberButtons[i].setEnabled(false);

        }

        label.setText("Player X winning");
    }

    public void playerOWin(int a, int b, int c) {

        numberButtons[a].setBackground(Color.green);
        numberButtons[b].setBackground(Color.green);
        numberButtons[c].setBackground(Color.green);

        for (int i = 0; i < numberButtons.length; i++) {
            if (numberButtons[i] == numberButtons[a] ||
                    numberButtons[i] == numberButtons[b] ||
                    numberButtons[i] == numberButtons[c]) {
                continue;
            }
            numberButtons[i].setEnabled(false);

        }

        label.setText("Player O winning");
    }

  

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < numberButtons.length; i++) {

            if (e.getSource() == numberButtons[i]) {

                if (playerTurn) {

                    if (numberButtons[i].getText() == "") {

                        numberButtons[i].setForeground(Color.RED);
                        numberButtons[i].setFont(new Font("Ink Free", Font.BOLD, 70));

                        numberButtons[i].setText("X");
                        playerTurn = false;
                        label.setText("Player O Turn");
                        check();
                    }
                } else {

                    numberButtons[i].setForeground(Color.blue);
                    numberButtons[i].setFont(new Font("Ink Free", Font.BOLD, 70));

                    numberButtons[i].setText("O");
                    playerTurn = true;
                    label.setText("Player X Turn");
                    check();

                }

            }
        }

    }
}
