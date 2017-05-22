import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UI extends javax.swing.JFrame {
    
    private Thread thread=new Thread();   // create thread object
   
    private int tSpeed=2000;         // controls the speed of dynamicaly changing buttons
    private final ImageIcon logo=new ImageIcon("app files\\image\\logo.png");  // logo of the frame
    private final Color colors[]={Color.GREEN,Color.BLACK,Color.RED,Color.BLUE,Color.ORANGE,Color.MAGENTA,Color.cyan}; // arrayof 7 colors
    
    public UI() {
        
        initComponents();
      
         setupUI(); 
         
    }   //  constructor 
    

   private void setupUI(){   // setup's the frame and other componets  
       
        this.add(startPanel);          // adds start panal to the frame
      
        kutirPanel.setVisible(false);
        startPanel.setVisible(true);
        fidelMainPanel.setVisible(false);
        helpPanel.setVisible(false);
        aboutPanel.setVisible(false);
        punctuationPanel.setVisible(false);
        ButtonGroup bg=new ButtonGroup();  // create button group 
        bg.add(oneSecond);    // add the checkBox to the group button
        bg.add(twoSecond);    // add the checkBox to the group button
        bg.add(thereSecond);  // add the checkBox to the group button
        
        GeezText();          // starts loading ge'ez text 
         
      setGeezButtonText(); // start the method witch sets button fidel text 
    
    }
    
   private void GeezText(){    

    String text=("ልጆች የግዕዝ ፊደላትን አብረን እንማር");
         
        char [] fidel=text.toCharArray();
             
   Thread t = new Thread() {
            
            @Override
            
      public void run() {  // override the run() method to specify the running behavior
                   
             for (char character:fidel) {
                    
                    firstLable.setText( firstLable.getText() . concat ( (String.valueOf(character) ) ) );
                  
                  try {
                       sleep(400);  // milliseconds
                      } 
                  catch (InterruptedException ex) { System.out.println("Interupted exception has occured");} 
                  
             
             }
                 
      }   // end of the run method
      };  // end of thread object Definiation
       
            t.start();  // call back run() method

} 
    
   private void setGeezButtonText(){  // set's button text to GE'EZ Fidel  
    
          jButton1.setText("\u1200");
          jButton2.setText("\u1208");
          jButton3.setText("\u1210");
          jButton4.setText("\u1218");
          jButton5.setText("\u1220");
          jButton6.setText("\u1228");
          jButton7.setText("\u1230");
          jButton8.setText("\u12D8");
          jButton9.setText("\u1238");
          jButton10.setText("\u1240"); 
          jButton11.setText("\u1260"); 
          jButton12.setText("\u1320");
          jButton13.setText("\u1270");
          jButton14.setText("\u1278");
          jButton15.setText("\u1280");
          jButton16.setText("\u1290");
          jButton17.setText("\u1298");
          jButton18.setText("\u12A0");
          jButton19.setText("\u12A8");
          jButton20.setText("\u1348");
          jButton21.setText("\u12C8");
          jButtons.setText("\u12D0");
          jButton23.setText("\u1350");
          jButton24.setText("\u12E8");
          jButton25.setText("\u12F0");
          jButton26.setText("\u1340");
          jButton27.setText("\u1300");
          jButton28.setText("\u1308");
          
          
    }

   private void showFidels(String [] fidels,JButton ClickedButton){
             
  
        JButton []fidelButtons={btn0,btn1,btn2,btn3,btn4,btn5,btn6}; //  array of buttons that display fidels 
             
        if(thread.isAlive()){ // checks whather the thread is already runninig and if it is ruuning it stops it
        
            thread.stop();
            
        }
        
           thread = new Thread() {           
            
            @Override

        public void run() {  // override the run() method to specify the running behavior
       
                    
                    for(JButton b:fidelButtons){
                    b.setText(" ");
                    }
                   
                  
                for (int i = 0; i < fidels.length; i++) {
                   
                      ClickedButton.setText(fidels[i]);
                      ClickedButton.setBackground(colors[i]);
                      fidelButtons[i].setText(fidels[i]);
                      fidelButtons[i].setForeground(colors[i]);
                      
                      SoundNarrator.playFidel(fidelButtons[i].getText()); //call the static method playFidel from SoundNarrator class 
                     
                    try {
                      
                      Thread.sleep(tSpeed); // milliseconds
                    
                    } catch (InterruptedException ex) {
                        
                        System.out.println("Interupted exception has occured");} 
 
                }
                    setGeezButtonText();
         }   
           };
            thread.start();
 }
   private void showQutir(JButton ClickedButton){
   
        JButton qutirButton[]={b0,b1,b2,b3,b4,b5,b6,b7,b8,b9};
         Color colors[]={Color.GREEN,Color.BLACK,Color.BLUE,Color.RED,Color.ORANGE,Color.pink,Color.cyan,Color.MAGENTA,Color.green,Color.gray};
        String qutir[]= new String [10];
                    
                    qutir [0]="";
                    qutir [1]="\u1369"; 
	            qutir [2]="\u136A";
	            qutir [3]="\u136B";
	            qutir [4]="\u136C";
	            qutir [5]="\u136D";
	            qutir [6]="\u136E";
	            qutir [7]="\u136F";
	            qutir [8]="\u1370";
	            qutir [9]="\u1371";
	
                           
        if(thread.isAlive()){ // checks whather the thread is already runninig and if it is ruuning it stops it
        
            thread.stop();
            
        }
        
                 
        thread = new Thread() {
            @Override
                        
            public void run() {  // override the run() to specify the running behavior
               
              for(JButton b:qutirButton ){
              b.setText("");
              }
              
               for (int i = 0; i <qutir.length;i++) {
                    
                    qutirButton[i].setText(ClickedButton.getText().concat(qutir[i]));
                    qutirButton[i].setForeground(colors[i]);
                    char [] q=qutirButton[i].getText().toCharArray();
                     for(char c:q){
                    
                         SoundNarrator.playFidel(Character.toString(c));
                     
                    try{
                     Thread.sleep(1500);
                    }catch(InterruptedException ie){}
                    
                     }
                    
                try {
                        sleep(tSpeed); // milliseconds
                    } catch (InterruptedException ex) { System.out.println("Interupted exception has occured");} 
                } setGeezButtonText();
            } // end of the run method
        };
      
            thread.start();  // call back run()      
        
   
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        helpPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        aboutPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        kutirPanel = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        showQutirPanel = new javax.swing.JPanel();
        b2 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b0 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        startPanel = new javax.swing.JPanel();
        kutirchoice = new javax.swing.JButton();
        firstLable = new javax.swing.JLabel();
        fidelChooice = new javax.swing.JButton();
        punctuationcoice = new javax.swing.JButton();
        bgImage = new javax.swing.JLabel();
        fidelMainPanel = new javax.swing.JPanel();
        fidelsPanel = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButtons = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        fidelShowPanel = new javax.swing.JPanel();
        btn4 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        bgimage = new javax.swing.JLabel();
        bgimage1 = new javax.swing.JLabel();
        punctuationPanel = new javax.swing.JPanel();
        jButton34 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        textFidels = new javax.swing.JTextField();
        exampleLabel = new javax.swing.JLabel();
        bgimage3 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        closeItem = new javax.swing.JMenuItem();
        page = new javax.swing.JMenu();
        fidelPage = new javax.swing.JMenuItem();
        kutirPage = new javax.swing.JMenuItem();
        puncPage = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        speed = new javax.swing.JMenu();
        oneSecond = new javax.swing.JCheckBoxMenuItem();
        twoSecond = new javax.swing.JCheckBoxMenuItem();
        thereSecond = new javax.swing.JCheckBoxMenuItem();
        kalManbebia = new javax.swing.JMenu();
        help = new javax.swing.JMenu();
        aboutApp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u130D\u12D5\u12DD ለልጆች");
        setIconImage( logo.getImage());
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Nyala", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 0));
        jLabel1.setText("                 አጠቃቀም");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Nyala", 0, 17)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("፩ በመጀመሪያ ከሚመጡት አማራጮች በመምረጥ አንዲሁም ገፅ\n  የሚለው ማስመረጫ በመጠቀም ወደ እሚፈልጉት ገፅ መሄድ\n  ይችላሉ  \n\n፪ የግዕዝ ፊደሎችን፣ቁጥሮችን የያዙትን በተኖች በመጫን የፊደሉን\n ተከታዬች ከነድምፃቸው መስማት ይቻላል። \n\n፫ ማስተካከያ ከዛም ፍጥነት የሚለውን በመጫን የፊደላትን እንዲሁም\n የቁጥሮችን የመቀያየር ፍጥነት መጨመር እንዲሁም መቀነስ ይቻላል።\n\n፬ ፊደል ማንበቢያ የሚለውን በመጫን ከዛም በሚመጣው ሰሌዳ ላይ\n  እንዲነበብ የሚፈልጉትን ቃል በማስገባት አንብብ የሚለውን በመጫን \n  የፊደሎቹን ድምፅ መስማት ይቻላል።\n");
        jTextArea1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout helpPanelLayout = new javax.swing.GroupLayout(helpPanel);
        helpPanel.setLayout(helpPanelLayout);
        helpPanelLayout.setHorizontalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        helpPanelLayout.setVerticalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Nyala", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
        jLabel2.setText("  ስለ ግዕዝ ለልጆች ፕሮግራም ");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(0, 51, 51));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Nyala", 0, 17)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jTextArea2.setText("   \n    ይህ  ፕሮግራም በ  - ዳዊት እሸቴ\n                          - አቤል ዘውዱ\n                          - ዬናስ ታየ\n  የ ባህር ዳር ዩኒቨርሲቲ  ሁለተኟ አመት የሶፍትዌር \n  ኢንጂነሪግ ተማሪዎች በ 2009 ዓ.ም ተሰራ");
        jTextArea2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout aboutPanelLayout = new javax.swing.GroupLayout(aboutPanel);
        aboutPanel.setLayout(aboutPanelLayout);
        aboutPanelLayout.setHorizontalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        aboutPanelLayout.setVerticalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        kutirPanel.setBackground(new java.awt.Color(88, 188, 103));
        kutirPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ቁጥር", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nyala", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        kutirPanel.setForeground(new java.awt.Color(255, 255, 255));
        kutirPanel.setLayout(null);

        jButton29.setBackground(new java.awt.Color(204, 255, 255));
        jButton29.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton29.setForeground(new java.awt.Color(102, 102, 0));
        jButton29.setText("፶");
        jButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton29);
        jButton29.setBounds(215, 200, 105, 105);

        jButton30.setBackground(new java.awt.Color(204, 255, 255));
        jButton30.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton30.setForeground(new java.awt.Color(102, 102, 0));
        jButton30.setText("፲");
        jButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton30);
        jButton30.setBounds(330, 59, 105, 105);

        jButton31.setBackground(new java.awt.Color(204, 255, 255));
        jButton31.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton31.setForeground(new java.awt.Color(102, 102, 0));
        jButton31.setText("፴");
        jButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton31);
        jButton31.setBounds(560, 59, 105, 105);

        jButton32.setBackground(new java.awt.Color(204, 255, 255));
        jButton32.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton32.setForeground(new java.awt.Color(102, 102, 0));
        jButton32.setText("፳");
        jButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton32);
        jButton32.setBounds(445, 59, 105, 105);

        jButton33.setBackground(new java.awt.Color(204, 255, 255));
        jButton33.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton33.setForeground(new java.awt.Color(102, 102, 0));
        jButton33.setText("፹");
        jButton33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton33);
        jButton33.setBounds(560, 200, 105, 105);

        jButton35.setBackground(new java.awt.Color(204, 255, 255));
        jButton35.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton35.setForeground(new java.awt.Color(102, 102, 0));
        jButton35.setText("፸");
        jButton35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton35);
        jButton35.setBounds(445, 200, 105, 105);

        jButton36.setBackground(new java.awt.Color(204, 255, 255));
        jButton36.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton36.setForeground(new java.awt.Color(102, 102, 0));
        jButton36.setText("፩");
        jButton36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton36);
        jButton36.setBounds(215, 59, 105, 105);

        jButton37.setBackground(new java.awt.Color(204, 255, 255));
        jButton37.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton37.setForeground(new java.awt.Color(102, 102, 0));
        jButton37.setText("፷");
        jButton37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton37);
        jButton37.setBounds(330, 200, 105, 105);

        jButton38.setBackground(new java.awt.Color(204, 255, 255));
        jButton38.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton38.setForeground(new java.awt.Color(102, 102, 0));
        jButton38.setText("፺");
        jButton38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton38);
        jButton38.setBounds(675, 200, 105, 105);

        jButton39.setBackground(new java.awt.Color(204, 255, 255));
        jButton39.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton39.setForeground(new java.awt.Color(102, 102, 0));
        jButton39.setText("፵");
        jButton39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton39);
        jButton39.setBounds(675, 59, 105, 105);

        showQutirPanel.setBackground(new java.awt.Color(255, 255, 255));
        showQutirPanel.setForeground(new java.awt.Color(255, 255, 255));

        b2.setBackground(new java.awt.Color(255, 255, 255));
        b2.setFont(new java.awt.Font("Nyala", 1, 40)); // NOI18N
        b2.setAlignmentY(0.0F);
        b2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b2.setPreferredSize(new java.awt.Dimension(33, 12));
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b6.setBackground(new java.awt.Color(255, 255, 255));
        b6.setFont(new java.awt.Font("Nyala", 1, 40)); // NOI18N
        b6.setAlignmentY(0.0F);
        b6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b6.setPreferredSize(new java.awt.Dimension(33, 12));
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b9.setBackground(new java.awt.Color(255, 255, 255));
        b9.setFont(new java.awt.Font("Nyala", 1, 40)); // NOI18N
        b9.setAlignmentY(0.0F);
        b9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b9.setPreferredSize(new java.awt.Dimension(33, 12));
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b1.setFont(new java.awt.Font("Nyala", 1, 40)); // NOI18N
        b1.setAlignmentY(0.0F);
        b1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b1.setPreferredSize(new java.awt.Dimension(33, 12));
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b3.setBackground(new java.awt.Color(255, 255, 255));
        b3.setFont(new java.awt.Font("Nyala", 1, 40)); // NOI18N
        b3.setAlignmentY(0.0F);
        b3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b3.setPreferredSize(new java.awt.Dimension(33, 12));
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b8.setBackground(new java.awt.Color(255, 255, 255));
        b8.setFont(new java.awt.Font("Nyala", 1, 40)); // NOI18N
        b8.setAlignmentY(0.0F);
        b8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b8.setPreferredSize(new java.awt.Dimension(33, 12));
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b4.setBackground(new java.awt.Color(255, 255, 255));
        b4.setFont(new java.awt.Font("Nyala", 1, 40)); // NOI18N
        b4.setAlignmentY(0.0F);
        b4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b4.setPreferredSize(new java.awt.Dimension(33, 12));
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b0.setBackground(new java.awt.Color(255, 255, 255));
        b0.setFont(new java.awt.Font("Nyala", 1, 40)); // NOI18N
        b0.setAlignmentY(0.0F);
        b0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b0.setPreferredSize(new java.awt.Dimension(33, 12));
        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0ActionPerformed(evt);
            }
        });

        b7.setBackground(new java.awt.Color(255, 255, 255));
        b7.setFont(new java.awt.Font("Nyala", 1, 40)); // NOI18N
        b7.setAlignmentY(0.0F);
        b7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b7.setPreferredSize(new java.awt.Dimension(33, 12));
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b5.setBackground(new java.awt.Color(255, 255, 255));
        b5.setFont(new java.awt.Font("Nyala", 1, 40)); // NOI18N
        b5.setAlignmentY(0.0F);
        b5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b5.setPreferredSize(new java.awt.Dimension(33, 12));
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showQutirPanelLayout = new javax.swing.GroupLayout(showQutirPanel);
        showQutirPanel.setLayout(showQutirPanelLayout);
        showQutirPanelLayout.setHorizontalGroup(
            showQutirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showQutirPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b0, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        showQutirPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9});

        showQutirPanelLayout.setVerticalGroup(
            showQutirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showQutirPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(showQutirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(showQutirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(b1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        showQutirPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9});

        kutirPanel.add(showQutirPanel);
        showQutirPanel.setBounds(18, 492, 996, 127);

        jButton44.setBackground(new java.awt.Color(204, 255, 255));
        jButton44.setFont(new java.awt.Font("Nyala", 0, 60)); // NOI18N
        jButton44.setForeground(new java.awt.Color(102, 102, 0));
        jButton44.setText("፻");
        jButton44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        kutirPanel.add(jButton44);
        jButton44.setBounds(445, 323, 105, 94);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/306942.jpg"))); // NOI18N
        kutirPanel.add(jLabel4);
        jLabel4.setBounds(0, -520, 1030, 1200);

        startPanel.setBackground(new java.awt.Color(88, 188, 103));
        startPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startPanel.setPreferredSize(new java.awt.Dimension(948, 677));
        startPanel.setLayout(null);

        kutirchoice.setFont(new java.awt.Font("Nyala", 1, 36)); // NOI18N
        kutirchoice.setForeground(new java.awt.Color(153, 153, 0));
        kutirchoice.setText("ቁጥር");
        kutirchoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kutirchoiceActionPerformed(evt);
            }
        });
        startPanel.add(kutirchoice);
        kutirchoice.setBounds(20, 260, 210, 50);

        firstLable.setFont(new java.awt.Font("Nyala", 2, 48)); // NOI18N
        firstLable.setForeground(new java.awt.Color(255, 255, 255));
        startPanel.add(firstLable);
        firstLable.setBounds(270, 250, 652, 79);

        fidelChooice.setFont(new java.awt.Font("Nyala", 1, 36)); // NOI18N
        fidelChooice.setForeground(new java.awt.Color(153, 153, 0));
        fidelChooice.setText("ፊደል");
        fidelChooice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fidelChooiceActionPerformed(evt);
            }
        });
        startPanel.add(fidelChooice);
        fidelChooice.setBounds(20, 160, 210, 50);

        punctuationcoice.setFont(new java.awt.Font("Nyala", 1, 36)); // NOI18N
        punctuationcoice.setForeground(new java.awt.Color(153, 153, 0));
        punctuationcoice.setText("ስርዓተ-ነጥብ");
        punctuationcoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                punctuationcoiceActionPerformed(evt);
            }
        });
        startPanel.add(punctuationcoice);
        punctuationcoice.setBounds(20, 360, 210, 47);

        bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/306942.jpg"))); // NOI18N
        startPanel.add(bgImage);
        bgImage.setBounds(0, -540, 1030, 1240);

        fidelMainPanel.setBackground(new java.awt.Color(88, 188, 103));
        fidelMainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ፊደላት", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nyala", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        fidelMainPanel.setLayout(null);

        fidelsPanel.setBackground(new java.awt.Color(88, 188, 103));
        fidelsPanel.setFont(new java.awt.Font("Nyala", 1, 18)); // NOI18N
        fidelsPanel.setLayout(null);

        jButton17.setBackground(new java.awt.Color(204, 255, 255));
        jButton17.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton17.setForeground(new java.awt.Color(102, 102, 0));
        jButton17.setText("ኘ");
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton17);
        jButton17.setBounds(10, 217, 108, 85);

        jButton11.setBackground(new java.awt.Color(204, 255, 255));
        jButton11.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton11.setForeground(new java.awt.Color(102, 102, 0));
        jButton11.setText("በ");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton11);
        jButton11.setBounds(262, 114, 108, 85);

        jButton18.setBackground(new java.awt.Color(204, 255, 255));
        jButton18.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton18.setForeground(new java.awt.Color(102, 102, 0));
        jButton18.setText("አ");
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton18);
        jButton18.setBounds(136, 217, 108, 85);

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 0));
        jButton2.setText("ለ");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton2);
        jButton2.setBounds(136, 11, 108, 85);

        jButton15.setBackground(new java.awt.Color(204, 255, 255));
        jButton15.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton15.setForeground(new java.awt.Color(102, 102, 0));
        jButton15.setText("ኀ");
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton15);
        jButton15.setBounds(640, 114, 108, 85);

        jButton5.setBackground(new java.awt.Color(204, 255, 255));
        jButton5.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 102, 0));
        jButton5.setText("ሰ");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton5);
        jButton5.setBounds(511, 11, 108, 85);

        jButton25.setBackground(new java.awt.Color(204, 255, 255));
        jButton25.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton25.setForeground(new java.awt.Color(102, 102, 0));
        jButton25.setText("ደ");
        jButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton25);
        jButton25.setBounds(10, 320, 108, 85);

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 0));
        jButton3.setText("ሐ");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton3);
        jButton3.setBounds(262, 11, 105, 85);

        jButton19.setBackground(new java.awt.Color(204, 255, 255));
        jButton19.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton19.setForeground(new java.awt.Color(102, 102, 0));
        jButton19.setText("ከ");
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton19);
        jButton19.setBounds(262, 217, 108, 85);

        jButton28.setBackground(new java.awt.Color(204, 255, 255));
        jButton28.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton28.setForeground(new java.awt.Color(102, 102, 0));
        jButton28.setText("ገ");
        jButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton28);
        jButton28.setBounds(262, 320, 108, 85);

        jButton14.setBackground(new java.awt.Color(204, 255, 255));
        jButton14.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton14.setForeground(new java.awt.Color(102, 102, 0));
        jButton14.setText("ቸ");
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton14);
        jButton14.setBounds(514, 114, 108, 85);

        jButton13.setBackground(new java.awt.Color(204, 255, 255));
        jButton13.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton13.setForeground(new java.awt.Color(102, 102, 0));
        jButton13.setText("ተ");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton13);
        jButton13.setBounds(388, 114, 108, 85);

        jButton12.setBackground(new java.awt.Color(204, 255, 255));
        jButton12.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton12.setForeground(new java.awt.Color(102, 102, 0));
        jButton12.setText("ጠ");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton12);
        jButton12.setBounds(388, 320, 108, 85);

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 0));
        jButton1.setText("ሀ");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton1);
        jButton1.setBounds(10, 11, 108, 85);

        jButton10.setBackground(new java.awt.Color(204, 255, 255));
        jButton10.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton10.setForeground(new java.awt.Color(102, 102, 0));
        jButton10.setText("ቀ");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton10);
        jButton10.setBounds(136, 114, 108, 85);

        jButton7.setBackground(new java.awt.Color(204, 255, 255));
        jButton7.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton7.setForeground(new java.awt.Color(102, 102, 0));
        jButton7.setText("ሠ");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton7);
        jButton7.setBounds(763, 11, 111, 85);

        jButtons.setBackground(new java.awt.Color(204, 255, 255));
        jButtons.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButtons.setForeground(new java.awt.Color(102, 102, 0));
        jButtons.setText("ዐ");
        jButtons.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButtons);
        jButtons.setBounds(514, 217, 108, 85);

        jButton6.setBackground(new java.awt.Color(204, 255, 255));
        jButton6.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton6.setForeground(new java.awt.Color(102, 102, 0));
        jButton6.setText("ረ");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton6);
        jButton6.setBounds(637, 11, 108, 85);

        jButton16.setBackground(new java.awt.Color(204, 255, 255));
        jButton16.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton16.setForeground(new java.awt.Color(102, 102, 0));
        jButton16.setText("ነ");
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton16);
        jButton16.setBounds(766, 114, 108, 85);

        jButton20.setBackground(new java.awt.Color(204, 255, 255));
        jButton20.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton20.setForeground(new java.awt.Color(102, 102, 0));
        jButton20.setText("ፈ");
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton20);
        jButton20.setBounds(640, 320, 108, 85);

        jButton9.setBackground(new java.awt.Color(204, 255, 255));
        jButton9.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton9.setForeground(new java.awt.Color(102, 102, 0));
        jButton9.setText("ሸ");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton9);
        jButton9.setBounds(10, 114, 108, 85);

        jButton27.setBackground(new java.awt.Color(204, 255, 255));
        jButton27.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton27.setForeground(new java.awt.Color(102, 102, 0));
        jButton27.setText("ጀ");
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton27);
        jButton27.setBounds(136, 320, 108, 85);

        jButton8.setBackground(new java.awt.Color(204, 255, 255));
        jButton8.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton8.setForeground(new java.awt.Color(102, 102, 0));
        jButton8.setText("ዘ");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton8);
        jButton8.setBounds(640, 217, 108, 85);

        jButton26.setBackground(new java.awt.Color(204, 255, 255));
        jButton26.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton26.setForeground(new java.awt.Color(102, 102, 0));
        jButton26.setText("ፀ");
        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton26);
        jButton26.setBounds(514, 320, 108, 85);

        jButton23.setBackground(new java.awt.Color(204, 255, 255));
        jButton23.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton23.setForeground(new java.awt.Color(102, 102, 0));
        jButton23.setText("ፐ");
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton23);
        jButton23.setBounds(766, 320, 108, 85);

        jButton21.setBackground(new java.awt.Color(204, 255, 255));
        jButton21.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton21.setForeground(new java.awt.Color(102, 102, 0));
        jButton21.setText("ወ");
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton21);
        jButton21.setBounds(388, 217, 108, 85);

        jButton4.setBackground(new java.awt.Color(204, 255, 255));
        jButton4.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 102, 0));
        jButton4.setText("መ");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton4);
        jButton4.setBounds(385, 11, 108, 85);

        jButton24.setBackground(new java.awt.Color(204, 255, 255));
        jButton24.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        jButton24.setForeground(new java.awt.Color(102, 102, 0));
        jButton24.setText("የ");
        jButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        fidelsPanel.add(jButton24);
        jButton24.setBounds(766, 217, 108, 85);

        fidelShowPanel.setBackground(new java.awt.Color(255, 255, 255));
        fidelShowPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        btn4.setBackground(new java.awt.Color(255, 255, 255));
        btn4.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        btn4.setForeground(new java.awt.Color(102, 102, 0));
        btn4.setText(" ");
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn4.setPreferredSize(new java.awt.Dimension(65, 100));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(255, 255, 255));
        btn3.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        btn3.setForeground(new java.awt.Color(102, 102, 0));
        btn3.setText(" ");
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3.setPreferredSize(new java.awt.Dimension(65, 100));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn1.setBackground(new java.awt.Color(255, 255, 255));
        btn1.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        btn1.setForeground(new java.awt.Color(102, 102, 0));
        btn1.setText(" ");
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn1.setPreferredSize(new java.awt.Dimension(65, 100));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(255, 255, 255));
        btn5.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        btn5.setForeground(new java.awt.Color(102, 102, 0));
        btn5.setText(" ");
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn5.setPreferredSize(new java.awt.Dimension(65, 100));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(255, 255, 255));
        btn6.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        btn6.setForeground(new java.awt.Color(102, 102, 0));
        btn6.setText(" ");
        btn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn6.setPreferredSize(new java.awt.Dimension(65, 100));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(255, 255, 255));
        btn2.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        btn2.setForeground(new java.awt.Color(102, 102, 0));
        btn2.setText(" ");
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn2.setPreferredSize(new java.awt.Dimension(65, 100));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn0.setBackground(new java.awt.Color(255, 255, 255));
        btn0.setFont(new java.awt.Font("Nyala", 0, 72)); // NOI18N
        btn0.setForeground(new java.awt.Color(102, 102, 0));
        btn0.setText(" ");
        btn0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn0.setPreferredSize(new java.awt.Dimension(65, 100));
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fidelShowPanelLayout = new javax.swing.GroupLayout(fidelShowPanel);
        fidelShowPanel.setLayout(fidelShowPanelLayout);
        fidelShowPanelLayout.setHorizontalGroup(
            fidelShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fidelShowPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        fidelShowPanelLayout.setVerticalGroup(
            fidelShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fidelShowPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fidelShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fidelShowPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn0, btn1, btn2, btn3, btn4, btn5, btn6});

        fidelsPanel.add(fidelShowPanel);
        fidelShowPanel.setBounds(0, 450, 880, 136);

        bgimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/306942.jpg"))); // NOI18N
        fidelsPanel.add(bgimage);
        bgimage.setBounds(-10, -560, 900, 1150);

        fidelMainPanel.add(fidelsPanel);
        fidelsPanel.setBounds(45, 27, 880, 590);

        bgimage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/306942.jpg"))); // NOI18N
        fidelMainPanel.add(bgimage1);
        bgimage1.setBounds(0, -500, 1030, 1160);

        punctuationPanel.setBackground(new java.awt.Color(88, 188, 103));
        punctuationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ስርዐተ-ነጥብ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nyala", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        punctuationPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        punctuationPanel.setLayout(null);

        jButton34.setBackground(new java.awt.Color(204, 255, 255));
        jButton34.setFont(new java.awt.Font("Nyala", 0, 100)); // NOI18N
        jButton34.setForeground(new java.awt.Color(102, 102, 0));
        jButton34.setText("፤");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        punctuationPanel.add(jButton34);
        jButton34.setBounds(799, 177, 155, 117);

        jButton40.setBackground(new java.awt.Color(204, 255, 255));
        jButton40.setFont(new java.awt.Font("Nyala", 0, 100)); // NOI18N
        jButton40.setForeground(new java.awt.Color(102, 102, 0));
        jButton40.setText("፣");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        punctuationPanel.add(jButton40);
        jButton40.setBounds(424, 177, 155, 117);

        jButton41.setBackground(new java.awt.Color(204, 255, 255));
        jButton41.setFont(new java.awt.Font("Nyala", 0, 100)); // NOI18N
        jButton41.setForeground(new java.awt.Color(102, 102, 0));
        jButton41.setText("።");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        punctuationPanel.add(jButton41);
        jButton41.setBounds(58, 177, 155, 117);

        jButton42.setBackground(new java.awt.Color(204, 255, 255));
        jButton42.setFont(new java.awt.Font("Nyala", 0, 100)); // NOI18N
        jButton42.setForeground(new java.awt.Color(102, 102, 0));
        jButton42.setText("፧");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        punctuationPanel.add(jButton42);
        jButton42.setBounds(611, 177, 155, 117);

        jButton43.setBackground(new java.awt.Color(204, 255, 255));
        jButton43.setFont(new java.awt.Font("Nyala", 0, 100)); // NOI18N
        jButton43.setForeground(new java.awt.Color(102, 102, 0));
        jButton43.setText("፡");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        punctuationPanel.add(jButton43);
        jButton43.setBounds(240, 177, 155, 117);

        textFidels.setEditable(false);
        textFidels.setBackground(new java.awt.Color(255, 255, 255));
        textFidels.setFont(new java.awt.Font("Nyala", 1, 36)); // NOI18N
        textFidels.setForeground(new java.awt.Color(102, 102, 0));
        textFidels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFidelsActionPerformed(evt);
            }
        });
        punctuationPanel.add(textFidels);
        textFidels.setBounds(110, 480, 815, 70);

        exampleLabel.setBackground(new java.awt.Color(204, 255, 255));
        exampleLabel.setFont(new java.awt.Font("Nyala", 1, 48)); // NOI18N
        exampleLabel.setForeground(new java.awt.Color(255, 255, 255));
        exampleLabel.setText("ምሳሌ");
        punctuationPanel.add(exampleLabel);
        exampleLabel.setBounds(450, 400, 120, 40);

        bgimage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/306942.jpg"))); // NOI18N
        punctuationPanel.add(bgimage3);
        bgimage3.setBounds(0, -520, 1030, 1200);

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setForeground(new java.awt.Color(255, 255, 255));

        fileMenu.setText("ፋይል");
        fileMenu.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N

        closeItem.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N
        closeItem.setText("ዝጋ");
        closeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeItemActionPerformed(evt);
            }
        });
        fileMenu.add(closeItem);

        Menu.add(fileMenu);

        page.setText("ገጽ");
        page.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N

        fidelPage.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N
        fidelPage.setText("ፊደል ገጽ");
        fidelPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fidelPageActionPerformed(evt);
            }
        });
        page.add(fidelPage);

        kutirPage.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N
        kutirPage.setText("ቁጥር ገጽ");
        kutirPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kutirPageActionPerformed(evt);
            }
        });
        page.add(kutirPage);

        puncPage.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N
        puncPage.setText("ስርዐተ-ነጥብ ገጽ");
        puncPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puncPageActionPerformed(evt);
            }
        });
        page.add(puncPage);

        Menu.add(page);

        editMenu.setText("ማስተካከያ");
        editMenu.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N

        speed.setText("ፍጥነት");
        speed.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N

        oneSecond.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N
        oneSecond.setText("፩ ሰከንድ");
        oneSecond.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                oneSecondItemStateChanged(evt);
            }
        });
        speed.add(oneSecond);

        twoSecond.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N
        twoSecond.setText("፪ ሰከንድ");
        twoSecond.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                twoSecondItemStateChanged(evt);
            }
        });
        speed.add(twoSecond);

        thereSecond.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N
        thereSecond.setText("፫ ሰከንድ");
        thereSecond.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                thereSecondItemStateChanged(evt);
            }
        });
        speed.add(thereSecond);

        editMenu.add(speed);

        Menu.add(editMenu);

        kalManbebia.setText("ፊደል ማንበቢያ ");
        kalManbebia.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N
        kalManbebia.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                kalManbebiaMenuSelected(evt);
            }
        });
        Menu.add(kalManbebia);

        help.setText(" አጠቃቀም ");
        help.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpMouseExited(evt);
            }
        });
        Menu.add(help);

        aboutApp.setText("ስለ ፕሮግራሙ");
        aboutApp.setFont(new java.awt.Font("Nyala", 0, 14)); // NOI18N
        aboutApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutAppMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutAppMouseExited(evt);
            }
        });
        Menu.add(aboutApp);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fidelMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(startPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(helpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(591, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(226, 226, 226)
                    .addComponent(aboutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(505, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kutirPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(punctuationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fidelMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(startPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(helpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 354, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(aboutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 485, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(kutirPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(punctuationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        showQutir(jButton29);
       
    }//GEN-LAST:event_jButton29ActionPerformed

    private void kutirchoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kutirchoiceActionPerformed
      startPanel.setVisible(false);
      kutirPanel.setVisible(true);
    }//GEN-LAST:event_kutirchoiceActionPerformed

    private void closeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeItemActionPerformed
     System.exit(0);
    }//GEN-LAST:event_closeItemActionPerformed

    private void oneSecondItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_oneSecondItemStateChanged
     tSpeed=1000;
    }//GEN-LAST:event_oneSecondItemStateChanged

    private void twoSecondItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_twoSecondItemStateChanged
     tSpeed=2000;
    }//GEN-LAST:event_twoSecondItemStateChanged

    private void kalManbebiaMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_kalManbebiaMenuSelected
 
        VoiceTranslator vt=new VoiceTranslator();
                        vt.setVisible(true);
                        vt.setAlwaysOnTop(true);
    }//GEN-LAST:event_kalManbebiaMenuSelected

    private void helpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseEntered
  
   helpPanel.setVisible(true);
    }//GEN-LAST:event_helpMouseEntered

    private void helpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseExited
      helpPanel.setVisible(false);
    }//GEN-LAST:event_helpMouseExited

    private void aboutAppMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutAppMouseEntered
     aboutPanel.setVisible(true);
    }//GEN-LAST:event_aboutAppMouseEntered

    private void aboutAppMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutAppMouseExited
    aboutPanel.setVisible(false);
    }//GEN-LAST:event_aboutAppMouseExited

    private void thereSecondItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_thereSecondItemStateChanged
       tSpeed=3000;
    }//GEN-LAST:event_thereSecondItemStateChanged

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        showQutir(jButton30);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
          showQutir(jButton31);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
           showQutir(jButton32);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
         showQutir(jButton33);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
         showQutir(jButton35);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        
     String  qutir []=new String [9];
                    qutir [0]="\u1369"; 
	            qutir [1]="\u136A";
	            qutir [2]="\u136B";
	            qutir [3]="\u136C";
	            qutir [4]="\u136D";
	            qutir [5]="\u136E";
	            qutir [6]="\u136F";
	            qutir [7]="\u1370";
	            qutir [8]="\u1371";
                    
                     JButton qutirButton[]={b0,b1,b2,b3,b4,b5,b6,b7,b8,b9};
         Color qutirColors[]={Color.GREEN,Color.BLACK,Color.BLUE,Color.RED,Color.ORANGE,Color.pink,Color.cyan,Color.MAGENTA,Color.green,Color.gray};
	       
        if(thread.isAlive()){ // checks whather the thread is already runninig and if it is ruuning it stops it
        
            thread.stop();
            
        }
        thread=new Thread(){
         
             @Override
             public void run(){
         
                 for(JButton b:qutirButton){
                 b.setText("");
                 }
                 
                 for(int i=0;i<qutir.length;i++){
                 qutirButton[i].setText(qutir[i]);
                 qutirButton[i].setForeground(qutirColors[i]);
                 SoundNarrator.playFidel(qutirButton[i].getText());
                 
                 try{
                 Thread.sleep(2000);
                 }catch(InterruptedException ie){
                     System.out.println("thread inturpted");
                 }
                 
                 }
         }
         
         };
         
         thread.start();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
          showQutir(jButton37);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
          showQutir(jButton38);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
           showQutir(jButton39);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed
        if(b0.getText().length()>1){
       char [] text=b0.getText().toCharArray();
      
       for(char c:text ){
       SoundNarrator.playFidel(Character.toString(c));try{Thread.sleep(2000);}catch(InterruptedException e){}
       }
       
       }
       else{
       SoundNarrator.playFidel(b0.getText());
       }
    }//GEN-LAST:event_b0ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
         if(b1.getText().length()>1){
       char [] text=b1.getText().toCharArray();
      
       for(char c:text ){
       SoundNarrator.playFidel(Character.toString(c));try{Thread.sleep(2000);}catch(InterruptedException e){}
       }
       
       }
       else{
       SoundNarrator.playFidel(b1.getText());
       }
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
            if(b2.getText().length()>1){
       char [] text=b2.getText().toCharArray();
      
       for(char c:text ){
       SoundNarrator.playFidel(Character.toString(c));try{Thread.sleep(2000);}catch(InterruptedException e){}
       }
       
       }
       else{
       SoundNarrator.playFidel(b2.getText());
       }
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
           if(b3.getText().length()>1){
       char [] text=b3.getText().toCharArray();
      
       for(char c:text ){
       SoundNarrator.playFidel(Character.toString(c));try{Thread.sleep(2000);}catch(InterruptedException e){}
       }
       
       }
       else{
       SoundNarrator.playFidel(b3.getText());
       }
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
         if(b4.getText().length()>1){
       char [] text=b4.getText().toCharArray();
      
       for(char c:text ){
       SoundNarrator.playFidel(Character.toString(c));try{Thread.sleep(2000);}catch(InterruptedException e){}
       }
       
       }
       else{
       SoundNarrator.playFidel(b4.getText());
       }
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
   if(b5.getText().length()>1){
       char [] text=b5.getText().toCharArray();
      
       for(char c:text ){
       SoundNarrator.playFidel(Character.toString(c));try{Thread.sleep(2000);}catch(InterruptedException e){}
       }
       
       }
       else{
       SoundNarrator.playFidel(b5.getText());
       }
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
       if(b6.getText().length()>1){
       char [] text=b6.getText().toCharArray();
      
       for(char c:text ){
       SoundNarrator.playFidel(Character.toString(c));try{Thread.sleep(2000);}catch(InterruptedException e){}
       }
       
       }
       else{
       SoundNarrator.playFidel(b6.getText());
       }
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
           if(b7.getText().length()>1){
       char [] text=b7.getText().toCharArray();
      
       for(char c:text ){
       SoundNarrator.playFidel(Character.toString(c));try{Thread.sleep(2000);}catch(InterruptedException e){}
       }
       
       }
       else{
       SoundNarrator.playFidel(b7.getText());
       }
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
          if(b8.getText().length()>1){
       char [] text=b8.getText().toCharArray();
      
       for(char c:text ){
       SoundNarrator.playFidel(Character.toString(c));try{Thread.sleep(2000);}catch(InterruptedException e){}
       }
       
       }
       else{
       SoundNarrator.playFidel(b8.getText());
       }
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
       if(b9.getText().length()>1){
       char [] text=b9.getText().toCharArray();
      
       for(char c:text ){
       SoundNarrator.playFidel(Character.toString(c));
//       try{
//           Thread.sleep(2000);
//                   }catch(InterruptedException e){}
//       
//       }
//       
       }
       else{
       SoundNarrator.playFidel(b9.getText());
       }
    }//GEN-LAST:event_b9ActionPerformed

    private void fidelChooiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fidelChooiceActionPerformed
      fidelMainPanel.setVisible(true);
      startPanel.setVisible(false);
      punctuationPanel.setVisible(false);
    }//GEN-LAST:event_fidelChooiceActionPerformed

    private void fidelPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fidelPageActionPerformed
      fidelMainPanel.setVisible(true);
      kutirPanel.setVisible(false);
      startPanel.setVisible(false);
      punctuationPanel.setVisible(false);
    }//GEN-LAST:event_fidelPageActionPerformed

    private void kutirPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kutirPageActionPerformed
      fidelMainPanel.setVisible(false);
      kutirPanel.setVisible(true);
      startPanel.setVisible(false);
      punctuationPanel.setVisible(false);
    }//GEN-LAST:event_kutirPageActionPerformed

    private void punctuationcoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_punctuationcoiceActionPerformed
       fidelMainPanel.setVisible(false);
       kutirPanel.setVisible(false);
       startPanel.setVisible(false);
       punctuationPanel.setVisible(true);
    }//GEN-LAST:event_punctuationcoiceActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
       SoundNarrator.playFidel(jButton43.getText());
       textFidels.setText("   አስቴር፡ወደ፡ት/ት፡ቤት፡ሄደች");
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
      SoundNarrator.playFidel(jButton41.getText());
      textFidels.setText("   አበበ በሶ በላ።");
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        SoundNarrator.playFidel(jButton40.getText()); 
        textFidels.setText("   ከበደ ገቢያ ሂዶ ሰላጣ፣ቲማቲም፣ሎሚ እና ካሮት ገዛ ");
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
      SoundNarrator.playFidel(jButton42.getText()); 
      textFidels.setText("   ሠላም የለበሽውን ቀሚስ ስንት ብር ገዛሽው፧");
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        SoundNarrator.playFidel(jButton34.getText()); 
        textFidels.setText("   መምህሩ እግሩን ስለታመመ ፤ ዛሬ መምጣት አይችልም");
    }//GEN-LAST:event_jButton34ActionPerformed

    private void puncPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puncPageActionPerformed
       fidelMainPanel.setVisible(false);
       kutirPanel.setVisible(false);
       startPanel.setVisible(false);
       punctuationPanel.setVisible(true);
    }//GEN-LAST:event_puncPageActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
                 SoundNarrator.playFidel(jButton44.getText());
    }//GEN-LAST:event_jButton44ActionPerformed

    private void textFidelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFidelsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFidelsActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        SoundNarrator.playFidel(btn0.getText());
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        SoundNarrator.playFidel(btn2.getText());    // TODO add your handling code here:
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        SoundNarrator.playFidel(btn6.getText());
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        SoundNarrator.playFidel(btn5.getText());
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        SoundNarrator.playFidel(btn1.getText());
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        SoundNarrator.playFidel(btn3.getText());
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        SoundNarrator.playFidel(btn4.getText());
    }//GEN-LAST:event_btn4ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed

        String fidel[]=new String[7];

        // yie

        fidel[0] =  ("\u12E8");
        fidel[1] =  ("\u12E9");
        fidel[2] =  ("\u12EA");
        fidel[3] =  ("\u12EB");
        fidel[4] =  ("\u12EC");
        fidel[5] =  ("\u12ED");
        fidel[6] =  ("\u12EE");

        showFidels(fidel,jButton24);

    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String fidel[] = new String[7];

        // me

        fidel[0] = "\u1218";
        fidel[1] = "\u1219";
        fidel[2] = "\u121A";
        fidel[3] = "\u121B";
        fidel[4] = "\u121C";
        fidel[5] = "\u121D";
        fidel[6] = "\u121E";

        showFidels(fidel,jButton4);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        String fidel[]=new String[7];

        // wie

        fidel[0] =  ("\u12C8");
        fidel[1] =  ("\u12C9");
        fidel[2] =  ("\u12CA");
        fidel[3] =  ("\u12CB");
        fidel[4] =  ("\u12CC");
        fidel[5] =  ("\u12CD");
        fidel[6] =  ("\u12CE");

        showFidels(fidel,jButton21);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed

        String fidel[]=new String[7];

        // p

        fidel[0] =  ("\u1350");
        fidel[1] =  ("\u1351");
        fidel[2] =  ("\u1352");
        fidel[3] =  ("\u1353");
        fidel[4] =  ("\u1354");
        fidel[5] =  ("\u1355");
        fidel[6] =  ("\u1356");

        showFidels(fidel,jButton23);

    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed

        String fidel[]=new String[7];

        // Tse

        fidel[0] =  ("\u1340");
        fidel[1] =  ("\u1341");
        fidel[2] =  ("\u1342");
        fidel[3] =  ("\u1343");
        fidel[4] =  ("\u1344");
        fidel[5] =  ("\u1345");
        fidel[6] =  ("\u1346");

        showFidels(fidel,jButton26);

    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String fidel[]=new String[7];

        // Zie

        fidel[0] =  ("\u12D8");
        fidel[1] =  ("\u12D9");
        fidel[2] =  ("\u12DA");
        fidel[3] =  ("\u12DB");
        fidel[4] =  ("\u12DC");
        fidel[5] =  ("\u12DD");
        fidel[6] =  ("\u12DE");

        showFidels(fidel,jButton8);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed

        String fidel[]=new String[7];

        // jie

        fidel[0] =  ("\u1300");
        fidel[1] =  ("\u1301");
        fidel[2] =  ("\u1302");
        fidel[3] =  ("\u1303");
        fidel[4] =  ("\u1304");
        fidel[5] =  ("\u1305");
        fidel[6] =  ("\u1306");

        showFidels(fidel,jButton27);

    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        String fidel[]=new String [7];

        // sh'e

        fidel[0] = "\u1238";
        fidel[1] = "\u1239";
        fidel[2] = "\u123A";
        fidel[3] = "\u123B";
        fidel[4] = "\u123C";
        fidel[5] = "\u123D";
        fidel[6] = "\u123E";

        showFidels(fidel,jButton9);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed

        String fidel[]=new String[7];

        // fua

        fidel[0] ="\u1348";
        fidel[1] ="\u1349";
        fidel[2] ="\u134A";
        fidel[3] ="\u134B";
        fidel[4] ="\u134C";
        fidel[5] ="\u134D";
        fidel[6] ="\u134E";

        showFidels(fidel,jButton20);

    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        String fidel[]=new String[7];

        // nie

        fidel[0] =  ("\u1290");
        fidel[1] =  ("\u1291");
        fidel[2] =  ("\u1292");
        fidel[3] =  ("\u1293");
        fidel[4] =  ("\u1294");
        fidel[5] =  ("\u1295");
        fidel[6] =  ("\u1296");

        showFidels(fidel,jButton16);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String fidel[]=new String [7];

        // re

        fidel[0] = "\u1228";
        fidel[1] = "\u1229";
        fidel[2] = "\u122A";
        fidel[3] = "\u122B";
        fidel[4] = "\u122C";
        fidel[5] = "\u122D";
        fidel[6] = "\u122E";

        showFidels(fidel,jButton6);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButtonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsActionPerformed

        String fidel[]=new String[7];

        // Anothe A

        fidel[0] =  ("\u12D0");
        fidel[1] =  ("\u12D1");
        fidel[2] =  ("\u12D2");
        fidel[3] =  ("\u12D3");
        fidel[4] =  ("\u12D4");
        fidel[5] =  ("\u12D5");
        fidel[6] =  ("\u12D6");

        showFidels(fidel,jButtons);
    }//GEN-LAST:event_jButtonsActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        String fidel[]=new String[7];

        // se

        fidel[0] = "\u1230";
        fidel[1] = "\u1231";
        fidel[2] = "\u1232";
        fidel[3] = "\u1233";
        fidel[4] = "\u1234";
        fidel[5] = "\u1235";
        fidel[6] = "\u1236";

        showFidels(fidel,jButton7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        String fidel []=new String [7];

        // qe

        fidel[0] = "\u1240";
        fidel[1] = "\u1241";
        fidel[2] = "\u1242";
        fidel[3] = "\u1243";
        fidel[4] = "\u1244";
        fidel[5] = "\u1245";
        fidel[6] = "\u1246";

        showFidels(fidel,jButton10);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String fidel[] = new String[7]; // array of Ge'ez Fidels

        //ha

        fidel[0] = "\u1200";
        fidel[1] = "\u1201";
        fidel[2] = "\u1202";
        fidel[3] = "\u1203";
        fidel[4] = "\u1204";
        fidel[5] = "\u1205";
        fidel[6] = "\u1206";

        showFidels(fidel,jButton1);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        String fidel[]=new String[7];

        fidel[0] ="\u1320";
        fidel[1] ="\u1321";
        fidel[2] ="\u1322";
        fidel[3] ="\u1323";
        fidel[4] ="\u1324";
        fidel[5] ="\u1325";
        fidel[6] ="\u1326";

        showFidels(fidel,jButton12);

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        String fidel[]=new String[7];

        //TE

        fidel[0] = "\u1270";
        fidel[1] = "\u1271";
        fidel[2] = "\u1272";
        fidel[3] = "\u1273";
        fidel[4] = "\u1274";
        fidel[5] = "\u1275";
        fidel[6] = "\u1276";

        showFidels(fidel,jButton13);

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        String fidel[] =new String[7];

        // che

        fidel[0] = "\u1278";
        fidel[1] = "\u1279";
        fidel[2] = "\u127A";
        fidel[3] = "\u127B";
        fidel[4] = "\u127C";
        fidel[5] = "\u127D";
        fidel[6] = "\u127E";

        showFidels(fidel,jButton14);

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed

        String fidel[]=new String[7];

        // gie

        fidel[0] =  ("\u1308");
        fidel[1] =  ("\u1309");
        fidel[2] =  ("\u130A");
        fidel[3] =  ("\u130B");
        fidel[4] =  ("\u130C");
        fidel[5] =  ("\u130D");
        fidel[6] =  ("\u130E");

        showFidels(fidel,jButton28);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        String fidel[]=new String[7];

        // ke

        fidel[0] =  ("\u12A8");
        fidel[1] =  ("\u12A9");
        fidel[2] =  ("\u12AA");
        fidel[3] =  ("\u12AB");
        fidel[4] =  ("\u12AC");
        fidel[5] =  ("\u12AD");
        fidel[6] =  ("\u12AE");

        showFidels(fidel,jButton19);

    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String fidel[] = new String[7];

        //hameru ha

        fidel[0] = "\u1210";
        fidel[1] = "\u1211";
        fidel[2] = "\u1212";
        fidel[3] = "\u1213";
        fidel[4] = "\u1214";
        fidel[5] = "\u1215";
        fidel[6] = "\u1216";

        showFidels(fidel,jButton3);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed

        String fidel[]=new String[7];

        // die

        fidel[0] =  ("\u12F0");
        fidel[1] =  ("\u12F1");
        fidel[2] =  ("\u12F2");
        fidel[3] =  ("\u12F3");
        fidel[4] =  ("\u12F4");
        fidel[5] =  ("\u12F5");
        fidel[6] =  ("\u12F6");

        showFidels(fidel,jButton25);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String fidel[] = new String[7];

        // esatu se

        fidel[0] = "\u1220";
        fidel[1] = "\u1221";
        fidel[2] = "\u1222";
        fidel[3] = "\u1223";
        fidel[4] = "\u1224";
        fidel[5] = "\u1225";
        fidel[6] = "\u1226";

        showFidels(fidel,jButton5);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        String fidel[]=new String[7];

        //ha

        fidel[0] = "\u1280";
        fidel[1] = "\u1281";
        fidel[2] = "\u1282";
        fidel[3] = "\u1283";
        fidel[4] = "\u1284";
        fidel[5] = "\u1285";
        fidel[6] = "\u1286";

        showFidels(fidel,jButton15);

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String fidel[] = new String[7];

        //le

        fidel[0] = "\u1208";
        fidel[1] = "\u1209";
        fidel[2] = "\u120A";
        fidel[3] = "\u120B";
        fidel[4] = "\u120C";
        fidel[5] = "\u120D";
        fidel[6] = "\u120E";

        showFidels(fidel,jButton2);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        String fidel[]=new String[7];

        // AA

        fidel[0] =  ("\u12A0");
        fidel[1] =  ("\u12A1");
        fidel[2] =  ("\u12A2");
        fidel[3] =  ("\u12A3");
        fidel[4] =  ("\u12A4");
        fidel[5] =  ("\u12A5");
        fidel[6] =  ("\u12A6");

        showFidels(fidel,jButton18);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        String fidel[]=new String[7];

        // be

        fidel[0] = "\u1260";
        fidel[1] = "\u1261";
        fidel[2] = "\u1262";
        fidel[3] = "\u1263";
        fidel[4] = "\u1264";
        fidel[5] = "\u1265";
        fidel[6] = "\u1266";

        showFidels(fidel,jButton11);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed

        String fidel[]=new String[7];

        // nye

        fidel[0] =  ("\u1298");
        fidel[1] =  ("\u1299");
        fidel[2] =  ("\u129A");
        fidel[3] =  ("\u129B");
        fidel[4] =  ("\u129C");
        fidel[5] =  ("\u129D");
        fidel[6] =  ("\u129E");

        showFidels(fidel,jButton17);

    }//GEN-LAST:event_jButton17ActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu aboutApp;
    private javax.swing.JPanel aboutPanel;
    private javax.swing.JButton b0;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JLabel bgImage;
    private javax.swing.JLabel bgimage;
    private javax.swing.JLabel bgimage1;
    private javax.swing.JLabel bgimage3;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JMenuItem closeItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JLabel exampleLabel;
    private javax.swing.JButton fidelChooice;
    private javax.swing.JPanel fidelMainPanel;
    private javax.swing.JMenuItem fidelPage;
    private javax.swing.JPanel fidelShowPanel;
    private javax.swing.JPanel fidelsPanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel firstLable;
    private javax.swing.JMenu help;
    private javax.swing.JPanel helpPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtons;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JMenu kalManbebia;
    private javax.swing.JMenuItem kutirPage;
    private javax.swing.JPanel kutirPanel;
    private javax.swing.JButton kutirchoice;
    private javax.swing.JCheckBoxMenuItem oneSecond;
    private javax.swing.JMenu page;
    private javax.swing.JMenuItem puncPage;
    private javax.swing.JPanel punctuationPanel;
    private javax.swing.JButton punctuationcoice;
    private javax.swing.JPanel showQutirPanel;
    private javax.swing.JMenu speed;
    private javax.swing.JPanel startPanel;
    private javax.swing.JTextField textFidels;
    private javax.swing.JCheckBoxMenuItem thereSecond;
    private javax.swing.JCheckBoxMenuItem twoSecond;
    // End of variables declaration//GEN-END:variables
}
