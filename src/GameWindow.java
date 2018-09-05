
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GameWindow
{
    JFrame window;
    Container Con;
    JPanel Title, Start, MaintextPanel, ChoicePanel, PlayerStats, PicturePanel;
    JLabel TitleName,  PictureLabel;
    Font TitleFont = new Font("Times New Roman", Font.PLAIN,90);
    Font Default = new Font("Times New Roman", Font.PLAIN,27);
    ImageIcon image;
    JButton startButton, choice1, choice2;
    private JTextArea MainTextArea;
    TitleHandle TtHandeler = new TitleHandle();
    String Scenes;
    ChoiceHandler choiceHandler = new ChoiceHandler();

    boolean Getmoney;
    boolean maymoney;
    String ImageName;

    public static void main(String[] args)
    {
        new GameWindow();
    }

    public GameWindow()
    {
        window = new JFrame();
        window.setSize(900,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        Con = window.getContentPane();

        Title = new JPanel();
        Title.setBounds(100,100,600,150);
        Title.setBackground(Color.black);
        TitleName = new JLabel("Fractale");
        TitleName.setForeground(Color.white);
        TitleName.setFont(TitleFont);

        Start = new JPanel();
        Start.setBounds(300,400,200,100);
        Start.setBackground(Color.BLACK);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(Default);
        startButton.addActionListener(TtHandeler);
        startButton.setFocusPainted(false);

        Title.add(TitleName);
        Start.add(startButton);
        Con.add(Title);
        Con.add(Start);

        playSound();
        window.setVisible(true);

    }

    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("res/idk (1).wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void GameScreen()
    {
        Title.setVisible(false);
        Start.setVisible(false);

        MaintextPanel = new JPanel();
        MaintextPanel.setBounds(10,90,550,350);
        MaintextPanel.setBackground(Color.black);
        Con.add(MaintextPanel);

        MainTextArea = new JTextArea();
        MainTextArea.setBounds(10,90,550,350);
        MainTextArea.setBackground(Color.black);
        MainTextArea.setForeground(Color.white);
        MainTextArea.setFont(Default);
        MainTextArea.setLineWrap(true);
        MainTextArea.setEditable(false);
        MaintextPanel.add(MainTextArea);

        PicturePanel = new JPanel();
        PicturePanel.setBounds(550,150,300,300);
        PicturePanel.setBackground(Color.black);
        Con.add(PicturePanel);

        PictureLabel = new JLabel();

        image = new ImageIcon("res/Images/ID.png");

        PictureLabel.setIcon(image);
        PicturePanel.add(PictureLabel);

        ChoicePanel = new JPanel();
        ChoicePanel.setBounds(250,450,300,150);
        ChoicePanel.setBackground(Color.black);
        ChoicePanel.setLayout(new GridLayout(2,1));
        Con.add(ChoicePanel);

        choice1 = new JButton();
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(Default);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("1");
        ChoicePanel.add(choice1);

        choice2 = new JButton();
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(Default);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("2");
        ChoicePanel.add(choice2);

        PlayerStats = new JPanel();
        PlayerStats.setBounds(100,17,600,50);
        PlayerStats.setBackground(Color.black);
        PlayerStats.setLayout(new GridLayout(1,4));
        Con.add(PlayerStats);

        Scene1_1();

    }
    public void Scene1_1()
    {
        Scenes = "1_1";
        choice1.setText("Next");
        MainTextArea.setText("Your vision flashes all white before it returns.\nThe eye scanner makes another run across your \npupils before you hear a quiet chime come from \nyour AsteRisk brand check-in module. \nYour credentials fill up onto the screen.\n");
    }
    public void Scene1_2()
    {
        image = new ImageIcon("res/Images/Mom2.png");
        PictureLabel.setIcon(image);
        Scenes = "1_2";
        MainTextArea.setText("“Are you sure you’ll be alright sweetie?”\n" +
                "“I’ll be fine Mom” You turn to reassure your\n Mom and see your Dad standing next to her,\n arms crossed and with a worried expression.\n “And don’t you worry too, Dad.  I passed\n training with flying colors. And besides,\n asteroid mining will be an adventure.”\n");
    }
    public void Scene1_3()
    {
        Scenes = "1_3";
        MainTextArea.setText("Your parents trade glances and then sigh.\n “We’ll just... miss you.” Your Dad gives you a\n hug. \n" +
                "“Yeah Dad, I’ll be fine.” Your voice is muffled\n by your dad’s sweater.\n" +
                "“James, we put together a little something\n for you.” Your Dad hands you a thick manila envelope. \n" +
                "You rifle through the contents to see a big\n stack of credits. You look up at your Dad in\n awe.\n" +
                "“Yeah, that’s about 30,000 credits. Use it\n well, son.” Your dad pats you on the back.");
    }
    public void Scene1_4()
    {
        Scenes = "1_4";
        MainTextArea.setText("“Dad...,” You look at what was likely a year’s\n" +
                " worth of credits. “Where did you get all of \n" +
                "this?”\n" +
                "“We took it out of the value of the house” \n" +
                "your mom replies. “Trust us, it’s fine. We \n" +
                "want you to have this.” You stare at the thin \n" +
                "wooden interior of the modest house you \n" +
                "grew up in. You know that if you accept the \n" +
                "credits, this house may be gone forever.\n" +
                "\n" +
                "\n");
        choice1.setText("Accept Money");
        choice2.setText("Decline Money");

    }
    public void Scene1_5_a()
    {
        Scenes = "1_5_a";
        MainTextArea.setText("“Thank you both. I’ll use it well. Love you \n" +
                "both.” You head out with the envelope safely \n" +
                "tucked away.\n" +
                "\n");
        choice1.setText("Next");
        choice2.setText("");
        Getmoney = true;

    }
    public void Scene1_5_b()
    {
        Scenes = "1_5_b";
        MainTextArea.setText("“Thanks, really. But it’s fine. The company will\n" +
                " provide all my needs while I’m out mining. \n" +
                "Keep the money, guys.” You smile, hand the \n" +
                "envelope back to your parents and head out \n" +
                "the door before they can offer again.\n" +
                "\n");
        choice1.setText("Go for a walk");
        choice2.setText("");
        Getmoney = false;

    }
    public void Scene2_1()
    {
        image = new ImageIcon("res/Images/MayChild2.png");
        PictureLabel.setIcon(image);
        Scenes = "2_1";
        MainTextArea.setText("You walk out into the empty streets. From\n" +
                "\n" +
                " behind you feel someone bump into you\n" +
                " \n" +
                "and the sensation of your wallet being\n" +
                "\n" +
                " relieved from your pocket. You whirl \n" +
                "\n" +
                "around and grab the thief by the arm to\n" +
                "\n" +
                " see… a little girl.\n" +
                "\n");
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene2_2()
    {
        Scenes = "2_2";
        MainTextArea.setText("She looks to be around nine. Dark brown\n" +
                "\n" +
                " hair, thin, and emerald green eyes.\n" +
                "\n" +
                " Scared, emerald green eyes. You turn to\n" +
                "\n" +
                " see if anyone is nearby. No one. You \n" +
                "\n" +
                "recall the police station down the road \n" +
                "\n" +
                "and then you hear her stomach growl.\n" +
                "\n");
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene2_3()
    {
        Scenes = "2_3";
        MainTextArea.setText("Do you let her go or buy her some food?\n" );
        choice1.setText("Buy her food");
        choice2.setText("Call cops\n");
    }
    public void Scene2_4_a()
    {
        Scenes = "2_4_a";
        MainTextArea.setText("You crouch down until you’re eye level\n" +
                " with her. “Hey, don’t cry. I’m not mad. But\n" +
                " you shouldn’t go around stealing other\n" +
                " people’s things, yeah?” She continues to\n" +
                " look frightened. “Hey, what do you say\n" +
                " you hand me back my wallet and I treat\n" +
                " you to some food. You’re hungry right?”\n" );
        choice1.setText("Next");
        choice2.setText("");
        maymoney = true;
    }
    public void Scene2_4_a_2()
    {
        Scenes = "2_4_a_2";
        MainTextArea.setText("Slowly she nods. And you let go of her\n" +
                " arm. She doesn’t run. “I’m James, what’s\n" +
                " your name?”\n" +
                "“May” she replies. You smile and take\n" +
                " May to a diner down the street. Two\n" +
                " burgers and two milkshakes later, you\n" +
                " get her to promise to not steal again, and\n" +
                " say goodbyes.\n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene2_4_b()
    {
        Scenes = "2_4_b";
        MainTextArea.setText("Hungry or not, stealing is wrong. Perhaps \n" +
                "she’ll learn from consequences. You drag \n" +
                "the little pickpocket down to the \n" +
                "authorities office. She cries the entire way \n" +
                "there.\n" );
        choice1.setText("Next");
        choice2.setText("");
        maymoney = false;
    }
    public void Scene6_1()
    {
        image = new ImageIcon("res/Images/Plant3.png");
        PictureLabel.setIcon(image);
        Scenes = "6_1";
        MainTextArea.setText("You stand in line to get onto the\n" +
                " spaceships. There was a gentle breeze \n" +
                "and perfect weather at the moment. You \n" +
                "know that you’re going to miss this while \n" +
                "mining.\n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene6_2()
    {

        Scenes = "6_2";
        MainTextArea.setText("You were going to miss a lot…\n" +
                "\n" +
                "“Next!” That was you now. A worke directs you to a coffin-shaped machine Were the designers of this place just that\n" +
                " morbid?\n" +
                "A bit creeped out, you step in. The person\n" +
                " who directed you buckles you up, and hits a \n" +
                "button inside the machine. The lid closes\n" +
                " and words pop up in front of you.\n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene6_3()
    {

        Scenes = "6_3";
        MainTextArea.setText("COMMENCING CRYOSTASIS\n" +
                "\n" +
                "You close your eyes and take a breath…\n" +
                "And you exhale, suddenly feeling\n" +
                " extremely cold. But why aren’t you in\n" +
                " cryostasis?\n" +
                "You open your eyes.\n" +
                "‘Welcome to the Asteroid Belt. It has been\n" +
                " 5 years’ is displayed on a screen in front of you.\n" +
                "“Oh,” You say. “That was quick.”\n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene6_4()
    {

        Scenes = "6_4";
        MainTextArea.setText("You mine away at the asteroid that you \n" +
                "landed on, packing the Dylithium you\n" +
                " mined, before going back into cryostasis.\n" +
                "\n" +
                "You land once again on Earth. But this \n" +
                "time when the doors open, the world \n" +
                "outside is very different, with new \n" +
                "buildings and people...\n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene10()
    {
        image = new ImageIcon("res/Images/MomOld2.png");
        PictureLabel.setIcon(image);
        Scenes = "10";
        MainTextArea.setText("You knew that the only reason your\n" +
                " parents still had a house to live in was\n" +
                " because of your choice to decline their \n" +
                "offer for money. You were happy with that\n" +
                " decision, considering that the mining job \n" +
                "paid enough\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene26_1()
    {
        image = new ImageIcon("res/Images/image0.png");
        PictureLabel.setIcon(image);
        Scenes = "26_1";
        MainTextArea.setText("You feel like you’ve been hit by a pile of \n" +
                "bricks. You shake your head in disbelief.\n" +
                " No, this couldn’t be happening. They still\n" +
                " had such a long life ahead of them. They\n" +
                " should still be alive and happy!\n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene26_2()
    {
        Scenes = "26_2";
        MainTextArea.setText("You begin the trek to visit their graves, \n" +
                "memories from your childhood and from \n" +
                "your adult life coming along the way.\n" +
                "\n" +
                "You finally get to their graves when tears\n" +
                " start to fall. You sit in front of their graves. “I didn’t think you’d leave so \n" +
                "soon,” Another sob. “I’ll miss you guys.”\n" +
                "\n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene12_1()
    {
        image = new ImageIcon("res/Images/HMay.png");
        PictureLabel.setIcon(image);
        Scenes = "12_1";
        MainTextArea.setText("You are walking on a trail next to a high\n" +
                " school. It was rush hour, the worst time \n" +
                "to be out. Many high school students \n" +
                "flood out of the gates as you push \n" +
                "through the crowd.\n" +
                "\n" +
                "“Hey!” You hear a call but think it’s for \n" +
                "someone else and keep walking. “Hey, \n" +
                "mister!” You feel a pat on your shoulder. \n" +
                "Quickly realizing that call was actually for \n" +
                "you, you turn around. \n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene12_2()
    {

        Scenes = "12_2";
        MainTextArea.setText("\n" +
                "“Wow, you look like you haven’t aged a \n" +
                "day.” She said with a grin. \n" +
                "\n" +
                "Then you remember. It was the \n" +
                "pickpocket from ten years ago. “May! \n" +
                "Glad to see you’re not stealing wallets \n" +
                "anymore. You’re in high school now?”\n" +
                "She nods excitedly. “Yup. A senior. I’m \n" +
                "about to graduate soon. Can’t wait!”\n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene13_1()
    {
        image = new ImageIcon("res/Images/Dmay.png");
        PictureLabel.setIcon(image);
        Scenes = "13_1";
        MainTextArea.setText("You go out for a walk. It’s been some time\n" +
                " since you’ve done this, apparently ten\n" +
                " years. \n" +
                "You walk past an empty alleyway during \n" +
                "your walk and into a dead end. You’re \n" +
                "about to turn around, but someone \n" +
                "tackles you and pins you on the dead \n" +
                "end.\n" +
                "“Give me your money and I won’t hurt \n" +
                "you!” You hear a familiar voice say quietly\n" +
                " but firmly. You turn your head, first \n" +
                "seeing a knife in the person’s hand and \n" +
                "then...\n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }
    public void Scene13_2()
    {

        Scenes = "13_2";
        MainTextArea.setText("Just as you recognize her, unfortunately, \n" +
                "she recognizes you. “It’s you! You’re the \n" +
                "one that put me through all this shit!”\n" +
                "\n" );
        choice1.setText("Next");
        choice2.setText("");
    }

    public void Scene0()
    {

        Scenes = "0";
        MainTextArea.setText("To Be Continue" );
        choice1.setText("Back to start");
        choice2.setText("");
    }

    public class TitleHandle implements ActionListener{

        public void actionPerformed(ActionEvent event)
        {
            GameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String PlayerCommand = event.getActionCommand();
            switch (Scenes)
            {
                case "1_1":
                    switch (PlayerCommand)
                    {
                        case "1":Scene1_2(); break;
                        case "2":Scene1_2(); break;
                    }
                    break;
                case "1_2":
                    switch (PlayerCommand)
                    {
                        case "1":Scene1_3(); break;
                        case "2":Scene1_3(); break;
                    }
                    break;
                case "1_3":
                    switch (PlayerCommand)
                    {
                        case "1":Scene1_4(); break;
                        case "2":Scene1_4(); break;
                    }
                    break;
                case "1_4":
                    switch (PlayerCommand)
                    {
                        case "1":Scene1_5_a(); break;
                        case "2":Scene1_5_b(); break;
                    }
                    break;
                case "1_5_a":
                    switch (PlayerCommand)
                    {
                        case "1":Scene2_1(); break;
                        case "2":Scene2_1(); break;
                    }
                    break;
                case "1_5_b":
                    switch (PlayerCommand)
                    {
                        case "1":Scene2_1(); break;
                        case "2":Scene2_1(); break;
                    }
                    break;
                case "2_1":
                    switch (PlayerCommand)
                    {
                        case "1":Scene2_2(); break;
                        case "2":Scene2_2(); break;
                    }
                    break;
                case "2_2":
                    switch (PlayerCommand)
                    {
                        case "1":Scene2_3(); break;
                        case "2":Scene2_3(); break;
                    }
                    break;
                case "2_3":
                    switch (PlayerCommand)
                    {
                        case "1":Scene2_4_a(); break;
                        case "2":Scene2_4_b(); break;
                    }
                    break;
                case "2_4_a":
                    switch (PlayerCommand)
                    {
                        case "1":Scene2_4_a_2(); break;
                        case "2":Scene2_4_a_2(); break;
                    }
                    break;
                case "2_4_a_2":
                    switch (PlayerCommand)
                    {
                        case "1":Scene6_1(); break;
                        case "2":Scene6_1(); break;
                    }
                    break;
                case "2_4_b":
                    switch (PlayerCommand)
                    {
                        case "1":Scene6_1(); break;
                        case "2":Scene6_1(); break;
                    }
                    break;
                case "6_1":
                    switch (PlayerCommand)
                    {
                        case "1":Scene6_2(); break;
                        case "2":Scene6_2(); break;
                    }
                    break;
                case "6_2":
                    switch (PlayerCommand)
                    {
                        case "1":Scene6_3(); break;
                        case "2":Scene6_3(); break;
                    }
                    break;
                case "6_3":
                    switch (PlayerCommand)
                    {
                        case "1":Scene6_4(); break;
                        case "2":Scene6_4(); break;
                    }
                    break;
                case "6_4":
                    switch (PlayerCommand)
                    {
                        case "1":
                            if (Getmoney)
                            {
                                Scene26_1();
                                break;}
                            else{
                                Scene10();
                                break;}
                        case "2":
                            if (Getmoney)
                            {
                                Scene26_1();
                                break;}
                            else{
                                Scene10();
                                break;}
                    }
                    break;

                case "26_1":
                    switch (PlayerCommand)
                    {
                        case "1":Scene26_2(); break;
                        case "2":Scene26_2(); break;
                    }
                    break;
                case "26_2":
                    switch (PlayerCommand)
                    {
                        case "1":
                            if (maymoney)
                            {
                                Scene12_1();
                                break;}
                            else{
                                Scene13_1();
                                break;}
                        case "2":
                            if (maymoney)
                            {
                                Scene12_1();
                                break;}
                            else{
                                Scene13_1();
                                break;}
                    }
                    break;
                case "10":
                    switch (PlayerCommand)
                    {
                        case "1":
                            if (maymoney)
                            {
                                Scene12_1();
                                break;}
                            else{
                                Scene13_1();
                                break;}
                        case "2":
                            if (maymoney)
                            {
                                Scene12_1();
                                break;}
                            else{
                                Scene13_1();
                                break;}
                    }
                    break;
                case "12_1":
                    switch (PlayerCommand)
                    {
                        case "1":Scene12_2(); break;
                        case "2":Scene12_2(); break;
                    }
                    break;
                case "13_1":
                    switch (PlayerCommand)
                    {
                        case "1":Scene13_2(); break;
                        case "2":Scene13_2(); break;
                    }
                    break;
                case "13_2":
                    switch (PlayerCommand)
                    {
                        case "1":Scene0(); break;
                        case "2":Scene0(); break;
                    }
                    break;
                case "12_2":
                    switch (PlayerCommand)
                    {
                        case "1":Scene0(); break;
                        case "2":Scene0(); break;
                    }
                case "0":
                    switch (PlayerCommand)
                    {
                        case "1":Scene1_1(); break;
                        case "2":Scene1_1(); break;
                    }
            }
        }
    }


}
