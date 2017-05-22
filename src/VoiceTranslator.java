;

public class VoiceTranslator extends javax.swing.JFrame {

        public VoiceTranslator() {
        initComponents();
       
       }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        voiceTranslatorPanel = new javax.swing.JPanel();
        anbibButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTextFiled = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ቃል ማንበቢያ");
        setFont(new java.awt.Font("Nyala", 0, 10)); // NOI18N
        setResizable(false);

        voiceTranslatorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ፊደላትን ወደ መጻፊያ ሰሌዳ ያስገቡ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nyala", 0, 14))); // NOI18N

        anbibButton.setFont(new java.awt.Font("Nyala", 0, 36)); // NOI18N
        anbibButton.setForeground(new java.awt.Color(102, 102, 0));
        anbibButton.setText("አንብብ");
        anbibButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anbibButtonActionPerformed(evt);
            }
        });

        inputTextFiled.setColumns(20);
        inputTextFiled.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        inputTextFiled.setRows(5);
        inputTextFiled.setToolTipText("");
        jScrollPane1.setViewportView(inputTextFiled);

        javax.swing.GroupLayout voiceTranslatorPanelLayout = new javax.swing.GroupLayout(voiceTranslatorPanel);
        voiceTranslatorPanel.setLayout(voiceTranslatorPanelLayout);
        voiceTranslatorPanelLayout.setHorizontalGroup(
            voiceTranslatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, voiceTranslatorPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(voiceTranslatorPanelLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(anbibButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        voiceTranslatorPanelLayout.setVerticalGroup(
            voiceTranslatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(voiceTranslatorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(anbibButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(voiceTranslatorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(voiceTranslatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void anbibButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anbibButtonActionPerformed
     
        char [] input=inputTextFiled.getText().toCharArray();
        
        Thread t=new Thread (){
      
            @Override
        
            public void run (){
         
            for (int i=0;i<input.length;i++){
               
                SoundNarrator.playFidel(String.valueOf(input[i]));
            
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("interrupt has occured");
                }
               }
            
            }
       };
        
       t.start();
 
    }//GEN-LAST:event_anbibButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anbibButton;
    private javax.swing.JTextArea inputTextFiled;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel voiceTranslatorPanel;
    // End of variables declaration//GEN-END:variables
}
