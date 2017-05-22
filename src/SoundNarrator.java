
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


class SoundNarrator{        
	
		static AudioPlayer audioPlayer;
		static InputStream inputStream;
		static AudioStream audioStream;
		
		public static boolean openFile(File file){   // 
		
		try{
			
			inputStream = new FileInputStream(file);
			
					audioStream = new AudioStream(inputStream);
					
                                        return true;
			
		}

		
		catch (IOException exception){
			
			System.out.println("File not found in app File folder");
			return false;
		}
	}
	
		public synchronized static void playFidel(String fidelText){     
			
			AudioPlayer.player.stop(audioStream);
			File file = new File("app files\\audio\\"+fidelText+".wav");
			
				if( openFile(file) ){
					
					AudioPlayer.player.start(audioStream);
                                       
					
								}
					}
               
	
	} // end of soundNarrator class