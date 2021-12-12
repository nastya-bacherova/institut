package lesson_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Создать фрейм. Поместить в него 2 панели. На 1-ю панель поместить 4 кнопки,
//а на 2-ю – метку. При нажатии на кнопки смещать метку в одном из направлений к
//границе панели. Метка не должна выходить за пределы панели.

public class FrameMy extends JFrame {
    JLabel point;
    JPanel pnl1;
    JPanel pnl2;
    JButton btnUp;
    JButton btnDown;
    JButton btnLeft;
    JButton btnRight;

    public FrameMy(){
        ButtonListener btnUplistener = new ButtonListener();

        setTitle("Перемещение метки"); // заголовок фрейма
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screens = kit.getScreenSize();
        int w,h;
        w = screens.width;
        h = screens.height;

        setSize(w/2,h/2); //Устанавливает размер фрейма в половину размера экрана
        setLocation(w/4, h/4);  // Устанавливает положение окна

        Image img = Toolkit.getDefaultToolkit().createImage(getClass().getResource("test.jpg"));
        setIconImage(img);

        createGUI();
        // Добавление слушателей
        btnUp.addActionListener(btnUplistener);
//        btnDown.addActionListener(btnDownlistener);
//        btnLeft.addActionListener(btnLeftlistener);
//        btnRight.addActionListener(btnRightlistener);
    }

    private void createGUI() {
        pnl1 = new JPanel();
        pnl1.setLayout(new FlowLayout()); //компоненты располагаются в ряд
        pnl2 = new JPanel();
        pnl2.setLayout(new FlowLayout()); //компоненты располагаются в ряд

        btnUp = new JButton("Вверх");
        btnDown = new JButton("Вниз");
        btnLeft = new JButton("Влево");
        btnRight = new JButton("Вправо");

        ImageIcon point = new ImageIcon("img_7741.png");
        JLabel image = new JLabel();
        image.setIcon(point);

        pnl1.add(btnUp);
        pnl1.add(btnDown);
        pnl1.add(btnLeft);
        pnl1.add(btnRight);
        pnl2.add(new JLabel(point));


        // Добавляем панели на фрейм
        setLayout(new GridLayout(2, 1));
        getContentPane().add(pnl1);
        getContentPane().add(pnl2);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("test");
        }
    }
}
