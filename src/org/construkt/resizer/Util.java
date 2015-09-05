package org.construkt.resizer;

public final class Util
{
	private static final char EXT_SEPARATOR = '.';
	
	/**
	 * Gets the file extension from the end of a file.
	 * @param filePath The file with an extension attached to it.
	 * @param incSeparator Specify weather to include the period separator on return.
	 * @return Returns the file extension with specified format. Returns null if no extension is found.
	 */
	public static String getFileExtension(String filePath, boolean incSeparator)
	{
		String bufferExtension = "";
		
		for (int i = filePath.length() - 1; i >= 0; i--)
		{
			if (filePath.charAt(i) == EXT_SEPARATOR)
				break;
			else
				bufferExtension += filePath.charAt(i);
		}
		
		if (incSeparator)
			bufferExtension += EXT_SEPARATOR;
		
		bufferExtension = new StringBuilder(bufferExtension).reverse().toString();
		
		return bufferExtension;
	}
	
	/**
	 * 	Removes the extension from the filename included in the file path.
	 * @param filePath The file to remove the extension from.
	 * @return Returns a filename with the extension removed.
	 */
	public static String removeFileExtension(String filePath)
	{
		String ext = getFileExtension(filePath, true);		
		String retPath = filePath.substring(0, filePath.length() - ext.length());
		
		return retPath;
	}
	
	/**
	 * 	Appends text to a filename before the extension.
	 * @param filePath The file to add the appended text to.
	 * @param textToAppend The text to be included before the extension.
	 * @return Returns a filename with text appended before the extension.
	 */
	public static String appendTextBeforeExtension(String filePath, String textToAppend)
	{
		String ext = getFileExtension(filePath, true);
		String rmExt = removeFileExtension(filePath);
		
		String retPath = rmExt + textToAppend + ext;
		
		return retPath;
	}
}