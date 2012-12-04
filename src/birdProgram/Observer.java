package birdProgram;

import java.awt.Image;
import java.awt.image.ImageObserver;

public class Observer implements ImageObserver{
	
	public Observer(){
		
	}

	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		return false;
	}
}
