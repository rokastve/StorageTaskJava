# StorageTaskJava
A task with Java. Shop storage system,task for internship. 

Functionality:
- Review products with lower than needed quantity
- Review products that are expiring before entered date.

Products are sorted alphabeticaly by name, all the duplicate instances (same name, code, expiration date) are moved to single by adding up the quantities.

How to use:
1. When you start the program keep the same structure (Data folder with csv files in same directory as scr folder).
2. Enter the file name, without .csv (for example: sample).
3. Choose which option you want:
  3.1 Choose other file
  3.2 Filter by needed quantity
  3.3 Filter by expiration date
  3.4  Exit

3.1 After picking this option you have same text as program startup - you type file name without .csv
 
3.2 Picking this option asks user to input needed amount of products, it returns sorted list with merged duplicates that have quanitities lower than limts

3.2 Picking this option asks user to input expiration date, it returns sorted list with merged duplicates that have their expiration date lower than the scosen one

3.4 Program stop the cycle and doesn't ask user to choose an option anymore
