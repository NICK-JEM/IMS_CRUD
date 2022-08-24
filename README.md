# IMS_CRUD ```java```
## crud based inventory management system - back end focus

### this code is intended to be used with an SQL database table called equipment. 
An sql file will be uploaded at a later juncture, hopefully accompanied by a jar file, so code
can be run from the CLI.

> * Create function added: user can now add a record to the lab equipment table in the labs database
> * Read function added: user can now read what is contained in the equipment table of the labs database

```   
The user will be asked to choose either create or read, store will lead to a sequence of prompts for the user to 
input specific column values, while read will display the contents of the table in a list. 
After each function completes, the user will be asked if they wish to continue, inputting 'y' will return user 
to function choice while inputting 'n' will close the connection and terminate the application.

```
> * Update and Delete functions added
> 
  >*note: other crud functions added to facilitate testing*

```
The user will now be asked to choose between store, read, update or delete functions. The create and read functions
behave as before, the Update function will ask the user for the item_id of the record they wish to change, followed
by prompts for the new value for each column of the specified record. The delete function will ask the user for the
id number of the record to delete, then delete that record. Both will notify user of successful change / bad query.
```



