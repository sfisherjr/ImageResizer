package org.construkt.resizer;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHandler
{	
	private BufferedImage imageBuffer;
	private BufferedImage resizeImageBuffer;
	private BufferedImage completedImage;
	
	public ImageHandler() {}
	
	public void loadImage(String filePath) throws IOException 
	{
		imageBuffer = ImageIO.read(new File(filePath));	
	}
	
	public void resizeFromBuffer(int width, int height) 
	{
		if (imageBuffer != null)
		{
			Image imgScalar = imageBuffer.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			resizeImageBuffer = new BufferedImage(width, height, imageBuffer.getType());
			
			Graphics2D graphics = resizeImageBuffer.createGraphics();
			graphics.drawImage(imgScalar, 0, 0, null);
			graphics.dispose();
			
			completedImage = resizeImageBuffer;
		}
		else
			throw new NullPointerException();
	}
	
	public void saveImage(String filePath) throws IOException
	{
		if (imageBuffer != null)
			ImageIO.write(completedImage, "png", new File(filePath));
		else
			throw new NullPointerException();
	}
}