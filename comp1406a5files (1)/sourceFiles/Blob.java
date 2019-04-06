package sourceFiles;

public class Blob extends Image{

  // leave this constructor as is. This is the constructor that we will  use
	// when testing your code.
	public Blob(int rows, int cols){
		super(rows, cols);
	}
	
	public void computePixelPerimeters(int row, int column){
		this.clearImage();
		helperComputePixelPerimeters(row, column);
	}

  public void helperComputePixelPerimeters(int row, int column){
	  Pixel mainPix = this.getPixel(row, column);
	  if(mainPix.visited() ==false){
		  mainPix.setVisited(true);
		  if(mainPix.hasInk()!=false){
			  int count = 0;
			  Pixel getPix = this.getPixel(row,column);
			  if(row>0){
				  getPix = this.getPixel(row-1,column);
				  if(getPix.hasInk()==false){
					  count+=1;
				  }
			  }if(column<this.cols-1){
				  getPix = this.getPixel(row,column+1);
				  if(getPix.hasInk()==false){
					  count+=1;
				  }
			  }if(row<this.rows-1){
				  getPix = this.getPixel(row+1,column);
				  if(getPix.hasInk()==false){
					  count+=1;
				  }
			  }if(column>0){
				  getPix = this.getPixel(row,column-1);
				  if(getPix.hasInk()==false){
					  count+=1;
				  }
			  }mainPix.setSides(count);
			  
			  if(row>0){
				  helperComputePixelPerimeters(row-1,column);
			  }if(column<this.cols-1){
				  helperComputePixelPerimeters(row,column+1);
			  }if(row<this.rows-1){
				  helperComputePixelPerimeters(row+1,column);
			  }if(column>0){
				  helperComputePixelPerimeters(row,column-1);
				  }
		  }
	  }
  }
  
  public int perimeter(int row, int column){
	  this.clearImage();
	  computePixelPerimeters(row, column);
	  return helperPerimeter(row, column);
  }



  public int helperPerimeter(int row, int column){
	  int resolution = 0;
	  Pixel mainPix = this.getPixel(row, column);
	  mainPix.setVisited(false);
	  if(mainPix.hasInk()==false){
		  return resolution;
	  }
	  else{
		  resolution = mainPix.getSides();
		  Pixel getPix = this.getPixel(row, column);
		  if(row>0){
			  getPix = this.getPixel(row-1,column);
			  if(getPix.visited()==true){
				  //System.out.println("1");
				  resolution = resolution + helperPerimeter(row-1,column);
			  }
		  }if(column<this.cols-1){
			  getPix = this.getPixel(row,column+1);
			  if(getPix.visited()==true){
				  //System.out.println("2");
				  resolution = resolution + helperPerimeter(row, column+1);
			  }
		  }if(row<this.rows-1){
			  getPix = this.getPixel(row+1,column);
			  if(getPix.visited()==true){
				  //System.out.println("3");
				  resolution = resolution + helperPerimeter(row+1, column);
			  }
		  }if(column>0){
			  getPix = this.getPixel(row,column-1);
			  if(getPix.visited()==true){
				  //System.out.println("4");
				  resolution = resolution+helperPerimeter(row, column-1);
			  }
		  }
	  }
	  return resolution;
  }




	public static void main(String[] args){
		// for testing...
		//Image img = Helper.makeRandomImage(20,80,0.35);
		Blob img = new Blob(3,3);
		img.pixels[0][0] = new Pixel(0,0,false);
		img.pixels[0][1] = new Pixel(0,1,false);
		img.pixels[0][2] = new Pixel(0,2,false);
		img.pixels[1][0] = new Pixel(1,0,false);
		img.pixels[1][1] = new Pixel(1,1,true);
		img.pixels[1][2] = new Pixel(1,2,true);
		img.pixels[2][0] = new Pixel(2,0,false);
		img.pixels[2][1] = new Pixel(2,1,false);
		img.pixels[2][2] = new Pixel(2,2,false);
		int test = img.perimeter(1,2);
		System.out.println(test);

	}


}
