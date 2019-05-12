### Date: 1 March 2019
### Name: Zachary Shaffer

To run my program, first `cd` into the `src/` directory using the following
line in your terminal:
```
cd src
```
Then, run the `myQueryProgram.py` code by entering the following into your
terminal:
```
python3 myQueryProgram.py
```
For best use, it is recommended that the user create a new database by deleting
the old `myCampusDB.sqlite3` file and following the build instructions located
in `campusDB_build.txt`.

### The Output of my program is the following:
```
Welcome to my database automation program!
  Enter table name: Instructor
 + Note: There are < 5 > attributes associated with table < instructor >.
 +  Instructor  BEFORE inserting data:
	...
Would you like to INSERT data in the table? (Y/N): Y
Enter ID value: 11111
Enter name value: Stephenson
Enter student value: CompBio
Enter deptName value: S13
Enter salary value: 120000
 +  Instructor  AFTER inserting data:
	11111|Stephenson|CompBio|S13|120000
	...
Would you like to EDIT data in a table? (Y/N): Y
Enter the name of the table you'd like to edit: Instructor
Attributes in Instructor:
ID
name
student
deptName
salary
What is the ID of the attribute you'd like to edit?: 11111
Which attribute would you like to edit?: name
What would you like that attribute to now be?: Stephendad
 +  Instructor  AFTER editing data:
	11111|Stephendad|CompBio|S13|120000
	...
  -- End of program --
```
