Mike Dumas
Programming Project 2 Great Books

• Obtaining the Catalog
	∘ Have a method used to display files in current directory
		∘ Prompt User for the filename of the file that will contain the list of Book Objects in our library (library.dat)
			‣ If a non .dat file is entered prompt again until the correct filename is entered
	∘ After correct entry, 
		‣ Obtain information in file, create the book object for each one, add each book object to an Arraylist.
			• Must first have a class file LibraryBook, contiaining method to create a book object with the 5 fields.
				∘ Must also have getter methods to obtain the necessary information.
		• The dat file contains necessary book information seperated by semicolons in respective order:  
			∘ Title;Author's Name(Last,first);Copyright;Price;Genre; Where Genre is represented by initials (f = fiction, nf = 				nonfiction, d\t = drama, p = poetry) Use tokenizer
		∘ Method should go in line by line, obtaining each field which will be private instance variables in a class file, and 				properly creating a Book for it, and storing that book in the Arraylist.
		• Store the book in the Arraylist.
		• Keep obtaining and Storing until the end of the file is reached
	‣ After filling all books in the array, sort the array using selectionsort
		• method should accept # of books as an input parameter and an array of books as a parameter
		• temporary variables used to swap will be of type book
		• comparing the title field of the books, so go in the array to get to the book, go into the book object to access the title.
		∘ After sorted Print out a message detailing the total number of books in catalog, and a statement that they have been sorted by title
	∘ Pause, Prompting User to hit return to continue.
• A Method for displaying The Main Menu
	∘ Heading Followed by Nice Menu
	∘ 3 possible options (Use a Swtich Statement)
		‣ 1) display all book records
			• use a printrecord method that accepts a book as a parameter, and prints it up to the end of the array. Prompt for continue before 			printing each book to give the effect of pausing.
			∘ Show Record# and Organized Book Information
			∘ user can hit M and than enter at any time to return to main menu
		‣ 2) search for book by title
			• Prompt user for Title (Case Sensitive)
				• If book is not found, print some error, pause for enter to continue.
				• If book is found display all the appropriate information for that book object
					∘ Books are stored in an arraylist, each slot is a record or basically a book.
					∘ Will use a binary search to find that book, we have to compare the title component of the book object.
					∘ when book is found call a method that will print the record starting at this location
		‣ 3) exit
		
		∘ If an option other than those is entered, inform of error, pause, clear screen and re print menu

How Selection Sort Works:
Given an array of 5 integers, [3,7,2,15,1] the selection sort will begin with the first slot of the array. 
It will check if the number (3) in that slot (0) is the smallest number in the array.
If the number is the smallest, than it moves on to the next slot since that number is already in the right position.
If the number is not the smallest, the selection sort will continue through the array until it finds the location of the smallest number. 
Since 3 is not the smallest number in the array, selection sort finds the location of the smallest number (1) which is located in slot 4.
Once found it swaps the contents of the location we were currently at (0), with the contents of the location(4) that contained the smallest number (1)
So now the array will contain [1,7,2,15,3]  
Then it moves on to the next slot, and repeats the same process until the end of the array is reached.


How the Binary Search Works:
The Binary Search is utilized on a sorted Array.
The binary search first calculates the middle location of an array by using integer division with the array size divided by two.
It then begins searching for a key at that midpoint location.
If key is found than we are in luck
If key is not found, we check to see if our key would be located before, or after that midpoint, by checking if key is less than or greater than what ever was contained in the middle slot.
If it is less than, we calculate a new middle utilizing the formula (first+last)/2. In this case we set last equal to the current middle - 1. And our first is still zero. So it does integer division with our current middle -1 divided by 2.
If key was greater than our current middle, we calculate our new middle using the same formula (first+last)/2 but we keep our last as the size of the array but we change the value of first to middle +1.
After finding this new middle, we search again for that key.
If it is found were in luck, if not we continue narrowing down our data, until the key is found.

If we had the array above after it is sorted [1,2,3,7,15] and we were looking for the key 2.

We calculate the location of our middle slot in this array using the formula
(first+last)/2
First is initialized as 0, and last is initialized as the size of the array-1 so the equation 
=(size of the array -1)/2  

Which is 4/2, which by integer division gives 2. So our current middle is slot 2.

Slot 2 contians 3, which is not our key.

Our key is less than what is in the middle slot so
We change the location of our last, since we know it will be less than what our current middle just was so:
last = middle -1
	= 1

And our new middle:
=(first+last)/2 
=(0+1)/2 which by integer division is 0. 



With our new middle as 0, we search slot 0 for the key. Slot 0 contains 1.
Our key is greater than what is in slot 0 so we change the value of our first, we know we can start searching at the slot after our current middle.

So first
= middle +1 = 0 + 1 = 1

and our new middle
= (first+last) /2
= (1+1)/2 = 1

We now search for our key again at slot [1], and slot [1] does indeed contain our key.
So it took 3 checks to find our key.

