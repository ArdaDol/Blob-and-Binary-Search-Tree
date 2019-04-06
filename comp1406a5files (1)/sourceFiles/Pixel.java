package sourceFiles;

public class Pixel{
	protected int     row;     // row of pixel
	protected int     col;     // column of pixel
	protected boolean hasInk;  // true of this pixel has ink (coloured)
	protected int     sides;   // number of sides with a neihbour WITHOUT ink
	protected boolean visited; // has this pixel been visited
  protected Object  extra;   // place for you to store something (if needed)

	public Pixel(int row, int col, boolean hasInk){
		this.row = row;
		this.col = col;
		this.hasInk = hasInk;
		this.sides = 0;
		this.visited = false;
		this.extra = null;
	}

	public int getRow(){ return this.row; }
	public int getCol(){ return this.col; }
	public boolean hasInk(){ return this.hasInk; }
	public int getSides(){ return this.sides; }
	public boolean visited(){ return this.visited; }
	public Object getExtra(){ return this.extra; }

  public void setSides(int n){ this.sides = n;}
	public void setVisited(boolean v){ this.visited = v;}
	public void setExtra(Object obj){ this.extra = obj; }

  /** Clear all settable state of this pixel; set everythibg to 'zero' */
  public void clear(){
		this.sides = 0;
		this.visited = false;
		this.extra = null;
	}
}
