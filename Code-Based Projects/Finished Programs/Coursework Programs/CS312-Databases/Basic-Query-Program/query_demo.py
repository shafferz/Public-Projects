#!/usr/bin/env python3
# date: 1 March 2019
# Zachary Shaffer

import sqlite3

# use a dictionary to keep track of how many attributes there are per table.
tables_dict = {"instructor": 5,
"teaches":5,
"student": 4,
"course": 4,
"department": 3
}

# define a function to get user-in put for the name of the table
def getTableName():
    """Function to get the table name from the user"""
    prmpt = "  Enter table name: "
    tableToEdit = input(prmpt) # enter input
    tableToEdit = tableToEdit.lower() # put text in to lower case
    # Error message if table doesn't exist
    while(tableToEdit not in tables_dict):
        print(  "The entered table does not exist in the dictionary. Please re-enter the name")
        tableToEdit = input(prmpt) # enter input
        tableToEdit = tableToEdit.lower() # put text in to lower case
    return tableToEdit
# end of getTableName()

# define a function to get user input for the fields of given table
def insertTable(myTable_str):
    connection = sqlite3.connect('myCampusDB.sqlite3')
    cursor = connection.execute(("SELECT * FROM " + myTable_str.capitalize()))
    # Get the attribute names from a table based on given cursor
    names = [description[0] for description in cursor.description]
    values = []
    # Store the values for each attribute
    for name in names:
        prmpt = ("Enter " + name + " value: ")
        attrib = input(prmpt)
        values.append(attrib)
    # Format the query
    query = ("INSERT INTO " + myTable_str.capitalize() + " VALUES (")
    for v in values:
        query = query + ("\"" + v + "\", ")
    query = query.rstrip(", ")
    query = query + ");"
    # Execute query and close connection
    cursor.execute(query)
    connection.commit()
    connection.close()
# end of insertTable

def editTable():
    connection = sqlite3.connect('myCampusDB.sqlite3')
    # Prompt for table to edit
    edTable = input("Enter the name of the table you'd like to edit: ")
    edTable = edTable.lower().capitalize()
    cursor = connection.execute(("SELECT * FROM " + edTable) + ";")
    # Print schema for user to select attribute
    print("Attributes in " + edTable + ": ")
    for row in cursor.execute("PRAGMA table_info('" + edTable + "')").fetchall():
        print(row[1])
    # Get info for query
    edID = input("What is the ID of the attribute you'd like to edit?: ")
    edAtt = input("Which attribute would you like to edit?: ")
    newAtt = input("What would you like that attribute to now be?: ")
    # Format the query
    query = ("UPDATE " + edTable + " SET " + edAtt + " = \"" + newAtt + "\" WHERE ID = " + edID + ";")
    # Execute query and close connection
    cursor.execute(query)
    connection.commit()
    connection.close()
    # Return the edTable to print new table
    return edTable

# define a function to print any given table
def printTable(myTable_str):
    connection = sqlite3.connect('myCampusDB.sqlite3')
    cursor = connection.execute(("SELECT * FROM " + myTable_str.capitalize()) + ";")
    # Get rows of table
    rows = cursor.fetchall()
    # Format data from table and print
    for row in rows:
        prnt_str = ""
        for ele in row:
            prnt_str = prnt_str + ele + "|"
        prnt_str = prnt_str.rstrip('|')
        print("\t" + prnt_str)
    connection.close()
    print("\t...")
# end of printTable

# the program actually starts here. The dictionary and the function have already been read and are in memory.
print("  Welcome to my database automation program!")
myTable_str = getTableName()
print(" + Note: There are <", tables_dict[myTable_str],"> attributes associated with table <",myTable_str,">.")
# Display table current state
print(" + ", myTable_str.capitalize(), " BEFORE inserting data:")
printTable(myTable_str)
# Prompt user to insert data
inStr = input("Would you like to INSERT data in the table? (Y/N): ")
inStr = inStr.lower()
# Insert data
if inStr == "y" or inStr == "yes":
    insertTable(myTable_str)
    print(" + ", myTable_str.capitalize(), " AFTER inserting data:")
    # Display table after insertion
    printTable(myTable_str)
# Prompt user to ask if they'd like to edit
edStr = input("Would you like to EDIT data in a table? (Y/N): ")
edStr = edStr.lower()
# Edit data
if edStr == "y" or edStr == "yes":
    tableEdited = editTable()
    # Display new table
    print(" + ", tableEdited, " AFTER editing data:")
    printTable(tableEdited)
print("  -- End of program --")
