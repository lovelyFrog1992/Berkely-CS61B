/* PixImage.java */

/**
 *  The PixImage class represents an image, which is a rectangular grid of
 *  color pixels.  Each pixel has red, green, and blue intensities in the range
 *  0...255.  Descriptions of the methods you must implement appear below.
 *  They include a constructor of the form
 *
 *      public PixImage(int width, int height);
 *
 *  that creates a black (zero intensity) image of the specified width and
 *  height.  Pixels are numbered in the range (0...width - 1, 0...height - 1).
 *
 *  All methods in this class must be implemented to complete Part I.
 *  See the README file accompanying this project for additional details.
 */

public class PixImage {

  /**
   *  Define any variables associated with a PixImage object here.  These
   *  variables MUST be private.
   */
   private int Width;
   private int Height;
   private short[][][] pixel;
   /*private pixelStore[][] RGBval;*/
   private short[] trans;



  /**
   * PixImage() constructs an empty PixImage with a specified width and height.
   * Every pixel has red, green, and blue intensities of zero (solid black).
   *
   * @param width the width of the image.
   * @param height the height of the image.
   */
  public PixImage(int width, int height) {
    // Your solution here.
	Width=width;
	Height=height;
	//pixel=new pixelStore[Width][Height];
	pixel =new short[Width][Height][3];
//	pixelStore st;
	for(int j=0;j<=height-1;j++){
		for(int i=0;i<=width-1;i++){
	//		st=new pixelStore(i,j,(short)0,(short)0,(short)0);
			pixel[i][j][0]=0;
			pixel[i][j][1]=0;
			pixel[i][j][2]=0;
		}
	}
  }

  /**
   * getWidth() returns the width of the image.
   *
   * @return the width of the image.
   */
  public int getWidth() {
    // Replace the following line with your solution.
    return Width;
  }

  /**
   * getHeight() returns the height of the image.
   *
   * @return the height of the image.
   */
  public int getHeight() {
    // Replace the following line with your solution.
    return Height;
  }

  /**
   * getRed() returns the red intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the red intensity of the pixel at coordinate (x, y).
   */
  public short getRed(int x, int y) {
    // Replace the following line with your solution.
//	try{
	  trans=pixel[x][y];
    //  return (trans.getRGB())[0];
	  return trans[0];
/*	}catch(Exception e){
		System.out.println("x:"+x+"y:"+y);
		System.exit(0);
	}
	return 0;*/
	  
  }

  /**
   * getGreen() returns the green intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the green intensity of the pixel at coordinate (x, y).
   */
  public short getGreen(int x, int y) {
    // Replace the following line with your solution.
	trans=pixel[x][y];
    //return(trans.getRGB())[1];
	return trans[1];
  }

  /**
   * getBlue() returns the blue intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the blue intensity of the pixel at coordinate (x, y).
   */
  public short getBlue(int x, int y) {
    // Replace the following line with your solution.
      trans=pixel[x][y];
    //  return(trans.getRGB())[2];
      return trans[2];
  }

  /**
   * setPixel() sets the pixel at coordinate (x, y) to specified red, green,
   * and blue intensities.
   *
   * If any of the three color intensities is NOT in the range 0...255, then
   * this method does NOT change any of the pixel intensities.
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @param red the new red intensity for the pixel at coordinate (x, y).
   * @param green the new green intensity for the pixel at coordinate (x, y).
   * @param blue the new blue intensity for the pixel at coordinate (x, y).
   */
  public void setPixel(int x, int y, short red, short green, short blue) {
    // Your solution here.
	if((red>=0&&red<=255)&&(green>=0&&green<=255)&&(blue>=0&&blue<=255)){
	//	pixelStore pxs=new pixelStore(x,y,red,green,blue);
		pixel[x][y][0]=red;
		pixel[x][y][1]=green;
		pixel[x][y][2]=blue;
	}	
  }

  /**
   * toString() returns a String representation of this PixImage.
   *
   * This method isn't required, but it should be very useful to you when
   * you're debugging your code.  It's up to you how you represent a PixImage
   * as a String.
   *
   * @return a String representation of this PixImage.
   */
  public String toString() {
    // Replace the following line with your solution.
    String res="";
    for(int j=0;j<Height;j++){
    	for(int i=0;i<Width;i++){
    		res=res+" | ";
    		for(int k=0;k<3;k++){
    			res=res+" "+String.valueOf((int)pixel[i][j][k]);
    		}
    		res=res+" | ";
    		if(i==Width-1){
    			res=res+"\r\n";
    		}
    	}
    }
	  return res;
  }

  /**
   * boxBlur() returns a blurred version of "this" PixImage.
   *
   * If numIterations == 1, each pixel in the output PixImage is assigned
   * a value equal to the average of its neighboring pixels in "this" PixImage,
   * INCLUDING the pixel itself.
   *
   * A pixel not on the image boundary has nine neighbors--the pixel itself and
   * the eight pixels surrounding it.  A pixel on the boundary has six
   * neighbors if it is not a corner pixel; only four neighbors if it is
   * a corner pixel.  The average of the neighbors is the sum of all the
   * neighbor pixel values (including the pixel itself) divided by the number
   * of neighbors, with non-integer quotients rounded toward zero (as Java does
   * naturally when you divide two integers).
   *
   * Each color (red, green, blue) is blurred separately.  The red input should
   * have NO effect on the green or blue outputs, etc.
   *
   * The parameter numIterations specifies a number of repeated iterations of
   * box blurring to perform.  If numIterations is zero or negative, "this"
   * PixImage is returned (not a copy).  If numIterations is positive, the
   * return value is a newly constructed PixImage.
   *
   * IMPORTANT:  DO NOT CHANGE "this" PixImage!!!  All blurring/changes should
   * appear in the new, output PixImage only.
   *
   * @param numIterations the number of iterations of box blurring.
   * @return a blurred version of "this" PixImage.
   */
  public PixImage boxBlur(int numIterations) {
    // Replace the following line with your solution.
	int count=1;
	PixImage newPx=null;
//	System.out.println("r:"+newPx.getRed(0,0));
	if(numIterations<=0){
		return this;
	}else{
		newPx=BlurCalculator(this);
		while(count<numIterations){
			newPx=BlurCalculator(newPx);
			count++;
			
		}
	}
//	System.out.println("r:"+newPx.getRed(0,0)+"n:"+numIterations+"c:"+count);
	return newPx;
    
  }
 /* private pixelStore[][] extendStore(pixelStore[][] arr){
	  pixelStore[][] extended=new pixelStore[Width+2][Height+2];
	  pixelStore st=null;
	  st=new pixelStore(0,0,(short)0,(short)0,(short)0);
	  for(int i=0;i<=Width+1;i++){
		  for(int j=0;j<=Height+1;j++){
			  if(i==0||i==Width+1||j==0||j==Height+1){
				  extended[i][j]=st;
			  }else{
				  extended[i][j]=arr[i-1][j-1];
			  }
		  }
	  }
	  return extended;
  }*/
  private PixImage BlurCalculator(PixImage pximg){
	  int c;
	  short r,g,b;
	  PixImage newImage=new PixImage(Width,Height);
	  for(int i=0;i<Width;i++){
		  int[] x={i-1,i-1,i-1,i,i,i,i+1,i+1,i+1};
		  for(int j=0;j<Height;j++){	
			  c=0;
			  r=0;
			  g=0;
			  b=0;
			  int[] y={j-1,j,j+1,j-1,j,j+1,j-1,j,j+1};
			 for(int k=0;k<9;k++){
				 if(x[k]>=0&&x[k]<Width&&y[k]>=0&&y[k]<Height){
					 r=(short)(pximg.getRed(x[k], y[k])+r);
					 g=(short)(pximg.getGreen(x[k], y[k])+g);
					 b=(short)(pximg.getBlue(x[k], y[k])+b);
					 c++;
				 }
			 }

			 if(c!=0){
		        r=(short)(r/c);
			    g=(short)(g/c);
			    b=(short)(b/c); 
			 }else{
				 System.out.println("Wrong here");
				 System.exit(0);
			 }
	/*		if(i==0&&j==0){
				 System.out.println("r:"+r);
			 }*/
	//		 System.out.println("r:"+r+"g:"+g+"b:"+b);
			 newImage.setPixel(i,j,r,g,b);

		  }
		
	  }
	return newImage;  
  } 

  /**
   * mag2gray() maps an energy (squared vector magnitude) in the range
   * 0...24,969,600 to a grayscale intensity in the range 0...255.  The map
   * is logarithmic, but shifted so that values of 5,080 and below map to zero.
   *
   * DO NOT CHANGE THIS METHOD.  If you do, you will not be able to get the
   * correct images and pass the autograder.
   *
   * @param mag the energy (squared vector magnitude) of the pixel whose
   * intensity we want to compute.
   * @return the intensity of the output pixel.
   */
  private static short mag2gray(long mag) {
    short intensity = (short) (30.0 * Math.log(1.0 + (double) mag) - 256.0);

    // Make sure the returned intensity is in the range 0...255, regardless of
    // the input value.
    if (intensity < 0) {
      intensity = 0;
    } else if (intensity > 255) {
      intensity = 255;
    }
    return intensity;
  }

  /**
   * sobelEdges() applies the Sobel operator, identifying edges in "this"
   * image.  The Sobel operator computes a magnitude that represents how
   * strong the edge is.  We compute separate gradients for the red, blue, and
   * green components at each pixel, then sum the squares of the three
   * gradients at each pixel.  We convert the squared magnitude at each pixel
   * into a grayscale pixel intensity in the range 0...255 with the logarithmic
   * mapping encoded in mag2gray().  The output is a grayscale PixImage whose
   * pixel intensities reflect the strength of the edges.
   *
   * See http://en.wikipedia.org/wiki/Sobel_operator#Formulation for details.
   *
   * @return a grayscale PixImage representing the edges of the input image.
   * Whiter pixels represent stronger edges.
   */
  public PixImage sobelEdges() {
    // Replace the following line with your solution.
    PixImage pximg=new PixImage(Width,Height);
	long[] gradR,gradG,gradB;
	long[][] energy=new long[Width][Height];
	short[][] intensity=new short[Width][Height];	
	for(int i=0;i<Width;i++){
		for(int j=0;j<Height;j++){
			gradR=calcuGrad(i,j,"red");
			gradG=calcuGrad(i,j,"green");
			gradB=calcuGrad(i,j,"blue");
			energy[i][j]=gradR[0]*gradR[0]+gradR[1]*gradR[1]+gradG[0]*gradG[0]+gradG[1]*gradG[1]+gradB[0]*gradB[0]+gradB[1]*gradB[1];
			intensity[i][j]=mag2gray(energy[i][j]);
			pximg.setPixel(i,j,intensity[i][j],intensity[i][j],intensity[i][j]);
		}
	}
	
	return pximg;
    // Don't forget to use the method mag2gray() above to convert energies to
    // pixel intensities.
  }
  private long[] calcuGrad(int x,int y,String s){
	  int xt,yt;
	  long tx=0,ty=0;
	  long[] grad=new long[2];
	  long[] m1={1,2,1,0,0,0,-1,-2,-1};
	  long[] m2={1,0,-1,2,0,-2,1,0,-1};
	  int[] intenX={x-1,x-1,x-1,x,x,x,x+1,x+1,x+1};
	  int[] intenY={y-1,y,y+1,y-1,y,y+1,y-1,y,y+1};
	  for(int i=0;i<9;i++){
		 xt=intenX[i];
         yt=intenY[i];
		 if(xt<0)xt=0;
		 if(xt>=Width)xt=Width-1;
		 if(yt<0)yt=0;
		 if(yt>=Height)yt=Height-1;
		 if(s.equals("red")){
			tx=m1[i]*((long)this.getRed(xt,yt))+tx;
            ty=m2[i]*((long)this.getRed(xt,yt))+ty;			
		 }else if(s.equals("green")){
			tx=m1[i]*((long)this.getGreen(xt,yt))+tx;
            ty=m2[i]*((long)this.getGreen(xt,yt))+ty;	 
		 }else{
			tx=m1[i]*((long)this.getBlue(xt,yt))+tx;
            ty=m2[i]*((long)this.getBlue(xt,yt))+ty;
		 }
	  }
		 grad[0]=tx;
		 grad[1]=ty;
		 return grad;
		 
	  }
	  


  /**
   * TEST CODE:  YOU DO NOT NEED TO FILL IN ANY METHODS BELOW THIS POINT.
   * You are welcome to add tests, though.  Methods below this point will not
   * be tested.  This is not the autograder, which will be provided separately.
   */


  /**
   * doTest() checks whether the condition is true and prints the given error
   * message if it is not.
   *
   * @param b the condition to check.
   * @param msg the error message to print if the condition is false.
   */
  private static void doTest(boolean b, String msg) {
    if (b) {
      System.out.println("Good.");
    } else {
      System.err.println(msg);
    }
  }

  /**
   * array2PixImage() converts a 2D array of grayscale intensities to
   * a grayscale PixImage.
   *
   * @param pixels a 2D array of grayscale intensities in the range 0...255.
   * @return a new PixImage whose red, green, and blue values are equal to
   * the input grayscale intensities.
   */
  private static PixImage array2PixImage(int[][] pixels) {
    int width = pixels.length;
    int height = pixels[0].length;
    PixImage image = new PixImage(width, height);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
                       (short) pixels[x][y]);
      }
    }

    return image;
  }

  /**
   * equals() checks whether two images are the same, i.e. have the same
   * dimensions and pixels.
   *
   * @param image a PixImage to compare with "this" PixImage.
   * @return true if the specified PixImage is identical to "this" PixImage.
   */
  public boolean equals(PixImage image) {
    int width = getWidth();
    int height = getHeight();

    if (image == null ||
        width != image.getWidth() || height != image.getHeight()) {
      return false;
    }

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (! (getRed(x, y) == image.getRed(x, y) &&
               getGreen(x, y) == image.getGreen(x, y) &&
               getBlue(x, y) == image.getBlue(x, y))) {
   //       System.out.println("r:"+getRed(x,y)+"g:"+getGreen(x,y)+"b:"+getBlue(x,y)+"x:"+x+"y:"+y);
          return false;
        }
      }
    }
    return true;
  }

  /**
   * main() runs a series of tests to ensure that the convolutions (box blur
   * and Sobel) are correct.
   */
  public static void main(String[] args) {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.
    PixImage image1 = array2PixImage(new int[][] { { 0, 10, 240 },
                                                   { 30, 120, 250 },
                                                   { 80, 250, 255 } });
    System.out.println("Testing getWidth/getHeight on a 3x3 image.  " +
                       "Input image:");
    System.out.print(image1.toString());
 //   System.exit(0);
    doTest(image1.getWidth() == 3 && image1.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 3x3 image.");
  /*  PixImage testimg=image1.boxBlur(1);
    System.out.println(testimg.getRed(0,0)+" "+image1.getRed(0,0));
    System.exit(0);*/
    doTest(image1.boxBlur(1).equals(
           array2PixImage(new int[][] { { 40, 108, 155 },
                                        { 81, 137, 187 },
                                        { 120, 164, 218 } })),
           "Incorrect box blur (1 rep):\n" + image1.boxBlur(1));
    doTest(image1.boxBlur(2).equals(
           array2PixImage(new int[][] { { 91, 118, 146 },
                                        { 108, 134, 161 },
                                        { 125, 151, 176 } })),
           "Incorrect box blur (2 rep):\n" + image1.boxBlur(2));
    doTest(image1.boxBlur(2).equals(image1.boxBlur(1).boxBlur(1)),
           "Incorrect box blur (1 rep + 1 rep):\n" +
           image1.boxBlur(2) + image1.boxBlur(1).boxBlur(1));

    System.out.println("Testing edge detection on a 3x3 image.");
 //   PixImage testImg=image1.sobelEdges();
  /*  System.out.println(testImg.equals(array2PixImage(new int[][] { { 104, 189, 180 },
                                        { 160, 193, 157 },
                                        { 166, 178, 96 } })));*/
 //   System.out.println("r:"+testImg.getRed(0, 0)+"g:"+testImg.getGreen(0, 0)+"b:"+testImg.getBlue(0, 0));
  //  System.exit(0);
    doTest(image1.sobelEdges().equals(
           array2PixImage(new int[][] { { 104, 189, 180 },
                                        { 160, 193, 157 },
                                        { 166, 178, 96 } })),
           "Incorrect Sobel:\n" + image1.sobelEdges());


    PixImage image2 = array2PixImage(new int[][] { { 0, 100, 100 },
                                                   { 0, 0, 100 } });
    System.out.println("Testing getWidth/getHeight on a 2x3 image.  " +
                       "Input image:");
    System.out.print(image2.toString());
    doTest(image2.getWidth() == 2 && image2.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 2x3 image.");
    doTest(image2.boxBlur(1).equals(
           array2PixImage(new int[][] { { 25, 50, 75 },
                                        { 25, 50, 75 } })),
           "Incorrect box blur (1 rep):\n" + image2.boxBlur(1));

    System.out.println("Testing edge detection on a 2x3 image.");
    doTest(image2.sobelEdges().equals(
           array2PixImage(new int[][] { { 122, 143, 74 },
                                        { 74, 143, 122 } })),
           "Incorrect Sobel:\n" + image2.sobelEdges());
  }
}
