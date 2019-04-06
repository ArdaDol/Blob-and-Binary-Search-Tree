package sourceFiles;

public class Image{

	protected Pixel[][] pixels;
	protected int rows;
	protected int cols;

	public Image(int rows, int cols){
		this.pixels = new Pixel[rows][cols];
		this.rows = rows;
		this.cols = cols;
	}

	public Pixel getPixel(int row, int col){
		return this.pixels[row][col];
	}




  /** Clear all pixels in the image; setting all settable state to 'zero' */
  public void clearImage(){
		for(int row=0; row<this.rows; row+=1){
			for(int col=0; col<this.cols; col+=1){
				getPixel(row,col).clear();
			}
		}

	}





	public static String WALL = "#";     // "\u2588";
	public static String EMPTY = " ";    //

	@Override
	public String toString(){
		String ans = "+";
		for(int c=0; c<cols; c+=1){
			ans += "-";
		}
		ans += "+\n";
		for(int r=0; r<rows; r+=1){
			ans += "|";
			for(int c=0; c<cols; c+=1){
					ans += getPixel(r,c).hasInk()?WALL:EMPTY;
			}
			ans += "|\n";
		}
		ans += "+";
		for(int c=0; c<cols; c+=1){
			ans += "-";
		}
		ans += "+";

		return ans;
	}



}
