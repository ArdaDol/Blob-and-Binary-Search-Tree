package sourceFiles;

public class Helper{

	/** Generate a random Image that is rows X cols large, where each
		* location has ink with the given probability.
		*
		* @param rows is the number of rows in the image
		* @param cols is the number of columns in the image
		* @param p is the probability that the any cell in image has ink
		* @return an image that rows X cols large where each pixel has
		*		      ink with given probability.
		*/
	public static Image makeRandomImage(int rows, int cols, double prob){
		Image img = new Blob(rows, cols);
		for(int row=0; row<rows; row+=1){
			for(int col=0; col<cols; col+=1){
				img.pixels[row][col] = new Pixel(row, col, Math.random()<prob);
			}
		}
		return img;
	}



}
