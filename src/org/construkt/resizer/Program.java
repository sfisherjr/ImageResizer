package org.construkt.resizer;

import java.io.IOException;

public class Program
{
	public static void main(String[] args)
	{
		if (args.length > 0)
		{
			String curImagePath = args[0];						
			ImageHandler imgHandler = new ImageHandler();
			String neuImagePath = Util.appendTextBeforeExtension(curImagePath, "_small");
			
			try
			{
				imgHandler.loadImage(curImagePath);
				imgHandler.resizeFromBuffer(256, 256);
				imgHandler.saveImage(neuImagePath);
			} 
			catch (IOException ex)
			{
				System.out.println("Error loading image, please make sure that the image exists");
				return;
			}
			catch (NullPointerException ne)
			{
				System.out.println("Error mutating image, please provide a valid image file.");
			}
		}
	}
}