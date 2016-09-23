/* RunLengthEncoding.java */

/**
 *  The RunLengthEncoding class defines an object that run-length encodes
 *  a PixImage object.  Descriptions of the methods you must implement appear
 *  below.  They include constructors of the form
 *
 *      public RunLengthEncoding(int width, int height);
 *      public RunLengthEncoding(int width, int height, int[] red, int[] green,
 *                               int[] blue, int[] runLengths) {
 *      public RunLengthEncoding(PixImage image) {
 *
 *  that create a run-length encoding of a PixImage having the specified width
 *  and height.
 *
 *  The first constructor creates a run-length encoding of a PixImage in which
 *  every pixel is black.  The second constructor creates a run-length encoding
 *  for which the runs are provided as parameters.  The third constructor
 *  converts a PixImage object into a run-length encoding of that image.
 *
 *  See the README file accompanying this project for additional details.
 */

public class RunLengthEncoding implements Iterable {

  /**
   *  Define any variables associated with a RunLengthEncoding object here.
   *  These variables MUST be private.
   */
   private DList colorList;
   private int Weight,Height;





  /**
   *  The following methods are required for Part II.
   */

  /**
   *  RunLengthEncoding() (with two parameters) constructs a run-length
   *  encoding of a black PixImage of the specified width and height, in which
   *  every pixel has red, green, and blue intensities of zero.
   *
   *  @param width the width of the image.
   *  @param height the height of the image.
   */

  public RunLengthEncoding(int width, int height) {
    // Your solution here.
     colorList=new DList();
	 DListNode colornode=new DListNode(width*height,0,0,0);
	 colorList.addDListFront(colornode);	
	 Weight=width;
	 Height=height;
  }

  /**
   *  RunLengthEncoding() (with six parameters) constructs a run-length
   *  encoding of a PixImage of the specified width and height.  The runs of
   *  the run-length encoding are taken from four input arrays of equal length.
   *  Run i has length runLengths[i] and RGB intensities red[i], green[i], and
   *  blue[i].
   *
   *  @param width the width of the image.
   *  @param height the height of the image.
   *  @param red is an array that specifies the red intensity of each run.
   *  @param green is an array that specifies the green intensity of each run.
   *  @param blue is an array that specifies the blue intensity of each run.
   *  @param runLengths is an array that specifies the length of each run.
   *
   *  NOTE:  All four input arrays should have the same length (not zero).
   *  All pixel intensities in the first three arrays should be in the range
   *  0...255.  The sum of all the elements of the runLengths array should be
   *  width * height.  (Feel free to quit with an error message if any of these
   *  conditions are not met--though we won't be testing that.)
   */

  public RunLengthEncoding(int width, int height, int[] red, int[] green,
                           int[] blue, int[] runLengths) {
    // Your solution here.
	colorList=new DList();
	DListNode colorNode;
	Weight=width;
	Height=height;
	int count=0;
	if(red.length==green.length&&red.length==blue.length&&red.length==runLengths.length){
		for(int i=0;i<red.length;i++){
			if(red[i]>=0&&red[i]<=255&&green[i]>=0&&green[i]<=255&&blue[i]>=0&&blue[i]<=255){
			   colorNode=new DListNode(runLengths[i],red[i],green[i],blue[i]);
			   colorList.addDListEnd(colorNode);
			}else{
				System.out.println("Wrong color range");
			    System.exit(0);
			}
			count=count+runLengths[i];
		}
		if(count!=width*height){
			System.out.println("Wrong runLengths");
			System.exit(0);
		}
	}else{
		System.out.println("Wrong color length");
		System.exit(0);
	}
	
  }

  /**
   *  getWidth() returns the width of the image that this run-length encoding
   *  represents.
   *
   *  @return the width of the image that this run-length encoding represents.
   */

  public int getWidth() {
    // Replace the following line with your solution.
    return Weight;
  }

  /**
   *  getHeight() returns the height of the image that this run-length encoding
   *  represents.
   *
   *  @return the height of the image that this run-length encoding represents.
   */
  public int getHeight() {
    // Replace the following line with your solution.
    return Height;
  }

  /**
   *  iterator() returns a newly created RunIterator that can iterate through
   *  the runs of this RunLengthEncoding.
   *
   *  @return a newly created RunIterator object set to the first run of this
   *  RunLengthEncoding.
   */
  public RunIterator iterator() {
    // Replace the following line with your solution.
    RunIterator it=new RunIterator(colorList);
	return it;
    // You'll want to construct a new RunIterator, but first you'll need to
    // write a constructor in the RunIterator class.
  }

  /**
   *  toPixImage() converts a run-length encoding of an image into a PixImage
   *  object.
   *
   *  @return the PixImage that this RunLengthEncoding encodes.
   */
  public PixImage toPixImage() {
    // Replace the following line with your solution.
   PixImage img=new PixImage(Weight,Height);
   RunIterator it=this.iterator();
   int[] l;
   int x=0;
   int y=0;
   while(it.hasNext()){
	   l=it.next();
	   for(int i=0;i<l[0];i++){
		   img.setPixel(x,y,(short)l[1],(short)l[2],(short)l[3]);
		   x++;
		   if(x%Weight==0){
			   y++;
			   x=0;
		   }
	   }
   }
   return img;
  }

  /**
   *  toString() returns a String representation of this RunLengthEncoding.
   *
   *  This method isn't required, but it should be very useful to you when
   *  you're debugging your code.  It's up to you how you represent
   *  a RunLengthEncoding as a String.
   *
   *  @return a String representation of this RunLengthEncoding.
   */
  public String toString() {
    // Replace the following line with your solution.
    return "";
  }


  /**
   *  The following methods are required for Part III.
   */

  /**
   *  RunLengthEncoding() (with one parameter) is a constructor that creates
   *  a run-length encoding of a specified PixImage.
   * 
   *  Note that you must encode the image in row-major format, i.e., the second
   *  pixel should be (1, 0) and not (0, 1).
   *
   *  @param image is the PixImage to run-length encode.
   */
  public RunLengthEncoding(PixImage image) {
    // Your solution here, but you should probably leave the following line
    // at the end.
	colorList=new DList();
	 DListNode nd;
	Weight=image.getWidth();
	Height=image.getHeight();
	int lastR=(int)image.getRed(0, 0);
	int lastG=image.getGreen(0, 0);
	int lastB=image.getBlue(0, 0);
	int[] recR=new int[Weight*Height];
	int[] recG=new int[Weight*Height];
	int[] recB=new int[Weight*Height];
	int[] runL=new int[Weight*Height];	
	int k=0;
	recR[k]=lastR;
	recG[k]=lastG;
	recB[k]=lastB;
	runL[k]=1;
	int count=1;
	for(int j=0;j<Height;j++){
		for(int i=0;i<Weight;i++){		
			if(lastR==(int)image.getRed(i,j)&&lastG==(int)image.getGreen(i,j)&&lastB==(int)image.getBlue(i, j)){
				if(!(i==0&&j==0)){
					runL[k]++;
					continue;
				}
			}else{
				k++;
				lastR=(int)image.getRed(i,j);
				lastG=(int)image.getGreen(i,j);
				lastB=(int)image.getBlue(i, j);		
				recR[k]=lastR;
				recG[k]=lastG;
				recB[k]=lastB;
				runL[k]=1;
				count++;
			}							
		}
			
	}

/*	count++;
	recR[k]=lastR;
	recG[k]=lastG;
	recB[k]=lastB;
	runL[k]=l;*/
    for(int i=0;i<count;i++){
    		nd=new DListNode(runL[i],recR[i],recG[i],recB[i]);
    		colorList.addDListEnd(nd);
    	 }
  /*  RunIterator it=new RunIterator(colorList);
    while(it.hasNext()){
  	  System.out.println("c:"+it.next()[1]);
    } 
    System.exit(0);*/
    check();
  }

  /**
   *  check() walks through the run-length encoding and prints an error message
   *  if two consecutive runs have the same RGB intensities, or if the sum of
   *  all run lengths does not equal the number of pixels in the image.
   */
  public void check() {
    // Your solution here.
	  RunIterator it=this.iterator();
	  int[] lastRun=new int[4];
	  int[] currRun;
	  int runLength=0;
	  while(it.hasNext()){
		  currRun=it.next();
		  if(currRun[0]<1){
			  System.out.println("run has a length less than 1");
			  System.exit(0);
		  }
		  if(runLength>0){
			  if(currRun[1]==lastRun[1]&&currRun[2]==lastRun[2]&&currRun[3]==lastRun[3]){
				  System.out.println("Two consecutive runs have the same contens");
				  System.exit(0);
			  }
		  }
		  lastRun=currRun;
		  runLength=runLength+currRun[0];
		  
	  }
	  if(runLength!=Weight*Height){
		  System.out.println("sum of run length wrong");
		  System.exit(0);
	  }
	  
  }


  /**
   *  The following method is required for Part IV.
   */

  /**
   *  setPixel() modifies this run-length encoding so that the specified color
   *  is stored at the given (x, y) coordinates.  The old pixel value at that
   *  coordinate should be overwritten and all others should remain the same.
   *  The updated run-length encoding should be compressed as much as possible;
   *  there should not be two consecutive runs with exactly the same RGB color.
   *
   *  @param x the x-coordinate of the pixel to modify.
   *  @param y the y-coordinate of the pixel to modify.
   *  @param red the new red intensity to store at coordinate (x, y).
   *  @param green the new green intensity to store at coordinate (x, y).
   *  @param blue the new blue intensity to store at coordinate (x, y).
   */
  public void setPixel(int x, int y, short red, short green, short blue) {
    // Your solution here, but you should probably leave the following line
    //   at the end.
	  DListNode nd1,nd2,nd;
	  nd=null;
	  int[] data;
	  int location=y*Weight+x+1;
	  int l1,l2,d1,d2,d;
      nd1=colorList.head.next;
      nd2=colorList.head.prev;   
      l1=nd1.item[0];
      l2=nd2.item[0];
      d1=location-l1;
      d2=Weight*Height-l2-location;
  if(x==2){
/*    	   RunIterator it=new RunIterator(colorList);
          while(it.hasNext()){
        	  System.out.println("l:"+it.next()[0]);
          } 
          System.exit(0);*/
	  int stop=1;
      }
      if(d2<d1){
    	  while(d2>=0){
    		  nd2=nd2.prev;
    		  l2=nd2.item[0]+l2;
    		  d2=Weight*Height-location-l2;
    	  }
    	  nd=nd2;
    	  d=-d2;
      }else{
    	  while(d1>0){
    		  nd1=nd1.next;
    		  l1=l1+nd1.item[0];
    		  d1=location-l1;
    	  }
    	  d=nd1.item[0]+d1;
    	  nd=nd1;
      }  
      data=nd.item;
      if((int)red!=data[1]||(int)green!=data[2]||(int)blue!=data[3]){
    	  DListNode newnd1,newnd2,newnd3;
    	  if(data[0]==1){
    		  newnd1=new DListNode(1,red,green,blue);
    		  colorList.change(newnd1, nd);
              this.changeLink(newnd1);
    	  }else{
    		  if(d==1){
    		  newnd1=new DListNode(1,red,green,blue);
    		  newnd2=new DListNode(data[0]-d,data[1],data[2],data[3]);
    		  colorList.insertNode(newnd1, newnd2, nd);
    		  this.changeLink(newnd1);
    	  }else if(d==data[0]){
    		  newnd1=new DListNode(data[0]-1,data[1],data[2],data[3]);
    		  newnd2=new DListNode(1,red,green,blue);
    		  colorList.insertNode(newnd1, newnd2, nd);
    		  this.changeLink(newnd2);
    	  }else{
    		  int r=data[0]-d;
    		  int l=data[0]-1-r;
    		  newnd1=new DListNode(l,data[1],data[2],data[3]);
    		  newnd2=new DListNode(1,red,green,blue);
    		  newnd3=new DListNode(r,data[1],data[2],data[3]);
    		  colorList.insertNode(newnd1, newnd2, newnd3,nd);
    	  }  
    		  }
    		 
    	 }
    	  
     
      // Test colorList
/*if(x==2){
          RunIterator it=new RunIterator(colorList);
      while(it.hasNext()){
    	  System.out.println("l:"+it.next()[0]);
      } 
   System.exit(0);
}*/
    check();
  }
  private void changeLink(DListNode nd){
	 if(nd.item[1]==nd.prev.item[1]&&nd.item[2]==nd.prev.item[2]&&
        nd.item[3]==nd.prev.item[3]){
		// System.out.println("l1:"+nd.prev.item[0]+" l2:"+nd.item[0]);
		       nd.item[0]=nd.prev.item[0]+nd.item[0];
    		   nd.prev.prev.next=nd;
    		   nd.prev=nd.prev.prev;
    	  }
     if(nd.item[1]==nd.next.item[1]&&nd.item[2]==nd.next.item[2]
       &&nd.item[3]==nd.next.item[3]){
    	// System.out.println("l1:"+nd.next.item[0]+" l2:"+nd.item[0]);
    	    nd.item[0]=nd.next.item[0]+nd.item[0];
    		nd.next=nd.next.next;
    		nd.next.next.prev=nd;
       }
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
   //     System.out.println(pixels[x][y]);
      }
    }

    return image;
  }

  /**
   * setAndCheckRLE() sets the given coordinate in the given run-length
   * encoding to the given value and then checks whether the resulting
   * run-length encoding is correct.
   *
   * @param rle the run-length encoding to modify.
   * @param x the x-coordinate to set.
   * @param y the y-coordinate to set.
   * @param intensity the grayscale intensity to assign to pixel (x, y).
   */
  private static void setAndCheckRLE(RunLengthEncoding rle,
                                     int x, int y, int intensity) {
    rle.setPixel(x, y,
                 (short) intensity, (short) intensity, (short) intensity);
    rle.check();
  }

  /**
   * main() runs a series of tests of the run-length encoding code.
   */
  public static void main(String[] args) {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.
    PixImage image1 = array2PixImage(new int[][] { { 0, 3, 6 },
                                                   { 1, 4, 7 },
                                                   { 2, 5, 8 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 3x3 image.  Input image:");
    System.out.print(image1.toString());
    RunLengthEncoding rle1 = new RunLengthEncoding(image1);
    rle1.check();
    System.out.println("Testing getWidth/getHeight on a 3x3 encoding.");
    doTest(rle1.getWidth() == 3 && rle1.getHeight() == 3,
           "RLE1 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x3 encoding.");
    doTest(image1.equals(rle1.toPixImage()),
           "image1 -> RLE1 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 0, 42);
    image1.setPixel(0, 0, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           
                 /*      array2PixImage(new int[][] { { 42, 3, 6 },
                                                    { 1, 4, 7 },
                                                    { 2, 5, 8 } }))*/
           
           "Setting RLE1[0][0] = 42 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 1, 0, 42);
    image1.setPixel(1, 0, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[1][0] = 42 fails.");
  // System.exit(0);
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 1, 2);
    image1.setPixel(0, 1, (short) 2, (short) 2, (short) 2);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[0][1] = 2 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 0, 0);
    image1.setPixel(0, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[0][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 2, 2, 7);
    image1.setPixel(2, 2, (short) 7, (short) 7, (short) 7);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[2][2] = 7 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 2, 2, 42);
    image1.setPixel(2, 2, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[2][2] = 42 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 1, 2, 42);
    image1.setPixel(1, 2, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[1][2] = 42 fails.");


    PixImage image2 = array2PixImage(new int[][] { { 2, 3, 5 },
                                                   { 2, 4, 5 },
                                                   { 3, 4, 6 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on another 3x3 image.  Input image:");
    System.out.print(image2.toString());
    RunLengthEncoding rle2 = new RunLengthEncoding(image2);
    rle2.check();
    System.out.println("Testing getWidth/getHeight on a 3x3 encoding.");
    doTest(rle2.getWidth() == 3 && rle2.getHeight() == 3,
           "RLE2 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x3 encoding.");
    doTest(rle2.toPixImage().equals(image2),
           "image2 -> RLE2 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle2, 0, 1, 2);
    image2.setPixel(0, 1, (short) 2, (short) 2, (short) 2);
    doTest(rle2.toPixImage().equals(image2),
           "Setting RLE2[0][1] = 2 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle2, 2, 0, 2);
    image2.setPixel(2, 0, (short) 2, (short) 2, (short) 2);
    doTest(rle2.toPixImage().equals(image2),
           "Setting RLE2[2][0] = 2 fails.");


    PixImage image3 = array2PixImage(new int[][] { { 0, 5 },
                                                   { 1, 6 },
                                                   { 2, 7 },
                                                   { 3, 8 },
                                                   { 4, 9 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 5x2 image.  Input image:");
    System.out.print(image3.toString());
    RunLengthEncoding rle3 = new RunLengthEncoding(image3);
    rle3.check();
    System.out.println("Testing getWidth/getHeight on a 5x2 encoding.");
    doTest(rle3.getWidth() == 5 && rle3.getHeight() == 2,
           "RLE3 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 5x2 encoding.");
    doTest(rle3.toPixImage().equals(image3),
           "image3 -> RLE3 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 4, 0, 6);
    image3.setPixel(4, 0, (short) 6, (short) 6, (short) 6);
    rle3.toPixImage();
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[4][0] = 6 fails.");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 0, 1, 6);
    image3.setPixel(0, 1, (short) 6, (short) 6, (short) 6);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[0][1] = 6 fails.");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 0, 0, 1);
    image3.setPixel(0, 0, (short) 1, (short) 1, (short) 1);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[0][0] = 1 fails.");


    PixImage image4 = array2PixImage(new int[][] { { 0, 3 },
                                                   { 1, 4 },
                                                   { 2, 5 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 3x2 image.  Input image:");
    System.out.print(image4.toString());
    RunLengthEncoding rle4 = new RunLengthEncoding(image4);
    rle4.check();
    System.out.println("Testing getWidth/getHeight on a 3x2 encoding.");
    doTest(rle4.getWidth() == 3 && rle4.getHeight() == 2,
           "RLE4 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x2 encoding.");
    doTest(rle4.toPixImage().equals(image4),
           "image4 -> RLE4 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 2, 0, 0);
    image4.setPixel(2, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[2][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 1, 0, 0);
    image4.setPixel(1, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[1][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 1, 0, 1);
    image4.setPixel(1, 0, (short) 1, (short) 1, (short) 1);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[1][0] = 1 fails.");
  }
}
