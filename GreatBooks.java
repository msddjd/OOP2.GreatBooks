import java.util.*;
import java.io.*;

public class GreatBooks
{
	
	static ArrayList<LibraryBook> records = new ArrayList<LibraryBook>();

	//records.add(0, new LibraryBook("The Bible","Christ, Jesus",0,6.00,'n'));
	//System.out.println(	records.get(0).getTitle() );
	

	public static void main (String []args)
	{

		showfiles();
		getdatfile(); //gets dat file, creates a book for each book in dat file and stores each book in a slot of the arraylisti
		selectionSort();
		menu();
		


	}


	public static void showfiles()
	{
		
                //Get all files from directory
                File curDir = new File(".");
                String[] fileNames = curDir.list();
                ArrayList<String> data = new ArrayList<String>();

                //Find files which may have data. (aka, are in the .dat format)
                for(String s:fileNames)
                        if(s.endsWith(".dat"))
                                data.add(s);

		data.trimToSize();
		
		clearScreen();

		System.out.println("\t\t\tTHE BOOK SEARCH PROGRAM");

		
		for(int i = 0; i < 80; i++)
		System.out.print("-");
	

		System.out.println("\nWhat file is your book data stored in?\n");
	
		System.out.println("Here are the .dat file(s) in the current directory:\n");

	 	for(int i = 0; i < data.size(); i++)
		System.out.print("[ " + data.get(i) + " ]\t");
		System.out.println("\n");


	}

	 
	private static void getdatfile()
	{

			
			String title = "";
			String author = "";
			int copyright = -1;
			double price = 0.00;
			char genre = 'z';
			String newgenre = "";


		try	
		 {
			Scanner stdin = new Scanner(System.in);
			System.out.print("Enter name of file : ");
			String filename = stdin.nextLine();
			stdin = new Scanner(new File(filename));
			

			

			String currentline = ""; //initializing current line
			StringTokenizer currentfield = new StringTokenizer(currentline); //initializing current tokenizer 
			int slot=0;
	
			do	
			{
				
				currentline = stdin.nextLine();						//get next line
				currentfield = new StringTokenizer(currentline,";");			//get next field

				title = currentfield.nextToken(); 					//get next field which is title
				author = currentfield.nextToken(); 					//get next field which is author
				copyright =  Integer.parseInt(currentfield.nextToken());		//get next field which is copyright
				price = Double.parseDouble(currentfield.nextToken());			//get next field which is price
				genre = currentfield.nextToken().charAt(0);				//get next field which is genre

					switch(genre)							//switch statement to convert genre initial to extended form
					{
						case 'f' : newgenre = "Fiction";
								break;

						case 'n' : newgenre = "Non-Fiction";
								break;

						case 'd' : newgenre = "Drama";
								break;

						case 'p' : newgenre = "Poetry";
								break;

						default : newgenre = "Unknown";
								break;

					}


				records.add(slot, new LibraryBook(title,author,copyright,price,newgenre));	//create a book in current array slot with the known values
	
				slot++;									//move on to next slot in arraylist
	
			}while(stdin.hasNext());

			records.trimToSize();


		 }
		catch (IOException e) 
			{	System.out.println("\n"+e.getMessage()+"\nPlease try again\n");
				
				getdatfile(); //if improper file name, it runs method again

			}

	}

	private static void clearScreen()
    	{
        	System.out.println("\u001b[H\u001b[2J");
    	}

	private static void pause()
	{
		
		System.out.println("\nHit Return to Continue...");
		Scanner stdin = new Scanner(System.in);
		stdin.nextLine();
		

	}
		
		
	  public static void selectionSort()
	  {
	        int minIndex, index, j;
	        LibraryBook temp = new LibraryBook("title","author",0,0.0,"unknown");	//initializing temporary library book
	
	        for (index = 0; index < records.size()-1; index++)
	        {
	                minIndex = index;
	                for (j = minIndex+1; j < records.size();  j++)
	                        if ( (records.get(j).getTitle().compareTo( records.get(minIndex).getTitle() )) < 0 ) //compare next book.title in array to previous book.title in array, if its less than - then
	                                minIndex = j;
	
	                if (minIndex != index)
	                {	
			

	                    temp = records.get(index);
	                    records.set( index,(records.get(minIndex)) );
	                    records.set( minIndex, temp );
	                }
		}

		System.out.println("\nA total of " + records.size() + " items were sorted");
		pause();
		

	}

	public static void menu()
	{

		clearScreen();

		for(int i = 0; i < 80; i++)
		System.out.print("^");

		
		System.out.println("\n\t\t\tTHE GREAT BOOKS SEARCH PROGRAM");

		for(int i = 0; i < 80; i++)
		System.out.print("^");


		System.out.println("\n1)\tDisplay all book records");
		System.out.println("2)\tSearch for a book by Title");
		System.out.println("3)\tExit Search Program");


		for(int i = 0; i < 80; i++)
		System.out.print("^");

		System.out.print("\nPlease Enter Your Choice > ");

		Scanner stdin = new Scanner(System.in);

		try{		

			int input = stdin.nextInt();
	
			switch(input)
			{

			case 1 : displayAll();
				menu();
				 break;

			case 2 :stdin.nextLine();
				System.out.print("\nSearch Title > ");
				String query = stdin.nextLine();
				displaythis( binarySearch(query) ); 
				break;

			case 3 :System.out.println("\nAdios Amigo :)"); 
				System.exit(0);

			default: System.out.println("\nYou have made an error, please try again.");
				pause();
				menu();
				break;


			}

		}catch(InputMismatchException IME)
			{	System.out.println("\nYou did not enter a number Please try again\n");
				pause();
				menu();   }
			




	}

	public static void displayAll()
	{

		clearScreen();
		
		
		Scanner stdin = new Scanner(System.in);
	 	String input = "";

		for(int k = 0; k < records.size(); k++)
		{
			System.out.println("Record #"+ (k+1) +" :");
		
			for(int y = 0; y < 80; y++)
			System.out.print("^");

			System.out.println("\n\t\tTitle \t\t\t:"+ records.get(k).getTitle());

			
			System.out.println("\n\t\tAuthor's Name \t\t:"+ records.get(k).getAuthor());
			

			System.out.println("\n\t\tCopyright \t\t:"+ records.get(k).getCopyright());
			

			System.out.println("\n\t\tPrice \t\t\t:$"+ records.get(k).getPrice());

			
			System.out.println("\n\t\tGenre \t\t\t:"+ records.get(k).getGenre());

			for(int x = 0; x < 80; x++)
			System.out.print("^");

			System.out.println("\n\nPlease Hit Return to Continue or M for Menu...");
			input = stdin.nextLine();
			
			if( input.equalsIgnoreCase("M") )
			menu();

			clearScreen();
		


		}		


	}
	
	
	  private static int binarySearch (String title)
	  {
	        int first = 0, last = records.size()-1, middle, location;

	 	boolean found = false;

	        do
	        {
	                middle = (first + last) / 2;

	                if ( title.equals( records.get(middle).getTitle() ) )
                        found = true;
        	        else if ( title.compareTo( records.get(middle).getTitle() ) < 0 )
                        last = middle - 1;
	                else
	                first = middle + 1;
		  	}  while ( (! found) && (first <= last) );

	        location = middle;

	        return (found ? location : -1);
	

	}

	
	public static void displaythis(int k)
	{

		if(k<0)
		{System.out.println("\n\nSorry, the book was not found.");
		pause();
		menu();}
		


		clearScreen();
		

			System.out.println("Record #" + (k+1) + " :");
		
			for(int y = 0; y < 80; y++)
			System.out.print("^");

			System.out.println("\n\t\tTitle \t\t\t:"+ records.get(k).getTitle());

			
			System.out.println("\n\t\tAuthor's Name \t\t:"+ records.get(k).getAuthor());
			

			System.out.println("\n\t\tCopyright \t\t:"+ records.get(k).getCopyright());
			

			System.out.println("\n\t\tPrice \t\t\t:$"+ records.get(k).getPrice());

			
			System.out.println("\n\t\tGenre \t\t\t:"+ records.get(k).getGenre());

			for(int x = 0; x < 80; x++)
			System.out.print("^");

			pause();
			menu();

	}

	

 }
